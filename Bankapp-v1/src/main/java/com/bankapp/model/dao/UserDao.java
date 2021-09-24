package com.bankapp.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.web.entities.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	public User findByUsername(String username);

	public User findByEmail(String email);

	public List<User> findByProfile(String profile);
}
