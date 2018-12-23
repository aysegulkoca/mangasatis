package com.mangasatis.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mangasatis.Model.*;

public class MusteriDAO {
	
	private static Connection con = null;
	private static PreparedStatement psmt = null;
	private static ResultSet rs = null;
	
	public static String musteriPozisyonunuGetir(int pid) {
		
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
	
	public static ArrayList<Musteri> tumMusterileriListele() throws SQLException {
		
		ArrayList<Musteri> musteriler = new ArrayList<Musteri>();
		
		String sqlSorgu = "SELECT * FROM `musteri`;";
		
		try {
			
			con = BaglantiDAO.getConnection();
			psmt = con.prepareStatement(sqlSorgu);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				
				Musteri musteri = new Musteri();
				musteri.setMusteriId(rs.getInt(1));
				musteri.setMusteriAdi(rs.getString(2));
				musteri.setMusteriSoyadi(rs.getString(3));
				musteri.setMusteriEmail(rs.getString(4));
				musteri.setMusteriPassword(rs.getString(5));
				musteri.setMusteriAdres(rs.getString(6));
				musteri.setPozisyon_pozisyonId(rs.getInt(7));
				
				musteriler.add(musteri);
				
			}
			
			con.close();
			
		} catch (final SQLException ex) {
			
			ex.printStackTrace();
			System.out.println("Musteri Listeleme sorgusu çalýþtýrýlamadý.");
			
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
		
		return musteriler;
		
	}

	public static Musteri musteriyiGoster(int mid) throws SQLException {
		
		Musteri musteri = null;
		
		String sqlSorgu = "SELECT * FROM `musteri` WHERE `musteriId`=" + mid + ";";
		
		try {
			
			con = BaglantiDAO.getConnection();
			
			psmt = con.prepareStatement(sqlSorgu); 
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				
				musteri = new Musteri();
				
				musteri.setMusteriId(rs.getInt(1));
				musteri.setMusteriAdi(rs.getString(2));
				musteri.setMusteriSoyadi(rs.getString(3));
				musteri.setMusteriEmail(rs.getString(4));
				musteri.setMusteriPassword(rs.getString(5));
				musteri.setMusteriAdres(rs.getString(6));
				musteri.setPozisyon_pozisyonId(rs.getInt(7));

			}
			
			con.close();
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			System.out.println("Musteri görüntüleme sorgusu çalýþmadý");
			
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

		return musteri;
		
	}
	
	public static int musteriEkle(Musteri musteri) throws SQLException {
		
		int durum = 0;
		
		String sql = "INSERT INTO `musteri`(`musteriAdi`, `musteriSoyadi`, `musteriEmail`, "
				+ "`musteriPassword`, `musteriAdres`, `pozisyon_pozisyonId`) VALUES(?,?,?,?,?,?);";
		
		try{
			
			con=BaglantiDAO.getConnection();
			psmt=con.prepareStatement(sql);
			
			psmt.setString(1, musteri.getMusteriAdi());
			psmt.setString(2, musteri.getMusteriSoyadi());
			psmt.setString(3, musteri.getMusteriEmail());
			psmt.setString(4, musteri.getMusteriPassword());
			psmt.setString(5, musteri.getMusteriAdres());
			psmt.setInt(6, musteri.getPozisyon_pozisyonId());
			
			durum = psmt.executeUpdate();	
			
			con.close();
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			System.out.println("Musteri ekleme sorgusu yapýlamadý.");
			
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

	public static int musteriGüncelle(Musteri musteri) throws SQLException {
		
		int durum = 0;
		
		String sqlSorgu = "UPDATE `musteri` SET `musteriAdi`=?, `musteriSoyadi`=?, `musteriEmail`=?,"
				+ "`musteriPassword`=? , `musteriAdres`=? WHERE `musteriId` = ?";
		
		try {
			
			con = BaglantiDAO.getConnection();
			psmt = con.prepareStatement(sqlSorgu);
			
			psmt.setString(1, musteri.getMusteriAdi());
			psmt.setString(2, musteri.getMusteriSoyadi());
			psmt.setString(3, musteri.getMusteriEmail());
			psmt.setString(4, musteri.getMusteriPassword());
			psmt.setString(5, musteri.getMusteriAdres());
			psmt.setInt(6, musteri.getMusteriId());
			
			durum = psmt.executeUpdate();
			
			con.close();
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			System.out.println("Musteri güncelleme sorgusu yapýlamadý.");
			
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
	
	public static int musteriSil(int musteriId) throws SQLException {
		
		int durum = 0;
		
		String sqlSorgu = "DELETE FROM `musteri` WHERE `musteriId` = ?;";
		
		try {
			
			con = BaglantiDAO.getConnection();
			psmt = con.prepareStatement(sqlSorgu);
			psmt.setInt(1, musteriId);
			
			durum = psmt.executeUpdate();
			
			con.close();
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			System.out.println("Musteri silme sorgusu yapýlamadý.");
			
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

	public static Musteri musteriLogin(String email, String password) {
		
		Musteri musteri = null;
		
		String sqlSorgu = "SELECT * FROM `musteri` WHERE `musteriEmail`=? AND `musteriPassword`=?;";
		
		try{
			
			con = BaglantiDAO.getConnection();
			psmt = con.prepareStatement(sqlSorgu);
			
			psmt.setString(1, email);
			psmt.setString(2, password);
			rs=psmt.executeQuery();
			
			if(rs.next()){
				
				musteri  =new Musteri();
				musteri.setMusteriId(rs.getInt(1));
				musteri.setMusteriAdi(rs.getString(2));	
				musteri.setMusteriSoyadi(rs.getString(3));
				musteri.setMusteriEmail(rs.getString(4));
				musteri.setMusteriPassword(rs.getString(5));
				musteri.setMusteriAdres(rs.getString(6));
				
			}

			con.close();
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			System.out.println("Musteri bulma sorgusu yapýlamadý.");
			
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
		
		return musteri;	
		
	}

	public static boolean musteriKontrol(String email) {
		
		boolean durum = false;
		
		String sqlSorgu = "SELECT * FROM `musteri` WHERE `musteriEmail`=?;";
		
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
			System.out.println("Musteri kontrol sorgusu yapýlamadý.");
			
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

}
