package com.mutilisateur.controller;

import java.util.List;
import java.util.Optional;
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

import com.mutilisateur.DTO.UtilisateurDTO;
import com.mutilisateur.entity.Utilisateur;
import com.mutilisateur.mapper.IUtilisateurMapper;
import com.mutilisateur.service.IUtilisateurService;

@CrossOrigin
@RestController
public class UtilisateurController {

	@Autowired
	IUtilisateurService utilisateurService;
	@Autowired
	IUtilisateurMapper utilisateurMapper;
	
	@PostMapping("/utilisateurs")
	public UtilisateurDTO save(@RequestBody Utilisateur utilisateur) {
		return utilisateurMapper.convertToUtilisateurDTO(utilisateurService.saveUtilisateur(utilisateur));
	}
	
	@GetMapping("/utilisateurs")
	public List<UtilisateurDTO> findUtilisateurs(){
		return (List<UtilisateurDTO>) utilisateurService.findUtilisateurs().stream().map(e-> utilisateurMapper.convertToUtilisateurDTO(e))
				.collect(Collectors.toList());
	}


	@DeleteMapping("/utilisateurs/{id}")
	public void deleteUtilisateurById(@PathVariable("id") Long id) {
		utilisateurService.deleteUtilisateurById(id);
	}

	@PutMapping("/utilisateurs/{id}")
	public UtilisateurDTO updateUtilisateur(@PathVariable("id") Long id, @RequestBody Utilisateur utilisateur) {
		Utilisateur currentUtilisateur = utilisateurService.findUtilisateur(id);
		currentUtilisateur.setNomUtilisateur(utilisateur.getNomUtilisateur());
		currentUtilisateur.setPrenomUtilisateur(utilisateur.getPrenomUtilisateur());
		currentUtilisateur.setLoginUtilisateur(utilisateur.getLoginUtilisateur());
		currentUtilisateur.setPasswordUtilisateur(utilisateur.getPasswordUtilisateur());
		currentUtilisateur.setDateNaissanceUtilisateur(utilisateur.getDateNaissanceUtilisateur());
		currentUtilisateur.setNumeroTelephoneUtilisateur(utilisateur.getNumeroTelephoneUtilisateur());
		currentUtilisateur.setVilleUtilisateur(utilisateur.getVilleUtilisateur());
		currentUtilisateur.setAdresseUtilisateur(utilisateur.getAdresseUtilisateur());
		currentUtilisateur.setRoleUtilisateur(utilisateur.getRoleUtilisateur());
		return utilisateurMapper.convertToUtilisateurDTO(utilisateurService.saveUtilisateur(currentUtilisateur));
	}
	
}
