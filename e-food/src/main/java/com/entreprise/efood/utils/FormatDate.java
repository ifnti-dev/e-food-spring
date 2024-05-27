package com.entreprise.efood.utils;

import java.sql.Date;
import java.text.ParseException;


public class FormatDate {

    public static Date formatStringToDate(String dateString) throws ParseException {

        // SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.FRENCH);

       
        Date date =  Date.valueOf(dateString);

        return date;
    }
}
