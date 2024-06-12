package com.entreprise.efood.services.commandes;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.entreprise.efood.dtos.OrderDTO;

public interface CommandService {
    public ResponseEntity<Map<String, String>> storeOrder( OrderDTO orderDTO);
}
