package com.entreprise.efood.services.menu;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.entreprise.efood.dtos.MenuDTO;

public interface MenuService {

    public ResponseEntity<Map<String, List<MenuDTO>>> getAllMenus(Long restaurant_id);

    public ResponseEntity<Map<String, MenuDTO>> getMenu(Long menu_id);

    
}
