package com.mangasatis.Servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mangasatis.DAO.SiparisDAO;
import com.mangasatis.Model.*;


@WebServlet("/SiparisVer")
public class SiparisVer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SiparisVer() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("musteri")!=null){
			
			Siparis siparis = new Siparis();
			
			Musteri musteri = (Musteri) request.getSession().getAttribute("musteri");
			@SuppressWarnings("unchecked")
			ArrayList<Manga> mangalar = (ArrayList<Manga>) request.getSession().getAttribute("sepet");
			
			Date simdikiZaman = new Date();
	        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			
			for(int i=0 ; i < mangalar.size() ; i++){
				siparis.setUrunMiktari(1);
				siparis.setToplamFiyat(mangalar.get(i).getMangaFiyati());
				siparis.setSiparisTarihi(df.format(simdikiZaman));
				siparis.setTeslimTarihi(df.format(simdikiZaman));
				siparis.setManga_mangaId(mangalar.get(i).getMangaId());
				siparis.setMusteri_musteriId(musteri.getMusteriId());
				
				
				SiparisDAO.siparisEkle(siparis);
				
			}
			mangalar.clear();
		}
		
		response.sendRedirect("siparislerim");

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
