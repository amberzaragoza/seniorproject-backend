package com.project.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.api.models.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, String> {

}