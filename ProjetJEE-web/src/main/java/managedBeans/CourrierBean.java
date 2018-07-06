package managedBeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
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

import tn.esprit.Service.CorrespondentServicelocal;
import tn.esprit.Service.CourrierServiceLocal;
import tn.esprit.entities.Attachement;
import tn.esprit.entities.Correspondent;
import tn.esprit.entities.Courrier;

@ManagedBean(name = "Courrier")
@SessionScoped
public class CourrierBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Courrier cr = new Courrier();

	@EJB
	CourrierServiceLocal courrierService;
	
	@EJB
	CorrespondentServicelocal correspondentService ; 

	public CourrierBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private String selectedValue;
	 
	public String getSelectedValue() {
		return selectedValue;
	}
 
	public void setSelectedValue(String selectedValue) {
		this.selectedValue = selectedValue;
	}
	private List<Courrier> listcourriers ; 
	private List<Correspondent> listcorrespendent ; 
	
	

	@PostConstruct
	public void  init(){
		HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		listcourriers = new ArrayList<>() ; 
		this.listcourriers=courrierService.getCourrierList() ; 
		if(null!=req.getParameter("id"))
			updateCourrier(req.getParameter("id"));
		listcorrespendent = correspondentService.getCorrespondentList() ; 
	}
		
	public List<Correspondent> getListcorrespendent() {
		return listcorrespendent;
	}

	public void setListcorrespendent(List<Correspondent> listcorrespendent) {
		this.listcorrespendent = listcorrespendent;
	}

	private String courrierId;

	public String getCourrierId() {
		return courrierId;
	}

	public void setCourrierId(String courrierId) {
		this.courrierId = courrierId;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public byte getEtat() {
		return etat;
	}

	public void setEtat(byte etat) {
		this.etat = etat;
	}

	public String getObjetCourrier() {
		return objetCourrier;
	}

	public void setObjetCourrier(String objetCourrier) {
		this.objetCourrier = objetCourrier;
	}

	public byte getSense() {
		return sense;
	}

	public void setSense(byte sense) {
		this.sense = sense;
	}

	public String getTypeCourrier() {
		return typeCourrier;
	}

	public void setTypeCourrier(String typeCourrier) {
		this.typeCourrier = typeCourrier;
	}

	public List<Attachement> getAttachements() {
		return attachements;
	}

	public void setAttachements(List<Attachement> attachements) {
		this.attachements = attachements;
	}

	public Correspondent getCorrespondent() {
		return correspondent;
	}

	public void setCorrespondent(Correspondent correspondent) {
		this.correspondent = correspondent;
	}

	private String detail;
	private byte etat;
	private String objetCourrier;
	private byte sense;
	private String typeCourrier;
	private List<Attachement> attachements;
	private Correspondent correspondent;

	public Courrier getCr() {
		return cr;
	}

	public void setCr(Courrier cr) {
		this.cr = cr;
	}

	public void saveCourrier(ActionEvent actionEvent) {
		
		Correspondent c = correspondentService.getCorrespondent(selectedValue);
		cr.setCourrierId("sss");
		cr.setAttachements(null);
		cr.setCorrespondent(c);
		courrierService.saveCourrier(cr);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Le courrier  a été sauvegardé.", null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void getAllCourriers(){	
		listcourriers = courrierService.getCourrierList();
	}

	public String updateCourrier(String courrierId){
		this.cr = courrierService.getCourrier(courrierId) ; 
		return  "updateCourrier.xhtml?faces-redirect=true";
	}

	public List<Courrier> getListcourriers() {
		return this.listcourriers;
	}

	public void setListcourriers(List<Courrier> listcourriers) {
		this.listcourriers = listcourriers;
	}

	public String updateCourrierPut(){
		courrierService.updateCourrier(cr);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Le courrier  a été mis a jour.", null);
		FacesContext.getCurrentInstance().addMessage(null, message);
		return  "ListCourrier.xhtml?faces-redirect=true";
	}
	
	//Success
		public void supprimerCourrier(String courrierId) {
			try {
				courrierService.deleteCourrier(courrierId);
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
