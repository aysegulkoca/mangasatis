package com.mangasatis.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.mangasatis.DAO.TurDAO;
import com.mangasatis.DAO.YayinEviDAO;

import com.mangasatis.Model.Tur;
import com.mangasatis.Model.YayinEvi;

@WebServlet("/TurYayineviEkle")
public class TurYayineviEkle extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TurYayineviEkle() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		request.setCharacterEncoding("utf-8");
		String tur = request.getParameter("tur");
		String yayinevi = request.getParameter("yayinevi");

		if(request.getParameter("turButton") != null){
			
			turEkle(tur);

		} else if(request.getParameter("yayineviButton") != null){
			yayineviEkle(yayinevi);
		}
		else{						
			response.sendRedirect("urunler");		
		}
		
		response.sendRedirect("urunler");		
		
	}
	
	public void turEkle(String tur) {
		Tur yenitur = new Tur();
		yenitur.setTur(tur);
		TurDAO.turEkle(yenitur);
	}
	
	public void yayineviEkle(String yayinevi) {
		YayinEvi yeniyayinevi = new YayinEvi();
		yeniyayinevi.setYayinEviAdi(yayinevi);
		YayinEviDAO.yayinEviEkle(yeniyayinevi);
	}

}
