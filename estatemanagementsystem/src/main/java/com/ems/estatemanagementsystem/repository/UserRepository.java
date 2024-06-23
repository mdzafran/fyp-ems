package com.ems.estatemanagementsystem.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.estatemanagementsystem.entity.Role;
import com.ems.estatemanagementsystem.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    Optional<User> findByIDNum(String idNum);

    User findUserById(Long userId);

    List<User> findByRoles(Role role);

    void deleteById(Long id);
    
    
}
