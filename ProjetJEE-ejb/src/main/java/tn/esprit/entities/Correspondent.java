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

	
	private String adresseId;

	private int codePostal;

	
	private String email;

	private int fax;

	
	private String nomCorrespondant;

	
	private String pays;

	
	private String rue;

	private int telephone;

	
	private String userId;

	
	private String ville;

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

	public int getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
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

	public String getPays() {
		return this.pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getRue() {
		return this.rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getTelephone() {
		return this.telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
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