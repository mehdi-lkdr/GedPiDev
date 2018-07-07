package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;


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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonProperty("Id")
	private String id;
	@JsonProperty("AccessFailedCount")
	private int accessFailedCount;
	@JsonProperty("DepartmentId")
	private int departmentId;
	@JsonProperty("Email")
	private String email;
	@JsonProperty("EmailConfirmed")
	private Boolean emailConfirmed;
	@JsonProperty("LockoutEnabled")
	private Boolean lockoutEnabled;
	@JsonProperty("LockoutEndDateUtc")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lockoutEndDateUtc;
	@JsonProperty("FirstName")
	private String firstName ;
	@JsonProperty("LastName")
	private String lastName;
	@JsonProperty("PasswordHash")
	@Column(length = 255)
	private String passwordHash;
	@JsonProperty("PhoneNumber")
	@Column(length = 255)
	private String phoneNumber;
	@JsonProperty("PhoneNumberConfirmed")
	private Boolean phoneNumberConfirmed;

	@JsonProperty("SecurityStamp")
	@Column(length = 255)
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
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAccessFailedCount() {
		return this.accessFailedCount;
	}

	public void setAccessFailedCount(int accessFailedCount) {
		this.accessFailedCount = accessFailedCount;
	}

	public int getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEmailConfirmed() {
		return this.emailConfirmed;
	}

	public void setEmailConfirmed(Boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}

	public Boolean getLockoutEnabled() {
		return this.lockoutEnabled;
	}

	public void setLockoutEnabled(Boolean lockoutEnabled) {
		this.lockoutEnabled = lockoutEnabled;
	}

	public Date getLockoutEndDateUtc() {
		return this.lockoutEndDateUtc;
	}

	public void setLockoutEndDateUtc(Date lockoutEndDateUtc) {
		this.lockoutEndDateUtc = lockoutEndDateUtc;
	}

	public String getPasswordHash() {
		return this.passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Boolean getPhoneNumberConfirmed() {
		return this.phoneNumberConfirmed;
	}

	public void setPhoneNumberConfirmed(Boolean phoneNumberConfirmed) {
		this.phoneNumberConfirmed = phoneNumberConfirmed;
	}

	public String getSecurityStamp() {
		return this.securityStamp;
	}

	public void setSecurityStamp(String securityStamp) {
		this.securityStamp = securityStamp;
	}

	public Boolean getTwoFactorEnabled() {
		return this.twoFactorEnabled;
	}

	public void setTwoFactorEnabled(Boolean twoFactorEnabled) {
		this.twoFactorEnabled = twoFactorEnabled;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Aspnetuserclaim> getAspnetuserclaims() {
		return this.aspnetuserclaims;
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