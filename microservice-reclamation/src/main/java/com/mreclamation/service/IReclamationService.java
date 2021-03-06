package com.mreclamation.service;

import java.util.List;

import com.mreclamation.entities.Reclamation;

public interface IReclamationService {

	public Reclamation saveReclamation(Reclamation reclamation);
	
	public List<Reclamation> findAllReclamation();
	
	public Reclamation findOneReclamation(Long idReclamation);
	
	void deleteReclamation(Long idReclamation);
	

}
