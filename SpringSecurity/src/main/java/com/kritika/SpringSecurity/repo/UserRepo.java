package com.kritika.SpringSecurity.repo;

import com.kritika.SpringSecurity.model.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository <users,Integer> {


    users findByUsername(String username);
}
