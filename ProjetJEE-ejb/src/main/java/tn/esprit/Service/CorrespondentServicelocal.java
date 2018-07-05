package tn.esprit.Service;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entities.Correspondent;

@Local
public interface CorrespondentServicelocal {

	
	
	
	public void saveCorrespondent(Correspondent corresp) ; 
	public void updateCorrespondent(Correspondent corresp) ; 
	public void deleteCorrespondent(String correspId) ; 
	public Correspondent getCorrespondent(String correspondentId); 
	public List<Correspondent>  getCorrespondentList(); 
	
}
