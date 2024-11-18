package com.studentportal.dashboard;

import jakarta.persistence.EntityManager;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Controller
public class CsvUploadController {
    private static final Logger logger = LoggerFactory.getLogger(CsvUploadController.class);

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserRepository studentRepository;


    @PostMapping("/upload")
    @Transactional
    public ResponseEntity<String> handleCsvUpload(@RequestParam("csvFile") MultipartFile file) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withTrim());
            List<CSVRecord> records = csvParser.getRecords();

            // Print headers for debugging
            logger.info("CSV Headers: {}", csvParser.getHeaderMap().keySet());

            int batchSize = 25;
            for (int i = 0; i < records.size(); i++) {
                CSVRecord csvRecord = records.get(i);
                String nameOfDistrict = csvRecord.get("NAME OF DISTRICT").trim();
                String block = csvRecord.get("Block").trim();
                String centerNo = csvRecord.get("Centre Number").trim();
                String centerName = csvRecord.get("Centre Name").trim();
                String rollNo = csvRecord.get("Roll No").trim();
                String studentName = csvRecord.get("Student Name").trim();
                String motherName = csvRecord.get("Mother Name").trim();
                String fatherName = csvRecord.get("Father Name").trim();
                String gender = csvRecord.get("GENDER").trim();
                String dateOfBirth = csvRecord.get("DATE OF BIRTH").trim();
                String category = csvRecord.get("CATEGORY").trim();
                String aadharNumber = csvRecord.get("AADHAR NUMBER").trim();
                String mobileNumber = csvRecord.get("MOBILE NUMBER").trim();
                String schoolName = csvRecord.get("School Name").trim();
                String udise = csvRecord.get("UDISE").trim();
                String aClass = csvRecord.get("class").trim();
                String subject = csvRecord.get("Subject").trim();
                String subDate = csvRecord.get("SubDate").trim();
                String subTime = csvRecord.get("SubTime").trim();
                String barcode = csvRecord.get("Barcode").trim();

                User student = new User();
                student.setNameOfDistrict(nameOfDistrict);
                student.setBlock(block);
                student.setCentreNumber(centerNo);
                student.setCentreName(centerName);
                student.setRollNo(rollNo);
                student.setStudentName(studentName);
                student.setMotherName(motherName);
                student.setFatherName(fatherName);
                student.setGender(gender);
                student.setDateOfBirth(dateOfBirth);
                student.setCategory(category);
                student.setAadharNumber(aadharNumber);
                student.setMobileNumber(mobileNumber);
                student.setSchoolName(schoolName);
                student.setUdise(udise);
                student.setClassName(aClass);
                student.setSubject(subject);
                student.setSubDate(subDate);
                student.setSubTime(subTime);
                student.setBarcode(barcode);

                entityManager.persist(student);
                if (i % batchSize == 0) {
                    entityManager.flush();
                    entityManager.clear();
                }
            }
        } catch (IOException e) {
            logger.error("Error during file processing: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error during file processing: " + e.getMessage());
        } catch (NumberFormatException e) {
            logger.error("Invalid number format in CSV: {}", e.getMessage());
            return ResponseEntity.badRequest()
                    .body("Error: Invalid number format in CSV: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("Mapping for headers not found: {}", e.getMessage());
            return ResponseEntity.badRequest()
                    .body("Error: Mapping for headers not found. Please check your CSV format.");
        }

        return ResponseEntity.ok("File uploaded and student data inserted successfully!");
    }

    @DeleteMapping("/deleteAllStudents")
    @Transactional
    public ResponseEntity<String> deleteAllStudents() {
        try {

            studentRepository.deleteAll();
            return ResponseEntity.ok("All student records have been deleted.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting student records: " + e.getMessage());
        }
    }

}
