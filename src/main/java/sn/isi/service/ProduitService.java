package sn.isi.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.isi.dao.IProduitRepository;
import sn.isi.dto.Produit;
import sn.isi.entities.ProduitEntity;
import sn.isi.mapping.ProduitMapper;
import sn.isi.exception.EntityNotFoundException;
import sn.isi.exception.RequestException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProduitService {
    private IProduitRepository iProduitRepository;
    private ProduitMapper produitMapper;

    public ProduitService(IProduitRepository iProduitRepository, ProduitMapper produitMapper) {
        this.iProduitRepository = iProduitRepository;
        this.produitMapper = produitMapper;
    }

    @Transactional(readOnly = true)
    public List<Produit> getProduits() {
        return StreamSupport.stream(iProduitRepository.findAll().spliterator(), false)
                .map(produitMapper::toProduit)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Produit getProduit(int id) {
        return produitMapper.toProduit(iProduitRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Produit non trouvé avec l'ID : " + id)));
    }

    @Transactional
    public Produit createProduit(Produit produit) {
        ProduitEntity produitEntity = produitMapper.fromProduit(produit);
        return produitMapper.toProduit(iProduitRepository.save(produitEntity));
    }

    @Transactional
    public Produit updateProduit(int id, Produit produit) {
        if (!iProduitRepository.existsById(id)) {
            throw new EntityNotFoundException("Produit non trouvé avec l'ID : " + id);
        }

        ProduitEntity updatedProduitEntity = produitMapper.fromProduit(produit);
        updatedProduitEntity.setId(id);

        return produitMapper.toProduit(iProduitRepository.save(updatedProduitEntity));
    }


    @Transactional
    public void deleteProduit(int id) {
        try {
            iProduitRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException("Erreur lors de la suppression du produit avec l'ID : " + id, HttpStatus.CONFLICT);
        }
    }
}
