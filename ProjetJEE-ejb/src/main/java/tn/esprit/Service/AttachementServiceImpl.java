package tn.esprit.Service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.entities.Attachement;


@Stateless
public class AttachementServiceImpl implements AttachementServiceLocal , AttachementServiceRemote {

	
	
	
	@PersistenceContext
	private EntityManager em;
	
	
	
	@Override
	public void saveAttachement(Attachement attachement) {
		// TODO Auto-generated method stub
		em.persist(attachement);
	}

	@Override
	public void updatettachement(Attachement attachement) {
		// TODO Auto-generated method stub
		em.merge(attachement);
	}

	@Override
	public void deleteAttachement(int attachementId) {
		// TODO Auto-generated method stub
		em.remove(getAttachement(attachementId));
		
	}

	@Override
	public Attachement getAttachement(int attachementId) {
		// TODO Auto-generated method stub
		return em.find(Attachement.class, attachementId);
	}

	@Override
	public List<Attachement> getAttachementList() {
		// TODO Auto-generated method stub
		return em.createQuery("select d from Attachement d", Attachement.class).getResultList() ; 
	}

}
