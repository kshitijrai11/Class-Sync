package com.studentportal.dashboard;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Admin findByUsernameAndPassword(String username, String password) {
        Admin admin = adminRepository.findByUsernameAndPassword(username, password);
        return admin;
    }

    @Override
    public boolean validateAdmin(String username, String password) {
        Admin admin = adminRepository.findByUsernameAndPassword(username, password);
        if (admin != null) {
            return admin.getPassword().equals(password);
        }
        return false;
    }
}
