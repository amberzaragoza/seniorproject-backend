package com.project.api.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.api.models.Business;
import com.project.api.models.Menu;
import com.project.api.models.MenuItem;
import com.project.api.services.BusinessService;
import com.project.api.services.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {

  @Autowired
  private MenuService menuService;
  @Autowired
  private BusinessService businessService;

  public MenuController(MenuService menuService, BusinessService businessService) {
    this.menuService = menuService;
    this.businessService = businessService;
  }

  // Post Requests ========================================================================
  @PostMapping("/post/{businessId}")
  public void saveMenu(@RequestBody Menu menu, @PathVariable String businessId) {
    Business business = businessService.getBusinessById(businessId).get();
    business.addMenu(menu);
    menuService.save(menu);
  }

  @PostMapping("/post/item/{menuId}")
  public void addItemToMenu(@PathVariable String menuId, @RequestBody MenuItem item) {
    Menu menu = menuService.findById(menuId).get();
    menu.addItem(item);
    menuService.save(menu);
  }

  // Get Requests ==========================================================================
  @GetMapping("/get/id/{id}")
  public Optional<Menu> getBusinessById(@PathVariable String id) {
    return menuService.findById(id);
  }

}
