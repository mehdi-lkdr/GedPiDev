package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;


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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String adresseId;

	private int codePostal;

	@Column(length = 255)
	private String pays;

	@Column(length = 255)
	private String rue;

	@Column(length = 255)
	private String ville;

	//bi-directional one-to-one association to Correspondent
	@OneToOne
	@JoinColumn(name="AdresseId")
	private Correspondent correspondent;

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

	public Correspondent getCorrespondent() {
		return this.correspondent;
	}

	public void setCorrespondent(Correspondent correspondent) {
		this.correspondent = correspondent;
	}

}