package com.entreprise.efood.utils.validators;

import java.util.Map;
import java.util.Objects;

import com.entreprise.efood.utils.exceptions.menuExceptions.InvalidNameValueForMenu;
import com.entreprise.efood.utils.exceptions.menuExceptions.InvalidPriceValueForMenu;
import com.entreprise.efood.utils.exceptions.menuExceptions.InvalidStatutValueForMenu;
import com.entreprise.efood.utils.exceptions.menuExceptions.InvalidTempPreparationValueForMenu;

public class MenuValidators {

    public static boolean validateMenuEntry(Map<String, Object> requestMap)
            throws InvalidNameValueForMenu, InvalidPriceValueForMenu,
            InvalidTempPreparationValueForMenu, InvalidStatutValueForMenu {

        ;
        if ((Double) requestMap.get("prix") < 0.0 || Objects.isNull(requestMap.get("prix"))) {
            throw new InvalidPriceValueForMenu("Le prix du menu ne peut être négatif ou inexistant");
            // } else if( Long.parseLong(requestMap.get("prix")) ) {

        } else if (Objects.isNull(requestMap.get("nom"))) {
            throw new InvalidNameValueForMenu("Veuillez renseigner le nom du menu");
        } else if (Objects.isNull(requestMap.get("temps_preparation"))) {
            throw new InvalidTempPreparationValueForMenu("Veuillez renseigner le temps de préparation");
        } else if (Objects.isNull(requestMap.get("statut"))) {
            throw new InvalidStatutValueForMenu("Veuillez renseigner le statut du menu");
        }

        return true;
    }
}
