package com.cos.recorSys.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.recorSys.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
	Optional<Users> findByUsername(String username);
	Optional<Users> findByUserid(String userid);
	boolean existsByUserid(String userid);




}