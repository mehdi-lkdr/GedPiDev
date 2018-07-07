package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	@JsonProperty("WorkflowIds")
	private String workflowId;

	//bi-directional many-to-many association to Department
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="workflowdepartments"
		, joinColumns={
			@JoinColumn(name="Workflow_WorkflowId")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Department_DepartementId")
			}
		)
	@JsonProperty("Steps")
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