package com.mgestionProduit.servicesImpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgestionProduit.entites.Commande;
import com.mgestionProduit.repositories.ICommandeRepository;
import com.mgestionProduit.services.ICommandeService;



@Service
public class CommandeServiceImpl implements ICommandeService{
	
	@Autowired
	ICommandeRepository commandeRepository;

	@Override
	public Commande saveCommade(Commande commande) {
		return commandeRepository.save(commande);
	}

	@Override
	public void deleteCommande(Long idCommande) {
		commandeRepository.deleteById(idCommande);
		
	}

	@Override
	public List<Commande> getCommandes() {
		return commandeRepository.findAll();
	}

	@Override
	public Commande getCommande(Long idCommande) {
		return commandeRepository.findById(idCommande).get();
	}
}
