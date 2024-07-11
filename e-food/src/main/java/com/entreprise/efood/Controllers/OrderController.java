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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entreprise.efood.Models.Restaurant;
import com.entreprise.efood.dtos.StatusDTO;
import com.entreprise.efood.dtos.commandeDTO.DetailsClientCommandeDTO;
import com.entreprise.efood.dtos.commandeDTO.MenuCommandeClientDTO;
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
    @PostMapping(value="/create")
    public ResponseEntity<Map<String,String>>  order(@RequestBody OrderDTO orderDTO){


        
        ResponseEntity<Map<String,String>> responseEntity =  orderServiceImpl.storeOrder(orderDTO);

        
        return responseEntity;
    }

    @PutMapping(value="/status/")
    public ResponseEntity<Map<String,Boolean>>  updateCommandStatus(@RequestBody StatusDTO statusDTO) {
        
        System.out.println(statusDTO.getStatus());
        
        Map<String,Boolean> responseEntity = new HashMap<>();
        
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

    @GetMapping(value="/")
    public ResponseEntity<Page<RetrieveCmdDTO>> getAllCommands(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size ,@RequestParam(required = true) String id){

        LOGGER.info("OK");
        LOGGER.debug("Debugging");
        LOGGER.error(Request.CLIENT_CERT_AUTH);
        Restaurant r = new Restaurant();
        r.setCode(Long.parseLong(id));
        ResponseEntity<Page<RetrieveCmdDTO>> commandes = orderServiceImpl.getAllCommands(page,size,r);

        return commandes;

    }

    @GetMapping("/menus")
    public ResponseEntity<Map<String,Object>> getCommandById(@RequestParam String id) {
      

        Map<String,Object>  mcmds= orderServiceImpl.retrieveMenus(id);
        return new ResponseEntity<>(mcmds,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String,Page<DetailsClientCommandeDTO>>> getClientCommands(@PathVariable String id) {
        Map<String,Page<DetailsClientCommandeDTO>> responseHashMap = new HashMap<>();
        

        // LOGGER.info(id);

        Page<DetailsClientCommandeDTO> details = orderServiceImpl.getClientCommndes(Long.parseLong(id));
        responseHashMap.put("data", details);
        
        // LOGGER.info();
        return new ResponseEntity<>(responseHashMap,HttpStatus.OK);
    }
    
    


}
