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
@AllArgsConstructor
public class OrderCommandDTO {
    @NotNull
    private String idClient;
    @NotNull
    private String idRestaurant;
    @NotNull
    private String[] idMenus;
    @Nullable
    private String preferences;
    @Nullable
    private String coordX;
    @Nullable
    private String coordY;

}


