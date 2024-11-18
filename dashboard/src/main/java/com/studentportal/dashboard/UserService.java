package com.studentportal.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    @Autowired

    User findByRollNoAndBarcode(String roll_no, String barcode);
    boolean validateUser(String roll_no, String barcode);
    List<User> findByRollNumbers(List<String> roll_no);

}

