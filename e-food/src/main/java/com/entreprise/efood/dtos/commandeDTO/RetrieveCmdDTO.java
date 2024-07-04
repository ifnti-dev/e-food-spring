package com.entreprise.efood.dtos.commandeDTO;

import java.sql.Timestamp;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RetrieveCmdDTO {
    @NotNull
    private double montant;
    @NotNull
    private Long id;
    @NotNull
    private Timestamp date;
    @NotNull
    private String nom;
    @NotNull
    private String prenom;



}
