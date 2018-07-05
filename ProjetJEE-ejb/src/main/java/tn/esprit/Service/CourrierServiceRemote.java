package tn.esprit.Service;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entities.Courrier;

@Remote
public interface CourrierServiceRemote {

	
	public void saveCourrier(Courrier courrier) ; 
	public void updateCourrier(Courrier courrier) ; 
	public void deleteCourrier(String courrierId) ; 
	public Courrier getCourrier(String courrierId) ; 
	public List<Courrier> getCourrierList() ; 
	
}
