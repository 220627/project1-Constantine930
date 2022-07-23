package P1attempt2.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
						rs.getDouble("reim_amount"),
						rs.getDate("reim_sub"),
						rs.getString("reim_desc"),
						A.UserByID(rs.getInt("reim_auth")),
						A.UserByID(rs.getInt("reim_res")),
						rs.getInt("reim_status_id"),
						rs.getInt("reim_type_id")
						);
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
						rs.getInt("reim_status_id"),
						rs.getInt("reim_type_id")
						);
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
	public boolean UpdateStatus(int perm, int stat, int id) {
		try(Connection Conn= ConUtil.getConnection()){
			if (perm==1) {
			String sql = "Update ers_reim set reim_status_id=? where reim_id =?;";
			PreparedStatement ps=Conn.prepareStatement(sql);
			ps.setInt(1, stat);
			ps.setInt(2,id);
			ps.executeUpdate();
			System.out.println("reim status with id " + id + " Updated to status " +stat);
			return true;
			}else{System.out.println("No permision/bad permission");return false;}
		}catch(SQLException e){
			System.out.println("Something is off");
			e.printStackTrace();
		}
		
		
		
		
		return false;}

}

