package com.mangasatis.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mangasatis.Model.Manga;


public class MangaDAO {
	
	private static Connection con = null;
	private static PreparedStatement psmt = null;
	private static ResultSet rs = null;
	
	public static String mangaTurunuGetir(int tid) throws SQLException {
		
		String tur = null;
		String sqlSorgu = "SELECT `tur` FROM `tur` WHERE `turId`=" + tid + ";";
		
		try {
			
			con = BaglantiDAO.getConnection();
			psmt = con.prepareStatement(sqlSorgu);
			rs = psmt.executeQuery();
			
			if( rs.next() ) {
			
				tur = rs.getString(1);
				
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
		
		return tur;
	}
	
	public static String mangaYayineviniGetir(int yid) throws SQLException {
		
		String yayinevi = null;
		String sqlSorgu = "SELECT `yayinEviAdi` FROM `yayinevi` WHERE `yayinEviId`=" + yid + ";";
		
		try {
			con = BaglantiDAO.getConnection();
			psmt = con.prepareStatement(sqlSorgu);
			rs = psmt.executeQuery();
			
			if ( rs.next() ) {
				
				yayinevi = rs.getString(1);
				
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
		
		return yayinevi;
	}
	
	public static ArrayList<Manga> tumMangalariListele() throws SQLException {
		
		ArrayList<Manga> mangalar = new ArrayList<Manga>();

		String sqlSorgu = "SELECT * FROM `manga`";
		
		try {
			con = BaglantiDAO.getConnection();
			psmt = con.prepareStatement(sqlSorgu);
			rs = psmt.executeQuery();
			
			while (rs.next()) {

				Manga manga = new Manga();
				manga.setMangaId(rs.getInt(1));
				manga.setMangaAdi(rs.getString(2));
				manga.setMangaAciklamasi(rs.getString(3));
				manga.setMangaFiyati(rs.getInt(4));
				manga.setMangaMiktari(rs.getInt(5));
				manga.setMangaResmi(rs.getString(6));
				manga.setYayinevi_yayineviId(rs.getInt(7));
				manga.setTur_turId(rs.getInt(8));

				mangalar.add(manga);	
			}
		
			con.close();
			
		} catch (final SQLException ex) {
			
			ex.printStackTrace();
			System.out.println("Mangalarý Listeleme sorgusu çalýþtýrýlamadý.");
			
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
		
		return mangalar;
		
	}
	
	public static ArrayList<Manga> mangalariTureGoreListele(int tid) throws SQLException {
		
		ArrayList<Manga> mangalar = new ArrayList<Manga>();
		
		String sqlSorgu = "SELECT * FROM `manga` WHERE `tur_turId`=" + tid + ";";
		
		try {
			con = BaglantiDAO.getConnection();
			psmt = con.prepareStatement(sqlSorgu);
			rs = psmt.executeQuery();
			
			while (rs.next()) {

				Manga manga = new Manga();
				manga.setMangaId(rs.getInt(1));
				manga.setMangaAdi(rs.getString(2));
				manga.setMangaAciklamasi(rs.getString(3));
				manga.setMangaFiyati(rs.getInt(4));
				manga.setMangaMiktari(rs.getInt(5));
				manga.setMangaResmi(rs.getString(6));
				manga.setYayinevi_yayineviId(rs.getInt(7));
				manga.setTur_turId(rs.getInt(8));
				
				mangalar.add(manga);	
			}
		
			con.close();
			
		} catch (final SQLException ex) {
			
			ex.printStackTrace();
			System.out.println("Mangalarý türe göre Listeleme sorgusu çalýþtýrýlamadý.");
			
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
		
		return mangalar;
		
	}

	public static ArrayList<Manga> mangalariYayinEvineGoreListele(int yid) throws SQLException {
		
		ArrayList<Manga> mangalar = new ArrayList<Manga>();
		
		String sqlSorgu = "SELECT * FROM `manga` WHERE `yayinevi_yayineviId`=" + yid + ";";
		
		try {
			con = BaglantiDAO.getConnection();
			psmt = con.prepareStatement(sqlSorgu);
			rs = psmt.executeQuery();
			
			while (rs.next()) {

				Manga manga = new Manga();
				
				manga.setMangaId(rs.getInt(1));
				manga.setMangaAdi(rs.getString(2));
				manga.setMangaAciklamasi(rs.getString(3));
				manga.setMangaFiyati(rs.getInt(4));
				manga.setMangaMiktari(rs.getInt(5));
				manga.setMangaResmi(rs.getString(6));
				manga.setYayinevi_yayineviId(rs.getInt(7));
				manga.setTur_turId(rs.getInt(8));
				
				mangalar.add(manga);	
			}
		
			con.close();
			
		} catch (final SQLException ex) {
			
			ex.printStackTrace();
			System.out.println("Mangalarý yayýn evine göre Listeleme sorgusu çalýþtýrýlamadý.");
			
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
		
		return mangalar;
		
	}

	public static Manga mangayiGoster(int mid) throws SQLException {
		
		Manga manga = null;
		
		String sqlSorgu = "SELECT * FROM `manga` WHERE `mangaId`=" + mid + ";";
		
		try {
			
			con = BaglantiDAO.getConnection();
			
			psmt = con.prepareStatement(sqlSorgu); 
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				
				manga = new Manga();
				
				manga.setMangaId(rs.getInt(1));
				manga.setMangaAdi(rs.getString(2));
				manga.setMangaAciklamasi(rs.getNString(3));
				manga.setMangaFiyati(rs.getInt(4));
				manga.setMangaMiktari(rs.getInt(5));
				manga.setMangaResmi(rs.getString(6));
				manga.setTur_turId(rs.getInt(8));
				manga.setYayinevi_yayineviId(rs.getInt(7));
						
			}
			
			con.close();
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			System.out.println("Manga görüntüleme sorgusu çalýþmadý");
			
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

		return manga;
		
	}
	
	public static int mangaEkle(Manga manga) {
		
		int durum = 0;
		
		String sqlSorgu = "INSERT INTO `manga`(`mangaAdi`, `mangaAciklamasi`, `mangaFiyati`, "
				+ "`mangaMiktari`, `mangaResmi`, `yayinevi_yayineviId`, `tur_turId`) "
				+ "VALUES (?,?,?,?,?,?,?);";
		try {
			
			con = BaglantiDAO.getConnection();
			psmt = con.prepareStatement(sqlSorgu);
			
			psmt.setString(1, manga.getMangaAdi());
			psmt.setString(2, manga.getMangaAciklamasi());
			psmt.setFloat(3, manga.getMangaFiyati());
			psmt.setInt(4, manga.getMangaMiktari());
			psmt.setString(5, manga.getMangaResmi());
			psmt.setInt(6, manga.getYayinevi_yayineviId());
			psmt.setInt(7, manga.getTur_turId());
			
			durum = psmt.executeUpdate();
			
			con.close();
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			System.out.println("Manga ekleme sorgusu yapýlamadý.");
			
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

	public static int mangaGüncelle(Manga manga) throws SQLException {
		
		int durum = 0;
		
		String sqlSorgu = "UPDATE `manga` SET `mangaAdi`=?,`mangaAciklamasi`=?,"
				+ "`mangaFiyati`=?,`mangaMiktari`=?,`yayinevi_yayineviId`=?,`tur_turId`=?  WHERE `mangaId`=?";
		
		try {
			
			con = BaglantiDAO.getConnection();
			psmt = con.prepareStatement(sqlSorgu);
			
			psmt.setString(1, manga.getMangaAdi());
			psmt.setString(2, manga.getMangaAciklamasi());
			psmt.setFloat(3, manga.getMangaFiyati());
			psmt.setInt(4, manga.getMangaMiktari());
			psmt.setInt(5, manga.getYayinevi_yayineviId());
			psmt.setInt(6, manga.getTur_turId());
			psmt.setInt(7, manga.getMangaId());
			
			durum = psmt.executeUpdate();
			
			con.close();
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			System.out.println("Manga güncelleme sorgusu yapýlamadý.");
			
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

	public static int mangaSil(int mangaId) throws SQLException {
		
		int durum = 0;
		
		String sqlSorgu = "DELETE FROM Manga WHERE mangaId = ?;";
		
		try {
			
			con = BaglantiDAO.getConnection();
			psmt = con.prepareStatement(sqlSorgu);
			psmt.setInt(1, mangaId);
			
			durum = psmt.executeUpdate();
			
			con.close();
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			System.out.println("Manga silme sorgusu yapýlamadý.");
			
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
