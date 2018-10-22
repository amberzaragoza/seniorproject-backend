package com.project.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.api.models.Menu;
import com.project.api.models.MenuItem;
import com.project.api.repositories.MenuItemRepository;
import com.project.api.repositories.MenuRepository;

@Service
public class MenuService {

	@Autowired
  private MenuRepository menuRepository;
  @Autowired
  private MenuItemRepository menuItemRepository;


  public MenuService(MenuRepository menuRepository,
                     MenuItemRepository menuItemRepository) {
    this.menuRepository = menuRepository;
    this.menuItemRepository = menuItemRepository;
	}

  public void update(Menu menu){
    menuRepository.save(menu);
  }

  public void update(MenuItem item){
    menuItemRepository.save(item);
  }
  
  public void deleteMenu(String id){
    menuRepository.deleteById(id);
  }

  public void deleteMenuItem(String id){
    menuItemRepository.deleteById(id);
  }

	public void save(Menu menu) {
		menuRepository.save(menu);
	}

	public Optional<Menu> findById(String id) {
		return menuRepository.findById(id);
  }
  
  public List<MenuItem> getAllItems(String menuId){
    Menu menu = menuRepository.findById(menuId).get();
    List<MenuItem> items = new ArrayList<>();
    menu.getItems().forEach(items::add);
    return items;
    
  }

}
