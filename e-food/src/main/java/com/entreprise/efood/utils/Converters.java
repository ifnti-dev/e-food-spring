package com.entreprise.efood.utils;

import java.util.ArrayList;
import java.util.List;

public class Converters {

    public static ArrayList<Long> convertStringArrayToLongArray(Object object) {
        ArrayList<Long> longsList = new ArrayList<>();
        for (String elt : (List<String>) object) {
            longsList.add(Long.parseLong(elt));
        }
        return longsList;
    }
}
