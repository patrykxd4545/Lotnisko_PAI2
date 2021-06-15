package com.airline.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.airline.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, CrudRepository<User, Long> {

	User findByEmail(String email);
	List<User> findByUserId(Long userId);
	boolean existsByEmail(String email);

}
