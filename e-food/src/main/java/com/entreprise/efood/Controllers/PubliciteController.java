package com.entreprise.efood.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entreprise.efood.Models.Publicite;
import com.entreprise.efood.services.PubliciteService;

@RestController
@RequestMapping("/api/v1/publicites")
public class PubliciteController {

    @Autowired
    private PubliciteService publiciteService;

    /**
    * Read - Récuperer toutes les publicites
    * @return - Une liste d'objets de Publicité
    */
    @GetMapping
    public List<Publicite> getPublicites() {
        return publiciteService.findAll();
    }

    
}