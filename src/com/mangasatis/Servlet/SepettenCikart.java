package com.mangasatis.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mangasatis.Model.Manga;


@WebServlet("/SepettenCikart")
public class SepettenCikart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SepettenCikart() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mangaId = Integer.parseInt(request.getParameter("mangaId"));
		@SuppressWarnings("unchecked")
		ArrayList<Manga> sepet = (ArrayList<Manga>) request.getSession().getAttribute("sepet");
		ArrayList<Manga> yeniSepet = new ArrayList<Manga>();
		
		for(int i = 0; i < sepet.size();i++){
			if(sepet.get(i).getMangaId() != mangaId){ 
				yeniSepet.add(sepet.get(i));
			}			
		}
		request.getSession().setAttribute("sepet",yeniSepet);
		request.getRequestDispatcher("sepetim").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
