package managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import tn.esprit.Service.CorrespondentServicelocal;
import tn.esprit.entities.Adress;
import tn.esprit.entities.Correspondent;
import tn.esprit.entities.Courrier;


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


//	private Adress adress;
//
//
//	private List<Courrier> courriers;


	public String getCorrespondentId() {
		return correspondentId;
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
