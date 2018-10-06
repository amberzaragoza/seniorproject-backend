package com.project.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.api.models.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {
	public AppUser findByUsername(String username);
	public AppUser findByResetToken(String resetToken);
}
