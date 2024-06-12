package com.entreprise.efood.services.commandes;

import com.entreprise.efood.dtos.OrderDTO;

public interface CommandService {
    public Long storeOrder( OrderDTO orderDTO);
}
