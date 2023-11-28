package com.codecafe.api.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;

import com.codecafe.exceptions.SpringExceptionHandler;

@Service
public class MenuService {
	
	@Autowired
	SpringExceptionHandler excp;
	@Autowired
	private WebRequest webRequest;
	@Autowired
	MenuRepo repo;
	
	
	public ResponseEntity<List<Menu>> getallitems() throws Exception {
		try{
			List<Menu> returneditems =repo.findAll();
			if(returneditems.isEmpty()) {
				throw new Exception("No Menu found!");
			}else {
				return new ResponseEntity<>(returneditems,HttpStatus.OK);
			}
		}catch(Exception E) {
			excp.handleAllException(E,webRequest);
			
			return  new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<List<Menu>> getitembyid(Integer menuid) throws Exception{
		
		try{
			List<Menu> returneditems =repo.findBymenuId(menuid);
			if(returneditems.isEmpty()) {
				throw new Exception("No items found!");
			}else {
				return new ResponseEntity<>(returneditems,HttpStatus.OK);
			}
		}catch(Exception E) {
			excp.handleAllException(E,webRequest);
			
			return  new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<Menu> addItem(Menu menu) throws Exception{
		try {
			repo.save(menu);
			return new ResponseEntity<Menu>(menu,HttpStatus.CREATED);
		}catch(Exception E) {
			excp.handleAllException(E,webRequest);
			return new ResponseEntity<Menu>(menu,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	public ResponseEntity<Object> deleteMenuItem(Integer itemid) throws Exception{
			
			try{	
				List<Menu> returnedCustomers =repo.findBymenuId(itemid);
				if(returnedCustomers.isEmpty()) {
					throw new Exception("No customers found!");
				}else {
					repo.deleteById(itemid);
					return new ResponseEntity<Object>("Item deleted Successully!",HttpStatus.OK);
				
				}
				
			}catch(Exception E) {
				excp.handleAllException(E,webRequest);
				
				return  new ResponseEntity<Object>("Error in deleting Item!",HttpStatus.BAD_REQUEST);
			}
		}
	
}
