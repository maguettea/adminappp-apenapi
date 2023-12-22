package sn.isi.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sn.isi.dto.Produit;
import sn.isi.service.ProduitService;

import java.util.List;

@RestController
@RequestMapping("/produits")
public class ProduitController {
    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping
    public List<Produit> getProduits() {
        return produitService.getProduits();
    }

    @GetMapping("/{id}")
    public Produit getProduit(@PathVariable("id") int id) {
        return produitService.getProduit(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Produit createProduit(@Valid @RequestBody Produit produit) {
        return produitService.createProduit(produit);
    }

    @PutMapping("/{id}")
    public Produit updateProduit(@PathVariable("id") int id, @Valid @RequestBody Produit produit) {
        return produitService.updateProduit(id, produit);
    }

    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable("id") int id) {
        produitService.deleteProduit(id);
    }
}
