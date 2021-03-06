package  com.mgestionProduit.services;

import java.util.List;

import com.mgestionProduit.entites.Livraison;


public interface ILivraisonService {
	
	public Livraison saveLivraison(Livraison livraison);
	
	public void deleteLivraison(Long idLivraison);
	
	public List<Livraison> getLivraisons();
	
	public Livraison getLivraison(Long idLivraison);
	

}
