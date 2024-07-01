package com.entreprise.efood.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.entreprise.efood.dtos.ComposantDTO;
import com.entreprise.efood.services.composantes.ComposantesServiceImpl;
import com.entreprise.efood.utils.AppConstant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(path = AppConstant.COMPOSANTES_CONTROLLER_BASE_URL)
public class ComposantesController {

    @Autowired
    private ComposantesServiceImpl composantesServiceImpl;

    // méthode GET retournant l'ensemble des composantes
    @GetMapping("/{restaurant_id}")
    public ResponseEntity<Map<String, List<ComposantDTO>>> getAllComposantes(@PathVariable String restaurant_id) {
        try {
            return composantesServiceImpl.getAllComposants(Long.parseLong(restaurant_id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // si erreur lors de l'éxécution retour d'une erreur 500
        Map<String, List<ComposantDTO>> composantes = new HashMap<>();
        composantes.put("composantes", new ArrayList<>());
        return new ResponseEntity<Map<String, List<ComposantDTO>>>(composantes, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/add")
    public ResponseEntity<Map<String, String>> createComposante(@RequestBody() ComposantDTO ComposantDTO) {
        Map<String, String> message = new HashMap<>();
        try {
            return composantesServiceImpl.addComponsant(ComposantDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        message.put("message", "Erreur lors de la création de la composante de menu");
        return new ResponseEntity<Map<String, String>>(message, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, String>> updateComposante(@PathVariable String id,
            @RequestBody() ComposantDTO composantDTO) {
        Map<String, String> message = new HashMap<>();
        try {
            return composantesServiceImpl.updateComposant(composantDTO, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        message.put("message", "Erreur lors de la création de la composante de menu");
        return new ResponseEntity<Map<String, String>>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> deleteComponent(@PathVariable String id) {
        Map<String, String> message = new HashMap<>();
        try {
            return composantesServiceImpl.deleteComposant(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        message.put("message", "Erreur lors de la suppression de la composante de menu");
        return new ResponseEntity<Map<String, String>>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
