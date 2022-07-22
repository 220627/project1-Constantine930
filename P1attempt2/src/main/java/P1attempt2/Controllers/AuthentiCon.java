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
			System.out.println(ID);}
		
		if(AS.login(lDto.getName(), lDto.getPass())!=null) {
			ses = ctx.req.getSession();
			Lo.info("User Logged in!");
			ctx.result("we welcome you " + lDto.getName());
			ctx.status(202);
			}else {ctx.result("NO, Wrong pass or name");
			Lo.warn("User Failed to Login");
				ctx.status(401);}
	};
}
