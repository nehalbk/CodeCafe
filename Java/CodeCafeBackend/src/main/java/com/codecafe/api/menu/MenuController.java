package com.codecafe.api.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {
	
	@Autowired
	MenuService menuService;
	
	@ResponseBody
	@GetMapping(value="/menu",produces="application/json")
	public ResponseEntity<List<Menu>> getMenu() throws Exception{
		return menuService.getallitems();
	}
	
	@ResponseBody
	@GetMapping(value="menu/{menuItem}",produces="application/json")
	public ResponseEntity<List<Menu>> getMenuItem(@PathVariable int menuItem) throws Exception {
		return menuService.getitembyid(menuItem);
	}
}
