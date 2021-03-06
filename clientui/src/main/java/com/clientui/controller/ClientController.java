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
import com.clientui.beans.CommandeBean;
import com.clientui.beans.LivraisonBean;
import com.clientui.beans.PrestationBean;
import com.clientui.beans.ProduitBean;
import com.clientui.beans.ReclamationBean;
import com.clientui.beans.ReservationBean;
import com.clientui.beans.SalonBean;
import com.clientui.beans.UtilisateurBean;
import com.clientui.proxies.MicroServiceProduitProxies;
import com.clientui.proxies.MicroServiceReclamationProxies;
import com.clientui.proxies.MicroServiceReservationProxies;
import com.clientui.proxies.MicroServiceUtilisateurProxies;

@CrossOrigin
@RestController
public class ClientController {
	
	@Autowired
	private MicroServiceReclamationProxies microServiceReclamationProxies;
	
	@Autowired
	private MicroServiceUtilisateurProxies microServiceUtilisateurProxies;
	
	@Autowired
	private MicroServiceReservationProxies microServiceReservationProxies;
	
	@Autowired
	private MicroServiceProduitProxies microServiceProduitProxies;
	
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
	
	//Produits
	
	@GetMapping("/produits")
	public List<ProduitBean> getProduits() {
		return microServiceProduitProxies.findAll();
		
	}
	@GetMapping("/commandes")
	public List<CommandeBean> getCommandes() {
		return microServiceProduitProxies.findAllCommande();
	}
	@GetMapping("/livraisons")
	public List<LivraisonBean> getLivraisons() {
		return microServiceProduitProxies.findAllLivraisons();
	}
	
	@GetMapping("/produits/{id}")
	public ProduitBean findProduit(@PathVariable("id") Long id) {
		return microServiceProduitProxies.findOne(id);
	}
	@GetMapping("/commandes/{id}")
	public CommandeBean findCommande(@PathVariable("id") Long id) {
		return microServiceProduitProxies.findOneCommande(id);
	}
	
	@GetMapping("/livraisons/{id}")
	public LivraisonBean findLivraison(@PathVariable("id") Long id) {
		return microServiceProduitProxies.findOneLivraisons(id);
	}
	
	@PostMapping("/livraisons")
	public LivraisonBean saveCommande(@RequestBody LivraisonBean livraison) {
		 return microServiceProduitProxies.saveLivraison(livraison);
			
	}
	@PostMapping("/produits")
	public ProduitBean saveProduit(@RequestBody ProduitBean produit) {
		 return microServiceProduitProxies.saveProduit(produit);
	}
	@PostMapping("/commandes")
	public CommandeBean saveCommande(@RequestBody CommandeBean commande) {
		 return microServiceProduitProxies.saveCommande(commande);
	}
	@PutMapping("/produits/{id}")
	public ProduitBean updateProduit(@PathVariable("id") long idProduit, @RequestBody ProduitBean produit) {
		ProduitBean currentProduit = microServiceProduitProxies.findOne(idProduit);
		currentProduit.setCommande(produit.getCommande());
		currentProduit.setNom(produit.getNom());
		currentProduit.setPrix(produit.getPrix());
		
		return microServiceProduitProxies.saveProduit(currentProduit);

	}
	@PutMapping("/commandes/{id}")
	public CommandeBean updateCommande(@PathVariable("id") long idCommande, @RequestBody CommandeBean commande) {
		CommandeBean currentCommande = microServiceProduitProxies.findOneCommande(idCommande);
		currentCommande.setDateAchat(commande.getDateAchat());
		currentCommande.setLivraison(commande.getLivraison());
		currentCommande.setPrix(commande.getPrix());
		currentCommande.setProduits(commande.getProduits());
		return microServiceProduitProxies.saveCommande(currentCommande);

	}
	
	@PutMapping("/livraisons/{id}")
	public LivraisonBean updateLivraison(@PathVariable("id") long idLivraison, @RequestBody LivraisonBean livraison) {
		LivraisonBean currentLivraison = microServiceProduitProxies.findOneLivraisons(idLivraison);
		currentLivraison.setAdresse(livraison.getAdresse());
		currentLivraison.setCommandes(livraison.getCommandes());
		currentLivraison.setLivraisonDate(livraison.getLivraisonDate());
		return microServiceProduitProxies.saveLivraison(currentLivraison);

	}
	
	@DeleteMapping("/produits/{id}")
	void deleteProduit(@PathVariable("id") Long id) {
		microServiceProduitProxies.deleteProduit(id);
		}
	@DeleteMapping("/commandes/{id}")
	void deleteCommande(@PathVariable("id") Long id) {
		microServiceProduitProxies.deleteCommande(id);
		}
	
	@DeleteMapping("/livraisons/{id}")
	void deleteLivraison(@PathVariable("id") Long id) {
		microServiceProduitProxies.deleteLivraison(id);
	
	}
	
	//Reservation
	
	@GetMapping("/reservations")
	public List<ReservationBean> getReservations() {
		return microServiceReservationProxies.findAllReservation();
		
	}
	
	@GetMapping("/reservations/{id}")
	public ReservationBean findReservation(@PathVariable("id") Long id) {
		return microServiceReservationProxies.findOneReservation(id);
	}
	
	@PostMapping("/reservations")
	public ReservationBean saveProduit(@RequestBody ReservationBean reservation) {
		 return microServiceReservationProxies.saveReservation(reservation);
			
	}
	
	@PutMapping("/reservations/{id}")
	public ReservationBean updateReservation(@PathVariable("id") long idReservation, @RequestBody ReservationBean reservation) {
		ReservationBean currentReservation = microServiceReservationProxies.findOneReservation(idReservation);
		currentReservation.setDateReservation(reservation.getDateReservation());
		return microServiceReservationProxies.saveReservation(currentReservation);

	}
	
	
	
	
	
	@GetMapping("/prestations")
	public List<PrestationBean> getPrestations() {
		return microServiceReservationProxies.findAllPrestation();
		
	}
	
	@GetMapping("/prestations/{id}")
	public PrestationBean findPrestation(@PathVariable("id") Long id) {
		return microServiceReservationProxies.findOnePrestation(id);
	}
	
	@PostMapping("/prestations")
	public PrestationBean savePrestation(@RequestBody PrestationBean prestation) {
		 return microServiceReservationProxies.savePrestation(prestation);
			
	}
	
	@PutMapping("/prestations/{id}")
	public PrestationBean updatePrestation(@PathVariable("id") long idPrestation, @RequestBody PrestationBean prestation) {
		PrestationBean currentPrestation = microServiceReservationProxies.findOnePrestation(idPrestation);
		currentPrestation.setNomPrestation(prestation.getNomPrestation());
		return microServiceReservationProxies.savePrestation(currentPrestation);

	}
	
	
	
	
	@GetMapping("/salons")
	public List<SalonBean> getSalons() {
		return microServiceReservationProxies.findAllSalon();
		
	}
	
	@GetMapping("/salons/{id}")
	public SalonBean findSalon(@PathVariable("id") Long id) {
		return microServiceReservationProxies.findOneSalon(id);
	}
	
	@PostMapping("/salons")
	public SalonBean saveSalon(@RequestBody SalonBean salon) {
		 return microServiceReservationProxies.saveSalon(salon);
			
	}
	
	@PutMapping("/salons/{id}")
	public SalonBean updateSalon(@PathVariable("id") long idSalon, @RequestBody SalonBean salon) {
		SalonBean currentSalon = microServiceReservationProxies.findOneSalon(idSalon);
		currentSalon.setNomSalon(salon.getNomSalon());
		currentSalon.setAdresseSalon(salon.getAdresseSalon());
		currentSalon.setPhonenumber(salon.getPhonenumber());
		
		return microServiceReservationProxies.saveSalon(currentSalon);

	}
}
