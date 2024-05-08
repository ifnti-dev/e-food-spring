package com.entreprise.efood.dtos;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.entreprise.efood.Models.Image;
import com.entreprise.efood.Models.Publicite;
import com.fasterxml.jackson.annotation.JsonIgnore;

// import com.fasterxml.jackson.annotation.JsonIgnore;

// import com.entreprise.efood.Models.Image;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PubliciteDTO{
    private Long id;
    private String titre;
    private String description;
    private Long restaurantId;
    
    @JsonIgnore
    private List<Long> imagesIds;
    public PubliciteDTO(Publicite pub){
        List<Long> ids = new ArrayList<>();

        if(pub.getImages() != null){
            for (Image i : pub.getImages()) {
                Long id =  i.getId();
                ids.add(id);
            }
    }
        this.id = pub.getId();
        this.titre = pub.getTitre();
        this.description = pub.getDescription();
        this.restaurantId = pub.getRestaurant().getId();
        this.imagesIds = ids;
  
}



}


