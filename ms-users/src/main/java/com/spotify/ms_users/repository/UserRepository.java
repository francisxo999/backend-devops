package com.spotify.ms_users.repository;

import com.spotify.ms_users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailAndPassword(String email, String password);
}