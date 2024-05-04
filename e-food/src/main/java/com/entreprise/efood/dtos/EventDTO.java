package com.entreprise.efood.dtos;

import java.io.Serializable;
import java.sql.Date;
import java.text.ParseException;

import com.entreprise.efood.utils.FormatDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EventDTO implements Serializable {

    private static final long serialVersionUID = -7941769011539363185L;

    private Long id_restaurant;
    private String description;
    private Date date_debut;
    private Date date_fin;
    private Long code;
    private String titre;

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
    public EventDTO(Long id_restaurant, String description, Date date_debut, Date date_fin, String titre, Long code)
            throws ParseException {
        this.id_restaurant = id_restaurant;
        this.description = description;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.titre = titre;
        this.code = code;
    }



    public EventDTO(Long id_restaurant, Long code) {
        this.id_restaurant = id_restaurant;
        this.code = code;
    }

    public EventDTO() {

    }

}
