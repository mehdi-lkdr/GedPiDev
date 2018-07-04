package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the departments database table.
 * 
 */
@Entity
@Table(name="departments")
@NamedQuery(name="Department.findAll", query="SELECT d FROM Department d")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String departementId;

	@Column(length = 255)
	private String email;

	@Column(length = 255)
	private String nomDepartement;

	@Column(length = 255)
	private String responsable;

	private int telephone;

	//bi-directional many-to-one association to Aspnetuser
	@OneToMany(mappedBy="department")
	private List<Aspnetuser> aspnetusers;

	//bi-directional many-to-many association to Workflow
	@ManyToMany(mappedBy="departments")
	private List<Workflow> workflows;

	public Department() {
	}

	public String getDepartementId() {
		return this.departementId;
	}

	public void setDepartementId(String departementId) {
		this.departementId = departementId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomDepartement() {
		return this.nomDepartement;
	}

	public void setNomDepartement(String nomDepartement) {
		this.nomDepartement = nomDepartement;
	}

	public String getResponsable() {
		return this.responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public int getTelephone() {
		return this.telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public List<Aspnetuser> getAspnetusers() {
		return this.aspnetusers;
	}

	public void setAspnetusers(List<Aspnetuser> aspnetusers) {
		this.aspnetusers = aspnetusers;
	}

	public Aspnetuser addAspnetuser(Aspnetuser aspnetuser) {
		getAspnetusers().add(aspnetuser);
		aspnetuser.setDepartment(this);

		return aspnetuser;
	}

	public Aspnetuser removeAspnetuser(Aspnetuser aspnetuser) {
		getAspnetusers().remove(aspnetuser);
		aspnetuser.setDepartment(null);

		return aspnetuser;
	}

	public List<Workflow> getWorkflows() {
		return this.workflows;
	}

	public void setWorkflows(List<Workflow> workflows) {
		this.workflows = workflows;
	}

}