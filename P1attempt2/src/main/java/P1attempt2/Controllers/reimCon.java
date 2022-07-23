package P1attempt2.Controllers;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;

import P1attempt2.models.ers_reim;
import P1attempt2.Dao.reimDAO;
import io.javalin.http.Handler;

public class reimCon {
public static Logger log = LogManager.getLogger();
AuthentiCon AC = new AuthentiCon();
reimDAO rDao = new reimDAO();
public Handler Viewreim=(ctx)->{
    if (AuthentiCon.ses!=null) {
    ArrayList<ers_reim> Tom = rDao.Viewreim(AuthentiCon.perm, AuthentiCon.ID);
    Gson gson = new Gson();
    String rSon = gson.toJson(Tom);
    log.info("stuff has been viewed");
	ctx.result(rSon);
	ctx.status(200);} else {ctx.result("ses ain't available");}
    };
public Handler UpdateStat=(ctx)->{
	if (AuthentiCon.ses!=null) {
	int id = Integer.parseInt(ctx.pathParam("id"));
	int stat = Integer.parseInt(ctx.body());
	if(rDao.UpdateStatus(AuthentiCon.perm, stat, id)) {
		log.info("Status Updated");
		ctx.status(202);
	}else {
		log.info("Unaccepted perm");
		ctx.status(406);
	}}else {log.warn("Someone did me dirty");
		ctx.result("No session");
		ctx.status(404);}
		
};



}

