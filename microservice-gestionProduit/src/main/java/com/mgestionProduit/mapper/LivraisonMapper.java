package com.mgestionProduit.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.mgestionProduit.dto.LivraisonDTO;
import com.mgestionProduit.entites.Livraison;

@Component
public class LivraisonMapper implements ILivraisonMapper{

	ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public LivraisonDTO convertToLivraisonDTO(Livraison livraison) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		LivraisonDTO livraisonDTO = modelMapper.map(livraison, LivraisonDTO.class);
		return livraisonDTO;
	}

	@Override
	public Livraison convertToLivraison(LivraisonDTO livraisonDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Livraison livraison = modelMapper.map(livraisonDTO, Livraison.class);
		return livraison;
	}

}
