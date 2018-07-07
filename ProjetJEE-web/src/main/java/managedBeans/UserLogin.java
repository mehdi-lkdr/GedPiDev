package managedBeans;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import tn.esprit.Service.LoginService;
import tn.esprit.Service.UserService;
import tn.esprit.entities.Aspnetuser;
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
	@Inject
	private UserService userService ;
    private String username;
    private String password;
    private UserInfo user = new UserInfo() ; 
    
    @PostConstruct
    public void init(){
		HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();

		if(req.getParameter("log") != null)
		{
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please check your login/password", null);
    		FacesContext.getCurrentInstance().addMessage(null, message);
		}
    }
    
    public String login(){
    	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
    	Map<String, Object> sessionMap = externalContext.getSessionMap();
    	user = loginService.getUserToken(this.username, this.password) ; 
    	sessionMap.put("UserCred",user);
    	Aspnetuser u = null ;
    	try {
			u = userService.getUserByUserName(user);
			sessionMap.put("navigationUser",u);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	if(user != null && u != null) {
    		try {
				externalContext.redirect("index.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

    		return "index.xhtml?faces-redirect=true";
    	} else {
    		return "login?log=1" ;
    	}
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