package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * The persistent class for the adresses database table.
 * 
 */
@Entity
@Table(name="adresses")
@NamedQuery(name="Adress.findAll", query="SELECT a FROM Adress a")
public class Adress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@JsonProperty
	private String adresseId;
	@JsonProperty
	private int codePostal;

	@JsonProperty
	@Column(length = 255)
	private String pays;

	@JsonProperty
	@Column(length = 255)
	private String rue;
	
	@JsonProperty
	@Column(length = 255)
	private String ville;
	
	//bi-directional one-to-one association to Correspondent
	@JsonProperty
	@OneToOne
	@JoinColumn(name="AdresseId")
	private Correspondent correspondent;

	public Adress() {
	}
	@JsonProperty
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

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Correspondent getCorrespondent() {
		return this.correspondent;
	}

	public void setCorrespondent(Correspondent correspondent) {
		this.correspondent = correspondent;
	}
	@JsonCreator
	public Adress(@JsonProperty("adresseId")String adresseId,@JsonProperty("codePostal") int codePostal,@JsonProperty("pays") String pays,
			@JsonProperty("rue") String rue,@JsonProperty("ville") String ville,
			@JsonProperty("correspondent")Correspondent correspondent) {
		super();
		this.adresseId = adresseId;
		this.codePostal = codePostal;
		this.pays = pays;
		this.rue = rue;
		this.ville = ville;
		this.correspondent = correspondent;
	}
	
}