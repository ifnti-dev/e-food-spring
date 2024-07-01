package com.entreprise.efood.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
// import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
// @NoArgsConstructor
@AllArgsConstructor
public class ImageDTO {
    private Long id;
    private String url;
    private Long menuId;
    private Long publiciteId;

    public ImageDTO() {
        
    }
}













