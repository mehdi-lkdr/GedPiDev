package managedBeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

import tn.esprit.Service.CorrespondentServicelocal;

import tn.esprit.entities.Correspondent;



@ManagedBean(name="Correspondent")
@SessionScoped
public class CorrespondentBean implements Serializable{
	
	
	
	private static final long serialVersionUID = 1L;
	
	private Correspondent c = new Correspondent() ; 


	
	
	@EJB
	CorrespondentServicelocal correspondentServicelocal ;  

	private String correspondentId;


	private String adresseId;

	private String email;

	private int fax;


	private String nomCorrespondant;

	private int telephone;
	
	private List<Correspondent> correspendentList ; 
	
	private boolean edit  ;
	
	@PostConstruct
	public void loadAllCorrespendant(){
		correspendentList = correspondentServicelocal.getCorrespondentList() ; 
	}
	
	

//	private Adress adress;
//
//
//	private List<Courrier> courriers;

	
	
	
	

	public Correspondent getC() {
		return c;
	}


	public void setC(Correspondent c) {
		this.c = c;
	}


	public String getCorrespondentId() {
		return correspondentId;
	}


	public List<Correspondent> getCorrespendentList() {
		return correspendentList;
	}


	public void setCorrespendentList(List<Correspondent> correspendentList) {
		this.correspendentList = correspendentList;
	}


	public void setCorrespondentId(String correspondentId) {
		this.correspondentId = correspondentId;
	}


	public String getAdresseId() {
		return adresseId;
	}


	public void setAdresseId(String adresseId) {
		this.adresseId = adresseId;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getFax() {
		return fax;
	}


	public void setFax(int fax) {
		this.fax = fax;
	}


	public String getNomCorrespondant() {
		return nomCorrespondant;
	}


	public void setNomCorrespondant(String nomCorrespondant) {
		this.nomCorrespondant = nomCorrespondant;
	}


	public int getTelephone() {
		return telephone;
	}


	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}


//	public Adress getAdress() {
//		return adress;
//	}
//
//
//	public void setAdress(Adress adress) {
//		this.adress = adress;
//	}
//
//
//	public List<Courrier> getCourriers() {
//		return courriers;
//	}
//
//
//	public void setCourriers(List<Courrier> courriers) {
//		this.courriers = courriers;
//	}


	public boolean isEdit() {
		return edit;
	}



	public void setEdit(boolean edit) {
		this.edit = edit;
	}



	public CorrespondentBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public void saveCorresp(ActionEvent actionEvent){	
		
		c.setCorrespondentId("aaaaaa");
		correspondentServicelocal.saveCorrespondent(c);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correspondent Ajouté Avec Succés",
				null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	
	
	public void getAllCorrespondent(ActionEvent actionEvent){	
	
		correspendentList = correspondentServicelocal.getCorrespondentList();

		
	}
	
	
	public String updatePageCorrespondent(String  correspondent){	
		
		this.c=  correspondentServicelocal.getCorrespondent(correspondent);

		this.edit = true ; 
		return "/updateCorrespondent.xhtml?faces-redirect=true";
	}
	
	
	public Correspondent getCorrespondent(String  correspondent){	
		
		return correspondentServicelocal.getCorrespondent(correspondent);

		
	}
	
	public void updateCorrespondent(Correspondent correspondent){
		correspondentServicelocal.updateCorrespondent(correspondent);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correspondent Updated Avec Succés",
				null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	//Success
	public void supprimerCorrespondent(String correspondentId) {
		correspondentServicelocal.deleteCorrespondent(correspondentId);;
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
	
	
	
	
	
	
	
	
	
	
	
	

}
