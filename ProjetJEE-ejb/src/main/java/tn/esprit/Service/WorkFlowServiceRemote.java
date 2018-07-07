package tn.esprit.Service;

import javax.ejb.Remote;

import tn.esprit.entities.Workflow;

@Remote
public interface WorkFlowServiceRemote {

	
	
	
	
	
	public void saveWorkFlow(Workflow wf) ; 
	public void updateWorkFlow(Workflow wf) ; 
	public void deleteWorkFlow(String wfId) ; 
	public Workflow getWorkFlow(String wfId) ; 
}
