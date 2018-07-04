package tn.esprit.Service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.entities.Correspondent;

@Stateless
public class CorrespondentServiceImpl implements CorrespondentServicelocal , CorrespondentServiceRemote{

	
	@PersistenceContext
	private EntityManager em;
	
	
	
	@Override
	public void saveCorrespondent(Correspondent corresp) {
		// TODO Auto-generated method stub
		em.persist(corresp);
	}

	@Override
	public void updateCorrespondent(Correspondent corresp) {
		// TODO Auto-generated method stub
		em.merge(corresp) ; 
	}

	@Override
	public void deleteCorrespondent(int correspId) {
		// TODO Auto-generated method stub
		
		em.remove(getCorrespondent(correspId));
	}

	@Override
	public Correspondent getCorrespondent(int correspondentId) {
		// TODO Auto-generated method stub
		return em.find(Correspondent.class, correspondentId);
	}

	@Override
	public List<Correspondent> getCorrespondentList() {
		// TODO Auto-generated method stub
		return em.createQuery("select d from Correspondent d", Correspondent.class).getResultList() ; 
	}

	
	
	
	
}
