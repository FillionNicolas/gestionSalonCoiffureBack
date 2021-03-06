package  com.mgestionProduit.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Livraison implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLivraison;
	
	private Date livraisonDate;
	private String adresse;
	
	@OneToMany(mappedBy = "livraison")
	private List<Commande> commandes=new ArrayList<>();
	
	public Livraison() {}

	public Livraison(Long idLivraison, Date livraisonDate, String adresse, List<Commande> commandes) {
		super();
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public List<Commande> getCommandes() {
		return commandes;
	}



	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}


	@Override
	public String toString() {
		return "Livraison [idLivraison=" + idLivraison + ", livraisonDate=" + livraisonDate + ", adresse=" + adresse
				+ ", commandes=" + commandes + "]";
	}


}
