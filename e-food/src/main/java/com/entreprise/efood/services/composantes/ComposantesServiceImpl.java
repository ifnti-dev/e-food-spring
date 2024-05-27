package com.entreprise.efood.services.composantes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.entreprise.efood.Models.Composant;
import com.entreprise.efood.dtos.ComposantDTO;
import com.entreprise.efood.repository.ComposantRepository;
import com.entreprise.efood.utils.exceptions.composantExceptions.InvalidNameValueForComposant;
import com.entreprise.efood.utils.exceptions.composantExceptions.InvalidPriceValueForComposant;
import com.entreprise.efood.utils.validators.ComposantValidators;
import com.entreprise.efood.mappers.ComposantMapper;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ComposantesServiceImpl implements ComposantesService {

    @Autowired
    private ComposantRepository composantRepository;

    @Override
    /*
     * cette méthode permet de retourner la liste des composantes de menu
     * elle retourne une réponse Http contenant un message et un code HTTP
     */

    public ResponseEntity<Map<String, List<ComposantDTO>>> getAllComposants() {
        Map<String, List<ComposantDTO>> mappedComposants = new HashMap<>();
        try {
            List<ComposantDTO> composants = composantRepository.getComposants();
            mappedComposants.put("composantes", composants);
            return new ResponseEntity<Map<String, List<ComposantDTO>>>(mappedComposants, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mappedComposants.put("composantes", new ArrayList<>());
        return new ResponseEntity<Map<String, List<ComposantDTO>>>(mappedComposants, HttpStatus.OK);
    }

    @Override
    /*
     * cette méthode permet de créer une composante de menu
     * elle retourne une réponse Http contenant un message et un code de la reponse
     */
    public ResponseEntity<Map<String, String>> addComponsant(ComposantDTO composantDTO) {
        Map<String, String> message = new HashMap<>();
        try {
            Composant composant = new Composant();
            if (ComposantValidators.validateComposantEntry(composantDTO)) {
                composant = ComposantMapper.maptoComposant(composantDTO, composant);
                composantRepository.save(composant);

                message.put("message", "Compsante de menu crée avec succès");
                return new ResponseEntity<Map<String, String>>(message, HttpStatus.CREATED);
            }
        } catch (InvalidPriceValueForComposant e) {
            message.put("message", "Erreur lors de la création de la composante de menu : le prix donné est négatif");
            return new ResponseEntity<Map<String, String>>(message, HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (InvalidNameValueForComposant e) {
            message.put("message",
                    "Erreur lors de la création de la composante de menu : le nom de la composante n'a pas été renseigné");
            return new ResponseEntity<Map<String, String>>(message, HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (Exception e) {
            e.printStackTrace();
        }
        message.put("message", "Erreur lors de la création de la composante de menu");
        return new ResponseEntity<Map<String, String>>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    /*
     * cette methode permet de modifier une composante
     * elle retourne une réponse HTTP contenant un message et le code de la reponse
     */
    public ResponseEntity<Map<String, String>> updateComposant(ComposantDTO composantDTO, String id) {
        Map<String, String> message = new HashMap<>();
        try {
            Composant composant = composantRepository.getById(Long.parseLong(id));
            if (composant != null) {
                if (ComposantValidators.validateComposantEntry(composantDTO)) {
                    composant = ComposantMapper.maptoComposant(composantDTO, composant);
                    composantRepository.save(composant);
                    message.put("message", "Compsante de menu crée avec succès");
                    return new ResponseEntity<Map<String, String>>(message, HttpStatus.CREATED);
                }
            }

        } catch (EntityNotFoundException e) {
            message.put("message", "Composante de menu introuvable");
            return new ResponseEntity<Map<String, String>>(message, HttpStatus.NOT_FOUND);
        } catch (InvalidPriceValueForComposant e) {
            message.put("message", "Erreur lors de la création de la composante de menu : le prix donné est négatif");
            return new ResponseEntity<Map<String, String>>(message, HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (InvalidNameValueForComposant e) {
            message.put("message",
                    "Erreur lors de la création de la composante de menu : le nom de la composante n'a pas été renseigné");
            return new ResponseEntity<Map<String, String>>(message, HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (Exception e) {
            e.printStackTrace();
        }
        message.put("message", "Erreur lors de la création de la composante de menu");
        return new ResponseEntity<Map<String, String>>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<Map<String, String>> deleteComposant(String id) {
        Map<String, String> message = new HashMap<>();
        try {
            System.out.println(id);
            Composant composant = composantRepository.getById(Long.parseLong(id));
            if (composant != null) {
                composantRepository.delete(composant);
                message.put("message", "Composante de menu supprimée");
                return new ResponseEntity<Map<String, String>>(message, HttpStatus.OK);
            }

        } catch (EntityNotFoundException e) {
            message.put("message", "Composante de menu introuvable");
            return new ResponseEntity<Map<String, String>>(message, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
        }
        message.put("message", "Erreur lors de la suppression de la composante de menu");
        return new ResponseEntity<Map<String, String>>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
