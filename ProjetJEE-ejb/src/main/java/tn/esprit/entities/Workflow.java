package tn.esprit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;


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
	@JsonProperty("WorkflowId")
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
	@JsonProperty("Departments")
	private List<Department> departments;


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

}