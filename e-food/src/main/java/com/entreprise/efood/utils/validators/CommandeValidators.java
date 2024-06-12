package com.entreprise.efood.utils.validators;

import com.entreprise.efood.dtos.OrderDTO;
import com.entreprise.efood.utils.exceptions.commandsExceptions.InvalidIdValue;


public class CommandeValidators {
    
    public static boolean validateCommandEntry(OrderDTO orderDTO) throws InvalidIdValue {
        if (orderDTO.getIdMenus() == null) {
            throw new InvalidIdValue("Veuillez choisir un ménu");
        } else if (orderDTO.getIdClient()== null) {
            throw new InvalidIdValue("Veuillez renseigner vos informations");
        }
        return true;
    }
}
