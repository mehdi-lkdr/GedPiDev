package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the correspondents database table.
 * 
 */
@Entity
@Table(name="correspondents")
@NamedQuery(name="Correspondent.findAll", query="SELECT c FROM Correspondent c")
public class Correspondent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String correspondentId;

	@Column(length = 255)
	private String adresseId;

	@Column(length = 255)
	private String email;

	private int fax;

	@Column(length = 255)
	private String nomCorrespondant;

	private int telephone;

	//bi-directional one-to-one association to Adress
	@OneToOne(mappedBy="correspondent")
	private Adress adress;

	//bi-directional many-to-one association to Courrier
	@OneToMany(mappedBy="correspondent")
	private List<Courrier> courriers;

	public Correspondent() {
	}

	public String getCorrespondentId() {
		return this.correspondentId;
	}

	public void setCorrespondentId(String correspondentId) {
		this.correspondentId = correspondentId;
	}

	public String getAdresseId() {
		return this.adresseId;
	}

	public void setAdresseId(String adresseId) {
		this.adresseId = adresseId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getFax() {
		return this.fax;
	}

	public void setFax(int fax) {
		this.fax = fax;
	}

	public String getNomCorrespondant() {
		return this.nomCorrespondant;
	}

	public void setNomCorrespondant(String nomCorrespondant) {
		this.nomCorrespondant = nomCorrespondant;
	}

	public int getTelephone() {
		return this.telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public Adress getAdress() {
		return this.adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public List<Courrier> getCourriers() {
		return this.courriers;
	}

	public void setCourriers(List<Courrier> courriers) {
		this.courriers = courriers;
	}

	public Courrier addCourrier(Courrier courrier) {
		getCourriers().add(courrier);
		courrier.setCorrespondent(this);

		return courrier;
	}

	public Courrier removeCourrier(Courrier courrier) {
		getCourriers().remove(courrier);
		courrier.setCorrespondent(null);

		return courrier;
	}

}