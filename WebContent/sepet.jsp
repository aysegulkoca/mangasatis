<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@page
	import="com.mangasatis.Model.*"
	import="com.mangasatis.DAO.*"
%>

<% if (request.getSession().getAttribute("musteri") == null) {
		response.sendRedirect("giris");
	}
%>

<% 
ArrayList<Manga> sepet = new ArrayList<Manga> ((ArrayList<Manga>) request.getSession().getAttribute("sepet")); 
Musteri musteri = (Musteri) request.getSession().getAttribute("musteri");
%>
<% ArrayList<Tur> turler = new ArrayList<Tur>(TurDAO.tumturleriListele()); %>
<% ArrayList<YayinEvi> yayinevleri = new ArrayList<YayinEvi>(YayinEviDAO.tumYayinEvileriniListele()); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Sepetim</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="sepet-style.css">
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
                <h2>SEPETİM</h2>
                <hr>
                <legend>Alışveriş Sepetiniz</legend>
                <h5>Sepete eklediğiniz manga/mangalar aşağıda yer alan tabloda görüntülenmektedir. Almaktan vazgeçtiğiniz bir manga varsa
                    manganın bulunduğu satırdaki SİL butonuna basmanız yeterlidir. Aynı mangadan birden çok satın almak istiyorsanız manganın
                    bulunduğu satırdaki ADET EKLE butonuna basabilirsiniz.
                </h5>
                <div class="table-responsive">
                    <table>
                        <tr>
                            <th>Manga Kapağı</th>
                            <th>Manga Adı</th>
                            <th>Manga Yayınevi</th>
                            <th>Manga Türü</th>
                            <th>Manga Fiyatı</th>
                            <th>Seçenekler</th>
                        </tr>
                        <%for(int i = 0; i < sepet.size(); i++){ %>
	                        <tr>
	                            <td><img width="40" src="<%= sepet.get(i).getMangaResmi() %>"></td>
	                            <td><%= sepet.get(i).getMangaAdi() %></td>
	                            <td><%= sepet.get(i).getYayinevi_yayineviId() %></td>
	                            <td><%= sepet.get(i).getTur_turId() %></td>
	                            <td><%= sepet.get(i).getMangaFiyati() %></td>
	                            <td><center><a href="SepettenCikart?mangaId=<%= sepet.get(i).getMangaId() %>"><button class="btn btn-danger"><i class="fas fa-trash-alt"></i>Sil</button></center></td>
	                        </tr>
                        <%} %>

                    </table>
  					
  					<%float  toplam = 0;
                    for(int i = 0; i < sepet.size(); i++){ %>
	                   <% toplam += sepet.get(i).getMangaFiyati(); %>
                    <%} %>
                    <label name="toplamFiyat">Toplam Fiyat : <%= toplam %></label>
                </div> 
            </div>
            <a href="SiparisVer" class="btn btn-success my-2 my-sm-0">SATIN AL</a>
            <form class="form-odeme">
                <div class="form-group">
                    <label for="exampleTextarea"><legend>Açık Adresiniz :</legend></label>
                    <textarea name="musteriAdres" class="form-control" id="exampleTextarea" rows="3" required>${musteri.musteriAdres}</textarea>

                </div>
                <fieldset class="form-group">
                    <legend>Ödeme Şekli :</legend>
                    <div class="form-check">
                    <label class="form-check-label">
                        <input type="radio" class="form-check-input" name="optionsRadios" id="nakit" checked>
                        Nakit (Kapıda Ödeme)
                    </label>
                    </div>
                    <div class="form-check">
                    <label class="form-check-label">
                        <input type="radio" class="form-check-input" name="optionsRadios" id="kredikarti">
                        Kredi Kartı (Kapıda Ödeme)
                    </label>
                    </div>
                    <div class="form-check disabled">
                    <label class="form-check-label">
                        <input type="radio" class="form-check-input" name="optionsRadios" id="yok" disabled>
                        Kredi Kartı (İnternet Bankacılığı)
                    </label>
                    </div>
                    <small class="form-text text-muted">İnternet Bankacılığı sistemimiz bakımdadır. Anlayışınız için teşekkürler.</small>
                </fieldset>
                <div class="form-check">
                    <label class="form-check-label">
                    <input type="checkbox" class="form-check-input">
                    Siparişimle ilgili e-mail almak istiyorum.
                    </label>
                </div>
                <div class="form-check">
                    <label class="form-check-label">
                    <input type="checkbox" class="form-check-input" required>
                    <a href="#">Mesafeli satış sözleşmesi</a>ni okudum ve kabul ediyorum.
                    </label>
                </div>
                <hr>
            </form>
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