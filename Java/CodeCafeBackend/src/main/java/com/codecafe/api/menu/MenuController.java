package com.codecafe.api.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping(value="/menu",consumes="application/json")
	public ResponseEntity<Menu> addItem(@RequestBody Menu menu) throws Exception{
		return menuService.addItem(menu);
	}
	
	@DeleteMapping(value="/menu")
	public ResponseEntity<Object> deleteMenuItem(@RequestBody Integer itemid) throws Exception {
		return menuService.deleteMenuItem(itemid);
	}
}
