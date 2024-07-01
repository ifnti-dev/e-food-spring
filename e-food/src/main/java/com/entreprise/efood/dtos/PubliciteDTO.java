package com.entreprise.efood.dtos;

import java.util.ArrayList;
import java.util.List;

import com.entreprise.efood.Models.Image;
import com.entreprise.efood.Models.Publicite;

// import com.fasterxml.jackson.annotation.JsonIgnore;

// import com.entreprise.efood.Models.Image;
// import lombok.AllArgsConstructor;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;

// @AllArgsConstructor
// @Getter
// // @NoArgsConstructor
// @Setter
public class PubliciteDTO {
    private Long id;
    private String titre;
    private String description;
    private Long restaurantId;
    private List<Long> imagesIds;

    public PubliciteDTO() {
    }

    public PubliciteDTO(long id, String titre, String description) {
        this.id = id;
        this.titre = titre;
        this.description = description;
    }

    public PubliciteDTO(Publicite pub) {
        List<Long> ids = new ArrayList<>();

        if (pub.getImages() != null) {
            for (Image i : pub.getImages()) {
                Long id = i.getId();
                ids.add(id);

            }
        }
        this.id = pub.getId();
        this.titre = pub.getTitre();
        this.description = pub.getDescription();
        this.restaurantId = pub.getRestaurant().getCode();
        this.imagesIds = ids;

    }

    public Long getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public List<Long> getImagesIds() {
        return imagesIds;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public void setImagesIds(List<Long> imagesIds) {
        this.imagesIds = imagesIds;
    }

    @Override
    public String toString() {
        return "PubliciteDTO [id=" + id + ", titre=" + titre + ", description=" + description + ", restaurantId="
                + restaurantId + ", imagesIds=" + imagesIds + ", getId()=" + getId() + ", getTitre()=" + getTitre()
                + ", getDescription()=" + getDescription() + ", getRestaurantId()=" + getRestaurantId()
                + ", getImagesIds()=" + getImagesIds() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + ", toString()=" + super.toString() + "]";
    }

}
