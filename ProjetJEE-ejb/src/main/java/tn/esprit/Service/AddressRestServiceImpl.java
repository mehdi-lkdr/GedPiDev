package tn.esprit.Service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.client.Client;

import tn.esprit.entities.Adress;


@Stateless(name = "addressRestServiceImpl")
public class AddressRestServiceImpl implements AddressService , AddressServiceRemote {

	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void saveAdresse(Adress adress) {
		// TODO Auto-generated method stub
		em.persist(adress);
	}

	@Override
	public void updateAdresse(Adress adress) {
		// TODO Auto-generated method stub
		em.merge(adress);
	}

	@Override
	public void deleteAdresse(String adressId) {
		// TODO Auto-generated method stub
		
		try {
			em.remove(getAdresseById(adressId));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Adress getAdresseById(String idAdresse) throws Exception {
		
			return new Adress() ; 
	}

	@Override
	public List<Adress> getListAdresse() {
		// TODO Auto-generated method stub
			return new ArrayList<Adress>() ;
		}

	
	
	
	
	
	
}
