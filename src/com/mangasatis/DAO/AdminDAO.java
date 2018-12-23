package com.mangasatis.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mangasatis.Model.Admin;

public class AdminDAO {
	
	private static Connection con = null;
	private static PreparedStatement psmt = null;
	private static ResultSet rs = null;
	
	public static String adminPozisyonunuGetir(int pid) {
		
		String pozisyon = null;
		String sqlSorgu = "SELECT `pozisyon` FROM `pozisyon` WHERE `pozisyonId`=" + pid + ";";
		
		try {
			
			con = BaglantiDAO.getConnection();
			psmt = con.prepareStatement(sqlSorgu);
			rs = psmt.executeQuery();
			
			if( rs.next() ) {
			
				pozisyon = rs.getString(1);
				
			}
			
			con.close();
			
		} catch (final SQLException ex) {
			
			ex.printStackTrace();
			
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
		
		return pozisyon;
	}
	
	public static ArrayList<Admin> tumAdminleriListele() throws SQLException {
		
		ArrayList<Admin> adminler = new ArrayList<Admin>();
		
		String sqlSorgu = "SELECT * FROM `admin`;";
		
		try {
			con = BaglantiDAO.getConnection();
			psmt = con.prepareStatement(sqlSorgu);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setAdminId(rs.getInt(1));
				admin.setAdminAdi(rs.getString(2));
				admin.setAdminSoyadi(rs.getString(3));
				admin.setAdminPassword(rs.getString(4));
				admin.setAdminEmail(rs.getString(5));
				admin.setPozisyon_pozisyonId(rs.getInt(6));
				
				adminler.add(admin);	
			}
			
			con.close();
			
		} catch (final SQLException ex) {
			
			ex.printStackTrace();
			System.out.println("Admin Listeleme sorgusu çalýþtýrýlamadý.");
			
		} finally {
			
			try {
				
				con.close();
				psmt.close();
				rs.close();	
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return adminler;
		
	}

	public static int adminEkle(Admin admin) throws SQLException {
		
		int durum = 0;
		
		String sqlSorgu = "INSERT INTO `admin`(`adminId`, `adminAdi`, `adminSoyadi`, "
				+ "`adminEmail`, `adminPassword`, `pozisyon_pozisyonId`) VALUES(?,?,?,?,?)";
		
		try{
			
			con=BaglantiDAO.getConnection();
			psmt=con.prepareStatement(sqlSorgu);
			
			psmt.setString(1, admin.getAdminAdi());
			psmt.setString(2, admin.getAdminSoyadi());
			psmt.setString(3, admin.getAdminEmail());
			psmt.setString(4, admin.getAdminPassword());
			psmt.setInt(5, admin.getPozisyon_pozisyonId());
			
			durum = psmt.executeUpdate();
			
			con.close();
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			System.out.println("Admin ekleme sorgusu yapýlamadý.");
			
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

	public static int adminGüncelle(Admin admin) throws SQLException {
		
		int durum = 0;
		
		String sqlSorgu = "UPDATE `admin` SET `adminAdi`=?, `adminSoyadi`=?, `adminEmail`=?,"
				+ "`adminPassword`=? WHERE `adminId` = ?";
		
		try {
			
			con = BaglantiDAO.getConnection();
			psmt = con.prepareStatement(sqlSorgu);
			
			psmt.setString(1, admin.getAdminAdi());
			psmt.setString(2, admin.getAdminSoyadi());
			psmt.setString(3, admin.getAdminEmail());
			psmt.setString(4, admin.getAdminPassword());
			psmt.setInt(5, admin.getAdminId());
			
			durum = psmt.executeUpdate();
			
			con.close();
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			System.out.println("Admin güncelleme sorgusu yapýlamadý.");
			
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

	public static int adminSil(Admin admin) throws SQLException {
		
		int durum = 0;
		
		String sqlSorgu = "DELETE FROM `admin` WHERE `adminId` = ?;";
		
		try {
			
			con = BaglantiDAO.getConnection();
			psmt = con.prepareStatement(sqlSorgu);
			psmt.setInt(1, admin.getAdminId());
			
			durum = psmt.executeUpdate();
			
			con.close();
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			System.out.println("Admin silme sorgusu yapýlamadý.");
			
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

	public static Admin adminLogin(String email, String password) {
		
		Admin admin = null;
		
		String sqlSorgu = "SELECT * FROM `admin` WHERE `adminEmail`=? AND `adminPassword`=?;";
		
		try{
			
			con = BaglantiDAO.getConnection();
			psmt = con.prepareStatement(sqlSorgu);
			
			psmt.setString(1, email);
			psmt.setString(2, password);
			rs=psmt.executeQuery();
			
			if(rs.next()){
				
				admin=new Admin();
				admin.setAdminId(rs.getInt(1));
				admin.setAdminAdi(rs.getString(2));	
				admin.setAdminSoyadi(rs.getString(3));
				admin.setAdminEmail(rs.getString(4));
				admin.setAdminPassword(rs.getString(5));
				
			}

			con.close();
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			System.out.println("Admin login sorgusu yapýlamadý.");
			
		} finally {
			
			try {
				
				con.close();
				psmt.close();
				rs.close();	
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			}
		}
		
		return admin;	
		
	}

	public static boolean adminKontrol(String email) {
		
		boolean durum = false;
		
		String sqlSorgu = "SELECT * FROM `admin` WHERE `adminEmail`=?;";
		
		try{
			
			con = BaglantiDAO.getConnection();
			psmt = con.prepareStatement(sqlSorgu);
			
			psmt.setString(1, email);
			rs=psmt.executeQuery();
			
			if(rs.next()){
				
				durum = true;
				
			}

			con.close();
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			System.out.println("Admin bulma sorgusu yapýlamadý.");
			
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
