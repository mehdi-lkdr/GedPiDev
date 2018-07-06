package tn.esprit.entities;

public class UserInfo {

	private String userName  ;
	private String access_token;
	private String token_type ;
	public UserInfo(String userName, String access_token, String token_type) {
		super();
		this.userName = userName;
		this.access_token = access_token;
		this.token_type = token_type;
	}
	public UserInfo() {
		super();
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getToken_type() {
		return token_type;
	}
	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}
	
	
	
	
	
}
