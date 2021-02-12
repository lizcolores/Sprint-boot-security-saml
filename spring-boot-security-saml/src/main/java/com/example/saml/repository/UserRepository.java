package com.example.saml.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.saml.auth.StoredUser;

@Repository
public interface UserRepository extends JpaRepository<StoredUser, String> {
    Optional<StoredUser> findByUsernameIgnoreCase(String username);
    Optional<StoredUser> findByUsernameAndPasswordHash(String username, String passwordHash);
}