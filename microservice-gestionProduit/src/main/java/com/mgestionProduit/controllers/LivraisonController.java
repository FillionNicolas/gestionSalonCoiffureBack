package com.mgestionProduit.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.mgestionProduit.dto.LivraisonDTO;
import com.mgestionProduit.entites.Livraison;
import com.mgestionProduit.mapper.ILivraisonMapper;
import com.mgestionProduit.services.ILivraisonService;



@CrossOrigin
@RestController
public class LivraisonController {
	
	@Autowired
	ILivraisonMapper livraisonMapper;
	@Autowired
	ILivraisonService livraisonService;
	
	@PostMapping("/livraisons")
	public LivraisonDTO save(@RequestBody Livraison livraison) {
		return livraisonMapper.convertToLivraisonDTO( livraisonService.saveLivraison(livraison));
	}

	@DeleteMapping("/livraisons/{id}")
	public void deleteOneByID(@PathVariable("id") Long id) {
		livraisonService.deleteLivraison(id);
	}

	
	@GetMapping("/livraisons/{id}")
	public LivraisonDTO findOne(@PathVariable("id") Long id) {
		return livraisonMapper.convertToLivraisonDTO(livraisonService.getLivraison(id));
		
	}
	@GetMapping("/livraisons")
	public List<LivraisonDTO> findAll() {
		return (List<LivraisonDTO>)livraisonService.getLivraisons().stream().map(e->livraisonMapper.convertToLivraisonDTO(e))
				.collect(Collectors.toList());
	}
	
	@PutMapping("/livraisons/{id}")
	public LivraisonDTO updateLivraison(@RequestBody Livraison livraison , @PathVariable("id")Long id ) {
		Livraison currentLivraison = livraisonService.getLivraison(id);
		currentLivraison.setAdresse(livraison.getAdresse());
		currentLivraison.setCommandes(livraison.getCommandes());
		currentLivraison.setLivraisonDate(livraison.getLivraisonDate());;
		
		return livraisonMapper.convertToLivraisonDTO( livraisonService.saveLivraison(livraison));
	}

	
	

}
