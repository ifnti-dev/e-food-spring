package com.entreprise.efood.dtos;

import java.util.List;

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
public class PubliciteDTO {
    private Long id;
    private String titre;
    private String description;
    private Long restaurantId;

    // @JsonIgnore
    private List<Long> imagesIds;
}
