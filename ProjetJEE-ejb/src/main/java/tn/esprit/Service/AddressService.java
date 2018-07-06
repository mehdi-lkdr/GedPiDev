package tn.esprit.Service;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entities.Adress;

@Local
public interface AddressService {

	
	
	
	public void saveAdresse(Adress adress) ; 
	public void updateAdresse(Adress adress) ; 
	public void deleteAdresse(String adressId) ; 
	public Adress getAdresseById(String idAdresse) throws Exception ; 
	public List<Adress> getListAdresse();
	
	
	
	
	
}
