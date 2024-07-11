package com.entreprise.efood.services.commandes;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.entreprise.efood.Models.Restaurant;
import com.entreprise.efood.dtos.StatusDTO;
import com.entreprise.efood.dtos.commandeDTO.DetailsClientCommandeDTO;
import com.entreprise.efood.dtos.commandeDTO.OrderDTO;
import com.entreprise.efood.dtos.commandeDTO.RetrieveCmdDTO;

public interface CommandService {
    public ResponseEntity<Map<String, String>> storeOrder( OrderDTO orderDTO);
    public Boolean getCommandById(StatusDTO statusDTO);
    public ResponseEntity<Page<RetrieveCmdDTO>> getCommandsByStatus(String status,int page,int size);
    public ResponseEntity<Page<RetrieveCmdDTO>> getAllCommands(int page,int size,Restaurant r);

    public Map<String,Object> retrieveMenus(String id);
    public Page<DetailsClientCommandeDTO> getClientCommndes(Long idClient);
    
    
}
