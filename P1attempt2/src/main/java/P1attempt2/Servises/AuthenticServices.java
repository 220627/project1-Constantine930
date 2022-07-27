package P1attempt2.Servises;

import P1attempt2.Dao.Authentic;
import P1attempt2.models.users;

public class AuthenticServices {

	Authentic aDao = new Authentic();
	public users login(String name, String pass) {
		if(aDao.Login(name, pass)!=null) {return aDao.Login(name, pass);
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
