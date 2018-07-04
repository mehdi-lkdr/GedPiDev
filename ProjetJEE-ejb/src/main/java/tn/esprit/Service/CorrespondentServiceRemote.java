package tn.esprit.Service;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entities.Correspondent;

@Remote
public interface CorrespondentServiceRemote {

	
	public void saveCorrespondent(Correspondent corresp) ; 
	public void updateCorrespondent(Correspondent corresp) ; 
	public void deleteCorrespondent(int correspId) ; 
	public Correspondent getCorrespondent(int correspondentId); 
	public List<Correspondent>  getCorrespondentList(); 
	
	
}
