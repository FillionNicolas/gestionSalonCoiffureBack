package com.mreclamation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mreclamation.entities.Avis;
import com.mreclamation.repositories.AvisRepository;
import com.mreclamation.service.IAvisService;

@Service
public class AvisServiceImpl implements IAvisService{
	
	@Autowired
	AvisRepository avisRepository; 

	@Override
	public List<Avis> findAllAvis() {
		return avisRepository.findAll();
	}

	@Override
	public Avis findOneAvis(Long idAvis) {
		return avisRepository.getOne(idAvis);
	}

	@Override
	public Avis saveAvis(Avis avis) {
		return avisRepository.save(avis);
	}

	@Override
	public void deleteAvis(Long idAvis) {
		avisRepository.deleteById(idAvis);
	}

}
