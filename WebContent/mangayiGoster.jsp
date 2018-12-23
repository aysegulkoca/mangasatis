<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page
	import="com.mangasatis.Model.*"
	import="com.mangasatis.DAO.*"
%>

<% if (request.getSession().getAttribute("musteri") == null) {
		response.sendRedirect("giris");
	}
%>

<% 
Manga manga = (MangaDAO.mangayiGoster(Integer.parseInt(request.getParameter("mangaId"))));
String yayinevi = (MangaDAO.mangaYayineviniGetir(manga.getYayinevi_yayineviId()));
String tur = (MangaDAO.mangaTurunuGetir(manga.getTur_turId()));
%>

<% ArrayList<Tur> turler = new ArrayList<Tur>(TurDAO.tumturleriListele()); %>
<% ArrayList<YayinEvi> yayinevleri = new ArrayList<YayinEvi>(YayinEviDAO.tumYayinEvileriniListele()); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>MangaTR Manga Detay</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="mg-style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Pangolin|Patrick+Hand" rel="stylesheet">
    <script defer src="https://use.fontawesome.com/releases/v5.0.10/js/all.js" integrity="sha384-slN8GvtUJGnv6ca26v8EzVaR9DC58QEwsIk9q1QXdCU8Yu8ck/tL/5szYlBbqmS+" crossorigin="anonymous"></script>
</head>

<body>
    <nav class="navbar fixed-top navbar-light" style="background-color:rgba(56, 53, 43, 0.582);">
        <button onclick="openNav()" class="btn btn-outline-warning my-2 my-sm-0"><i class="icon fas fa-bars"></i> MangaTR Menü</button>
        <form class="form-inline"> 
        	<button formaction="anasayfa" class="btn btn-outline-warning my-2 my-sm-0">Anasayfa</button>
            <button formaction="mangalar" class="btn btn-outline-warning my-2 my-sm-0">Mangalar</button>
            <button formaction="sepetim" class="btn btn-outline-warning my-2 my-sm-0">Sepetim</button>
            <button formaction="siparislerim" class="btn btn-outline-warning my-2 my-sm-0">Siparişlerim</button>
            <button formaction="giris" class="btn btn-outline-warning my-2 my-sm-0">Çıkış</button>
        </form>
    </nav>
    
    <div id="mySidenav" class="sidenav">
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
        <ul class="list">
            <li class="title">TÜR</li>
            <% for(int i = 0 ; i < turler.size(); i++) { %>
	            <li><a href="tureGore?tur=<%=turler.get(i).getTurId() %>"><%= turler.get(i).getTur() %></a></li>
            <%} %>
            <li class="title">YAYINEVİ</li>
            <% for(int i = 0 ; i < yayinevleri.size(); i++) { %>
	            <li><a href="yayinEvineGore?yayinevi=<%=yayinevleri.get(i).getYayineviId() %>"><%= yayinevleri.get(i).getYayinEviAdi() %></a></li>
            <%} %>
        </ul>
    </div>
    
    <div class="wrapper">
        <div class="container">
            <div class="header">
                <center><a href="anasayfa"><img class="banner" src="img/2.jpg" alt="MangaTR"></a>
            </div>
            <legend>Manga Detay : </legend>
            <hr>
                    <center><img src="<%= manga.getMangaResmi() %>" height="400px"></center>
                    <center><table class="tablo">
                        <tr>
                            <th>Manga Adı: </th>
                            <td><%= manga.getMangaAdi() %></td>
                        </tr>
                        <tr>
                            <th>Manga Açıklaması: </th>
                            <td><%= manga.getMangaAciklamasi() %></td>
                        </tr>
                        <tr>
                            <th>Manga Yayınevi: </th>
                            <td><%= yayinevi %></td>
                        </tr>
                        <tr>
                            <th>Manga Türü: </th>
                            <td><%= tur %></td>
                        </tr>
                        <tr>
                            <th>Manga Fiyatı: </th>
                            <td><%= manga.getMangaFiyati() %></td>
                        </tr>
                        <tr>
                            <th>Manga Miktarı: </th>
                            <td><%= manga.getMangaMiktari() %></td>
                        </tr>
                    </table></center>
                    <center><a href="SepeteEkle?mangaId=<%=manga.getMangaId() %>" class="btn btn-success my-2 my-sm-0">Sepete At</a></center>

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
        function permDenied() {
            alert("Üye Girişi yapmadığınız sürece Sepet ya da Sipariş bilgilerine ulaşamazsanız.");
        }
        $(function () { $('[data-toggle="tooltip"]').tooltip()})
        $(function () { $('[data-toggle="popover"]').popover()})
        function openNav() {
            document.getElementById("mySidenav").style.width = "190px";
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