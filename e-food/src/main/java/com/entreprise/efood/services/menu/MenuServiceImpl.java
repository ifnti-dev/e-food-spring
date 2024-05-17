package com.entreprise.efood.services.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.entreprise.efood.dtos.MenuDTO;
import com.entreprise.efood.repository.MenuRepository;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public ResponseEntity<Map<String, List<MenuDTO>>> getAllMenus(Long restaurant_id) {
        Map<String, List<MenuDTO>> menus = new HashMap<>();
        try {
            List<MenuDTO> menuDTOs = menuRepository.getMenus(restaurant_id);
            menus.put("menus", menuDTOs);
            return new ResponseEntity<Map<String, List<MenuDTO>>>(menus, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
        }
        menus.put("menus", new ArrayList<MenuDTO>());
        return new ResponseEntity<Map<String, List<MenuDTO>>>(menus, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<Map<String, MenuDTO>> getMenu(Long menu_id) {
        Map<String, MenuDTO> message = new HashMap<>();
        try {
            MenuDTO menuDTO = menuRepository.getMenuById(menu_id);
            message.put("menu", menuDTO);
            return new ResponseEntity<Map<String, MenuDTO>>(message, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        message.put("menu", new MenuDTO());
        return new ResponseEntity<Map<String, MenuDTO>>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    


    

}
