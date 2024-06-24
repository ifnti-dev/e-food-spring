package com.entreprise.efood.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entreprise.efood.Models.Commande;
import com.entreprise.efood.dtos.OrderDTO;
import com.entreprise.efood.dtos.StatusDTO;
import com.entreprise.efood.services.commandes.OrderServiceImpl;
import com.entreprise.efood.utils.AppConstant;
import com.entreprise.efood.utils.encryDecry.EncryptionUtil;

import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping(path = AppConstant.ORDER_REST_PATH_API)
public class OrderController {
    private OrderServiceImpl orderServiceImpl;
    private EncryptionUtil encryptionUtil;

    public OrderController(OrderServiceImpl orderServiceImpl, EncryptionUtil eUtil){
        this.orderServiceImpl = orderServiceImpl;
        this.encryptionUtil = eUtil;
    }
    @PostMapping(value="/")
    public ResponseEntity<Map<String,String>>  order(@RequestBody OrderDTO orderDTO){
        
        ResponseEntity<Map<String,String>> responseEntity =  orderServiceImpl.storeOrder(orderDTO);

        
        return responseEntity;
    }

    @PutMapping(value="/status/")
    public ResponseEntity<Map<String,Boolean>>  updateCommandStatus(@RequestBody StatusDTO statusDTO) {
        
        Map<String,Boolean> responseEntity = new HashMap();
        
        boolean ok = orderServiceImpl.getCommandById(statusDTO);

        if (ok) {
            responseEntity.put("ok", true);
            return new  ResponseEntity<Map<String,Boolean>>(responseEntity,HttpStatus.OK) ;

        } else {
            responseEntity.put("error", false);
            return new  ResponseEntity<Map<String,Boolean>>(responseEntity,HttpStatus.OK) ;
        }
        
    }

    @GetMapping(value="/all/")
    public ResponseEntity<List<Commande>> getCommandsByStatus(@RequestBody StatusDTO statusDTO){

        ResponseEntity<List<Commande>> commandes = orderServiceImpl.getCommandsByStatus(statusDTO);

        return commandes;

    }


}