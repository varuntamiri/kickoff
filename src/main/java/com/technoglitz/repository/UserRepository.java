package com.technoglitz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.technoglitz.domain.Role;
import com.technoglitz.domain.User;

import java.util.Collection;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByEmail(String email);
    
    Collection<User> findAllByRole(Role role);
}
