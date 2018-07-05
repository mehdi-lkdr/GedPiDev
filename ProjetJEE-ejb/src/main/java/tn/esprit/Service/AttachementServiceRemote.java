package tn.esprit.Service;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entities.Attachement;

@Remote
public interface AttachementServiceRemote {

	
	
	
	public void saveAttachement(Attachement attachement) ; 
	public void updatettachement(Attachement attachement) ; 
	public void deleteAttachement(int attachementId) ; 
	public Attachement getAttachement(int attachementId) ; 
	public List<Attachement> getAttachementList() ; 
}
