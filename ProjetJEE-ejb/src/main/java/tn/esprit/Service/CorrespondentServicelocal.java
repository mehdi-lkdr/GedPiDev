package tn.esprit.Service;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entities.Correspondent;

@Local
public interface CorrespondentServicelocal {

	
	
	
	public void saveCorrespondent(Correspondent corresp) ; 
	public void updateCorrespondent(Correspondent corresp) ; 
	public void deleteCorrespondent(int correspId) ; 
	public Correspondent getCorrespondent(int correspondentId); 
	public List<Correspondent>  getCorrespondentList(); 
	
}
