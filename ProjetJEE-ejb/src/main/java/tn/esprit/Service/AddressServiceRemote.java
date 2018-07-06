package tn.esprit.Service;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entities.Adress;

@Remote
public interface AddressServiceRemote {

	
	public void saveAdresse(Adress adress) ; 
	public void updateAdresse(Adress adress) ; 
	public void deleteAdresse(String adressId) ; 
	public Adress getAdresseById(String idAdresse) throws Exception ; 
	public List<Adress> getListAdresse();
}
