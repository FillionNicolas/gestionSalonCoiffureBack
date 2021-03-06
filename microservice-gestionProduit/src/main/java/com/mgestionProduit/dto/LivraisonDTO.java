package com.mgestionProduit.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mgestionProduit.entites.Commande;

public class LivraisonDTO {

	private Long idLivraison;
	
	private Date livraisonDate;
	private String adresse;
	
	private List<Commande> commandes=new ArrayList<>();
	
	public LivraisonDTO() {}
	
	public LivraisonDTO(Long idLivraison, Date livraisonDate, String adresse,List<Commande> commandes ) {
		this.idLivraison = idLivraison;
		this.livraisonDate = livraisonDate;
		this.adresse = adresse;
		this.commandes = commandes;
	}

	public Long getIdLivraison() {
		return idLivraison;
	}

	public void setIdLivraison(Long idLivraison) {
		this.idLivraison = idLivraison;
	}

	public Date getLivraisonDate() {
		return livraisonDate;
	}

	public void setLivraisonDate(Date livraisonDate) {
		this.livraisonDate = livraisonDate;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}


	public String toString() {
		return "Livraison [idLivraison=" + idLivraison + ", livraisonDate=" + livraisonDate + ", adresse=" + adresse
				+ ", commandes=" + commandes + "]";
	}

}
