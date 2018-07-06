package tn.esprit.Service;

import javax.ejb.Local;

import tn.esprit.entities.UserInfo;

@Local
public interface LoginService {
	public UserInfo getUserToken(String userName, String password) ; 
}
