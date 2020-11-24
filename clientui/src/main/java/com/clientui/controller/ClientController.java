package com.clientui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clientui.beans.AvisBean;
import com.clientui.beans.ReclamationBean;
import com.clientui.beans.UtilisateurBean;
import com.clientui.proxies.MicroServiceReclamationProxies;
import com.clientui.proxies.MicroServiceUtilisateurProxies;

@CrossOrigin
@RestController
public class ClientController {
	
	@Autowired
	private MicroServiceReclamationProxies microServiceReclamationProxies;
	
	@Autowired
	private MicroServiceUtilisateurProxies microServiceUtilisateurProxies;
	
	//microserviceReclamation - Reclamation
//	@RequestMapping("/reclamations")
//	public String reclamation(Model model) {
//		List<ReclamationBean> reclamation = microServiceReclamationProxies.findAllReclamation();
//		model.addAttribute("reclamation", reclamation);
//		return "Reclamation";
//	}
	
	@GetMapping("/reclamations")
	public List<ReclamationBean> getReclamations() {
		return microServiceReclamationProxies.findAllReclamation();
	}
	
	@GetMapping("/reclamations/{id}")
	public ReclamationBean findReclamation(@PathVariable("id") Long id) {
		return microServiceReclamationProxies.findOneReclamation(id);
	}
	
	@PostMapping("/reclamations")
	public ReclamationBean saveReclamation(@RequestBody ReclamationBean reclamation) {
		return microServiceReclamationProxies.saveReclamation(reclamation);
	}
	
	@PutMapping("/reclamations/{id}")
	public ReclamationBean updateReclamation(@PathVariable("id") Long idReclamation, @RequestBody ReclamationBean reclamation) {
		ReclamationBean currentReclamation = microServiceReclamationProxies.findOneReclamation(idReclamation);
		currentReclamation.setTitre(reclamation.getTitre());
		currentReclamation.setDescription(reclamation.getDescription());
		currentReclamation.setIdUtilisateur(reclamation.getIdUtilisateur());
		
		return microServiceReclamationProxies.saveReclamation(currentReclamation);
	}
	
	@DeleteMapping("/reclamations/{id}")
	void deleteReclamation(@PathVariable("id") Long id) {
		microServiceReclamationProxies.deleteReclamation(id);
	}
	
	
	//microserviceReclamation - Avis
//	@RequestMapping("/avis")
//	public String avis(Model model) {
//		List<AvisBean> avis = microServiceReclamationProxies.findAllAvis();
//		model.addAttribute("avis", avis);
//		return "Avis";
//	}
	@GetMapping("/avis")
	public List<AvisBean> getAviss() {
		return microServiceReclamationProxies.findAllAvis();
	}
	
	@GetMapping("/avis/{id}")
	public AvisBean findAvis(@PathVariable("id") Long id) {
		return microServiceReclamationProxies.findOneAvis(id);
	}
	
	@PostMapping("/avis")
	public AvisBean saveAvis(@RequestBody AvisBean avis) {
		return microServiceReclamationProxies.saveAvis(avis);
	}
	
	@PutMapping("/avis/{id}")
	public AvisBean updateAvis(@PathVariable("id") Long idAvis, @RequestBody AvisBean avis) {
		AvisBean currentAvis = microServiceReclamationProxies.findOneAvis(idAvis);
		currentAvis.setTitre(avis.getTitre());
		currentAvis.setDescription(avis.getDescription());
		currentAvis.setIdUtilisateur(avis.getIdUtilisateur());
		return microServiceReclamationProxies.saveAvis(currentAvis);
	}
	
	@DeleteMapping("/avis/{id}")
	void deleteAvis(@PathVariable("id") Long id) {
		microServiceReclamationProxies.deleteAvis(id);
	}
	
	//microserviceUtilisateur
	
//	@RequestMapping("/utilisateur")
//	public String utilisateur(Model model) {
//		List<UtilisateurBean> utilisateur = microServiceUtilisateurProxies.findAllUtilisateur();
//		model.addAttribute("utilisateur", utilisateur);
//		return "Utilisateur";
//	}
	
	@GetMapping("/utilisateurs")
	public List<UtilisateurBean> getUtilisateurs() {
		return microServiceUtilisateurProxies.findAllUtilisateur();
	}
	
	@GetMapping("/utilisateurs/{id}")
	public UtilisateurBean findUtilisateur(@PathVariable("id") Long id) {
		return microServiceUtilisateurProxies.findOneUtilisateur(id);
	}
	
	@PostMapping("/utilisateurs")
	public UtilisateurBean saveUtilisateur(@RequestBody UtilisateurBean utilisateur) {
		return microServiceUtilisateurProxies.saveUtilisateur(utilisateur);
	}
	
	@PutMapping("/utilisateurs/{id}")
	public UtilisateurBean updateUtilisateur(@PathVariable("id") Long idUtilisateur, @RequestBody UtilisateurBean utilisateur) {
		UtilisateurBean currentUtilisateur = microServiceUtilisateurProxies.findOneUtilisateur(idUtilisateur);
		currentUtilisateur.setNomUtilisateur(utilisateur.getNomUtilisateur());
		currentUtilisateur.setPrenomUtilisateur(utilisateur.getPrenomUtilisateur());
		currentUtilisateur.setLoginUtilisateur(utilisateur.getLoginUtilisateur());
		currentUtilisateur.setPasswordUtilisateur(utilisateur.getPasswordUtilisateur());
		currentUtilisateur.setDateNaissanceUtilisateur(utilisateur.getDateNaissanceUtilisateur());
		currentUtilisateur.setNumeroTelephoneUtilisateur(utilisateur.getNumeroTelephoneUtilisateur());
		currentUtilisateur.setVilleUtilisateur(utilisateur.getVilleUtilisateur());
		currentUtilisateur.setAdresseUtilisateur(utilisateur.getAdresseUtilisateur());
		currentUtilisateur.setRoleUtilisateur(utilisateur.getRoleUtilisateur());
		
		return microServiceUtilisateurProxies.saveUtilisateur(currentUtilisateur);
	}
	
	@DeleteMapping("/utilisateurs/{id}")
	void deleteUtilisateur(@PathVariable("id") Long id) {
		microServiceUtilisateurProxies.deleteUtilisateur(id);
	}
}
