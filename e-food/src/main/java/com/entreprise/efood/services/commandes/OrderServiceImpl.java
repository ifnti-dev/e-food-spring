package com.entreprise.efood.services.commandes;

import java.sql.Timestamp;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entreprise.efood.Models.Client;
import com.entreprise.efood.Models.Commande;
import com.entreprise.efood.dtos.OrderDTO;
import com.entreprise.efood.repository.CommandeRepository;

@Service
public class OrderServiceImpl implements CommandService {

    @Autowired
    CommandeRepository commandeRepository;

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    public Long storeOrder(OrderDTO orderDTO) {
        // TODO Auto-generated method stub
        Long idClient = Long.parseLong(orderDTO.getIdClient());
        Client client = new Client();
        client.setId(idClient);
        Commande commande = new Commande();
        commande.setClient(client);
        commande.setDate_commande(Timestamp.from(Instant.now()));
        commande.setMontant(orderDTO.getMontant());
        commandeRepository.save(commande);
        return commande.getId();
    }
    
}
