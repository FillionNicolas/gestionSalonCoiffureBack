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

import com.mreclamation.entities.Avis;
import com.mreclamation.service.IAvisService;

@CrossOrigin
@RestController
public class AvisController {
	
	@Autowired
	IAvisService avisService;
	
	@GetMapping("/avis")
	public List<Avis> findAll(){
		return avisService.findAllAvis();
	}
	
	@GetMapping("/avis/{idAvis}")
	public Avis findOne(@PathVariable("idAvis") Long idAvis) {
		return avisService.findOneAvis(idAvis);
	}
	
	@PostMapping("/avis")
	public Avis saveAvis(@RequestBody Avis avis) {
		return avisService.saveAvis(avis);
		
	}
	
	@DeleteMapping("/avis/{idAvis}")
	public void deleteAvis(@PathVariable("idAvis") Long idAvis) {
		avisService.deleteAvis(idAvis);
	}
	
	@PutMapping("/avis/{idAvis}")
	public Avis updateAvis(@PathVariable("idAvis") Long idAvis, @RequestBody Avis avis) {
		Avis currentAvis = avisService.findOneAvis(idAvis);
		currentAvis.setTitre(avis.getTitre());
		currentAvis.setDescription(avis.getDescription());
		currentAvis.setIdUtilisateur(avis.getIdUtilisateur());
		return avisService.saveAvis(currentAvis);
	}

}
