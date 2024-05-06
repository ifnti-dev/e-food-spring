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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = AppConstant.COMPOSANTES_CONTROLLER_BASE_URL)
public class ComposantesController {

    @Autowired
    private ComposantesServiceImpl composantesServiceImpl;

    // méthode GET retournant l'ensemble des composantes
    @GetMapping("/")
    public ResponseEntity<Map<String, List<ComposantDTO>>> getAllComposantes() {
        try {
            return composantesServiceImpl.getAllComposants();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // si erreur lors de l'éxécution retour d'une erreur 500
        Map<String, List<ComposantDTO>> composantes = new HashMap<>();
        composantes.put("composantes", new ArrayList<>());
        return new ResponseEntity<Map<String, List<ComposantDTO>>>(composantes, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/add")
    public ResponseEntity<String> postMethodName(@RequestBody() ComposantDTO ComposantDTO) {
        try {
            return composantesServiceImpl.addComponsant(ComposantDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<String>("Erreur interne du serveur", HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
