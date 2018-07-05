package tn.esprit.Service;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entities.Courrier;

@Local
public interface CourrierServiceLocal {

	
	
	
	public void saveCourrier(Courrier courrier) ; 
	public void updateCourrier(Courrier courrier) ; 
	public void deleteCourrier(String courrierId) ; 
	public Courrier getCourrier(String courrierId) ; 
	public List<Courrier> getCourrierList() ; 
	
}
