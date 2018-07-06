package tn.esprit.Service;

import javax.ejb.Remote;

import tn.esprit.entities.UserInfo;

@Remote
public interface LoginServiceRemote {
	public UserInfo getUserToken(String userName, String password) ; 
}
