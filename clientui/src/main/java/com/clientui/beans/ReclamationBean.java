package com.clientui.beans;

public class ReclamationBean {

	private Long idReclamation;
	private String titre;
	private String description;
	private Long idUtilisateur;
	
	public ReclamationBean() {
		
	}
	
//	public ReclamationBean(Long idReclamation, String titre, String description) {
//		super();
//		this.idReclamation = idReclamation;
//		this.titre = titre;
//		this.description = description;
//	}
	
	public ReclamationBean(Long idReclamation, String titre, String description, Long idUtilisateur) {
		super();
		this.idReclamation = idReclamation;
		this.titre = titre;
		this.description = description;
		this.idUtilisateur = idUtilisateur;
	}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public Long getIdReclamation() {
		return idReclamation;
	}

	public void setIdReclamation(Long idReclamation) {
		this.idReclamation = idReclamation;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Reclamation [idReclamation=" + idReclamation + ", titre=" + titre + ", description=" + description
				+ "]";
	}	

}
