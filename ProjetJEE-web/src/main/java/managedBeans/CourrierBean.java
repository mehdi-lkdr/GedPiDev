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
import javax.mail.Part;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.model.chart.PieChartModel;

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
	private String objetCourrier;
	private String detail;
	private byte etat;  //valid
	private byte sense;  //sent 
	private String typeCourrier;  //in ,out
	private List<Attachement> attachements;
	private Correspondent correspondent;
	private Correspondent sender;
	
	private PieChartModel pieModel1;
	private String userid;
	private String selectedValue;
	private String selectedSender;
	private List<Courrier> listcourriers ; 
	private List<Correspondent> listcorrespendent ; 
	private List<Courrier> listSent;
	private List<Courrier> listreceived;
	private List<Courrier> listavalider;
	private Part file; 

	
	@PostConstruct
	public void  init(){
		HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		listcourriers = new ArrayList<>() ; 
		listSent = new ArrayList<>() ; 
		listreceived = new ArrayList<>() ;
		listavalider = new ArrayList<>() ;
		 createPieModels();
		this.listcourriers=courrierService.getCourrierList() ; 
		if(null!=req.getParameter("id"))
			updateCourrier(req.getParameter("id"));
		listcorrespendent = correspondentService.getCorrespondentList() ; 
		if(null!=req.getParameter("sent"))
			listSent = getSentCourriers();
		if(null!=req.getParameter("recu"))
			listreceived = getReceivedCourriers();
		
	}
	

	
	/**CRUD**/
	public void saveCourrier(ActionEvent actionEvent) {
		
		Correspondent c = correspondentService.getCorrespondent(selectedValue);
		cr.setCourrierId("1courrier");
		cr.setAttachements(null);
		cr.setCorrespondent(c);
		cr.setSender(selectedSender);
		courrierService.saveCourrier(cr);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Le courrier  a été sauvegardé.", null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void getAllCourriers(){	
		listcourriers = courrierService.getCourrierList();
	}

	
	public List<Courrier> getSentCourriers(){	
		
		for (Courrier cour:listcourriers) 
		{
			if (cour.getSender().equals("sssa"))
			{
				listSent.add(cour);
			}
		}
		return listSent ;
	}
	
	

	public List<Courrier> getReceivedCourriers(){	
		
		for (Courrier cour:listcourriers) 
		{
			if (cour.getCorrespondent().getCorrespondentId().equals("thebest"))
			{
				listreceived.add(cour);
			}
		}
		return listreceived ;
	}
	
	
	public List<Courrier> getavaliderCourriers(){	
		
		for (Courrier cour:listcourriers) 
		{
			if (cour.getEtat()==false)
			{
				listavalider.add(cour);
			}
		}
		return listavalider ;
	}
	
	public String updateCourrier(String courrierId){
		this.cr = courrierService.getCourrier(courrierId) ; 
		return  "updateCourrier.xhtml?faces-redirect=true";
	}

	

	public String updateCourrierPut(){
		courrierService.updateCourrier(cr);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Le courrier  a été mis a jour.", null);
		FacesContext.getCurrentInstance().addMessage(null, message);
		return  "ListCourrier.xhtml?faces-redirect=true";
	}
	

		public void supprimerCourrier(String courrierId) {
			try {
				courrierService.deleteCourrier(courrierId);
				refreshPage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	
		
		public void validerCourrier(String courrierId) {
			this.cr = courrierService.getCourrier(courrierId) ; 
			cr.setEtat(true);
			courrierService.saveCourrier(cr);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Le courrier  a été validé.", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			
		}
		
		public void rechercheCourrier(ActionEvent actionEvent) {
			
			
		}
		
		
		public void refreshPage() throws IOException {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
		}
		
		/******************Pie charts*********************/
		
		public void createPieModels() {
		        pieModel1 = new PieChartModel();
		         
		        pieModel1.set("Brand 1", 540);
		        pieModel1.set("Brand 2", 325);
		        pieModel1.set("Brand 3", 702);
		        pieModel1.set("Brand 4", 421);
		         
		        pieModel1.setTitle("Simple Pie");
		        pieModel1.setLegendPosition("w");
		    }

		public void setPieModel1(PieChartModel pieModel1) {
			this.pieModel1 = pieModel1;
		}
		
		
		
		
		
		/***getters & setters***/

		public String getUserid() {
			return userid;
		}

		public void setUserid(String userid) {
			this.userid = userid;
		}

		public String getSelectedValue() {
			return selectedValue;
		}
	 
		public void setSelectedValue(String selectedValue) {
			this.selectedValue = selectedValue;
		}
		public List<Courrier> getListSent() {
			return listSent;
		}

		public void setListSent(List<Courrier> listSent) {
			this.listSent = listSent;
		}

		public List<Courrier> getListreceived() {
			return listreceived;
		}

		public void setListreceived(List<Courrier> listreceived) {
			this.listreceived = listreceived;
		}

		public PieChartModel getPieModel1() {
			return this.pieModel1;
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
		
		public String getSelectedSender() {
			return selectedSender;
		}

		public void setSelectedSender(String selectedSender) {
			this.selectedSender = selectedSender;
		}
		
		public Courrier getCr() {
			return cr;
		}

		public void setCr(Courrier cr) {
			this.cr = cr;
		}
		public Correspondent getSender() {
			return sender;
		}

		public void setSender(Correspondent sender) {
			this.sender = sender;
		}
		
		public List<Courrier> getListcourriers() {
			return this.listcourriers;
		}

		public void setListcourriers(List<Courrier> listcourriers) {
			this.listcourriers = listcourriers;
		}



		public List<Courrier> getListavalider() {
			return listavalider;
		}



		public void setListavalider(List<Courrier> listavalider) {
			this.listavalider = listavalider;
		}

}
