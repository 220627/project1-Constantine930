package com.revature.Controllers;

import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.models.users;
import com.revature.Servises.AuthenticServices;

import io.javalin.http.Handler;

public class AuthentiCon {

	AuthenticServices AS = new AuthenticServices();
	public static HttpSession ses;
	public static int perm;
	public static int ID;
	public Handler loginHand=(ctx)->{
		String body = ctx.body();
		Gson gson = new Gson();
		users lDto= gson.fromJson(body, users.class);
		if(AS.loginEX(lDto.getName(),lDto.getPass())==1) {
			perm = 1;
			System.out.println(perm);
		}
		if(AS.loginSp(lDto.getName(),lDto.getPass())!=0) {
			ID = AS.loginSp(lDto.getName(),lDto.getPass());
			System.out.println(ID);
		}
		if(AS.login(lDto.getName(), lDto.getPass())!=null) {
			ses = ctx.req.getSession();
			ctx.result("we welcome you " + lDto.getName());
			ctx.status(202);
			}else {ctx.result("NO, Wrong pass or name");
				ctx.status(401);}
	};
}