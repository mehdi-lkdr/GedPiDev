package tn.esprit.entities;

import java.io.Serializable;
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

	
	private String creationUser;

	private int currentStat;

	
	private String dateCreation;

	
	private String documentCore;

	private Boolean etat;

	
	private String nomDocument;

	
	private String udateUser;

	
	private String updateDate;

	
	private String workflowId;

	//bi-directional one-to-one association to Attachement
	@OneToOne
	@JoinColumn(name="DocumentId")
	private Attachement attachement;

	public Document() {
	}

	public String getDocumentId() {
		return this.documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public String getCreationUser() {
		return this.creationUser;
	}

	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
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

	public String getDocumentCore() {
		return this.documentCore;
	}

	public void setDocumentCore(String documentCore) {
		this.documentCore = documentCore;
	}

	public Boolean getEtat() {
		return this.etat;
	}

	public void setEtat(Boolean etat) {
		this.etat = etat;
	}

	public String getNomDocument() {
		return this.nomDocument;
	}

	public void setNomDocument(String nomDocument) {
		this.nomDocument = nomDocument;
	}

	public String getUdateUser() {
		return this.udateUser;
	}

	public void setUdateUser(String udateUser) {
		this.udateUser = udateUser;
	}

	public String getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getWorkflowId() {
		return this.workflowId;
	}

	public void setWorkflowId(String workflowId) {
		this.workflowId = workflowId;
	}

	public Attachement getAttachement() {
		return this.attachement;
	}

	public void setAttachement(Attachement attachement) {
		this.attachement = attachement;
	}

}