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
            // récupération de la liste des menus d'un restaurant sans les composantes
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
            // ici on récupère le menu sans ses composantes
            MenuDTO menuDTO = menuRepository.getMenuById(menu_id);

            // si aucun menu n'est retrouvé une erreur 404 est retournée
            if (menuDTO == null) {
                message.put("message", menuDTO);
                return new ResponseEntity<Map<String, MenuDTO>>(message, HttpStatus.NOT_FOUND);
            }

            // ici on recupère le menu et toutes ses associations
            Menu menu = menuRepository.findById(menu_id).get();

            // récupérations des composantes du menu
            List<Composant> composants = menu.getComposants();

            // pour chaque composant l'attribut menu est défini à null pour éviter les
            // récursions
            for (Composant composant : composants) {
                composant.setMenus(null);
            }

            // ici on affecte la liste de composantes du menu au menuDTO
            menuDTO.setComposantes(composants);
            message.put("menu", menuDTO);

            // renvoi de la réponse
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
            // vérification des données en entrée
            if (MenuValidators.validateMenuEntry(requestMap)) {
                // instanciation du DTO et de l'entitée
                MenuDTO menuDTO = new MenuDTO();
                Menu menu = new Menu();

                // affectation des données aux attributs du DTO
                menuDTO.setNom((String) requestMap.get("nom"));
                menuDTO.setPrix((Double) requestMap.get("prix"));
                menuDTO.setStatut((String) requestMap.get("statut"));
                menuDTO.setTemps_preparation((String) requestMap.get("temps_preparation"));
                Restaurant restaurant = restaurantRepository.findById(restaurant_id).get();
                menu.setRestaurant(restaurant);

                // récupération des composants depuis la liste d'identifiants des composantes
                List<Composant> composants = getComposantsByIds(
                        // conversion de la liste de chaine de caractère d'identifiants de composantes
                        // en liste de Long
                        Converters.convertStringArrayToLongArray(requestMap.get("composantes")));
                menuDTO.setComposantes(composants);

                // mappage du DTO en entitée
                menu = MenuMapper.mapToMenu(menuDTO, menu);

                // sauvegarde des modifications
                menuRepository.save(menu);
                message.put("message", "Menu créé avec succès");

                // renvoi de la réponse
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
            // vérification des données en entrée
            if (MenuValidators.validateMenuEntry(requestMap)) {
                MenuDTO menuDTO = new MenuDTO();

                // récupération de l'entitéz Menu
                Menu menu = menuRepository.findById(restaurant_id).get();

                // si l'entitée n'est pas retrouvée une erreur 404 est retournée
                if (menu == null) {
                    message.put("message", "Menu inexistant");
                    return new ResponseEntity<Map<String, String>>(message, HttpStatus.NOT_FOUND);
                }

                // passage des donnée dans le dto
                menuDTO.setNom((String) requestMap.get("nom"));
                menuDTO.setPrix((Double) requestMap.get("prix"));
                menuDTO.setStatut((String) requestMap.get("statut"));
                menuDTO.setTemps_preparation((String) requestMap.get("temps_preparation"));

                // récupération des nouvelles composantes du menu
                List<Composant> composants = getComposantsByIds(
                        Converters.convertStringArrayToLongArray(requestMap.get("composantes")));

                // changement des composantes du menu
                menuDTO.setComposantes(composants);

                // affectation du restaurant au menu
                Restaurant restaurant = restaurantRepository.findById(restaurant_id).get();
                menu.setRestaurant(restaurant);

                // mappage du DTO à l'entitée
                menu = MenuMapper.mapToMenu(menuDTO, menu);

                // sauvegarde des modifications
                menuRepository.save(menu);
                message.put("message", "Menu mis à jour correctement");

                // renvoi de la réponse
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

            // si l'entitée n'est pas retrouvée une erreur 404 est retournée
            if (menu == null) {
                message.put("message", "Menu inexistant");
                return new ResponseEntity<Map<String, String>>(message, HttpStatus.NOT_FOUND);
            }

            // tableau vide permettant de "vider" les composantes du menu
            List<Composant> composants = new ArrayList<Composant>();

            // retrait des composantes du menu en affectant une liste vide de composantes
            menu.setComposants(composants);

            // sauvegarde de la modification
            menuRepository.save(menu);

            // suppression du menu
            menuRepository.delete(menu);
            message.put("message", "Menu supprimé correctement");

            // renvoi de la réponse
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}