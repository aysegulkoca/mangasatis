package com.mangasatis.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mangasatis.DAO.MusteriDAO;
import com.mangasatis.Model.Manga;
import com.mangasatis.Model.Musteri;


@WebServlet("/MusteriLogin")
public class MusteriLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MusteriLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		String email = request.getParameter("email");
		String parola = request.getParameter("parola");
		
		if (email != null && parola != null) {
			if ( MusteriDAO.musteriKontrol(email) == true ) {
				Musteri musteri = MusteriDAO.musteriLogin(email, parola);
				request.getSession().setAttribute("sepet", new ArrayList<Manga>());
				request.getSession().setAttribute("musteri", musteri);
				response.sendRedirect("anasayfa");				
			} else {
				response.sendRedirect("anasayfa"); 
			}

		} else {
			response.sendRedirect("anasayfa");
		}
		
	}

}
