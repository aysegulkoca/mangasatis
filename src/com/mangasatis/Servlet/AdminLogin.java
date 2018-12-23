package com.mangasatis.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mangasatis.DAO.AdminDAO;
import com.mangasatis.Model.Admin;


@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminLogin() {
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
			if ( AdminDAO.adminKontrol(email) == true ) {
				Admin admin = AdminDAO.adminLogin(email, parola);
				
				request.getSession().setAttribute("admin", admin);
				response.sendRedirect("siparisler");
			} else {
				response.sendRedirect("yoneticiPaneli"); 
			}

		} else {
			response.sendRedirect("yoneticiPaneli");
		}
	}
}
