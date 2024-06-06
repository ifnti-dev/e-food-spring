package com.entreprise.efood.services.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.entreprise.efood.Models.Composant;
import com.entreprise.efood.Models.Menu;
import com.entreprise.efood.Models.Restaurant;
import com.entreprise.efood.dtos.MenuDTO;
import com.entreprise.efood.mappers.MenuMapper;
import com.entreprise.efood.repository.ComposantRepository;
import com.entreprise.efood.repository.MenuRepository;
import com.entreprise.efood.repository.RestaurantRepository;
import com.entreprise.efood.utils.Converters;

import com.entreprise.efood.utils.exceptions.menuExceptions.InvalidNameValueForMenu;
import com.entreprise.efood.utils.exceptions.menuExceptions.InvalidPriceValueForMenu;
import com.entreprise.efood.utils.exceptions.menuExceptions.InvalidStatutValueForMenu;
import com.entreprise.efood.utils.exceptions.menuExceptions.InvalidTempPreparationValueForMenu;
import com.entreprise.efood.utils.validators.MenuValidators;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private ComposantRepository composantRepository;

    public List<Composant> getComposantsByIds(List<Long> ids) {
        return composantRepository.findAllById(ids);
    }

    @Override
    public ResponseEntity getAllMenus(Long restaurant_id) {
        Map<String, List<MenuDTO>> menus = new HashMap<>();
        try {
            // récupération de la liste des menus d'un restaurant sans les restaurants et
            // les composantes
            List<MenuDTO> menuDTOs = menuRepository.getMenus(restaurant_id);

            // boucle permettant de récupérer les identifiants des composantes de chaque
            // menu
            for (MenuDTO menuDTO : menuDTOs) {
                // on récupère le menu et ses composantes
                Menu menu = menuRepository.findById(menuDTO.getId()).get();
                // tableau vide destiné à contenir les identifiants
                List<Long> composants_ids = new ArrayList<>();
                // sur chaque composant du menu on ajoute son identifiant au tableau
                for (Composant composant : menu.getComposants()) {
                    composants_ids.add(composant.getId());
                }
                // ici est affecté le tableau d'identifiants des composantes du menu à celui-ci
                menuDTO.setComposants_ids(composants_ids);
            }
            // ajout de la liste de menus dans la réponse
            menus.put("menus", menuDTOs);
            return new ResponseEntity<Map<String, List<MenuDTO>>>(menus, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
        }
        menus.put("menus", new ArrayList<MenuDTO>());
        return new ResponseEntity<Map<String, List<MenuDTO>>>(menus, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity getMenu(Long menu_id) {
        Map<String, MenuDTO> message = new HashMap<>();
        try {
            MenuDTO menuDTO = menuRepository.getMenuById(menu_id);
            Menu menu = menuRepository.findById(menu_id).get();
            List<Long> composants_ids = new ArrayList<>();
            for (Composant composant : menu.getComposants()) {
                composants_ids.add(composant.getId());
            }
            List<Composant> composants = getComposantsByIds(composants_ids);
            for (Composant composant : composants) {
                composant.setMenus(null);
            }
            menuDTO.setComposantes(composants);
            message.put("menu", menuDTO);
            return new ResponseEntity<Map<String, MenuDTO>>(message, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        message.put("menu", new MenuDTO());
        return new ResponseEntity<Map<String, MenuDTO>>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity createMenu(Map<String, Object> requestMap, Long restaurant_id) {
        Map<String, String> message = new HashMap<>();
        try {
            if (MenuValidators.validateMenuEntry(requestMap)) {
                MenuDTO menuDTO = new MenuDTO();
                Menu menu = new Menu();
                menuDTO.setNom((String) requestMap.get("nom"));
                menuDTO.setPrix((Double) requestMap.get("prix"));
                menuDTO.setStatut((String) requestMap.get("statut"));
                menuDTO.setTemps_preparation((String) requestMap.get("temps_preparation"));
                Restaurant restaurant = restaurantRepository.getById(restaurant_id);
                List<Composant> composants = getComposantsByIds(
                        Converters.convertStringArrayToLongArray(requestMap.get("composantes")));
                menuDTO.setComposantes(composants);

                menu = MenuMapper.mapToMenu(menuDTO, menu);
                menu.setRestaurant(restaurant);

                menuRepository.save(menu);
                message.put("message", "Menu créé avec succès");
                return new ResponseEntity<Map<String, String>>(message, HttpStatus.CREATED);

            }

        } catch (InvalidPriceValueForMenu | InvalidNameValueForMenu | InvalidTempPreparationValueForMenu
                | InvalidStatutValueForMenu e) {
            e.printStackTrace();
        }
        message.put("message", "Erreur interne du serveur");
        return new ResponseEntity<Map<String, String>>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity updateMenu(Map<String, Object> requestMap, Long menu_id,
            Long restaurant_id) {
        Map<String, String> message = new HashMap<>();
        try {
            if (MenuValidators.validateMenuEntry(requestMap)) {
                MenuDTO menuDTO = new MenuDTO();
                Menu menu = menuRepository.getById(menu_id);
                menuDTO.setNom((String) requestMap.get("nom"));
                menuDTO.setPrix((Double) requestMap.get("prix"));
                menuDTO.setStatut((String) requestMap.get("statut"));
                menuDTO.setTemps_preparation((String) requestMap.get("temps_preparation"));
                List<Composant> composants = getComposantsByIds(
                        Converters.convertStringArrayToLongArray(requestMap.get("composantes")));
                menuDTO.setComposantes(composants);

                Restaurant restaurant = restaurantRepository.getById(restaurant_id);

                menu.setRestaurant(restaurant);
                menu = MenuMapper.mapToMenu(menuDTO, menu);
                menuRepository.save(menu);
                message.put("message", "Menu mis à jour correctement");
                return new ResponseEntity<Map<String, String>>(message, HttpStatus.OK);
            }
        } catch (InvalidNameValueForMenu | InvalidPriceValueForMenu | InvalidTempPreparationValueForMenu
                | InvalidStatutValueForMenu e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        message.put("message", "Erreur interne du serveur");
        return new ResponseEntity<Map<String, String>>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity deleteMenu(Long menu_id) {
        Map<String, String> message = new HashMap<>();
        try {
            Menu menu = menuRepository.findById(menu_id).get();
            List<Composant> composants = new ArrayList<Composant>();
            menu.setComposants(composants);
            menuRepository.save(menu);
            menuRepository.delete(menu);
            message.put("message", "Menu supprimé correctement");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}