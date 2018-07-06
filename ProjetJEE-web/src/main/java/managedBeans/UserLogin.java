package managedBeans;
import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import tn.esprit.Service.LoginService;
import tn.esprit.entities.UserInfo;
@ManagedBean(name = "UserLogin",eager=true)
@SessionScoped
public class UserLogin implements Serializable {
	
	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private LoginService loginService ;
    private String message ="Enter username and password.";
    private String username;
    private String password;
    private UserInfo user = new UserInfo() ; 
    
    @PostConstruct
    public void init(){
    	System.out.println("init");
    }
    
    public String login(){
    	System.out.println("init");
    	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
    	Map<String, Object> sessionMap = externalContext.getSessionMap();
    	user = loginService.getUserToken(this.username, this.password) ; 
    	sessionMap.put("UserCred",user);
    	
    	if("concretepage".equalsIgnoreCase(username) && "concretepage".equalsIgnoreCase(password)) {
    		message ="Successfully logged-in.";
    		return "success";
    	} else {
    		message ="Wrong credentials.";
    		return "login";
    	}
    }
    public String getMessage() {
	return message;
    }
    public void setMessage(String message) {
	this.message = message;
    }
    public String getUsername() {
	return username;
    }
    public void setUsername(String username) {
	this.username = username;
    }
    public String getPassword() {
	return password;
    }
    public void setPassword(String password) {
	this.password = password;
    }
	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
    
} 