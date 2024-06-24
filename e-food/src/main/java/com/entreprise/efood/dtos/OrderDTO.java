package com.entreprise.efood.dtos;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import groovyjarjarantlr4.v4.runtime.misc.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class OrderDTO {
    @NotNull
    private String idClient;
    @NotNull
    private String idRestaurant;
    @NotNull
    private ClientMenuDTO[] clientMenus;
    @Nullable
    private double coordX;
    @Nullable
    private double coordY;
    @NotNull
    private double montant;
    @Nullable
    private boolean livrable;
    @Nullable
    private String description;
   

  

}
