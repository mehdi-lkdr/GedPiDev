package managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import tn.esprit.Service.CourrierServiceLocal;
import tn.esprit.entities.Attachement;
import tn.esprit.entities.Correspondent;
import tn.esprit.entities.Courrier;

@ManagedBean(name = "Courrier")
@ViewScoped
public class CourrierBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Courrier cr = new Courrier();

	@EJB
	CourrierServiceLocal courrierService;

	public CourrierBean() {
		super();
		// TODO Auto-generated constructor stub
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

		cr.setCourrierId("1c");
		cr.setAttachements(null);
		cr.setCorrespondent(null);
		courrierService.saveCourrier(cr);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Le courrier  a été sauvegardé.", null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void UpdateCourrier(ActionEvent actionEvent) {
		cr = courrierService.getCourrier(courrierId);
		courrierService.updateCourrier(cr);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Le courrier  a été mis à jour.", null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void DeleteCourrier(ActionEvent actionEvent) {
		cr = courrierService.getCourrier(courrierId);
		courrierService.deleteCourrier(cr.getCourrierId());
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Le courrier  a été supprimé.", null);
		FacesContext.getCurrentInstance().addMessage(null, message);

	}

	public Courrier GetCourrier(ActionEvent actionEvent) {
		 
		return courrierService.getCourrier(courrierId);
	}

	public List<Courrier> GetListCourrier(ActionEvent actionEvent) {
		return courrierService.getCourrierList();
	}

}
