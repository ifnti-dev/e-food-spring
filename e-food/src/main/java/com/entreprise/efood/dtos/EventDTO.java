package com.entreprise.efood.dtos;

import java.sql.Date;
import java.text.ParseException;

import com.entreprise.efood.utils.FormatDate;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class EventDTO {

    private Long id_restaurant;
    private String description;
    private Date date_debut;
    private Date date_fin;

    private String titre;

    
    public EventDTO(Long id_restaurant, String description, String date_debut, String date_fin, String titre) throws ParseException {
        this.id_restaurant = id_restaurant;
        this.description = description;
        this.date_debut = FormatDate.formatStringToDate(date_debut);
        this.date_fin = FormatDate.formatStringToDate(date_fin);
        this.titre = titre;
    }


    public EventDTO(Long id_restaurant, String description, Date date_debut, Date date_fin, String titre) throws ParseException {
        this.id_restaurant = id_restaurant;
        this.description = description;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.titre = titre;
    }

    public EventDTO(){

    }





}
