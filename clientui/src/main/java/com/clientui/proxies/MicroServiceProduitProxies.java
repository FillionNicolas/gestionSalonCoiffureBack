package com.clientui.proxies;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.clientui.beans.CommandeBean;
import com.clientui.beans.LivraisonBean;
import com.clientui.beans.ProduitBean;

@FeignClient(name = "microservice-gestionProduit")
@RibbonClient(name = "microservice-gestionProduit")
public interface MicroServiceProduitProxies {

	@GetMapping(value="microservice-gestionProduit/produits")
	List<ProduitBean> findAll();
	
	@GetMapping("/commandes")
	List<CommandeBean> findAllCommande();
	
	@GetMapping("/livraisons")
	List<LivraisonBean> findAllLivraisons();
	
	@GetMapping("/produits/{id}")
	public ProduitBean findOne(@PathVariable("id") Long id);
	
	@GetMapping("/commandes/{id}")
	public CommandeBean findOneCommande(@PathVariable("id") Long id);
		
	@GetMapping("/livraisons/{id}")
	public LivraisonBean findOneLivraisons(@PathVariable("id") Long id);
	
	@PostMapping("/livraisons")
	public LivraisonBean saveLivraison( @RequestBody LivraisonBean livraison);
	
	@PostMapping("/produits")
	public ProduitBean saveProduit(@RequestBody ProduitBean produit);
	
	@PostMapping("/commandes")
	public CommandeBean saveCommande (@RequestBody CommandeBean commandeBean );
	
	@PutMapping("/produits/{id}")
	public ProduitBean updateProduit(ProduitBean produit, @PathVariable("id") Long id);

	@PutMapping("/commandes/{id}")
	public CommandeBean updateCommande (CommandeBean commande, @PathVariable("id") Long id);

	@PutMapping("/livraisons/{id}")
	public LivraisonBean updateLivraison(LivraisonBean livraison, @PathVariable("id") Long id);
	
	@DeleteMapping("/produits/{id}")
	void deleteProduit(@PathVariable("id") Long id);
	
	@DeleteMapping("/commandes/{id}")
	void deleteCommande( @PathVariable("id") Long id);
	@DeleteMapping("/livraisons/{id}")
	void deleteLivraison(@PathVariable("id") Long id);
	
}
