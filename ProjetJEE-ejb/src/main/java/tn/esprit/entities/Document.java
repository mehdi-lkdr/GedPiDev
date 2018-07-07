package tn.esprit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * The persistent class for the documents database table.
 * 
 */
@Entity
@Table(name="documents")
@NamedQuery(name="Document.findAll", query="SELECT d FROM Document d")
public class Document implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String documentId;
	@JsonProperty("CurrentStat")	
	private int currentStat;
	@JsonProperty("DateCreation")
	@Column(length = 255)
	private String dateCreation;
	
	@Column(length = 255)
	private String documentCore;


	private byte etat;
	@JsonProperty("NomDocument")
	@Column(length = 255)
	private String nomDocument;
	@JsonProperty("WorkflowId")
	@Column(length = 255)
	private String workflowId;

	//bi-directional many-to-one association to Aspnetuser
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ApplicationUserId")
	private Aspnetuser aspnetuser;

	//bi-directional one-to-one association to Attachement
	@OneToOne(cascade = CascadeType.ALL)
	private Attachement attachement;

	//bi-directional one-to-one association to Workflow
	@OneToOne( cascade = CascadeType.ALL)
	private Workflow workflow;
	
	@Transient
	private List<Department> departementList ; 

	
	
	
	


	public List<Department> getDepartementList() {
		return departementList;
	}

	public void setDepartementList(List<Department> departementList) {
		this.departementList = departementList;
	}

	public Document() {
	}

	public String getDocumentId() {
		return this.documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public int getCurrentStat() {
		return this.currentStat;
	}

	public void setCurrentStat(int currentStat) {
		this.currentStat = currentStat;
	}

	public String getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public byte getEtat() {
		return this.etat;
	}

	public void setEtat(byte etat) {
		this.etat = etat;
	}

	public String getNomDocument() {
		return this.nomDocument;
	}

	public void setNomDocument(String nomDocument) {
		this.nomDocument = nomDocument;
	}

	public String getWorkflowId() {
		return this.workflowId;
	}

	public void setWorkflowId(String workflowId) {
		this.workflowId = workflowId;
	}

	public Aspnetuser getAspnetuser() {
		return this.aspnetuser;
	}

	public void setAspnetuser(Aspnetuser aspnetuser) {
		this.aspnetuser = aspnetuser;
	}

	public Attachement getAttachement() {
		return this.attachement;
	}

	public void setAttachement(Attachement attachement) {
		this.attachement = attachement;
	}

	public Workflow getWorkflow() {
		return this.workflow;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}

	public String getDocumentCore() {
		return documentCore;
	}

	public void setDocumentCore(String documentCore) {
		this.documentCore = documentCore;
	}
	
	
	

}