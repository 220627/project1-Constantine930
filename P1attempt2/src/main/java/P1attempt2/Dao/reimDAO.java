package P1attempt2.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import P1attempt2.Controllers.AuthentiCon;
import P1attempt2.models.ers_reim;
import P1attempt2.util.ConUtil;

public class reimDAO {
	public ArrayList<ers_reim> Viewreim(int perm , int ID ) {
	try(Connection conn =ConUtil.getConnection()){
		ArrayList<ers_reim> bob = new ArrayList<>();
		Authentic A = new Authentic();
		if(perm==1) {
			String sql = "select * from ers_reim;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				//System.out.println("all good");
				ers_reim Bob=new ers_reim(
						rs.getInt("reim_id"),
						rs.getDouble("reim_amount"),
						rs.getDate("reim_sub"),
						rs.getString("reim_desc"),
						A.UserByID(rs.getInt("reim_auth")),
						A.UserByID(rs.getInt("reim_res")),
						A.StatByID(rs.getInt("reim_status_id")),
						A.TypeBYID(rs.getInt("reim_type_id"))
						);
				Bob.setAuth(rs.getInt("reim_auth"));
				Bob.setRes(rs.getInt("reim_res"));
				Bob.setStatus(rs.getInt("reim_status_id"));
				Bob.setType(rs.getInt("reim_type_id"));
				bob.add(Bob);}
				return bob;
		}else  if(ID!=0){
			String sql = "select * from ers_reim where reim_auth = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				//first step without the extra classes fluff.
				//small preference I don't want the employees to see the name of the respondent and they already know their own name.
				ers_reim Bob=new ers_reim(
						rs.getDouble("reim_amount"),
						rs.getDate("reim_sub"),
						rs.getString("reim_desc"),
						rs.getInt("reim_auth"),
						rs.getInt("reim_res"),
						A.StatByID(rs.getInt("reim_status_id")),
						A.TypeBYID(rs.getInt("reim_type_id"))
						);
				Bob.setStatus(rs.getInt("reim_status_id"));
				Bob.setType(rs.getInt("reim_type_id"));
				bob.add(Bob);
			}
				return bob;
			
		}else {System.out.println("something is off probably login");}
		
	}catch(SQLException e) {
		System.out.println("something went wrong");
		e.printStackTrace();
	}
	return null;
}
	public boolean UpdateStatus(int perm, int stat, int id, int I) {
		try(Connection Conn= ConUtil.getConnection()){
			if (perm==1) {
			String sql = "Update ers_reim set reim_status_id=? where reim_id =?;";
			PreparedStatement ps=Conn.prepareStatement(sql);
			ps.setInt(1, stat);
			ps.setInt(2,id);
			ps.executeUpdate();
			sql = "Update ers_reim set reim_res=? where reim_id =?;";
			ps=Conn.prepareStatement(sql);
			ps.setInt(1, I);
			ps.setInt(2,id);
			ps.executeUpdate();
			//IDEA UPDATE TIME WHEN time timed :)
			//String sql2= "Update ers_reim set reim_sub=now() where reim_id =?;"
			//PreparedStatement ps2=Conn.prepareStatement(sql2);
			//ps.setInt(1,id);
			//ps.executeUpdate;
			System.out.println("reim status with id " + id + " Updated to status " +stat);
			return true;
			}else{System.out.println("No permision/bad permission");return false;}
		}catch(SQLException e){
			System.out.println("Something is off");
			e.printStackTrace();
		}	
		
		return false;}
	public ArrayList<ers_reim> ViewreimByStatus(int perm , int ID, int stat ) {
		try(Connection conn =ConUtil.getConnection()){
			ArrayList<ers_reim> bob = new ArrayList<>();
			Authentic A = new Authentic();
			if(perm==1) {
				String sql = "select * from ers_reim where reim_status_id = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, stat);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					ers_reim Bob=new ers_reim(
							rs.getInt("reim_id"),
							rs.getDouble("reim_amount"),
							rs.getDate("reim_sub"),
							rs.getString("reim_desc"),
							A.UserByID(rs.getInt("reim_auth")),
							A.UserByID(rs.getInt("reim_res")),
							A.StatByID(rs.getInt("reim_status_id")),
							A.TypeBYID(rs.getInt("reim_type_id"))
							);
					Bob.setAuth(rs.getInt("reim_auth"));
					Bob.setRes(rs.getInt("reim_res"));
					Bob.setStatus(rs.getInt("reim_status_id"));
					Bob.setType(rs.getInt("reim_type_id"));
					bob.add(Bob);}
					return bob;
			}else  if(ID!=0){
				String sql = "select * from ers_reim where reim_auth = ? and reim_status_id=?;";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, ID);
				ps.setInt(2, stat);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					ers_reim Bob=new ers_reim(
							rs.getDouble("reim_amount"),
							rs.getDate("reim_sub"),
							rs.getString("reim_desc"),
							rs.getInt("reim_auth"),
							rs.getInt("reim_res"),
							A.StatByID(rs.getInt("reim_status_id")),
							A.TypeBYID(rs.getInt("reim_type_id"))
							);
					Bob.setStatus(rs.getInt("reim_status_id"));
					Bob.setType(rs.getInt("reim_type_id"));
					bob.add(Bob);
				}
					return bob;
				
			}else {System.out.println("something is off probably login");}
			
		}catch(SQLException e) {
			System.out.println("something went wrong");
			e.printStackTrace();
		}
		return null;
	}
	public boolean  NewReimReq(ers_reim reim,int ID) {
		try(Connection Conn= ConUtil.getConnection()){
			
			String sql = "Insert into ers_reim(reim_Amount, reim_Sub, reim_Desc, reim_auth, reim_res, reim_status_ID, reim_type_ID)Values(?,now(),?,?,?,3,?);";
			PreparedStatement ps=Conn.prepareStatement(sql);
			ps.setDouble(1, reim.getAmount());
			//ps.setDate(2, reim.getTime());
			ps.setString(2, reim.getDesc());
			ps.setInt(3, ID);
			ps.setInt(4, reim.getRes());
			ps.setInt(5, reim.getType());
			ps.executeUpdate();
			
			System.out.println("New reim request added");
			return true;
		}catch(SQLException e){
			System.out.println("Something is off");
			e.printStackTrace();
		}
		
		
		
		
		
		
		return false;
		
	}
}

