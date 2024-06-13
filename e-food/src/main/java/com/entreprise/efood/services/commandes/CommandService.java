package com.entreprise.efood.services.commandes;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.entreprise.efood.dtos.OrderDTO;
import com.entreprise.efood.dtos.StatusDTO;

public interface CommandService {
    public ResponseEntity<Map<String, String>> storeOrder( OrderDTO orderDTO);
    public Boolean getCommandById(StatusDTO statusDTO);
}
