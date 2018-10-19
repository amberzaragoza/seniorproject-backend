package com.project.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.api.models.Menu;
import com.project.api.repositories.MenuRepository;

@Service
public class MenuService {

	@Autowired
	private MenuRepository menuRepository;

	public MenuService(MenuRepository menuRepository) {
		this.menuRepository = menuRepository;
	}

	public void save(Menu menu) {
		menuRepository.save(menu);
	}

	public Optional<Menu> findById(String id) {
		return menuRepository.findById(id);
	}

}
