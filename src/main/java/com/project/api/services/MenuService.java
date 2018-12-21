package com.project.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

  public ResponseEntity<Menu> update(Menu menu) {
    Menu newMenu = menuRepository.save(menu);
    HttpHeaders httpHeaders = new HttpHeaders();
    return new ResponseEntity<>(newMenu, httpHeaders, HttpStatus.OK);
  }

  public ResponseEntity<MenuItem> update(MenuItem item) {
    MenuItem newItem = menuItemRepository.save(item);
    HttpHeaders httpHeaders = new HttpHeaders();
    return new ResponseEntity<>(newItem, httpHeaders, HttpStatus.OK);
  }

  public ResponseEntity<String> deleteMenu(String id) {
    menuRepository.deleteById(id);
    HttpHeaders httpHeaders = new HttpHeaders();
    return new ResponseEntity<>(id, httpHeaders, HttpStatus.OK);
  }

  public ResponseEntity<Menu> deleteMenuItem(String id) {
    menuItemRepository.deleteById(id);
    HttpHeaders httpHeaders = new HttpHeaders();
    return new ResponseEntity<>(null, httpHeaders, HttpStatus.OK);
  }

  public ResponseEntity<Menu> save(Menu menu) {
    Menu updatedMenu = menuRepository.save(menu);
    if(updatedMenu == null) return null;
    HttpHeaders httpHeaders = new HttpHeaders();
    return new ResponseEntity<>(updatedMenu, httpHeaders, HttpStatus.OK);
  }

  public Optional<Menu> findById(String id) {
    return menuRepository.findById(id);
  }

  public List<MenuItem> getAllItems(String menuId) {
    Menu menu = menuRepository.findById(menuId).get();
    List<MenuItem> items = new ArrayList<>();
    menu.getItems().forEach(items::add);
    return items;

  }

}
