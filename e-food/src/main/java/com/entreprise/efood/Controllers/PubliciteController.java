package com.entreprise.efood.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.entreprise.efood.dtos.PubliciteDTO;
import com.entreprise.efood.Models.Image;
import com.entreprise.efood.Models.Publicite;
import com.entreprise.efood.Models.Restaurant;
import com.entreprise.efood.services.PubliciteService;


@RestController
@CrossOrigin("http://192.168.62.119:8888/")
@RequestMapping("/api/v1/publicites")
public class PubliciteController {

    @Autowired
    private PubliciteService publiciteService;

     /**
    * Read - Récuperer toutes les publicites d'un restaurant
    * @return - Une liste d'objets de Publicité concernant un restaurant
    */
    
    @GetMapping("/restaurant/{id}")
    public ResponseEntity<List<Publicite>> getPublicitesByRestaurant(@PathVariable Long id) {
        List<PubliciteDTO> publiciteDTOs = publiciteService.findAllPubByresto(id);
        List<Publicite> publicites = publiciteDTOs.stream().map(this::convertToEntity).collect(Collectors.toList());
        return ResponseEntity.ok(publicites);
    }
    

    /**
    * Read - Récuperer toutes les publicites
    * @return - Une liste d'objets de Publicité
    */
    @GetMapping
    // public ResponseEntity<List<PubliciteDTO>> getPublicites() {
    //     List<Publicite> publicites = publiciteService.findAll();
    //     List<PubliciteDTO> publiciteDTOs = publicites.stream().map(this::convertToDto).collect(Collectors.toList());
    //     return ResponseEntity.ok(publiciteDTOs);
    // }
    public ResponseEntity<List<Publicite>> getPublicites() {
        List<PubliciteDTO> publicitesDTO = publiciteService.findAllbydto();
        List<Publicite> publicites = publicitesDTO.stream().map(this::convertToEntity).collect(Collectors.toList());
        return ResponseEntity.ok(publicites);
    }

    /**
    * Read - Récuperer une publicite par son id
    * @param id - l'identifiant de la publicite à récupérer
    * @return - l'objet Publicite correspondant à l'id
    */
    @GetMapping("/{id}")
    public ResponseEntity<PubliciteDTO> getPubliciteById(@PathVariable Long id) {
        Publicite publicite = publiciteService.getOne(id)
                .orElseThrow(() -> new IllegalArgumentException("Publicite non trouvée pour l'id : " + id));
        PubliciteDTO publiciteDTO = convertToDto(publicite);
        return ResponseEntity.ok(publiciteDTO);
    }

    /**
    * Create - Créer une nouvelle publicite
    * @param publiciteDTO - l'objet PubliciteDTO à créer
    * @return - l'objet Publicite créé
    */
    @PostMapping
    public ResponseEntity<PubliciteDTO> createPublicite(@RequestBody PubliciteDTO publiciteDTO) {
        Publicite publicite = publiciteService.saveOne(publiciteDTO);
        PubliciteDTO createdPubliciteDTO = convertToDto(publicite);
        return new ResponseEntity<>(createdPubliciteDTO, HttpStatus.CREATED);
    }

    /**
    * Update - Mettre à jour une publicite existante
    * @param id - l'identifiant de la publicite à mettre à jour
    * @param publiciteDTO - l'objet PubliciteDTO contenant les nouvelles données
    * @return - l'objet Publicite mis à jour
    */
    @PutMapping("/{id}")
    public ResponseEntity<PubliciteDTO> updatePublicite(@PathVariable Long id, @RequestBody PubliciteDTO publiciteDTO) {
        if (!publiciteService.getOne(id).isPresent()) {
            throw new IllegalArgumentException("Publicite non trouvée pour l'id : " + id);
        }
        publiciteDTO.setId(id);
        Publicite publicite = publiciteService.saveOne(publiciteDTO);
        PubliciteDTO updatedPubliciteDTO = convertToDto(publicite);
        return ResponseEntity.ok(updatedPubliciteDTO);
    }

    /**
    * Delete - Supprimer une publicite existante
    * @param id - l'identifiant de la publicite à supprimer
    */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublicite(@PathVariable Long id) {
        publiciteService.deleteOne(id);
        return ResponseEntity.noContent().build();
    }

    private PubliciteDTO convertToDto(Publicite publicite) {
        PubliciteDTO dto = new PubliciteDTO(publicite);
        return dto;
    }  
     private Publicite convertToEntity(PubliciteDTO dto) {
        Publicite publicite = new Publicite();
        // resto id
        Restaurant restaurant = new Restaurant();
        restaurant.setCode(dto.getRestaurantId());
        // Liste des images
        List<Long> imagesID = dto.getImagesIds();
        List<Image> images = new ArrayList<>();

        if(imagesID != null){
            for (Long id : imagesID) {
                Image img = new Image();
                img.setId(id);
                images.add(img);
            }
            publicite.setImages(images);

        }

        publicite.setId(dto.getId());
        publicite.setTitre(dto.getTitre());
        publicite.setDescription(dto.getDescription());
        publicite.setRestaurant(restaurant);
        
        
        return publicite;
    }
}






// package com.entreprise.efood.Controllers;


// import java.util.List;
// import java.util.stream.Collectors;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.entreprise.efood.dtos.PubliciteDTO;
// import com.entreprise.efood.Models.Image;
// import com.entreprise.efood.Models.Publicite;
// import com.entreprise.efood.services.PubliciteService;

// @RestController
// @RequestMapping("/api/v1/publicites")
// public class PubliciteController {

//     @Autowired
//     private PubliciteService publiciteService;

//     /**
//     * Read - Récuperer toutes les publicites
//     * @return - Une liste d'objets de Publicité
//     */
//     @GetMapping
//     public List<PubliciteDTO> getPublicites() {
//         List<Publicite> publicites = publiciteService.findAll();
//         return publicites.stream().map(this::convertToDto).collect(Collectors.toList());
//     }

//     private PubliciteDTO convertToDto(Publicite publicite) {
//         PubliciteDTO dto = new PubliciteDTO();
//         dto.setId(publicite.getId());
//         dto.setTitre(publicite.getTitre());
//         dto.setDescription(publicite.getDescription());
//         dto.setRestaurantId(publicite.getRestaurant().getId());
//         dto.setImagesIds(publicite.getImages().stream().map(Image::getId).collect(Collectors.toList()));
//         return dto;
//     }  
// }

