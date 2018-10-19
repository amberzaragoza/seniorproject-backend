package com.project.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.api.models.MenuItem;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, String> {

}