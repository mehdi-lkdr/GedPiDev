package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


/**
 * The persistent class for the courriers database table.
 * 
 */
@Entity
@Table(name="courriers")
@NamedQuery(name="Courrier.findAll", query="SELECT c FROM Courrier c")
public class Courrier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@JsonProperty("CourrierId")
	private String courrierId;

	@Column(length = 255)
	@JsonProperty("Detail")
	private String detail;
	
	@JsonProperty("Etat")
	private boolean etat;

	@Column(length = 255)
	@JsonProperty("ObjetCourrier")
	private String objetCourrier;
	
	@JsonProperty("Sense")
	private boolean sense;

	@Column(length = 255)
	@JsonProperty("TypeCourrier")
	private String typeCourrier;

	//bi-directional many-to-one association to Attachement
	@OneToMany(mappedBy="courrier",cascade =CascadeType.ALL)
	@JsonProperty("Attachements")
	private List<Attachement> attachements;

	//bi-directional many-to-one association to Correspondent
	@ManyToOne
	@JoinColumn(name="CorrespondentId")
	@JsonProperty("Correspondent")
	private Correspondent correspondent;

	public Courrier() {
	}
	@JsonCreator
	public Courrier(@JsonProperty("CourrierId") String courrierId,@JsonProperty("Detail") String detail,@JsonProperty("Etat") boolean etat,@JsonProperty("ObjetCourrier") String objetCourrier,
			@JsonProperty("Sense") boolean sense,@JsonProperty("TypeCourrier") String typeCourrier,
			@JsonProperty("Attachements")List<Attachement> attachements,@JsonProperty("CorrespondentId") Correspondent correspondent) {
		super();
		this.courrierId = courrierId;
		this.detail = detail;
		this.etat = etat;
		this.objetCourrier = objetCourrier;
		this.sense = sense;
		this.typeCourrier = typeCourrier;
		this.attachements = attachements;
		this.correspondent = correspondent;
	}

	public String getCourrierId() {
		return this.courrierId;
	}

	public void setCourrierId(String courrierId) {
		this.courrierId = courrierId;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public boolean getEtat() {
		return this.etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public String getObjetCourrier() {
		return this.objetCourrier;
	}

	public void setObjetCourrier(String objetCourrier) {
		this.objetCourrier = objetCourrier;
	}

	public boolean getSense() {
		return this.sense;
	}

	public void setSense(boolean sense) {
		this.sense = sense;
	}

	public String getTypeCourrier() {
		return this.typeCourrier;
	}

	public void setTypeCourrier(String typeCourrier) {
		this.typeCourrier = typeCourrier;
	}

	public List<Attachement> getAttachements() {
		return this.attachements;
	}

	public void setAttachements(List<Attachement> attachements) {
		this.attachements = attachements;
	}

	public Attachement addAttachement(Attachement attachement) {
		getAttachements().add(attachement);
		attachement.setCourrier(this);

		return attachement;
	}

	public Attachement removeAttachement(Attachement attachement) {
		getAttachements().remove(attachement);
		attachement.setCourrier(null);

		return attachement;
	}

	public Correspondent getCorrespondent() {
		return this.correspondent;
	}

	public void setCorrespondent(Correspondent correspondent) {
		this.correspondent = correspondent;
	}

}