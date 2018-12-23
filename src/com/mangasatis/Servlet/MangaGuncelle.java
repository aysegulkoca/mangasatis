package com.mangasatis.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mangasatis.DAO.MangaDAO;
import com.mangasatis.Model.Manga;

@WebServlet("/MangaGuncelle")
public class MangaGuncelle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MangaGuncelle() {
        super();    
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		request.setCharacterEncoding("utf-8");
		
		int id = Integer.parseInt(request.getParameter("mangaId"));
		String ad = request.getParameter("mangaAdi");
		String aciklama = request.getParameter("mangaAciklamasi");
		int miktar = Integer.parseInt(request.getParameter("mangaMiktari"));
		float fiyat = Float.parseFloat(request.getParameter("mangaFiyati"));
		int turId = Integer.parseInt(request.getParameter("mangaTuru"));
		int yayineviId = Integer.parseInt(request.getParameter("mangaYayinEvi"));

			Manga manga = new Manga();
			
			manga.setMangaId(id);
			manga.setMangaAdi(ad);
			manga.setMangaAciklamasi(aciklama);
			manga.setMangaFiyati(fiyat);
			manga.setMangaMiktari(miktar);
			manga.setTur_turId(turId);
			manga.setYayinevi_yayineviId(yayineviId);
			
			
			try {
				MangaDAO.mangaGüncelle(manga);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			response.sendRedirect("urunler");	
	
	}
		
}
