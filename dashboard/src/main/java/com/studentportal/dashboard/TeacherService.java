package com.studentportal.dashboard;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {

    Teacher findByRollNoAndBarcode(String roll_no, String barcode);

    boolean validateTeacher(String roll_no, String barcode);
    List<Long> getStudentCountByTeacherUdise(String teacherUdise) ;
    List<User> getAllStudents(String teacherUdise);
    List<User> getEnglishStudents(String teacherUdise);
    List<User> getGKStudents(String teacherUdise);
    List<User> getScienceStudents(String teacherUdise);
    List<User> getMathsStudents(String teacherUdise);
    List<User> getSSStudents(String teacherUdise);
    List<User> getSeventhStudents(String teacherUdise);
    List<User> getEighthStudents(String teacherUdise);
    List<User> getNineStudents(String teacherUdise);
}



