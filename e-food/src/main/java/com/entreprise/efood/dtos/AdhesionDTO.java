
package com.entreprise.efood.dtos;


import com.entreprise.efood.Models.Restaurant;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdhesionDTO {
    
    private Long id;

    @NotNull
    private String avis;

    @NotNull
    private Restaurant restaurant; 

}
