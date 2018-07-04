package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;
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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String courrierId;

	@Column(length = 255)
	private String detail;

	private byte etat;

	@Column(length = 255)
	private String objetCourrier;

	private byte sense;

	@Column(length = 255)
	private String typeCourrier;

	//bi-directional many-to-one association to Attachement
	@OneToMany(mappedBy="courrier")
	private List<Attachement> attachements;

	//bi-directional many-to-one association to Correspondent
	@ManyToOne
	@JoinColumn(name="CorrespondentId")
	private Correspondent correspondent;

	public Courrier() {
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

	public byte getEtat() {
		return this.etat;
	}

	public void setEtat(byte etat) {
		this.etat = etat;
	}

	public String getObjetCourrier() {
		return this.objetCourrier;
	}

	public void setObjetCourrier(String objetCourrier) {
		this.objetCourrier = objetCourrier;
	}

	public byte getSense() {
		return this.sense;
	}

	public void setSense(byte sense) {
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