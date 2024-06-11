package com.entreprise.efood.services.commandes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public String storeOrder(OrderDTO orderDTO) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
