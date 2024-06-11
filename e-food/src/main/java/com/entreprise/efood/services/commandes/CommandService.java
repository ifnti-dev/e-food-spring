package com.entreprise.efood.services.commandes;

import com.entreprise.efood.dtos.OrderCommandDTO;

public interface CommandService {
    public String orderCommand( OrderCommandDTO order);
}
