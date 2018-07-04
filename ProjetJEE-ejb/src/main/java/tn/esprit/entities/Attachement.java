package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the attachements database table.
 * 
 */
@Entity
@Table(name="attachements")
@NamedQuery(name="Attachement.findAll", query="SELECT a FROM Attachement a")
public class Attachement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String attachementId;

	@Column(length = 255)
	private String nomFichier;

	@Column(length = 255)
	private String urlFichier;

	//bi-directional many-to-one association to Courrier
	@ManyToOne
	@JoinColumn(name="CourrierId")
	private Courrier courrier;

	//bi-directional one-to-one association to Document
	@OneToOne(mappedBy="attachement")
	private Document document;

	public Attachement() {
	}

	public String getAttachementId() {
		return this.attachementId;
	}

	public void setAttachementId(String attachementId) {
		this.attachementId = attachementId;
	}

	public String getNomFichier() {
		return this.nomFichier;
	}

	public void setNomFichier(String nomFichier) {
		this.nomFichier = nomFichier;
	}

	public String getUrlFichier() {
		return this.urlFichier;
	}

	public void setUrlFichier(String urlFichier) {
		this.urlFichier = urlFichier;
	}

	public Courrier getCourrier() {
		return this.courrier;
	}

	public void setCourrier(Courrier courrier) {
		this.courrier = courrier;
	}

	public Document getDocument() {
		return this.document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

}