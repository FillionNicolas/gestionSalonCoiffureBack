package com.clientui.beans;

import javax.persistence.ManyToOne;



public class ProduitBean {

	private Long idProduit;

	private String nom;
	private float prix;
	
	@ManyToOne
	private CommandeBean commande;



	public ProduitBean() {
	}

	public ProduitBean(Long idProduit, String nom, float prix, CommandeBean commande) {
		super();
		this.idProduit = idProduit;
		this.nom = nom;
		this.prix = prix;
		this.commande = commande;
	
	}

	public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}
	



	public CommandeBean getCommande() {
		return commande;
	}

	public void setCommande(CommandeBean commande) {
		this.commande = commande;
	}

	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", nom=" + nom + ", prix=" + prix + "]";
	}

}

