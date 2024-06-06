package com.entreprise.efood.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
// import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entreprise.efood.dtos.PubliciteDTO;
import com.entreprise.efood.Models.Image;
// import com.entreprise.efood.Models.Image;
import com.entreprise.efood.Models.Publicite;
import com.entreprise.efood.Models.Restaurant;
import com.entreprise.efood.repository.PubliciteRepository;

@Service
@Transactional(readOnly = false)
public class PubliciteService {

    @Autowired
    private final PubliciteRepository repo;

    // @Autowired
    PubliciteService(PubliciteRepository repository) {
        this.repo = repository;
    }

    public List<PubliciteDTO> findAllbydto() {
        return repo.findAllPub();
    }

    public List<PubliciteDTO> findAllPubByresto(final Long id) {
        return repo.findAllPubByresto(id);
    }

    public Publicite saveOne(PubliciteDTO pubDto) {
        Publicite publicite = convertToEntity(pubDto);
        return repo.save(publicite);
    }

    public void deleteOne(final Long id) {
        repo.deleteById(id);
    }

    public Optional<Publicite> getOne(final Long id) {
        return repo.findById(id);
    }

    public Publicite convertToEntity(PubliciteDTO dto) {
        Publicite publicite = new Publicite();
        // resto id
        Restaurant restaurant = new Restaurant();
        restaurant.setCode(dto.getRestaurantId());
        // Liste des images
        List<Long> imagesID = dto.getImagesIds();
        List<Image> images = new ArrayList<>();

        if (imagesID != null) {
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

    // private PubliciteDTO convertToDto(Publicite publicite) {
    // PubliciteDTO dto = new PubliciteDTO();
    // dto.setId(publicite.getId());
    // dto.setTitre(publicite.getTitre());
    // dto.setDescription(publicite.getDescription());
    // dto.setRestaurantId(publicite.getRestaurant().getId());
    // dto.setImagesIds(publicite.getImages().stream().map(Image::getId).collect(Collectors.toList()));
    // return dto;
    // }
}
