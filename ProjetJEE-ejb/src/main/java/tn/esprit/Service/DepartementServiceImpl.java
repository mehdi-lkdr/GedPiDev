package tn.esprit.Service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.entities.Courrier;
import tn.esprit.entities.Department;

@Stateless
public class DepartementServiceImpl implements DepartementServiceLocal , DepartementServiceRemote {

	@PersistenceContext
	private EntityManager em;
	
	
	
	@Override
	public void saveDepartement(Department dept) {
		// TODO Auto-generated method stub
		em.persist(dept);
	}

	@Override
	public void updateDepartement(Department dept) {
		// TODO Auto-generated method stub
		em.merge(dept) ; 
	}

	@Override
	public void deleteDepartement(int deptId) {
		// TODO Auto-generated method stub
		em.remove(getDepartement(deptId));
	}

	@Override
	public Department getDepartement(int deptId) {
		// TODO Auto-generated method stub
		return em.find(Department.class, deptId);
	}

	@Override
	public List<Department> getDepartementList() {
		// TODO Auto-generated method stub
		return em.createQuery("select d from Department d", Department.class).getResultList() ;
	}

}
