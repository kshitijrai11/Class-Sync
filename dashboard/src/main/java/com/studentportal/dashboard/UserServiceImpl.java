package com.studentportal.dashboard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByRollNoAndBarcode(String rollNo, String barcode) {
        User user = userRepository.findByRollNoAndBarcode(rollNo, barcode);
        return user;
    }

    @Override
    public boolean validateUser(String roll_no, String barcode) {
        User user = userRepository.findByRollNoAndBarcode(roll_no, barcode);
        if (user != null) {
            return user.getBarcode().equals(barcode);
        }
        return false;
    }

    public List<User> findByRollNumbers(List<String> roll_no) {
        return userRepository.findByRollNumbers(roll_no);
    }
}

