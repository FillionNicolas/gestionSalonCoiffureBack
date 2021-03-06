package com.mreclamation.controller;

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

import com.mreclamation.DTO.ReclamationDTO;
import com.mreclamation.entities.Reclamation;
import com.mreclamation.mapper.IReclamationMapper;
import com.mreclamation.service.IReclamationService;

@CrossOrigin
@RestController
public class ReclamationController {
	
	@Autowired
	IReclamationService reclamationService;
	@Autowired
	IReclamationMapper reclamationMapper;
	
	
	@GetMapping("/reclamations")
	public List<ReclamationDTO> findAllReclamation() {
		return  (List<ReclamationDTO>)reclamationService.findAllReclamation().stream().map(e-> reclamationMapper.convertToReclamationDTO(e))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/reclamations/{id}")
	public ReclamationDTO findOneReclamation(@PathVariable("id") Long idReclamation) {
		return reclamationMapper.convertToReclamationDTO(reclamationService.findOneReclamation(idReclamation));
	}
	
	@PostMapping("/reclamations")
	public ReclamationDTO saveReclamation(@RequestBody Reclamation reclamation) {
		return reclamationMapper.convertToReclamationDTO(reclamationService.saveReclamation(reclamation));
	}
	
	@DeleteMapping("/reclamations/{id}")
	public void deleteReclamation(@PathVariable("id") Long idReclamation) {
		reclamationService.deleteReclamation(idReclamation);
	}
	
	@PutMapping("/reclamations/{id}")
	public ReclamationDTO updateReclamation(@RequestBody Reclamation reclamation, @PathVariable("id") Long idReclamation) {
		Reclamation currentReclamation = reclamationService.findOneReclamation(idReclamation);
		currentReclamation.setTitre(reclamation.getTitre());
		currentReclamation.setDescription(reclamation.getDescription());
		currentReclamation.setIdUtilisateur(reclamation.getIdUtilisateur());
		return reclamationMapper.convertToReclamationDTO(reclamationService.saveReclamation(currentReclamation));
	}

}
