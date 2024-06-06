package com.entreprise.efood.mappers;

import com.entreprise.efood.Models.Menu;
import com.entreprise.efood.dtos.MenuDTO;

public class MenuMapper {

    public static Menu mapToMenu(MenuDTO menuDTO, Menu menu) {
        if (menuDTO.getId() != null) {
            menu.setId(menuDTO.getId());
        }
        menu.setNom(menuDTO.getNom());
        menu.setPrix(menuDTO.getPrix());
        menu.setTemps_preparation(menuDTO.getTemps_preparation());
        menu.setStatut(menuDTO.getStatut());
        menu.setImages(menuDTO.getImages());
        return menu;
    }

    public static MenuDTO mapToMenuDTO(Menu menu) {
        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setId(menu.getId());
        menuDTO.setNom(menu.getNom());
        menuDTO.setPrix(menu.getPrix());
        menuDTO.setTemps_preparation(menu.getTemps_preparation());
        menuDTO.setStatut(menu.getStatut());
        menuDTO.setImages(menu.getImages());
        return menuDTO;
    }
}
