package com.entreprise.efood.utils.validators;

import com.entreprise.efood.dtos.OrderDTO;
import com.entreprise.efood.dtos.StatusDTO;
import com.entreprise.efood.utils.exceptions.commandsExceptions.InvalValue;
import com.entreprise.efood.utils.exceptions.commandsExceptions.InvalidIdCommand;


public class CommandeValidators {

    public static boolean validateCommandEntry(OrderDTO orderDTO) throws InvalValue {
        if (orderDTO.getClientMenus() == null) {
            throw new InvalValue("Veuillez choisir un ménu");
        } else if (orderDTO.getIdClient()== null) {
            throw new InvalValue("Veuillez renseigner vos informations");
        }
        else if (orderDTO.getMontant() <= 0) {
            throw new InvalValue("Le montant est invalide");
        }

        else if (orderDTO.isLivrable() == true && (orderDTO.getCoordX() == 0.0 || orderDTO.getCoordY() == 0.0)) {
            throw new InvalValue("Veuillez renseigner vos coordonnées");
        }
        return true;
    }

    public static boolean validate(StatusDTO statusDTO) throws InvalidIdCommand{

        

        return true;

    }
}
