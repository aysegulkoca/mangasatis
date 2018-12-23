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


<% ArrayList<Siparis> siparisler = new ArrayList<Siparis>(SiparisDAO.adminSiparisListele()); %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>MangaTR Yönetici Paneli</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="yonetici-style.css">
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
                <legend>Sipariş Listesi</legend>
                <h5>Müşterilere ait siparişlerin bir listesi aşağıdaki tabloda verilmiştir.
                </h5>
                <div class="table-responsive">
                    <table>
                        <tr>
                            <th>Müşteri Adı</th>
                            <th>Müşteri Adresi</th>
                            <th>Aldığı Ürün</th>
                            <th>Alışveriş Tutarı</th>
                        </tr>
                        <% for(int i = 0 ; i < siparisler.size(); i++) { %>
	                        <tr>
	                            <td><%= SiparisDAO.musteriAdiniGetir(siparisler.get(i).getMusteri_musteriId()) %></td>
	                            <td><%= SiparisDAO.musteriAdresiniGetir(siparisler.get(i).getMusteri_musteriId()) %></td>
	                            <td><%= SiparisDAO.mangaAdiniGetir(siparisler.get(i).getManga_mangaId()) %> </td>
	                            <td><%= siparisler.get(i).getToplamFiyat() %></td>	                           
	                        </tr>
	                    <% } %>                                                   
                    </table>
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

	