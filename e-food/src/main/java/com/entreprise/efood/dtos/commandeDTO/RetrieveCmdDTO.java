package com.entreprise.efood.dtos.commandeDTO;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RetrieveCmdDTO {
    @NotNull
    private double montant;
    @NotNull
    private Long id;

  


    public RetrieveCmdDTO(Long id, double mnt) {
        this.id = id;
        this.montant = mnt;
     }
}
