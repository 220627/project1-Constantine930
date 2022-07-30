package P1attempt2;

import java.sql.Connection;
import java.sql.SQLException;

import P1attempt2.Controllers.AuthentiCon;
import P1attempt2.Controllers.reimCon;
import P1attempt2.util.ConUtil;
import io.javalin.Javalin;

public class SableyeIsTheBest {
	public static void main(String[] args) {
		
		//Welcome to P1! 
		
		//If you're reading this, you've successfully cloned your repo and imported the template
		
		//Do you coding in this project, and don't forget to save/push your progress with:
		//git add.
		//git commit -m"message"
		//git push
		
		//yes, you WILL need to push to your repo. The clients will want to see your project repos in your portfolios.
		
		//here's a dog to help you on your way. Have fun!
		
//               __
//          (___()'`;
//          /,    /`
//          \\"--\\
//      __
// (___()'`;
// /,    /`
// \\"--\\
//      __
// (___()'`;
// /,    /`
// \\"--\\
		System.out.println("========Welcome to Sableye is the Best in Entetainment inc========");
		
		try(Connection con = ConUtil.getConnection()){
		System.out.println("Succs much less Success :)");

		}catch(SQLException e) {
			System.out.println("connection failed..");
			e.printStackTrace();
		}
		Javalin app = Javalin.create( config -> {config.enableCorsForAllOrigins();} ).start(3000);
		AuthentiCon AC = new AuthentiCon();
		reimCon RC = new reimCon();

		app.post("/login", AC.loginHand);
		app.get("/View", RC.Viewreim);
		app.put("/Reim/:id", RC.UpdateStat);
		app.get("/View/:status", RC.ViewByStat);
		app.put("/Reimreq", RC.ReimReq);
		app.get("/logout", AC.logoutHand);
	}
		
		
		
	}

