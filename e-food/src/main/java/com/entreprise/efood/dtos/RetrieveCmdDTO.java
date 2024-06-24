package com.entreprise.efood.dtos;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import groovyjarjarantlr4.v4.runtime.misc.Nullable;
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
    private Long idCmd;


    public RetrieveCmdDTO(Long id, double mnt) {
        this.idCmd = id;
        this.montant = mnt;

    }
}
