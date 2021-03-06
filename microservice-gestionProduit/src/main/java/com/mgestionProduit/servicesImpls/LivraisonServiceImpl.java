package com.mgestionProduit.servicesImpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgestionProduit.entites.Livraison;
import com.mgestionProduit.repositories.ILivraisonRepository;
import com.mgestionProduit.services.ILivraisonService;



@Service
public class LivraisonServiceImpl implements ILivraisonService{

	@Autowired
	ILivraisonRepository livraisonRepository;

	@Override
	public Livraison saveLivraison(Livraison livraison) {

		return livraisonRepository.save(livraison);
	}

	@Override
	public void deleteLivraison(Long idLivraison) {
		livraisonRepository.deleteById(idLivraison);

	}

	@Override
	public List<Livraison> getLivraisons() {
		return livraisonRepository.findAll();
	}

	@Override
	public Livraison getLivraison(Long idLivraison) {
		return livraisonRepository.findById(idLivraison).get();
	}




}
