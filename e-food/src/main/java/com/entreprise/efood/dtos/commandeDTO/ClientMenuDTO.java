package com.entreprise.efood.dtos.commandeDTO;

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
public class ClientMenuDTO {
    @NotNull
    private String id;
    @Nullable
    private String preference;
    @NotNull
    private int quantite;
}
