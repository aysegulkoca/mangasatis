package com.mangasatis.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mangasatis.Model.Tur;

public class TurDAO {
	
	private static Connection con = null;
	private static PreparedStatement psmt = null;
	private static ResultSet rs = null;
	
	public static ArrayList<Tur> tumturleriListele() throws SQLException {
		
		ArrayList<Tur> turler = new ArrayList<Tur>();
		
		String sqlSorgu = "SELECT * FROM `tur` ORDER BY `turId` ASC;";
		
		try {
			
			con = BaglantiDAO.getConnection();
			psmt = con.prepareStatement(sqlSorgu);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				
				turler.add(new Tur(rs.getInt(1), rs.getString(2)));
				
			}
			con.close();
			
		} catch (final SQLException ex) {
			
			ex.printStackTrace();
			System.out.println("Tür Listeleme sorgusu çalýþtýrýlamadý.");
			
		} finally {
			
			try {
				
				con.close();
				psmt.close();
				rs.close();	
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return turler;
		
	}

	public static int turEkle(Tur tur) {
		
		int durum = 0;
		
		String sqlSorgu = "INSERT INTO `tur` (`tur`) VALUES (?) ;";
		
		try {
			
			con = BaglantiDAO.getConnection();
			psmt = con.prepareStatement(sqlSorgu);
			psmt.setString(1, tur.getTur());
			
			durum = psmt.executeUpdate();
			
			con.close();
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			System.out.println("Tür ekleme sorgusu yapýlamadý.");
			
		} finally {
			
			try {
				
				if(rs != null) {
				    rs.close();
				}

				if(psmt != null) {
				   psmt.close();
				}


				if(con != null) {
				   con.close();
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			}
		}
		
		return durum;
		
	}

	public static int turGüncelle(Tur tur) throws SQLException {
		
		int durum = 0;
		
		String sqlSorgu = "UPDATE `tur` SET `tur` = ? WHERE `turId` = ?";
		
		try {
			
			con = BaglantiDAO.getConnection();
			psmt = con.prepareStatement(sqlSorgu);
			
			psmt.setString(1, tur.getTur());
			psmt.setInt(2, tur.getTurId());
			
			durum = psmt.executeUpdate();
			
			con.close();
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			System.out.println("Tür güncelleme sorgusu yapýlamadý.");
			
		} finally {
			
			try {
				
				con.close();
				psmt.close();
				rs.close();	
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			}
		}
		
		return durum;
		
	}

	public static int turSil(Tur tur) throws SQLException {
		
		int durum = 0;
		
		String sqlSorgu = "DELETE FROM `tur` WHERE `turId` = ?;";
		
		try {
			
			con = BaglantiDAO.getConnection();
			psmt = con.prepareStatement(sqlSorgu);
			psmt.setInt(1, tur.getTurId());
			
			durum = psmt.executeUpdate();
			
			con.close();
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			System.out.println("Tür silme sorgusu yapýlamadý.");
			
		} finally {
			
			try {
				
				con.close();
				psmt.close();
				rs.close();	
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			}
		}
		
		return durum;
		
	}
}
