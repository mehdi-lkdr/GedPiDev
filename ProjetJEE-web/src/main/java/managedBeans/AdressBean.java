package managedBeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import tn.esprit.entities.Correspondent;

@ManagedBean(name="adress")
@RequestScoped
public class AdressBean  implements Serializable {
	private static final long serialVersionUID = 1L;


	private String adresseId;

	private int codePostal;


	private String pays;


	private String rue;


	private String ville;


	private Correspondent correspondent;

	public AdressBean() {
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
