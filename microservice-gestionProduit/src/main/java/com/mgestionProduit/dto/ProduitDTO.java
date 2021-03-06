package com.mgestionProduit.dto;


import com.mgestionProduit.entites.Commande;

public class ProduitDTO {

	private Long idProduit;
	private Commande commande;

	private String nom;
	private float prix;

	public ProduitDTO() {
	}

	public ProduitDTO(Long idProduit, String nom, float prix, Commande commande) {
		super();
		this.idProduit = idProduit;
		this.nom = nom;
		this.prix = prix;

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
	
	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}


	public String toString() {
		return "Produit [idProduit=" + idProduit + ", nom=" + nom + ", prix=" + prix + " ]";
	}

}



