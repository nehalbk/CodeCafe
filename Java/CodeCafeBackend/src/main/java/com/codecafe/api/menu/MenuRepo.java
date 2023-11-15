package com.codecafe.api.menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface MenuRepo extends JpaRepository<Menu,Integer>{

}
