package com.mangasatis.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mangasatis.DAO.MusteriDAO;

@WebServlet("/MusteriSil")
public class MusteriSil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MusteriSil() {
        super();    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String id = request.getParameter("sil");
			if(id != null && !id.equals("")){
				try { 
					int musteriId = Integer.parseInt(id); 
					MusteriDAO.musteriSil(musteriId);
				} catch (SQLException e) {
					System.out.println("error " + e);
					e.printStackTrace();
				}
			}
				
		response.sendRedirect("musteriler");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}
}
