package tn.esprit.entities;

public class UserInfo {

	private String access_token ;
	private String userName ; 
	private String token_type ;
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getToken_type() {
		return token_type;
	}
	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}
	public UserInfo(String access_token, String userName, String token_type) {
		super();
		this.access_token = access_token;
		this.userName = userName;
		this.token_type = token_type;
	}
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	
}
