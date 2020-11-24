package com.mgestionProduit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mgestionProduit.entites.Produit;
import com.mgestionProduit.services.IProduitService;



@CrossOrigin
@RestController
public class ProduitController {
	
	@Autowired
	IProduitService produitService;
	
	@GetMapping("/produits")
	public List<Produit> findAll(){
		return produitService.getProduits();
	}
	
	@GetMapping("/produits/{id}")
	public Produit findOne(@PathVariable("id") Long id) {
		return produitService.getProduit(id);
		
	}
	
	@PostMapping("/produits")
	public Produit saveProduit(@RequestBody Produit produit) {
		return produitService.saveProduit(produit);
	}
	
	@PutMapping("/produits/{id}")
	public Produit updateProduit(@RequestBody Produit produit, @PathVariable("id")Long id ) {
		Produit currentProduit = produitService.getProduit(id);
		currentProduit.setNom(produit.getNom());
		currentProduit.setPrix(produit.getPrix());
		currentProduit.setCommande(produit.getCommande());
		return produitService.saveProduit(currentProduit);
	}
	
	@DeleteMapping("/produits/{id}")
	public void deleteProduit(@PathVariable("id") Long id) {
		produitService.deleteProduit(id);

	}
}
