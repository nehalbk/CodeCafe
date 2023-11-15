package com.codecafe.api.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {
	
	@Autowired
	MenuRepo repo;
	
	@ResponseBody
	@GetMapping(value="/menu",produces="application/json")
	public List<Menu> getMenu(){
		return repo.findAll();
	}
	
	@ResponseBody
	@GetMapping(value="menu/{menuItem}",produces="application/json")
	public Menu getMenuItem(@PathVariable int menuItem) {
		return repo.findById(menuItem).orElse(null);
	}
}
