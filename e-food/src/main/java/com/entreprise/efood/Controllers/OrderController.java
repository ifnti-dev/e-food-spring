package com.entreprise.efood.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Request;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entreprise.efood.dtos.MenuCommandeClientDTO;
import com.entreprise.efood.dtos.StatusDTO;
import com.entreprise.efood.dtos.commandeDTO.OrderDTO;
import com.entreprise.efood.dtos.commandeDTO.RetrieveCmdDTO;
import com.entreprise.efood.services.commandes.OrderServiceImpl;
import com.entreprise.efood.utils.AppConstant;
import com.entreprise.efood.utils.encryDecry.EncryptionUtil;

import org.springframework.web.bind.annotation.PutMapping;


@RestController
@CrossOrigin("*")
@RequestMapping(path = AppConstant.ORDER_REST_PATH_API)
public class OrderController {
    private OrderServiceImpl orderServiceImpl;
    private EncryptionUtil encryptionUtil;


    private static final Logger LOGGER = LogManager.getLogger(OrderController.class);


    public OrderController(OrderServiceImpl orderServiceImpl, EncryptionUtil eUtil){
        this.orderServiceImpl = orderServiceImpl;
        this.encryptionUtil = eUtil;
    }
    @PostMapping(value="/")
    public ResponseEntity<Map<String,String>>  order(@RequestBody OrderDTO orderDTO){

        System.out.println(orderDTO);
        
        ResponseEntity<Map<String,String>> responseEntity =  orderServiceImpl.storeOrder(orderDTO);

        
        return responseEntity;
    }

    @PutMapping(value="/status/")
    public ResponseEntity<Map<String,Boolean>>  updateCommandStatus(@RequestBody StatusDTO statusDTO) {
        
        System.out.println(statusDTO.getStatus());
        
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

    @GetMapping(value="/all")
    public ResponseEntity<Page<RetrieveCmdDTO>> getCommandsByStatus(@RequestParam String status, @RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size){

        LOGGER.info("OK");
        LOGGER.debug("Debugging");
        LOGGER.error(Request.CLIENT_CERT_AUTH);

        ResponseEntity<Page<RetrieveCmdDTO>> commandes = orderServiceImpl.getCommandsByStatus(status,page,size);

        return commandes;

    }

    @GetMapping("/")
    public ResponseEntity<Map<String,List<MenuCommandeClientDTO>>> getCommandById(@RequestParam String id) {
      
        Map<String,List<MenuCommandeClientDTO>> responseEntity = new HashMap();

        List<MenuCommandeClientDTO>  mcmds= orderServiceImpl.retrieveMenus(id);
        responseEntity.put("menus", mcmds);
        return new ResponseEntity<>(responseEntity,HttpStatus.OK);
    }
    


}
