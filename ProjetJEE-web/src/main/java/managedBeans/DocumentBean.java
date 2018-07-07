package managedBeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
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
import tn.esprit.Service.DocumentServiceLocal;
import tn.esprit.entities.Department;
import tn.esprit.entities.Document;
import tn.esprit.entities.Workflow;


@ManagedBean(name="Document")
@SessionScoped
public class DocumentBean  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String documentId;
	private int currentStat;
	private String dateCreation;
	private byte etat;
	private String nomDocument;
	private String documentCore;
	
	private List<Document> documentList ; 
	
	@EJB
	DocumentServiceLocal documentServiceLocal ;
	
	@EJB
	DepartementServiceLocal departementServiceLocal ; 
	
	
	private Document doc = new Document() ; 
	
	private List<Department> departementList ; 
	
	

	
	
	
	@PostConstruct
	public void loadAllDocument(){
		HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		documentList = documentServiceLocal.getDocumentList() ; 
		departementList = departementServiceLocal.getDepartementList() ; 
		
	
				if(null!=req.getParameter("id"))
			updatePageDocument(req.getParameter("id"));
	}
	
	
	
	
	
public void saveDocument (ActionEvent actionEvent){	
		

	
	// doc.setWorkflow(null);
	List<Department> deptList = new ArrayList<>() ; 
	
	Workflow workflow = new Workflow(); 
	workflow.setWorkflowId("2");
	HashMap<Integer, Department> dataMap = new HashMap<Integer, Department>();
	 
	 
	for (Department department : departementList) {
				dataMap.put(department.getOrder(), department)   ;
	}
	
	
	for(int i = 1 ; i < dataMap.size()  ; i++ ){
		
		deptList.add(dataMap.get(i)); 
	}
	
	workflow.setDepartments(deptList);
	//doc.setWorkflow(workflow);
			documentServiceLocal.saveDocument(doc);

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Document Ajouté Avec Succés",
				null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	
	
	public void getAllDocument(ActionEvent actionEvent){	
	
		documentList = documentServiceLocal.getDocumentList();

		
	}
	
	
public Document getDocument(String  document){	
		
		return documentServiceLocal.getDocument(document);

		
	}
	
	public String updateDocument(){
		documentServiceLocal.updateDocument(doc);;
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Document Updated Avec Succés",
				null);
		FacesContext.getCurrentInstance().addMessage(null, message);
		return  "/listDocument.xhtml?faces-redirect=true";
	}
	
	//Success
	public void supprimerDocument(String documentId) {
		documentServiceLocal.deleteDocument(documentId);
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
	
	
	
	public String updatePageDocument(String  correspondent){	
		
		this.doc=  documentServiceLocal.getDocument(correspondent);

	
		return "/updateDocument.xhtml?faces-redirect=true";
	}
	
	
	public DocumentBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public List<Document> getDocumentList() {
		return documentList;
	}


	public void setDocumentList(List<Document> documentList) {
		this.documentList = documentList;
	}


	public String getDocumentId() {
		return documentId;
	}
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	public int getCurrentStat() {
		return currentStat;
	}
	public void setCurrentStat(int currentStat) {
		this.currentStat = currentStat;
	}
	public String getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
	public byte getEtat() {
		return etat;
	}
	public void setEtat(byte etat) {
		this.etat = etat;
	}
	public String getNomDocument() {
		return nomDocument;
	}
	public void setNomDocument(String nomDocument) {
		this.nomDocument = nomDocument;
	}





	public String getDocumentCore() {
		return documentCore;
	}





	public void setDocumentCore(String documentCore) {
		this.documentCore = documentCore;
	}





	public Document getDoc() {
		return doc;
	}





	public void setDoc(Document doc) {
		this.doc = doc;
	}





	public List<Department> getDepartementList() {
		return departementList;
	}





	public void setDepartementList(List<Department> departementList) {
		this.departementList = departementList;
	}





	
	
	
	
	
	

}
