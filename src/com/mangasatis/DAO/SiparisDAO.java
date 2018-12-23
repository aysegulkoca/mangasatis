package com.mangasatis.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mangasatis.Model.Siparis;

public class SiparisDAO {
	
	private static Connection con = null;
	private static PreparedStatement psmt = null;
	private static ResultSet rs = null;

	public static String mangaAdiniGetir(int mid) throws SQLException {
		String mangaAdi = null;
		String sqlSorgu = "SELECT `mangaAdi` FROM `manga` WHERE `mangaId`=" + mid + ";";
		
		try {
			
			con = BaglantiDAO.getConnection();
			psmt = con.prepareStatement(sqlSorgu);
			rs = psmt.executeQuery();
			
			if( rs.next() ) {
			
				mangaAdi = rs.getString(1);
				
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
		
		return mangaAdi;
	}

	public static String musteriAdiniGetir(int mid) throws SQLException {
		
		String musteriAdi = null;
		String sqlSorgu = "SELECT `musteriAdi` FROM `musteri` WHERE `musteriId`=" + mid + ";";
		
		try {
			
			con = BaglantiDAO.getConnection();
			psmt = con.prepareStatement(sqlSorgu);
			rs = psmt.executeQuery();
			
			if( rs.next() ) {
			
				musteriAdi = rs.getString(1);
				
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
		
		return musteriAdi;
	}

	public static String musteriAdresiniGetir(int mid) throws SQLException {
		
		String musteriAdres = null;
		String sqlSorgu = "SELECT `musteriAdres` FROM `musteri` WHERE `musteriId`=" + mid + ";";
		
		try {
			
			con = BaglantiDAO.getConnection();
			psmt = con.prepareStatement(sqlSorgu);
			rs = psmt.executeQuery();
			
			if( rs.next() ) {

				musteriAdres = rs.getString(1);
				
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
		
		return musteriAdres;
	}
	
	public static ArrayList<Siparis> adminSiparisListele() throws SQLException {
		
		ArrayList<Siparis> tumSiparisler = new ArrayList<Siparis>();
		String sqlSorgu = "SELECT * FROM `siparis`";
		
		try {
			
			con = BaglantiDAO.getConnection();
			psmt = con.prepareStatement(sqlSorgu);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				Siparis siparis = new Siparis();
				
				siparis.setSiparisId(rs.getInt(1));
				siparis.setSiparisTarihi(rs.getString(2));
				siparis.setTeslimTarihi(rs.getString(3));
				siparis.setUrunMiktari(rs.getInt(4));
				siparis.setToplamFiyat(rs.getInt(5));
				siparis.setMusteri_musteriId(rs.getInt(7));
				siparis.setManga_mangaId(rs.getInt(6));

				tumSiparisler.add(siparis);
				
			}
			
			con.close();
			
		} catch (SQLException ex) {
			
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
		
		return tumSiparisler;
		
	}

	public static ArrayList<Siparis> musteriSiparisListele(int mid) throws SQLException {
		
		ArrayList<Siparis> tumSiparisler = new ArrayList<Siparis>();
		String sqlSorgu = "SELECT * FROM `siparis` WHERE `musteri_musteriId`=" + mid + ";";
		
		try {
			
			con = BaglantiDAO.getConnection();
			psmt = con.prepareStatement(sqlSorgu);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				Siparis siparis = new Siparis();
				
				siparis.setSiparisId(rs.getInt(1));
				siparis.setSiparisTarihi(rs.getString(2));
				siparis.setTeslimTarihi(rs.getString(3));
				siparis.setUrunMiktari(rs.getInt(4));
				siparis.setToplamFiyat(rs.getInt(5));
				siparis.setManga_mangaId(rs.getInt(6));

				tumSiparisler.add(siparis);
				
			}
			
			con.close();
			
		} catch (SQLException ex) {
			
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
		
		return tumSiparisler;
		
	}
	
	public static int siparisSayisi() {
		
		int adet = 0;
		
		String sqlSorgu = "SELECT COUNT(siparisId) FROM Siparis;";
		
		try {
			
			con = BaglantiDAO.getConnection();
			psmt =  con.prepareStatement(sqlSorgu);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				
				int sayi = (rs.getInt(1));
				adet = sayi;		
			}
			
			con.close();
			
		} catch (SQLException ex) {
			
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
		
		return adet;
	}
	
	public static int siparisEkle(Siparis siparis){
		int durum = 0;
		String sqlSorgu = "INSERT INTO `siparis`(`siparisTarihi`, `teslimTarihi`, `urunMiktari`, `toplamFiyati`, "
				+ "`urun_urunId`, `musteri_musteriId`) "
				+ "VALUES (?,?,?,?,?,?)";
		try {			
			con = BaglantiDAO.getConnection();			
			psmt = con.prepareStatement(sqlSorgu);
			
			psmt.setString(1, siparis.getSiparisTarihi());
			psmt.setString(2, siparis.getTeslimTarihi());
			psmt.setInt(3, siparis.getUrunMiktari());
			psmt.setFloat(4, siparis.getToplamFiyat());
			psmt.setInt(5, siparis.getManga_mangaId());
			psmt.setInt(6, siparis.getMusteri_musteriId());
			durum = psmt.executeUpdate();
			
		} catch (SQLException ex) {
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
		return durum;
	}

	public static int siparisSil(int siparisId){
	
		try {
			
			con = BaglantiDAO.getConnection();
			psmt =  con.prepareStatement("DELETE FROM Siparis WHERE siparisId=?;");
			psmt.executeUpdate();			
			con.close();
			
		} catch (SQLException ex) {
			
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
		
		return 1;
	}
	
}

