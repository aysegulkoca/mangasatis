package com.mangasatis.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mangasatis.Model.YayinEvi;

public class YayinEviDAO {
	
	private static Connection con = null;
	private static PreparedStatement psmt = null;
	private static ResultSet rs = null;
	
	public static ArrayList<YayinEvi> tumYayinEvileriniListele() throws SQLException {
		
		ArrayList<YayinEvi> yayinevileri = new ArrayList<YayinEvi>();
		
		String sqlSorgu = "SELECT * FROM `yayinevi` ORDER BY `yayinEviId` ASC;";
		
		try {
			
			con = BaglantiDAO.getConnection();
			psmt = con.prepareStatement(sqlSorgu);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				
				yayinevileri.add(new YayinEvi(rs.getInt(1), rs.getString(2)));
				
			}
			con.close();
			
		} catch (final SQLException ex) {
			
			ex.printStackTrace();
			System.out.println("Yayýn Evi Listeleme sorgusu çalýþtýrýlamadý.");
			
		} finally {
			
			try {
				
				con.close();
				psmt.close();
				rs.close();	
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return yayinevileri;
		
	}

	public static int yayinEviEkle(YayinEvi yayinevi) {
		
		int durum = 0;
		
		String sqlSorgu = "INSERT INTO `yayinevi` (`yayinEviAdi`) VALUES (?) ;";
		
		try {
			
			con = BaglantiDAO.getConnection();
			psmt = con.prepareStatement(sqlSorgu);
			psmt.setString(1, yayinevi.getYayinEviAdi());
			
			durum = psmt.executeUpdate();
			
			con.close();
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			System.out.println("Yayýn Evi ekleme sorgusu yapýlamadý.");
			
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

	public static int yayinEviGüncelle(YayinEvi yayinevi) throws SQLException {
		
		int durum = 0;
		
		String sqlSorgu = "UPDATE `yayinevi` SET `yayinEviAdi` = ? WHERE `yayinEviId` = ?";
		
		try {
			
			con = BaglantiDAO.getConnection();
			psmt = con.prepareStatement(sqlSorgu);
			
			psmt.setString(1, yayinevi.getYayinEviAdi());
			psmt.setInt(2, yayinevi.getYayineviId());
			
			durum = psmt.executeUpdate();
			
			con.close();
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			System.out.println("Yayin Evi güncelleme sorgusu yapýlamadý.");
			
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

	public static int yayineviSil(YayinEvi yayinevi) throws SQLException {
		
		int durum = 0;
		
		String sqlSorgu = "DELETE FROM `yayinevi` WHERE `yayinEviId` = ?;";
		
		try {
			
			con = BaglantiDAO.getConnection();
			psmt = con.prepareStatement(sqlSorgu);
			psmt.setInt(1, yayinevi.getYayineviId());
			
			durum = psmt.executeUpdate();
			
			con.close();
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			System.out.println("Yayin Evi silme sorgusu yapýlamadý.");
			
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
