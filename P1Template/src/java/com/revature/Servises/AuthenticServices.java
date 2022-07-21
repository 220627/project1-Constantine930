package com.revature.Servises;

import com.revature.Dao.Authentic;
import com.revature.models.users;

public class AuthenticServices {

	Authentic aDao = new Authentic();
	public String login(String name, String pass) {
		if(aDao.Login(name, pass)!=null) {return name;
		}else {return null;}
	}
	
	public int loginEX(String name, String pass) {
		if(aDao.Login(name, pass)!=null) {
			return aDao.Login(name, pass).getPerm();
		}else {return 0;}
	
}
	public int loginSp(String name, String pass) {
		if(aDao.Login(name, pass)!=null) {
			return aDao.Login(name, pass).getID();
		}else {return 0;}
}
}