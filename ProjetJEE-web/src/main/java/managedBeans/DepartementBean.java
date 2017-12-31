package managedBeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

import tn.esprit.Service.DepartementServiceLocal;

import tn.esprit.entities.Department;

@ManagedBean(name="Departement")
@SessionScoped
public class DepartementBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	private Department dept= new Department();
	
	@EJB
	DepartementServiceLocal departementServiceLocal ; 
	
	
	
	private String departementId;


	private String email;


	private String nomDepartement;


	private String responsable;

	private int telephone;
	
	
	@PostConstruct
	public void loadAllDepartements(){
		HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		departementList = departementServiceLocal.getDepartementList() ; 
		if(null!=req.getParameter("id"))
			updatePageDepartement(req.getParameter("id"));
	}
	
	
	public Department getDepartement(String  departement){	
		
		return departementServiceLocal.getDepartement(departement);

		
	}
	
	
	public String updateDepartement(){
		departementServiceLocal.updateDepartement(dept);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Departement Updated Avec Succés",
				null);
		FacesContext.getCurrentInstance().addMessage(null, message);
		return  "listDepartement.xhtml?faces-redirect=true";
	}
	
	
	public String saveDepartement(ActionEvent actionEvent){	
		
		
		dept.setWorkflows(null);
		dept.setAspnetusers(null);
		departementServiceLocal.saveDepartement(dept);;
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Departement Ajouté Avec Succés",
				null);
		FacesContext.getCurrentInstance().addMessage(null, message);
		return  "listDepartement.xhtml?faces-redirect=true";
	}
	
	
	
	
	
	public void getAllDepartement(ActionEvent actionEvent){	
		
		departementList = departementServiceLocal.getDepartementList();

		
	}
	
	//Success
	public void supprimerDepartement(String departementId) {
		departementServiceLocal.deleteDepartement(departementId);;
		try {
			refreshPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void refreshPage() throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
	}
	
	
	
	private List<Department> departementList ; 
	
	
	

	public List<Department> getDepartementList() {
		return departementList;
	}


	public void setDepartementList(List<Department> departementList) {
		this.departementList = departementList;
	}


	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public String getDepartementId() {
		return departementId;
	}

	public void setDepartementId(String departementId) {
		this.departementId = departementId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomDepartement() {
		return nomDepartement;
	}

	public void setNomDepartement(String nomDepartement) {
		this.nomDepartement = nomDepartement;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public DepartementBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public String updatePageDepartement(String  departement){	
		
		this.dept=  departementServiceLocal.getDepartement(departement);

		return "/UpdateDepartement.xhtml?faces-redirect=true";
	}
	
	
	
	
	
	
}
