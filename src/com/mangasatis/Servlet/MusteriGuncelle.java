package com.mangasatis.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mangasatis.DAO.MusteriDAO;
import com.mangasatis.Model.Musteri;

@WebServlet("/MusteriGuncelle")
public class MusteriGuncelle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MusteriGuncelle() {
        super();    
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		int id = Integer.parseInt(request.getParameter("musteriId"));
		String ad = request.getParameter("musteriAdi");
		String soyad = request.getParameter("musteriSoyadi");
		String email = request.getParameter("musteriEmail");
		String parola = request.getParameter("musteriPassword");
		String adres = request.getParameter("musteriAdres");
		
			Musteri musteri = new Musteri();
			
			musteri.setMusteriId(id);
			musteri.setMusteriAdi(ad);
			musteri.setMusteriSoyadi(soyad);
			musteri.setMusteriEmail(email);
			musteri.setMusteriPassword(parola);
			musteri.setMusteriAdres(adres);
			
			
			try {
				MusteriDAO.musteriGüncelle(musteri);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			response.sendRedirect("musteriler");	
	
	}
		
}
