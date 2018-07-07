package tn.esprit.Service;

import javax.ejb.Local;

import tn.esprit.entities.Workflow;

@Local
public interface WorkFlowServiceLocal {

	
	
	
	public void saveWorkFlow(Workflow wf) ; 
	public void updateWorkFlow(Workflow wf) ; 
	public void deleteWorkFlow(String wfId) ; 
	public Workflow getWorkFlow(String wfId) ; 
}
