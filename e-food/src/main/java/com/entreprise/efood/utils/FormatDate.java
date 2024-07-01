package com.entreprise.efood.utils;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;


public class FormatDate {

    public static Timestamp formatStringToDate(String dateString) throws ParseException {

        System.out.println(dateString);

        // SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.FRENCH);

       
        Timestamp date =  Timestamp.valueOf(dateString);

        return date;
    }
}
