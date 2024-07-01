package com.entreprise.efood.Controllers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entreprise.efood.constants.AdhesionConstant;
import com.entreprise.efood.dtos.AdhesionDTO;
import com.entreprise.efood.services.AdhesionService;

@RestController
@RequestMapping(path = AdhesionConstant.ADHESION_REQUEST_MAPPING)
    public class AdhesionController {
        @Autowired
        private   AdhesionService adhesionService;
    
        @GetMapping("/ListeAdhesion")
        public ResponseEntity<List<AdhesionDTO>> getAllAdhesion() {
            try {
                return adhesionService.getAllAdhesion();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return new ResponseEntity<List<AdhesionDTO>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    
        @PostMapping("/SaveAdhesion")
        public Map<String ,String>  postMethodName(@RequestBody() Map<String ,String> adhesionDTO) {
            try {
                return adhesionService.createAdhesion(adhesionDTO);
                
            }
            catch (Exception e) {
                e.printStackTrace();
            }
    
            return null;
        }
    



        @PutMapping("/updateAdhesion/{id}")
        public ResponseEntity<Object> updateAdhesion(@PathVariable Long id, @RequestBody Map<String, String> adhesionDTO) {
            try {
                adhesionDTO.put("id", id.toString()); // Inject the id from URL into the DTO map
                AdhesionDTO updatedAdhesion = adhesionService.updateAdhesion(adhesionDTO);
                return ResponseEntity.ok(updatedAdhesion);
            } 
            catch (RuntimeException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
            }
        }
    


        @DeleteMapping(value = "/deleteAdhésion/{id}")
        public ResponseEntity<String> deleteAdhésions(@PathVariable("id") Long id ) {

            try {
                adhesionService.deleteAdhésions(id);
                return ResponseEntity.ok("adhésion supprimé avec succès");
            }
            catch (RuntimeException e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retourne 404 si le restaurant n'est pas trouvé
            }
        }

    

        @GetMapping("/getAdhesionById/{id}")
        public ResponseEntity<AdhesionDTO> getAdhesionById(@PathVariable("id") Long id) {
        try {
            return adhesionService.getAdhesionById(id);
        } 
        catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retourne 404 si le restaurant n'est pas trouvé
        }
    }
}
