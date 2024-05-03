package com.entreprise.efood.services;



import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.entreprise.efood.Models.Publicite;
import com.entreprise.efood.repository.PubliciteRepository;

@Service
@Transactional(readOnly = true)
public class PubliciteService {
    private final PubliciteRepository repo;

    PubliciteService(PubliciteRepository repository) {
        this.repo = repository;
    }
// Liste des pubs
    public List<Publicite> findAll() {
        return repo.findAll();
    }
// creation d'une pub
    public Publicite saveOne(Publicite pub) {
        Publicite publicite = repo.save(pub);
        return publicite;
    }
// supprimer une pub
public void deleteOne(final Long id) {
    repo.deleteById(id);
}    

// Trouver une pub donnée
public Optional<Publicite> getOne(final Long id) {
        return repo.findById(id);
    }



}
