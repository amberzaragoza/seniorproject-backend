package com.project.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import com.project.api.models.AppUser;
@Repository
public interface UserRepository extends JpaRepository<AppUser, String> {
	public AppUser findByUsername(String username);
	public AppUser findByResetToken(String resetToken);
}
