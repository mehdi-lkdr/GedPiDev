package Controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;

import tn.esprit.Service.AddressService;
import tn.esprit.entities.Adress;

@Path("/hello")
@RequestScoped
public class FirstService {
	
	
	@Inject
	 AddressService adService ;
	
	
	public Adress getAddress() throws Exception{
		
		Adress a = adService.getAdresseById(1);
		return a ; 
		
	}

}
