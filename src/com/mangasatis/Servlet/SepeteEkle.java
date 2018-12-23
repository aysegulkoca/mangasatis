package com.mangasatis.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mangasatis.DAO.MangaDAO;
import com.mangasatis.Model.Manga;


@WebServlet("/SepeteEkle")
public class SepeteEkle extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SepeteEkle() {
        super();
    }

    @SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("mangaId"));
		

		if (request.getSession().getAttribute("musteri") != null) {
			@SuppressWarnings("unchecked")
			
			ArrayList<Manga> sepet = (ArrayList<Manga>)request.getSession().getAttribute("sepet");


			try {
				sepet.add(MangaDAO.mangayiGoster(id));
				request.getSession().setAttribute("sepet",sepet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("mangalar").forward(request, response);
		} else {
			response.sendRedirect("mangalar");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
