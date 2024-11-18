package com.studentportal.dashboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//import com.example.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByRollNoAndBarcode(String rollNo, String barcode);

    @Query("SELECT u FROM User u WHERE u.rollNo IN :rollNumbers")
    List<User> findByRollNumbers(List<String> rollNumbers);
}
