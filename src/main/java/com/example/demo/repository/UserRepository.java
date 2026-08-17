package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByEmail(String email);

	@Query(value = "SELECT * FROM ss_test_db.user where email= :emailId and password = :pword ", nativeQuery = true)
	Optional<User> dbLoginWithQuery(@Param("emailId") String dbEmail, @Param("pword") String dbPassword);

}
