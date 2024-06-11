package com.entreprise.efood.Controllers;

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
    public ResponseEntity<OrderDTO>  order(@RequestBody OrderDTO orderDTO){
        orderServiceImpl.storeOrder(orderDTO);
        return ResponseEntity.ok(orderDTO);
    }
}
