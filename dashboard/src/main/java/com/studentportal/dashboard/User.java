package com.studentportal.dashboard;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "student_details")
public class User {

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

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getSchoolName() {
        return schoolName;
    }



    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCentreName() {
        return centreName;
    }

    public void setCentreName(String centreName) {
        this.centreName = centreName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUdise() {
        return udise;
    }


    public String getNameOfDistrict() {
        return nameOfDistrict;
    }

    public String getBarcode() {
        return barcode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setstudentName(String name) {
        this.studentName=studentName;
    }

    public void setgetRollNo(String rollno) {
        this.rollNo=rollno;
    }

    public void setNameOfDistrict(String nameOfDistrict) {
        this.nameOfDistrict = nameOfDistrict;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public void setCentreNumber(String centreNumber) {
        this.centreNumber = centreNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public void setUdise(String udise) {
        this.udise = udise;
    }

    public void setSubDate(String subDate) {
        this.subDate = subDate;
    }

    public void setSubTime(String subTime) {
        this.subTime = subTime;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}
