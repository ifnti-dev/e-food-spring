package com.entreprise.efood.services.commandes;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.entreprise.efood.Models.Client;
import com.entreprise.efood.Models.Commande;
import com.entreprise.efood.Models.Livraison;
import com.entreprise.efood.Models.Menu;
import com.entreprise.efood.Models.MenuCommande;
import com.entreprise.efood.dtos.ClientMenuDTO;
import com.entreprise.efood.dtos.OrderDTO;
import com.entreprise.efood.dtos.RetrieveCmdDTO;
import com.entreprise.efood.dtos.StatusDTO;
import com.entreprise.efood.enums.StatusEnum;
import com.entreprise.efood.repository.CommandeRepository;
import com.entreprise.efood.repository.LivraisonRepository;
import com.entreprise.efood.repository.MenuCommandeRepository;
import com.entreprise.efood.utils.encryDecry.EncryptionUtil;
import com.entreprise.efood.utils.exceptions.commandsExceptions.InvalValue;
import com.entreprise.efood.utils.exceptions.commandsExceptions.InvalidIdCommand;
import com.entreprise.efood.utils.validators.CommandeValidators;

@Service
public class OrderServiceImpl implements CommandService {
    @Autowired
    EncryptionUtil encryptionUtil;

    public OrderServiceImpl(EncryptionUtil encryptionUtil) {
        this.encryptionUtil = encryptionUtil;
    }

    @Autowired
    CommandeRepository commandeRepository;
    @Autowired
    LivraisonRepository lRepository;
    @Autowired
    MenuCommandeRepository menuCommandeRepository;

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    public ResponseEntity<Map<String, String>> storeOrder(OrderDTO orderDTO) {

        Map<String, String> message = new HashMap<>();

        try {
            if (CommandeValidators.validateCommandEntry(orderDTO)) {
                Long idClient = Long.parseLong(orderDTO.getIdClient());
                Client client = new Client();
                client.setId(idClient);
                Commande commande = new Commande();
                commande.setClient(client);
                commande.setDate_commande(Timestamp.from(Instant.now()));
                commande.setMontant(orderDTO.getMontant());
                commande.setEtat(StatusEnum.EN_COURS.toString());
                
                
                // Save commande
                Commande savCommande = commandeRepository.save(commande);

                String cmdId = Long.toString(savCommande.getId());

                String encrypString = encryptionUtil.encrypt(cmdId);

                final List<MenuCommande> menuCommandes = constructMenusCommand(orderDTO.getClientMenus(),savCommande);

               
                menuCommandeRepository.saveAll(menuCommandes);

                if (orderDTO.isLivrable()) {
                    // Instance of livraison
                    Livraison livraison = new Livraison();
                    livraison.setCommande(savCommande);
                    livraison.setCoordonnee_x(orderDTO.getCoordX());
                    livraison.setCoordonnee_y(orderDTO.getCoordY());
                    livraison.setDescription(orderDTO.getDescription());
                    // TODO:Create enumeration
                    livraison.setStatut("En cours");
                    livraison.setDate(Timestamp.from(Instant.now()));

                    // data persist
                    lRepository.save(livraison);

                    message.put("ok", "true");
                    message.put("idCmd", encrypString);
                    return new ResponseEntity<Map<String, String>>(message, HttpStatus.OK);
                } else {
                    System.out.println("Oups !");
                }
                message.put("response", encrypString);
                return new ResponseEntity<Map<String, String>>(message, HttpStatus.CREATED);
            }
        } catch (InvalValue e) {
            message.put("Error", e.getMessage());
            return new ResponseEntity<Map<String, String>>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            message.put("Error", e.getMessage());
            return new ResponseEntity<Map<String, String>>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        message.put("message", "Erreur lors de la création de la commande");
        return new ResponseEntity<Map<String, String>>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @SuppressWarnings("deprecation")
    @Override
    public Boolean getCommandById(StatusDTO statusDTO) {
        

        try {
            Long decryptedId = Long.parseLong(encryptionUtil.decrypt(statusDTO.getIdCmd()));
            Optional<Commande> theCommande =  commandeRepository.findById(decryptedId);
            Client client = new Client();
            client.setId(Long.parseLong(statusDTO.getIdClient()));

            if (theCommande != null) {
                theCommande.get().setEtat(StatusEnum.valueOf(statusDTO.getStatus()).toString());
                theCommande.get().setClient(client);
                commandeRepository.save(theCommande.get());
            }
           
            
            return true;
        } catch (InvalidIdCommand e) {
            
            return false;

        }
        catch(Exception e){
            return false;
        }

      
    }

    private List<MenuCommande> constructMenusCommand( ClientMenuDTO[] clientMenuDTOs,Commande cmd ){

        final List<MenuCommande> menuCommandes = new ArrayList<>();

        for (int index = 0; index < clientMenuDTOs.length; index++) {
            MenuCommande mCommande = new MenuCommande();
            Menu menu = new Menu();
            menu.setId(Long.parseLong(clientMenuDTOs[index].getId()));
            mCommande.setPreference( clientMenuDTOs[index].getPreference() );
            mCommande.setQuantite(clientMenuDTOs[index].getQuantite());
            mCommande.setCommande(cmd);
            mCommande.setMenu(menu);
            menuCommandes.add(mCommande);
          

        }
        return menuCommandes;
    }

    @Override
    public ResponseEntity<List<RetrieveCmdDTO>> getCommandsByStatus(StatusDTO statusDTO) {
        try {
            List<RetrieveCmdDTO> commmands = commandeRepository.findCommandsByEtat(statusDTO.getStatus());

            // System.out.println(commmands);
            
            return new ResponseEntity<List<RetrieveCmdDTO>>(commmands,HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            return null;
        }

        
    }

}
