package tn.esprit.Service;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entities.Aspnetuser;
import tn.esprit.entities.UserInfo;

@Remote
public interface UserServiceRemote {

	
	
	
	public void saveUser(Aspnetuser aspnetuser ) ; 
	public void updateUser(Aspnetuser aspnetuser) ; 
	public void deleteUser(String aspnetuserId) ; 
	public Aspnetuser getUserById(String aspnetUserId ) throws Exception ; 
	public Aspnetuser getUserByUserName(UserInfo userInfo ) throws Exception ; 
	public List<Aspnetuser> getListUser();
	
	
	
	
	
}
