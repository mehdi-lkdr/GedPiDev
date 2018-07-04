package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the workflows database table.
 * 
 */
@Entity
@Table(name="workflows")
@NamedQuery(name="Workflow.findAll", query="SELECT w FROM Workflow w")
public class Workflow implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String workflowId;

	//bi-directional many-to-many association to Department
	@ManyToMany
	@JoinTable(
		name="workflowdepartments"
		, joinColumns={
			@JoinColumn(name="Workflow_WorkflowId")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Department_DepartementId")
			}
		)
	private List<Department> departments;

	//bi-directional one-to-one association to Document
	@OneToOne
	@JoinColumn(name="WorkflowId")
	private Document document;

	public Workflow() {
	}

	public String getWorkflowId() {
		return this.workflowId;
	}

	public void setWorkflowId(String workflowId) {
		this.workflowId = workflowId;
	}

	public List<Department> getDepartments() {
		return this.departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public Document getDocument() {
		return this.document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

}