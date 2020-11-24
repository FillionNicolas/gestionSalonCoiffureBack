package com.mreclamation.controller;

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

import com.mreclamation.entities.Reclamation;
import com.mreclamation.service.IReclamationService;

@CrossOrigin
@RestController
public class ReclamationController {
	
	@Autowired
	IReclamationService reclamationService;
	
	@GetMapping("/reclamations")
	public List<Reclamation> findAllReclamation() {
		return reclamationService.findAllReclamation();
	}
	
	@GetMapping("/reclamations/{id}")
	public Reclamation findOneReclamation(@PathVariable("id") Long idReclamation) {
		return reclamationService.findOneReclamation(idReclamation);
	}
	
	@PostMapping("/reclamations")
	public Reclamation saveReclamation(@RequestBody Reclamation reclamation) {
		return reclamationService.saveReclamation(reclamation);
	}
	
	@DeleteMapping("/reclamations/{id}")
	public void deleteReclamation(@PathVariable("id") Long idReclamation) {
		reclamationService.deleteReclamation(idReclamation);
	}
	
	@PutMapping("/reclamations/{id}")
	public Reclamation updateReclamation(@RequestBody Reclamation reclamation, @PathVariable("id") Long idReclamation) {
		Reclamation currentReclamation = reclamationService.findOneReclamation(idReclamation);
		currentReclamation.setTitre(reclamation.getTitre());
		currentReclamation.setDescription(reclamation.getDescription());
		currentReclamation.setIdUtilisateur(reclamation.getIdUtilisateur());
		return reclamationService.saveReclamation(currentReclamation);
	}

}
