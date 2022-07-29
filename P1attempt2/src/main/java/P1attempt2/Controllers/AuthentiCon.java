package P1attempt2.Controllers;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;

import P1attempt2.Servises.AuthenticServices;
import P1attempt2.models.users;
import io.javalin.http.Handler;

public class AuthentiCon {
	public static Logger Lo = LogManager.getLogger();
	AuthenticServices AS = new AuthenticServices();
	public static HttpSession ses;
	public static int perm;
	public static int ID;
	public Handler logoutHand=(ctx)->{
		Lo.info("User Loged out");
		ctx.result("You are out");
		ctx.status(200);
		perm=0;
		ID=0;
		ses=null;};
	public Handler loginHand=(ctx)->{
		String body = ctx.body();
		Gson gson = new Gson();
		users lDto= gson.fromJson(body, users.class);
		if(AS.loginEX(lDto.getName(),lDto.getPass())==1) {
			perm = AS.loginEX(lDto.getName(), lDto.getPass());
			System.out.println(perm);
		}
		
		if(AS.loginSp(lDto.getName(),lDto.getPass())!=0) {
			ID = AS.loginSp(lDto.getName(),lDto.getPass());
			System.out.println(ID);
			lDto.setID(ID);}
		
		if(AS.login(lDto.getName(), lDto.getPass())!=null) {
			ses = ctx.req.getSession();
			Lo.info("User Logged in!");
			String Hopethisworks =gson.toJson(AS.login(lDto.getName(), lDto.getPass()));
			ctx.result(Hopethisworks);
			ctx.status(202);
			}else {ctx.result("NO, Wrong pass or name");
			Lo.warn("User Failed to Login");
				ctx.status(401);}
	};
	}

