package com.project.api.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.api.models.Menu;
import com.project.api.services.MenuService;

@RestController
@RequestMapping("/menuitem")
public class MenuItemController {

	@Autowired
	private MenuService menuService;

  @Autowired
	public MenuItemController(MenuService menuService) {
		this.menuService = menuService;
	}

	// Get Requests
	@GetMapping("/get/id/{id}")
	public Optional<Menu> getBusinessById(@PathVariable String id) {
		return menuService.findById(id);
	}

}
