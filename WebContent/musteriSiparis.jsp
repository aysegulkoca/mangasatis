<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@page
	import="com.mangasatis.Model.*"
	import="com.mangasatis.DAO.*"
%>


<% Musteri musteri = (Musteri) request.getSession().getAttribute("musteri"); %>
<% ArrayList<Siparis> siparisler = new ArrayList<Siparis>(SiparisDAO.musteriSiparisListele(musteri.getMusteriId())); %>
<% ArrayList<Tur> turler = new ArrayList<Tur>(TurDAO.tumturleriListele()); %>
<% ArrayList<YayinEvi> yayinevleri = new ArrayList<YayinEvi>(YayinEviDAO.tumYayinEvileriniListele()); %>

<% if (request.getSession().getAttribute("musteri") == null) {
		response.sendRedirect("giris");
	}
%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Siparişlerim</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="siparis-style.css">
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
            <div class="container">
                <h2>SİPARİŞLERİM</h2>
                <hr>
                <legend>Sipariş Bilgileriniz</legend>
                <h5>Şimdiye kadar yapmış olduğunuz bütün alışverişlerin kaydı burada tutulmaktadır.
                    Siparişlerinizle ilgili bir sorun varsa İletişim bölümünden bize ulaşabilirsiniz.
                </h5>
                <div class="table-responsive">
                    <table>
                        <tr>
                            <th>Manga Adı</th>
                            <th>Manga Fiyatı</th>
                            <th>Manga Adeti</th>
                            <th>Sipariş Tarihi</th>

                        </tr>
                        <% for(int i = 0 ; i < siparisler.size(); i++) { %>
	                        <tr>
	                        	<td><%= SiparisDAO.mangaAdiniGetir(siparisler.get(i).getManga_mangaId()) %></td>
	                            <td><%= siparisler.get(i).getToplamFiyat() %></td>
	                            <td><%= siparisler.get(i).getUrunMiktari() %></td>
	                            <td><%= siparisler.get(i).getSiparisTarihi() %></td>
	                        </tr>
	                    <% } %>                                                  
                    </table>
                </div> 
                <hr>
                <legend>İletişim</legend>
                <form>
                    <div class="form-group">
                        <textarea class="form-control" id="textarea" cols="10" rows="5"></textarea>
                    </div>
                    <button type="submit" class="btn btn-outline-success my-2 my-sm-0" type="submit">GÖNDER</button>
                </form>
                
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