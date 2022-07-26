package P1attempt2.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import P1attempt2.models.users;
import P1attempt2.util.ConUtil;

public class Authentic {
	public users Login(String name, String pass) {	
		try(Connection conn =ConUtil.getConnection()){
			String sql = "select * from ers_users where ers_username = ? and ers_password = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				//System.out.println("all good");
				users Bob=new users(
						rs.getString("user_fname"),
						rs.getString("user_lname"),
						rs.getString("user_email"),
						rs.getInt("user_role_id"),
						rs.getInt("ers_user_id")
						);
				return Bob;
			}else {
				System.out.println("DID YOU MESS UP THE LOGIN AGAIN?");
			}
			
		}catch(SQLException e) {
			System.out.println("something went wrong");
			e.printStackTrace();
		}
		
		
		
		
		return null;
	}
// I am kinda double dipping here but where I will want to check for credentials I will also want to see the person's ID
	public users UserByID(int ID) {
		try(Connection conn =ConUtil.getConnection()){
			String sql = "select * from ers_users where ers_user_id=?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				//System.out.println("all good");
				users Bob=new users(
						rs.getString("user_fname"),
						rs.getString("user_lname"),
						rs.getString("user_email"),
						rs.getInt("user_role_id"),
						rs.getInt("ers_user_id")
						);
				return Bob;
			}else {
				System.out.println("YOU MESSED UP something?");
			}
			
		}catch(SQLException e) {
			System.out.println("something went wrong");
			e.printStackTrace();
		}
		
		
		
		
		return null;
	}
// I can just flood this spot with my object finding methods flood is a strong word, 2 more finders.
	public String StatByID(int ID) {try(Connection conn =ConUtil.getConnection()){
		String sql = "select * from ers_reim_status where reim_status_id=?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, ID);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			//System.out.println("all good");
			return rs.getString("reim_status");
			
		}else {
			System.out.println("YOU MESSED UP something?");
		}
		
	}catch(SQLException e) {
		System.out.println("something went wrong");
		e.printStackTrace();
	}
	return null;}

	public String TypeBYID(int ID) {
		try(Connection conn =ConUtil.getConnection()){
			String sql = "select * from ers_reim_type where reim_type_ID=?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				//System.out.println("all good");
				return rs.getString("reim_type");
				
			}else {
				System.out.println("YOU MESSED UP something?");
			}
			
		}catch(SQLException e) {
			System.out.println("something went wrong");
			e.printStackTrace();
		}
		return null;}
}
