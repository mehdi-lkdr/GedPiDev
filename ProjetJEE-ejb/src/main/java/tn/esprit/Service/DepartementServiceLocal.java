package tn.esprit.Service;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entities.Department;

@Local
public interface DepartementServiceLocal {

	
	
	public void saveDepartement(Department dept) ; 
	public void updateDepartement(Department dept) ; 
	public void deleteDepartement(String deptId) ; 
	public Department getDepartement(String deptId) ; 
	
	public List<Department> getDepartementList(); 
	
}
