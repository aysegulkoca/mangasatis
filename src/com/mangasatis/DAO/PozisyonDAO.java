package com.mangasatis.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mangasatis.Model.Pozisyon;

public class PozisyonDAO {

	private static Connection con = null;
	private static PreparedStatement psmt = null;
	private static ResultSet rs = null;
	
	public static ArrayList<Pozisyon> tumPozisyonlariListele() throws SQLException {
		
		ArrayList<Pozisyon> pozisyonlar = new ArrayList<Pozisyon>();
		
		String sqlSorgu = "SELECT * FROM `pozisyon` ORDER BY `pozisyonId` ASC;";
		
		try {
			
			con = BaglantiDAO.getConnection();
			psmt = con.prepareStatement(sqlSorgu);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				
				pozisyonlar.add(new Pozisyon(rs.getInt(1), rs.getString(2)));
				
			}
			
			con.close();
			
		} catch (final SQLException ex) {
			
			ex.printStackTrace();
			System.out.println("Yetki Listeleme sorgusu çalýþtýrýlamadý.");
			
		} finally {
			
			try {
				
				con.close();
				psmt.close();
				rs.close();	
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			}
		}
		
		return pozisyonlar;
		
	}
	
	public static int pozisyonEkle(Pozisyon pozisyon) {
		
		int durum = 0;
		
		String sqlSorgu = "INSERT INTO `pozisyon` (`pozisyon`) VALUES (?) ;";
		
		try {
			
			con = BaglantiDAO.getConnection();
			psmt = con.prepareStatement(sqlSorgu);
			psmt.setString(1, pozisyon.getPozisyon());
			
			durum = psmt.executeUpdate();
			
			con.close();
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			System.out.println("Pozisyon ekleme sorgusu yapýlamadý.");
			
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

	public static int pozisyonGüncelle(Pozisyon pozisyon) throws SQLException {
		
		int durum = 0;
		
		String sqlSorgu = "UPDATE `pozisyon` SET `pozisyon` = ? WHERE `pozisyonId` = ?";
		
		try {
			
			con = BaglantiDAO.getConnection();
			psmt = con.prepareStatement(sqlSorgu);
			
			psmt.setString(1, pozisyon.getPozisyon());
			psmt.setInt(2, pozisyon.getPozisyonId());
			
			durum = psmt.executeUpdate();
			
			con.close();
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			System.out.println("Pozisyon güncelleme sorgusu yapýlamadý.");
			
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

	public static int pozisyonSil(Pozisyon pozisyon) throws SQLException {
		
		int durum = 0;
		
		String sqlSorgu = "DELETE FROM `pozisyon` WHERE `pozisyonId` = ?;";
		
		try {
			
			con = BaglantiDAO.getConnection();
			psmt = con.prepareStatement(sqlSorgu);
			psmt.setInt(1, pozisyon.getPozisyonId());
			
			durum = psmt.executeUpdate();
			
			con.close();
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			System.out.println("Pozisyon silme sorgusu yapýlamadý.");
			
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
