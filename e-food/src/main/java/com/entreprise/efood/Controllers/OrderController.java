package com.entreprise.efood.Controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.entreprise.efood.dtos.OrderDTO;
import com.entreprise.efood.services.commandes.OrderServiceImpl;
import com.entreprise.efood.utils.AppConstant;

@RestController
@RequestMapping(path = AppConstant.ORDER_REST_PATH_API)
public class OrderController {
    private OrderServiceImpl orderServiceImpl;

    public OrderController(OrderServiceImpl orderServiceImpl){
        this.orderServiceImpl = orderServiceImpl;
    }
    @PostMapping(value="/")
    public ResponseEntity<Map<String,String>>  order(@RequestBody OrderDTO orderDTO){
        
        ResponseEntity<Map<String,String>> responseEntity =  orderServiceImpl.storeOrder(orderDTO);

        
        return responseEntity;
    }
}
