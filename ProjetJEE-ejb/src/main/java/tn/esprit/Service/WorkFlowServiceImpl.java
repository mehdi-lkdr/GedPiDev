package tn.esprit.Service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.entities.Document;
import tn.esprit.entities.Workflow;

@Stateless
public class WorkFlowServiceImpl implements WorkFlowServiceLocal , WorkFlowServiceRemote {
	
	
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void saveWorkFlow(Workflow wf) {
		// TODO Auto-generated method stub
		em.persist(wf);
	}

	@Override
	public void updateWorkFlow(Workflow wf) {
		// TODO Auto-generated method stub
		em.merge(wf) ;
	}

	@Override
	public void deleteWorkFlow(String wfId) {
		// TODO Auto-generated method stub
		em.remove(getWorkFlow(wfId));
	}

	@Override
	public Workflow getWorkFlow(String wfId) {
		// TODO Auto-generated method stub
		return em.find(Workflow.class, wfId);
	}

	
	
	
	
	
	
}
