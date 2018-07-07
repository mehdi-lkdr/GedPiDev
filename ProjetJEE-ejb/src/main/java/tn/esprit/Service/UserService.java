package tn.esprit.Service;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entities.Aspnetuser;
import tn.esprit.entities.UserInfo;

@Local
public interface UserService {

	
	
	
	public void saveUser(Aspnetuser aspnetuser ) ; 
	public void updateUser(Aspnetuser aspnetuser) ; 
	public void deleteUser(String aspnetuserId) ; 
	public Aspnetuser getUserById(String aspnetUserId ) throws Exception ; 
	public Aspnetuser getUserByUserName(UserInfo userinfo ) throws Exception ; 
	public List<Aspnetuser> getListUser();
	
	
	
	
	
}
