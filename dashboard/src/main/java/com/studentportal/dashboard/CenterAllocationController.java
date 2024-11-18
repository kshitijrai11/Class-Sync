package com.studentportal.dashboard;

import jakarta.persistence.Query;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

@Controller
public class CenterAllocationController {

    private static final Logger logger = LoggerFactory.getLogger(CenterAllocationController.class);

    @Autowired
    private EntityManager entityManager;

    @PostMapping("/uploadCenterList")
    @Transactional
    public ResponseEntity<List<CenterAllocationResponse>> handleCenterListUpload(@RequestParam("csvFile") MultipartFile file) {
        List<CenterAllocationResponse> allocationResponses = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withTrim());
            List<CSVRecord> records = csvParser.getRecords();

            for (CSVRecord record : records) {
                String district = record.get("District").trim();
                String block = record.get("Block").trim();
                String centerName = record.get("Center Name").trim();
                String centerNumber = record.get("Center Number").trim();
                int centerCapacity = Integer.parseInt(record.get("Center Capacity").trim());

                String countHql = "SELECT COUNT(u) FROM User u WHERE u.centreName = :centerName AND u.centreNumber = :centerNumber";
                Query countQuery = entityManager.createQuery(countHql);
                countQuery.setParameter("centerName", centerName);
                countQuery.setParameter("centerNumber", centerNumber);
                Long currentCount = (Long) countQuery.getSingleResult();

                int remainingCapacity = centerCapacity - currentCount.intValue();
                logger.info("Remaining capacity for center {}: {}", centerName, remainingCapacity);

                CenterAllocationResponse response = new CenterAllocationResponse();
                response.setDistrict(district);
                response.setBlock(block);
                response.setCenterName(centerName);
                response.setCenterNumber(centerNumber);
                response.setRemainingCapacity(remainingCapacity);

                if (remainingCapacity > 0) {
                    String totalStudentsHql = "SELECT COUNT(u) FROM User u WHERE u.nameOfDistrict = :district AND u.block = :block";
                    Query totalStudentsQuery = entityManager.createQuery(totalStudentsHql);
                    totalStudentsQuery.setParameter("district", district);
                    totalStudentsQuery.setParameter("block", block);
                    Long totalStudents = (Long) totalStudentsQuery.getSingleResult();

                    String fetchStudentsHql = "FROM User u WHERE u.nameOfDistrict = :district AND u.block = :block";
                    Query fetchStudentsQuery = entityManager.createQuery(fetchStudentsHql);
                    fetchStudentsQuery.setParameter("district", district);
                    fetchStudentsQuery.setParameter("block", block);
                    fetchStudentsQuery.setMaxResults(remainingCapacity);
                    List<User> studentsToAllocate = fetchStudentsQuery.getResultList();

                    if (!studentsToAllocate.isEmpty()) {
                        String updateUsersHql = "UPDATE User u SET u.centreName = :centerName, u.centreNumber = :centerNumber " +
                                "WHERE u.id IN (:studentIds)";
                        Query updateQuery = entityManager.createQuery(updateUsersHql);
                        updateQuery.setParameter("centerName", centerName);
                        updateQuery.setParameter("centerNumber", centerNumber);
                        updateQuery.setParameter("studentIds", studentsToAllocate.stream().map(User::getId).toList());

                        int rowsUpdated = updateQuery.executeUpdate();
                        int unallocatedStudents = totalStudents.intValue() - rowsUpdated;

                        response.setAllocatedStudents(rowsUpdated);
                        response.setUnallocatedStudents(unallocatedStudents);
                        response.setStatusMessage(rowsUpdated > 0 ? "Allocation successful" : "No students allocated");
                    } else {
                        response.setAllocatedStudents(0);
                        response.setUnallocatedStudents(remainingCapacity);
                        response.setStatusMessage("No students found for allocation");
                    }
                } else {
                    response.setAllocatedStudents(0);
                    response.setUnallocatedStudents(0);
                    response.setStatusMessage("Center capacity exceeded");
                }

                allocationResponses.add(response);
            }
        } catch (Exception e) {
            logger.error("Error processing CSV: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(allocationResponses);
    }


    @GetMapping("/displayList")
    public String displayList(Model model) {
        // If there are responses in the session, return to the allocations view
        if (model.containsAttribute("allocationResponses")) {
            return "allocations"; // Return to JSP that shows the allocations
        }
        return "error"; // Or some message indicating no data available
    }

}
