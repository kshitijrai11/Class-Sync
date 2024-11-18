package com.studentportal.dashboard;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "teacher_details")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name_of_district")
    private String nameOfDistrict;

    @Column(name = "block")
    private String block;

    @Column(name = "centre_number")
    private String centreNumber;

    @Column(name = "centre_name")
    private String centreName;

    @Column(name = "roll_no")
    private String rollNo;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "mother_name")
    private String motherName;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "category")
    private String category;

    @Column(name = "aadhar_number")
    private String aadharNumber;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "udise")
    private String udise;

    @Column(name = "class_name")
    private String className;

    @Column(name = "subject")
    private String subject;

    @Column(name = "sub_date")
    private String subDate;

    @Column(name = "sub_time")
    private String subTime;

    @Column(name = "barcode")
    private String barcode;

    public String getRollNo() {
        return rollNo;
    }

    public String getUdise() {
        return udise;
    }

    public String getBarcode() {
        return barcode;
    }
}
