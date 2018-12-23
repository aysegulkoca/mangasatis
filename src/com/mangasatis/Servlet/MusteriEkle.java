package com.mangasatis.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mangasatis.Model.Musteri;
import com.mangasatis.DAO.MusteriDAO;
import com.mangasatis.Model.Manga;

@WebServlet("/MusteriEkle")
public class MusteriEkle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MusteriEkle() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		request.setCharacterEncoding("utf-8");
		
		String ad = request.getParameter("musteriAdi"); 
		String soyad = request.getParameter("musteriSoyadi");
		String email = request.getParameter("musteriEmail");
		String parola = request.getParameter("musteriPassword");
		String adres = request.getParameter("musteriAdres");
		
		if( ad != "" && soyad != "" && email != "" && parola != "" ) {
			
			if ( MusteriDAO.musteriKontrol(email) != true ) {

				Musteri musteri = new Musteri();
				musteri.setMusteriAdi(ad); 
				musteri.setMusteriSoyadi(soyad);
				musteri.setMusteriEmail(email);
				musteri.setMusteriPassword(parola);
				musteri.setMusteriAdres(adres);
				musteri.setPozisyon_pozisyonId(2);
				
				try {
					MusteriDAO.musteriEkle(musteri);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 

				request.getSession().setAttribute("sepet", new ArrayList<Manga>());
				request.getSession().setAttribute("musteri", musteri); 
				response.sendRedirect("giris");
			} else{
				
				request.getRequestDispatcher("kayitOl").forward(request, response);
			}

		} else{
			
			request.getRequestDispatcher("giris").forward(request, response);
		}
		
	}
}
