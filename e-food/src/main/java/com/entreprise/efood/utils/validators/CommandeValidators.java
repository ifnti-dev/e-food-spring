package com.entreprise.efood.utils.validators;

import com.entreprise.efood.dtos.OrderDTO;
import com.entreprise.efood.utils.exceptions.commandsExceptions.InvalValue;


public class CommandeValidators {

    public static boolean validateCommandEntry(OrderDTO orderDTO) throws InvalValue {
        if (orderDTO.getIdMenus() == null) {
            throw new InvalValue("Veuillez choisir un ménu");
        } else if (orderDTO.getIdClient()== null) {
            throw new InvalValue("Veuillez renseigner vos informations");
        }
        else if (orderDTO.getMontant() <= 0) {
            throw new InvalValue("Le montant est invalide");
        }

        else if (orderDTO.isLivrable() == true && (orderDTO.getCoordX() == null || orderDTO.getCoordY() == null)) {
            throw new InvalValue("Veuillez renseigner vos coordonnées");
        }
        return true;
    }
}
