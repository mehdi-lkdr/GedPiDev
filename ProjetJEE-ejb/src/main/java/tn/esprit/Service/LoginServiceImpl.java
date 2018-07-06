package tn.esprit.Service;

import java.net.URLEncoder;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.json.Json;
import javax.json.JsonReader;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;

import tn.esprit.entities.UserInfo;


@Stateless
@Default
public class LoginServiceImpl implements  LoginService,LoginServiceRemote {
	
	private ObjectMapper mapper = new ObjectMapper();
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
			if(retour.lastIndexOf("access_token") != -1){
				JSONParser parser = new JSONParser();
				JSONObject json = (JSONObject) parser.parse(retour);
			UserInfo u = new UserInfo(json.getString("userName"),json.getString("access_token"),json.getString("token_type")) ;
			return u ; 
			}else{
				return null ;
			}
		}catch(Exception e){
			
		}
		return null ;
	}
	
}
