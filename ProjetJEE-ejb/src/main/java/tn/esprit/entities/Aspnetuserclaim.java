package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * The persistent class for the aspnetuserclaims database table.
 * 
 */
@Entity
@Table(name="aspnetuserclaims")
@NamedQuery(name="Aspnetuserclaim.findAll", query="SELECT a FROM Aspnetuserclaim a")
public class Aspnetuserclaim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id

	private int id;

	
	private String claimType;

	
	private String claimValue;

	//bi-directional many-to-one association to Aspnetuser
	@ManyToOne
	@JoinColumn(name="UserId")
	@JsonProperty("Aspnetuser")
	private Aspnetuser aspnetuser;

	public Aspnetuserclaim() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClaimType() {
		return this.claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}

	public String getClaimValue() {
		return this.claimValue;
	}

	public void setClaimValue(String claimValue) {
		this.claimValue = claimValue;
	}

	public Aspnetuser getAspnetuser() {
		return this.aspnetuser;
	}

	public void setAspnetuser(Aspnetuser aspnetuser) {
		this.aspnetuser = aspnetuser;
	}

}