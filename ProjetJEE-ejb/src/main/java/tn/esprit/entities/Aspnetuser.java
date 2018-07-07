package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the aspnetusers database table.
 * 
 */
@Entity
@Table(name="aspnetusers")
@NamedQuery(name="Aspnetuser.findAll", query="SELECT a FROM Aspnetuser a")
public class Aspnetuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	@JsonProperty("AccessFailedCount")
	private int accessFailedCount;
	@JsonProperty("DepartmentId")
	private int departmentId;
	@JsonProperty("Email")
	private String email;

	private byte emailConfirmed;

	
	private String firstName;

	
	private String lastName;

	private Boolean lockoutEnabled;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lockoutEndDateUtc;

	
	private String passwordHash;

	private String phoneNumber;



	private byte phoneNumberConfirmed;

	
	private String securityStamp;
	@JsonProperty("TwoFactorEnabled")
	private Boolean twoFactorEnabled;
	@JsonProperty("UserName")
	private String userName;

	@JsonProperty("Claims")
	//bi-directional many-to-one association to Aspnetuserclaim
	@OneToMany(mappedBy="aspnetuser")
	private List<Aspnetuserclaim> aspnetuserclaims;
	@JsonProperty("Logins")
	//bi-directional many-to-one association to Aspnetuserlogin
	@OneToMany(mappedBy="aspnetuser")
	private List<Aspnetuserlogin> aspnetuserlogins;

	//bi-directional many-to-many association to Aspnetrole
	@JsonProperty("Roles")
	@ManyToMany
	@JoinTable(
		name="aspnetuserroles"
		, joinColumns={
			@JoinColumn(name="UserId")
			}
		, inverseJoinColumns={
			@JoinColumn(name="RoleId")
			}
		)
	private List<Aspnetrole> aspnetroles;

	//bi-directional many-to-one association to Department
	@JsonProperty("department")
	@ManyToOne
	private Department department;


	public Aspnetuser() {
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public int getAccessFailedCount() {
		return accessFailedCount;
	}



	public void setAccessFailedCount(int accessFailedCount) {
		this.accessFailedCount = accessFailedCount;
	}



	public int getDepartmentId() {
		return departmentId;
	}



	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public byte getEmailConfirmed() {
		return emailConfirmed;
	}



	public void setEmailConfirmed(byte emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public Boolean getLockoutEnabled() {
		return lockoutEnabled;
	}



	public void setLockoutEnabled(Boolean lockoutEnabled) {
		this.lockoutEnabled = lockoutEnabled;
	}



	public Date getLockoutEndDateUtc() {
		return lockoutEndDateUtc;
	}



	public void setLockoutEndDateUtc(Date lockoutEndDateUtc) {
		this.lockoutEndDateUtc = lockoutEndDateUtc;
	}



	public String getPasswordHash() {
		return passwordHash;
	}



	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public byte getPhoneNumberConfirmed() {
		return phoneNumberConfirmed;
	}



	public void setPhoneNumberConfirmed(byte phoneNumberConfirmed) {
		this.phoneNumberConfirmed = phoneNumberConfirmed;
	}



	public String getSecurityStamp() {
		return securityStamp;
	}



	public void setSecurityStamp(String securityStamp) {
		this.securityStamp = securityStamp;
	}



	public Boolean getTwoFactorEnabled() {
		return twoFactorEnabled;
	}



	public void setTwoFactorEnabled(Boolean twoFactorEnabled) {
		this.twoFactorEnabled = twoFactorEnabled;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public List<Aspnetuserclaim> getAspnetuserclaims() {
		return aspnetuserclaims;
	}



	public void setAspnetuserclaims(List<Aspnetuserclaim> aspnetuserclaims) {
		this.aspnetuserclaims = aspnetuserclaims;
	}



	public Aspnetuserclaim addAspnetuserclaim(Aspnetuserclaim aspnetuserclaim) {
		getAspnetuserclaims().add(aspnetuserclaim);
		aspnetuserclaim.setAspnetuser(this);

		return aspnetuserclaim;
	}

	public Aspnetuserclaim removeAspnetuserclaim(Aspnetuserclaim aspnetuserclaim) {
		getAspnetuserclaims().remove(aspnetuserclaim);
		aspnetuserclaim.setAspnetuser(null);

		return aspnetuserclaim;
	}

	public List<Aspnetuserlogin> getAspnetuserlogins() {
		return this.aspnetuserlogins;
	}

	public void setAspnetuserlogins(List<Aspnetuserlogin> aspnetuserlogins) {
		this.aspnetuserlogins = aspnetuserlogins;
	}

	public Aspnetuserlogin addAspnetuserlogin(Aspnetuserlogin aspnetuserlogin) {
		getAspnetuserlogins().add(aspnetuserlogin);
		aspnetuserlogin.setAspnetuser(this);

		return aspnetuserlogin;
	}

	public Aspnetuserlogin removeAspnetuserlogin(Aspnetuserlogin aspnetuserlogin) {
		getAspnetuserlogins().remove(aspnetuserlogin);
		aspnetuserlogin.setAspnetuser(null);

		return aspnetuserlogin;
	}

	public List<Aspnetrole> getAspnetroles() {
		return this.aspnetroles;
	}

	public void setAspnetroles(List<Aspnetrole> aspnetroles) {
		this.aspnetroles = aspnetroles;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}