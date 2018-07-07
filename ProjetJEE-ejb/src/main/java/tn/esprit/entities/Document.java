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
	@JsonProperty("DocumentId")
	private String documentId;

	@JsonProperty("CreationUser")
	private String creationUser;
	@JsonProperty("CurrentStat")
	private int currentStat;

	@JsonProperty("DateCreation")
	private String dateCreation;

	@JsonProperty("DocumentCore")
	private String documentCore;
@JsonProperty("Etat")
	private Boolean etat;

	@JsonProperty("NomDocument")
	private String nomDocument;

	@JsonProperty("UdateUser")
	private String udateUser;

	@JsonProperty("UpdateDate")
	private String updateDate;

	@JsonProperty("WorkflowId")
	private String workflowId;



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


}