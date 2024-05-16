package com.entreprise.efood.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.entreprise.efood.dtos.MenuDTO;
import com.entreprise.efood.services.menu.MenuServiceImpl;
import com.entreprise.efood.utils.AppConstant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping(path = AppConstant.MENUS_CONTROLLER_BASE_URL)
public class MenuController {

    @Autowired
    private MenuServiceImpl menuServiceImpl;

    @GetMapping("/restaurant/{restaurant_id}")
    public ResponseEntity<Map<String, List<MenuDTO>>> getAllMenus(@PathVariable String restaurant_id) {
        Map<String, List<MenuDTO>> message = new HashMap<>();
        try {

            return menuServiceImpl.getAllMenus(Long.parseLong(restaurant_id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        message.put("menus", new ArrayList<MenuDTO>());
        return new ResponseEntity<Map<String, List<MenuDTO>>>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{menu_id}")
    public ResponseEntity<Map<String, MenuDTO>> showMenu(@PathVariable String menu_id) {
        Map<String, MenuDTO> message = new HashMap<>();
        try {
            return menuServiceImpl.getMenu(Long.parseLong(menu_id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        message.put("menu", new MenuDTO());
        return new ResponseEntity<Map<String, MenuDTO>>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    

}
