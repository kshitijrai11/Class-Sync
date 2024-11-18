package com.studentportal.dashboard;

import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@org.springframework.stereotype.Controller
public class Controller {

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private UserService userService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private AdminService adminService;

    @GetMapping("/")
    public String loginForm(User user, Model model) {
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping("/dashboard")
    public String authenticateUser(@RequestParam("role") String role, @ModelAttribute User user, @ModelAttribute Teacher teacher, HttpSession session, Model model) {

        logger.info("Attempting to authenticate user or teacher");
        String sessionId = session.getId();
        if ("student".equals(role)) {
            if (userService.validateUser(user.getRollNo(), user.getBarcode())) {
                User authenticatedUser = userService.findByRollNoAndBarcode(user.getRollNo(), user.getBarcode());
                session.setAttribute("user", authenticatedUser);
                session.setAttribute("msg", "Login Successful!");
                logger.info("Authentication successful for user: {}", authenticatedUser.getRollNo());
                logger.info("Session with ID {} started successfully.", sessionId);
                model.addAttribute("user", authenticatedUser);
                return "dashboard";
            } else {
                logger.warn("Authentication failed for username: {}", user.getRollNo());
                model.addAttribute("loginStatus", "failed");
                model.addAttribute("error", "Invalid username or password");
                return "login";
            }
        } else if ("teacher".equals(role)) {
            if (teacherService.validateTeacher(teacher.getRollNo(), teacher.getBarcode())) {
                Teacher authenticatedTeacher = teacherService.findByRollNoAndBarcode(teacher.getRollNo(), teacher.getBarcode());
                session.setAttribute("teacher", authenticatedTeacher);
                session.setAttribute("teacherUdise", authenticatedTeacher.getUdise());
                session.setAttribute("msg", "Login Successful as Teacher!");

                logger.info("Authentication successful for teacher: {}", authenticatedTeacher.getRollNo());
                logger.info("Session with ID {} started successfully.", sessionId);
                String teacherUdise = (String) session.getAttribute("teacherUdise");

                List<Long> studentCount = teacherService.getStudentCountByTeacherUdise(teacherUdise);
                model.addAttribute("totalStudents", studentCount.get(0));
                model.addAttribute("englishStudents", studentCount.get(1));
                model.addAttribute("gkStudents", studentCount.get(2));
                model.addAttribute("scienceStudents", studentCount.get(3));
                model.addAttribute("mathsStudents", studentCount.get(4));
                model.addAttribute("ssStudents", studentCount.get(5));
                model.addAttribute("sevenStudents", studentCount.get(6));
                model.addAttribute("eightStudents", studentCount.get(7));
                model.addAttribute("nineStudents", studentCount.get(8));
                model.addAttribute("tenStudents", studentCount.get(9));
                model.addAttribute("elevenStudents", studentCount.get(10));
                model.addAttribute("teacher", authenticatedTeacher);
                return "dashboard-teacher";
            } else {
                logger.warn("Authentication failed for teacher: {}", teacher.getRollNo());
                model.addAttribute("loginStatus", "failed");
                model.addAttribute("error", "Invalid username or password");
                return "login";
            }
        } else {
            logger.error("Invalid role selected: {}", role);
            model.addAttribute("error", "Please select a valid role");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        String sessionId = session.getId();
        session.invalidate();
        logger.info("Session with ID {} closed successfully.", sessionId);
        return "redirect:/";
    }

    @GetMapping("/showtotalstudent")
    public String showTotalStudents(HttpSession session, Model model) {
        String teacherUdise = (String) session.getAttribute("teacherUdise");
        List<User> students = teacherService.getAllStudents(teacherUdise);
        logger.info("Fetched {} Total students", students.size());
        model.addAttribute("students", students);
        return "studentListView";
    }


    @GetMapping("/englishstudentlist")
    public String showTotalEnglishStudents(HttpSession session, Model model) {
        String teacherUdise = (String) session.getAttribute("teacherUdise");
        List<User> students = teacherService.getEnglishStudents(teacherUdise);
        logger.info("Fetched {} English students", students.size());
        model.addAttribute("students", students);
        return "studentListView";
    }


    @GetMapping("/gkstudentlist")
    public String showTotalGKStudents(HttpSession session, Model model) {
        String teacherUdise = (String) session.getAttribute("teacherUdise");
        List<User> students = teacherService.getGKStudents(teacherUdise);
        logger.info("Fetched {} GK students", students.size());
        model.addAttribute("students", students);
        return "studentListView";
    }


    @GetMapping("/sciencestudentlist")
    public String showTotalScienceStudents(HttpSession session, Model model) {
        String teacherUdise = (String) session.getAttribute("teacherUdise");
        List<User> students = teacherService.getScienceStudents(teacherUdise);
        logger.info("Fetched {} Science students", students.size());
        model.addAttribute("students", students);
        return "studentListView";
    }


    @GetMapping("/mathsstudentlist")
    public String showTotalMathsStudents(HttpSession session, Model model) {
        String teacherUdise = (String) session.getAttribute("teacherUdise");
        List<User> students = teacherService.getMathsStudents(teacherUdise);
        logger.info("Fetched {} Maths students", students.size());
        model.addAttribute("students", students);
        return "studentListView";
    }


    @GetMapping("/ssstudentlist")
    public String showTotalSSStudents(HttpSession session, Model model) {
        String teacherUdise = (String) session.getAttribute("teacherUdise");
        List<User> students = teacherService.getSSStudents(teacherUdise);
        logger.info("Fetched {} SS students", students.size());
        model.addAttribute("students", students);
        return "studentListView";
    }


    @GetMapping("/classsevenstudents")
    public String showTotalSeventhStudents(HttpSession session, Model model) {
        String teacherUdise = (String) session.getAttribute("teacherUdise");
        List<User> students = teacherService.getSeventhStudents(teacherUdise);
        logger.info("Fetched {} Seventh students", students.size());
        model.addAttribute("students", students);
        return "studentListView";
    }

    @GetMapping("/classeightstudents")
    public String showTotalEighthStudents(HttpSession session, Model model) {
        String teacherUdise = (String) session.getAttribute("teacherUdise");
        List<User> students = teacherService.getEighthStudents(teacherUdise);
        logger.info("Fetched {} Eighth students", students.size());
        model.addAttribute("students", students);
        return "studentListView";
    }

    @GetMapping("/classninestudents")
    public String showTotalNineStudents(HttpSession session, Model model) {
        String teacherUdise = (String) session.getAttribute("teacherUdise");
        List<User> students = teacherService.getEighthStudents(teacherUdise);
        logger.info("Fetched {} Nine students", students.size());
        model.addAttribute("students", students);
        return "studentListView";
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> download(HttpSession session) {
        User authenticatedUser = (User) session.getAttribute("user");
        if (authenticatedUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        String rollNo = authenticatedUser.getRollNo();
        String studentName = authenticatedUser.getStudentName();
        String motherName = authenticatedUser.getMotherName();
        String fatherName = authenticatedUser.getFatherName();
        String centreName = authenticatedUser.getCentreName();
        String gender = authenticatedUser.getGender();
        String dob = authenticatedUser.getDateOfBirth();
        String category = authenticatedUser.getCategory();
        String mobileno = authenticatedUser.getMobileNumber();
        String school = authenticatedUser.getSchoolName();
        String clas = authenticatedUser.getClassName();
        String subject = authenticatedUser.getSubject();
        String district = authenticatedUser.getNameOfDistrict();

        AdmitCard admitCard = new AdmitCard();
        try {
            byte[] pdfBytes = admitCard.createPdf(rollNo, studentName, motherName, fatherName, centreName, gender, dob, category, mobileno, school, clas, subject, district);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "admit_card.pdf");
            headers.setContentLength(pdfBytes.length);
            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/downloadzip")
    public ResponseEntity<byte[]> downloadSelectedStudents(@RequestBody List<String> rollNumbers) throws IOException {
        Logger logger = LoggerFactory.getLogger(Controller.class);

        long startTime = System.nanoTime();

        logger.info("Starting ZIP download for {} students.", rollNumbers.size());

        Set<String> uniqueRollNumbers = new HashSet<>(rollNumbers);
        List<User> selectedStudents = userService.findByRollNumbers(new ArrayList<>(uniqueRollNumbers));

        logger.info("Number of students selected: {}", selectedStudents.size());

        AdmitCard admitCard = new AdmitCard();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        ExecutorService executorService = Executors.newFixedThreadPool(5); // Thread pool with 5 threads
        List<Future<Map<String, byte[]>>> futures = new ArrayList<>();

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream)) {

            Map<String, Integer> rollNumberCounter = new HashMap<>();

            // Submit tasks for each student to generate their PDFs
            for (User student : selectedStudents) {
                String rollNo = student.getRollNo();

                if (rollNumberCounter.containsKey(rollNo)) {
                    rollNumberCounter.put(rollNo, rollNumberCounter.get(rollNo) + 1);
                } else {
                    rollNumberCounter.put(rollNo, 0);
                }

                final String uniqueRollNo = rollNo + (rollNumberCounter.get(rollNo) > 0 ? "-" + rollNumberCounter.get(rollNo) : "");

                logger.debug("Submitting task for student with roll number: {}", rollNo);

                Future<Map<String, byte[]>> future = executorService.submit(new Callable<Map<String, byte[]>>() {
                    @Override
                    public Map<String, byte[]> call() throws Exception {
                        byte[] pdfBytes = admitCard.createPdf(student.getRollNo(), student.getStudentName(), student.getMotherName(), student.getFatherName(), student.getCentreName(), student.getGender(), student.getDateOfBirth(), student.getCategory(), student.getMobileNumber(), student.getSchoolName(), student.getClassName(), student.getSubject(), student.getNameOfDistrict());

                        if (pdfBytes == null || pdfBytes.length == 0) {
                            logger.error("Failed to generate PDF for student: {}", student.getRollNo());
                            throw new IOException("Failed to generate PDF for student: " + student.getRollNo());
                        }

                        Map<String, byte[]> pdfMap = new HashMap<>();
                        pdfMap.put(uniqueRollNo + "-admit-card.pdf", pdfBytes);
                        return pdfMap;
                    }
                });

                futures.add(future);
            }

            // Wait for all tasks to complete and add PDFs to the ZIP file
            for (Future<Map<String, byte[]>> future : futures) {
                Map<String, byte[]> studentPdfMap = future.get(); // Get the PDF bytes for each student
                for (Map.Entry<String, byte[]> entry : studentPdfMap.entrySet()) {
                    String zipEntryName = entry.getKey();
                    byte[] pdfData = entry.getValue();

                    ZipEntry zipEntry = new ZipEntry(zipEntryName);
                    zipOutputStream.putNextEntry(zipEntry);
                    zipOutputStream.write(pdfData);
                    zipOutputStream.closeEntry();
                }
            }

            zipOutputStream.flush();
            logger.info("ZIP file created successfully.");

        } catch (Exception e) {
            logger.error("Error occurred while creating the admit cards ZIP file: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } finally {
            executorService.shutdown();
        }

        long endTime = System.nanoTime();
        long duration = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

        logger.info("ZIP download completed in {} milliseconds.", duration);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"students-admit-cards.zip\"");
        headers.add(HttpHeaders.CONTENT_TYPE, "application/zip");

        return ResponseEntity.ok().headers(headers).body(byteArrayOutputStream.toByteArray());
    }

    @GetMapping("/admin")
    public String appadmin(HttpSession session, Model model){
        return "admin";
    }

    @PostMapping("/adminlogin")
    public String authenticateAdmin(@ModelAttribute Admin admin, HttpSession session, Model model) {

        logger.info("Attempting to authenticate Admin");
        String sessionId = session.getId();
        if (adminService.validateAdmin(admin.getUsername(), admin.getPassword())) {
                Admin authenticatedAdmin = adminService.findByUsernameAndPassword(admin.getUsername(), admin.getPassword());
                session.setAttribute("admin", authenticatedAdmin);
                session.setAttribute("msg", "Login Successful!");
                logger.info("Authentication successful for Admin: {}", authenticatedAdmin.getUsername());
                logger.info("Session with ID {} started successfully.", sessionId);
                model.addAttribute("admin", authenticatedAdmin);
                return "dashboard-admin";
            } else {
                logger.warn("Authentication failed for Admin: {}", admin.getUsername());
                model.addAttribute("loginStatus", "failed");
                model.addAttribute("error", "Invalid username or password");
                return "admin";
            }
    }

}