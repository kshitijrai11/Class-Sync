package com.studentportal.dashboard;

import org.springframework.stereotype.Service;

@Service
public interface AdminService {

    Admin findByUsernameAndPassword(String username, String password);

    boolean validateAdmin(String username, String password);
}
