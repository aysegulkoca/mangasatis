<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page
	import="com.mangasatis.Model.*"
	import="com.mangasatis.DAO.*"
%>

<% if (request.getSession().getAttribute("admin") == null) {
		response.sendRedirect("yoneticiPaneli");
	}
%>

<% ArrayList<Tur> turler = new ArrayList<Tur>(TurDAO.tumturleriListele()); %>
<% ArrayList<YayinEvi> yayinevleri = new ArrayList<YayinEvi>(YayinEviDAO.tumYayinEvileriniListele()); %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>MangaTR Manga Ekle</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="manga-ekle-style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Pangolin|Patrick+Hand" rel="stylesheet">
    <script defer src="https://use.fontawesome.com/releases/v5.0.10/js/all.js" integrity="sha384-slN8GvtUJGnv6ca26v8EzVaR9DC58QEwsIk9q1QXdCU8Yu8ck/tL/5szYlBbqmS+" crossorigin="anonymous"></script>
</head>

<body>
    <nav class="navbar fixed-top navbar-light" style="background-color:rgba(56, 53, 43, 0.582);">
        <button onclick="openNav()" class="btn btn-outline-warning my-2 my-sm-0"><i class="icon fas fa-bars"></i> MangaTR Menü</button>
        <form class="form-inline"> 
            <button formaction="yoneticiPaneli" class="btn btn-outline-warning my-2 my-sm-0">Çıkış</button>
        </form>
    </nav>
     <div id="mySidenav" class="sidenav">
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
        <ul class="list">
                <li class="title">LİSTELEME</li>
                <li><a href="urunler">Ürünler</a></li>
                <li><a href="musteriler">Müşteriler</a></li>
                <li><a href="siparisler">Siparişler</a></li>
                <hr>
                <li class="title">EKLEME</li>
                <li><a href="mangaEkle">Ürün Ekle</a></li>
                <li><a href="turYayinEviEkle">Yayınevi Ekle</a></li>
                <li><a href="turYayinEviEkle">Tür Ekle</a></li>
        </ul>
    </div>
    <div class="wrapper">
        <div class="container">
            <div class="header">
                <center><img class="banner" src="img/2.jpg" alt="MangaTR">
            </div>
            <div class="container">
                <center><h2>MANGATR YÖNETİCİ PANELİ</h2></center>
                <hr>
                    <legend>Manga Ekle</legend>
                    <h5>Lütfen eklemek istediğiniz mangaya ait bilgileri aşağıda yer alan forma göre doldurunuz.</h5>
					<div class="tablo">
						<form action="MangaEkle" method="POST">
						<table>
							<tr>
		                        <th>Manga Resmi</th>
		                        <td><input name="mangaResmi" type="text" required></td>
		                    </tr>
		                    <tr>
		                        <th>Manga Adı</th>
		                        <td><input name="mangaAdi" type="text" required></td>
		                    </tr>
		                    <tr>
		                        <th>Manga Açıklaması</th>
								<td><input name="mangaAciklamasi" type="text" required></td>
		                    </tr>
		                    <tr>
		                        <th>Fiyatı</th>
								<td><input name="mangaFiyati" type="number" required></td>
		                    <tr>
		                    <tr>
		                        <th>Miktarı</th>
								<td><input name="mangaMiktari" type="number" required></td>
		                    <tr>
		                    <tr>
		                        <th>Yayın Evi</th>
								<td><select name="mangaYayinEvi">
									<%for(int i = 0; i < yayinevleri.size(); i++){ %>
										<option value="<%= yayinevleri.get(i).getYayineviId() %>"><%= yayinevleri.get(i).getYayinEviAdi() %></option>
									<%} %>
								</select></td>
		                    </tr>
		                    <tr>
		                        <th>Türü</th>
								<td><select name="mangaTuru">
									<%for(int i = 0; i < turler.size(); i++){ %>
										<option value="<%= turler.get(i).getTurId() %>"><%= turler.get(i).getTur() %></option>
									<%} %>
								</select></td>
		                    </tr>
		                </table>    
		                <button type="submit" class="btn btn-success">EKLE</button>
						</form>
					</div>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" 
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" 
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" 
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" 
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script>
        $(function () { $('[data-toggle="tooltip"]').tooltip()})
        $(function () { $('[data-toggle="popover"]').popover()})
        function openNav() {
            document.getElementById("mySidenav").style.width = "200px";
        }
        function closeNav() {
            document.getElementById("mySidenav").style.width = "0";
        }
    </script>
</body>
<footer>
    <p class="mt-5 mb-3">&copy; 2017-2018 <br> Tüm Hakları Saklıdır</p>
</footer>
</html>