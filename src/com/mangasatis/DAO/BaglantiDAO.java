package com.mangasatis.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaglantiDAO {
	
	public static Connection getConnection(){
		Connection con = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mangasatis" + "?useSSL=false", "root", "");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Baðlantý oluþturulamadý.");
		}
		return con;
	}
	
	public static void kapat(Connection con, PreparedStatement psmt, ResultSet rs) throws SQLException{
		if (con != null)
			con.close();
		if (psmt != null)
			psmt.close();
		if (rs != null)
			rs.close();
	}
}
