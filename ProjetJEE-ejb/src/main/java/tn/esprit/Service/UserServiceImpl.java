package tn.esprit.Service;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import tn.esprit.entities.Aspnetuser;
import tn.esprit.entities.UserInfo;


@Stateless
@Default
public class UserServiceImpl implements UserService , UserServiceRemote {

	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void saveUser(Aspnetuser aspnetuser) {
		// TODO Auto-generated method stub
		em.persist(aspnetuser);
	}

	@Override
	public void updateUser(Aspnetuser aspnetuser) {
		// TODO Auto-generated method stub
		em.merge(aspnetuser);
	}

	@Override
	public void deleteUser(String aspnetuserId) {
		// TODO Auto-generated method stub
		try {
			em.remove(getUserById(aspnetuserId));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Aspnetuser getUserById(String aspnetUserId) throws Exception {
		// TODO Auto-generated method stub
		return em.find(Aspnetuser.class, aspnetUserId);	}

	@Override
	public List<Aspnetuser> getListUser() {
		// TODO Auto-generated method stub
		return em.createQuery("select d from Adress d", Aspnetuser.class).getResultList() ; 	
	}

	@Override
	public Aspnetuser getUserByUserName(UserInfo userInfo) throws Exception {
		
		ObjectMapper mapper = new ObjectMapper() ;
		ClientRequest request1 = new ClientRequest("http://localhost:10040/api/ApplicationUser?username="+userInfo.getUserName()); 
		request1.header("Authorization", userInfo.getToken_type()+" "+userInfo.getAccess_token());
		ClientResponse<String> resp1 = request1.get(String.class); 
		Aspnetuser user = mapper.readValue(resp1.getEntity(), Aspnetuser.class) ;
		return user ;
	}	
}
