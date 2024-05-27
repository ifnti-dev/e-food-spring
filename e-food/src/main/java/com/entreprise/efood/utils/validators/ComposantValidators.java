package com.entreprise.efood.utils.validators;

import com.entreprise.efood.dtos.ComposantDTO;
import com.entreprise.efood.utils.exceptions.composantExceptions.InvalidNameValueForComposant;
import com.entreprise.efood.utils.exceptions.composantExceptions.InvalidPriceValueForComposant;

public class ComposantValidators {

    public static boolean validateComposantEntry(ComposantDTO composantDTO)
            throws InvalidPriceValueForComposant, InvalidNameValueForComposant {
        if (composantDTO.getPrix() < 0.0) {
            throw new InvalidPriceValueForComposant("Le prix ne doit pas être négatif");
        } else if (composantDTO.getNom() == null) {
            throw new InvalidNameValueForComposant("Veuillez renseigner le nom de la composante de menu");
        }
        return true;
    }
}
