package com.intuit.user.repository;
import com.intuit.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Component
public class UserRepository {

    @Autowired
    private StoredUserRepository storedUserRepository;

    // Save or register a new user
    public User registerUser(User user) {
        return storedUserRepository.save(user);
    }

    // Find a user by username for login
    public Optional<User> findByUsername(String username) {
        return storedUserRepository.findByUsername(username);
    }

    // Update user information (email, password, etc.)
    public void updateUser(User user) {
        storedUserRepository.save(user);
    }

    // Fetch a user by their ID
    public Optional<User> findById(Long id) {
        return storedUserRepository.findById(id);
    }


    @Repository
    private interface StoredUserRepository extends JpaRepository<User, Long> {

        // Custom query methods
        Optional<User> findByUsername(String username);
    }
}
