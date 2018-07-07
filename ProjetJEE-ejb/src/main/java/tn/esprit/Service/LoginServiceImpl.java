package tn.esprit.Service;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.fasterxml.jackson.databind.ObjectMapper;

import tn.esprit.entities.UserInfo;


@Stateless
@Default
public class LoginServiceImpl implements  LoginService,LoginServiceRemote {
	
	private ResteasyClient client = new ResteasyClientBuilder().build();
    ResteasyWebTarget target = client.target("http://localhost:10040/token");
	@Override
	public UserInfo getUserToken(String userName, String password) {
		Form form = new Form(); 
		form.param("grant_type", "password").param("username", userName).param("password", password) ;
		Entity<Form> entity =Entity.form(form) ; 
		
		try{
	        Response response = target.request(MediaType.APPLICATION_JSON).post(entity);
	        String retour = response.readEntity(String.class) ;
	        System.out.println(retour);
			if(retour.lastIndexOf("access_token") != -1){
				
			UserInfo u = new UserInfo() ;	
			System.out.println(retour.indexOf("userName")+3);
			System.out.println(retour.indexOf("token_type")-3);
			u.setAccess_token(retour.substring(retour.indexOf("access_token")+15, retour.indexOf("token_type")-3));
			u.setToken_type("bearer");
			u.setUserName(retour.substring(retour.indexOf("userName")+11,retour.indexOf(".issued")-3));
			response.close(); 
			return u ; 
			}else{
				return null ;
			}
		}catch(Exception e){
			
		}
		return null ;
	}
	
}
