package com.entreprise.efood.services.commandes;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.entreprise.efood.Models.Commande;
import com.entreprise.efood.dtos.OrderDTO;
import com.entreprise.efood.dtos.RetrieveCmdDTO;
import com.entreprise.efood.dtos.StatusDTO;

public interface CommandService {
    public ResponseEntity<Map<String, String>> storeOrder( OrderDTO orderDTO);
    public Boolean getCommandById(StatusDTO statusDTO);
    public ResponseEntity<List<RetrieveCmdDTO>> getCommandsByStatus(StatusDTO statusDTO);
}
