package com.entreprise.efood.services.commandes;

import com.entreprise.efood.dtos.OrderDTO;

public interface CommandService {
    public String storeOrder( OrderDTO orderDTO);
}
