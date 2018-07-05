package tn.esprit.Service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import tn.esprit.entities.Courrier;



@Stateless
public class CourrierServiceImpl implements CourrierServiceLocal , CourrierServiceRemote {

	
	
	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public void saveCourrier(Courrier courrier) {
		// TODO Auto-generated method stub
		em.persist(courrier);
	}

	@Override
	public void updateCourrier(Courrier courrier) {
		// TODO Auto-generated method stub
		em.merge(courrier);
	}

	@Override
	public void deleteCourrier(int courrierId) {
		// TODO Auto-generated method stub
		em.remove(getCourrier(courrierId));
	}

	@Override
	public Courrier getCourrier(int courrierId) {
		// TODO Auto-generated method stub
		return em.find(Courrier.class, courrierId);
	}

	@Override
	public List<Courrier> getCourrierList() {
		// TODO Auto-generated method stub
		return em.createQuery("select d from Courrier d", Courrier.class).getResultList() ; 
	}

}
