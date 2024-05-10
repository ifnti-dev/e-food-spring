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
    public ResponseEntity<Map<String, List<MenuDTO>>> getAllMenus() {
        Map<String, List<MenuDTO>> menus = new HashMap<>();
        try {
            List<MenuDTO> menuDTOs = menuRepository.getMenus();
            menus.put("menus", menuDTOs);
            return new ResponseEntity<Map<String, List<MenuDTO>>>(menus, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
        }
        menus.put("menus", new ArrayList<MenuDTO>());
        return new ResponseEntity<Map<String, List<MenuDTO>>>(menus, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
