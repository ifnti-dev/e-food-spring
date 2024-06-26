package com.entreprise.efood.dtos;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;

import com.entreprise.efood.utils.FormatDate;
import com.fasterxml.jackson.annotation.JsonFormat;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EventDTO implements Serializable {

    @NotNull
    private Long id_restaurant;
    @NotNull
    private String description;

    @NotNull()

    private Timestamp date_debut;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Timestamp date_fin;

    @NotNull
    private Long code;
    @NotNull
    private String titre;
    private boolean status;

    // ce constructeur me permet de créer un event d'un restaurant
    public EventDTO(Long id_restaurant, String description, String date_debut, String date_fin, String titre)
            throws ParseException {
        this.id_restaurant = id_restaurant;
        this.description = description;
        this.date_debut = FormatDate.formatStringToDate(date_debut);
        this.date_fin = FormatDate.formatStringToDate(date_fin);
        this.titre = titre;
    }

    // Celui-ci pour la lecture des events d'un restaurant
    public EventDTO(Long id_restaurant, String description, Timestamp date_debut, Timestamp date_fin, String titre, Long code,boolean status)
            throws ParseException {
        this.id_restaurant = id_restaurant;
        this.description = description;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.titre = titre;
        this.code = code;
        this.status = status;
    }



    public EventDTO(Long id_restaurant, Long code) {
        this.id_restaurant = id_restaurant;
        this.code = code;
    }

    public EventDTO() {

    }

}
