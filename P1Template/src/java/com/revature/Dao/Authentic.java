package com.revature.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.users;
import com.revature.util.ConUtil;

public class Authentic {
		public users Login(String name, String pass) {
			
			try(Connection conn =ConUtil.getConnection()){
				String sql = "select * from ers_users where username = ? and password = ?;";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, pass);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					System.out.println("all good");
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

		}

