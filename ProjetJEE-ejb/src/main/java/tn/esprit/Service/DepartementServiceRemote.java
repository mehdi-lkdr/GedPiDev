package tn.esprit.Service;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entities.Department;

@Remote
public interface DepartementServiceRemote {

	
	public void saveDepartement(Department dept) ; 
	public void updateDepartement(Department dept) ; 
	public void deleteDepartement(int deptId) ; 
	public Department getDepartement(int deptId) ; 
	
	public List<Department> getDepartementList(); 
}
