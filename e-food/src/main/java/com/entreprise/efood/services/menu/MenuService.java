package com.entreprise.efood.services.menu;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface MenuService {

    public ResponseEntity getAllMenus(Long restaurant_id);

    public ResponseEntity getMenu(Long menu_id);

    public ResponseEntity createMenu(Map<String, Object> requestMap, Long restaurant_id);

    public ResponseEntity updateMenu(Map<String, Object> requestMap, Long menu_id,
            Long restaurant_id);

    public ResponseEntity deleteMenu(Long menu_id);
}
