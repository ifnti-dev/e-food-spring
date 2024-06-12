package com.entreprise.efood.services.commandes;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.entreprise.efood.Models.Client;
import com.entreprise.efood.Models.Commande;
import com.entreprise.efood.dtos.OrderDTO;
import com.entreprise.efood.repository.CommandeRepository;
import com.entreprise.efood.utils.encryDecry.EncryptionUtil;
import com.entreprise.efood.utils.exceptions.commandsExceptions.InvalValue;
import com.entreprise.efood.utils.validators.CommandeValidators;

@Service
public class OrderServiceImpl implements CommandService {
    @Autowired
    EncryptionUtil encryptionUtil;

    public OrderServiceImpl(EncryptionUtil encryptionUtil) {
        this.encryptionUtil = encryptionUtil;
    }

    @Autowired
    CommandeRepository commandeRepository;

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    public ResponseEntity<Map<String, String>> storeOrder(OrderDTO orderDTO) {

        Map<String, String> message = new HashMap<>();

        try {
            if (CommandeValidators.validateCommandEntry(orderDTO)) {

                Long idClient = Long.parseLong(orderDTO.getIdClient());
                Client client = new Client();
                client.setId(idClient);
                Commande commande = new Commande();
                commande.setClient(client);
                commande.setDate_commande(Timestamp.from(Instant.now()));
                commande.setMontant(orderDTO.getMontant());
                commande.setEtat("en cours");
                Commande savCommande = commandeRepository.save(commande);

                String cmdId = Long.toString(savCommande.getId());

                if (orderDTO.isLivrable()) {
                    System.out.println("good job");
                } else {
                    System.out.println("Oups !");
                }
                message.put("response", encryptionUtil.encrypt(cmdId));
                return new ResponseEntity<Map<String, String>>(message, HttpStatus.CREATED);
            }
        } catch (InvalValue e) {
            message.put("Error", e.getMessage());
           return new ResponseEntity<Map<String, String>>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        message.put("message", "Erreur lors de la création de la commande");
        return new ResponseEntity<Map<String, String>>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
