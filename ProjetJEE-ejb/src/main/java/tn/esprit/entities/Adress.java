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
	@JsonProperty("AdressId")
	private String adresseId;
	@JsonProperty("CodePostal")
	private int codePostal;

	@JsonProperty("Pays")
	@Column(length = 255)
	private String pays;

	@JsonProperty("Rue")
	@Column(length = 255)
	private String rue;
	
	@JsonProperty("Ville")
	@Column(length = 255)
	private String ville;
	


	public Adress() {
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


	@JsonCreator
	public Adress(@JsonProperty("AdresseId")String adresseId,@JsonProperty("CodePostal") int codePostal,@JsonProperty("Pays") String pays,
			@JsonProperty("Rue") String rue,@JsonProperty("Ville") String ville,
			@JsonProperty("Correspondent")Correspondent correspondent) {
		super();
		this.adresseId = adresseId;
		this.codePostal = codePostal;
		this.pays = pays;
		this.rue = rue;
		this.ville = ville;

	}
	
}