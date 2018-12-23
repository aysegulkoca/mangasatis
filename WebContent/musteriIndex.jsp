<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page
	import="com.mangasatis.Model.*"
	import="com.mangasatis.DAO.*"
%>
<% ArrayList<Manga> mangalar = new ArrayList<Manga>(MangaDAO.tumMangalariListele()); %>
<% ArrayList<Tur> turler = new ArrayList<Tur>(TurDAO.tumturleriListele()); %>
<% ArrayList<YayinEvi> yayinevleri = new ArrayList<YayinEvi>(YayinEviDAO.tumYayinEvileriniListele()); %>

<% if (request.getSession().getAttribute("musteri") == null) {
		response.sendRedirect("giris");
	}
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>MangaTR Ana Sayfa</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="as-style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Pangolin|Patrick+Hand" rel="stylesheet">
    <script defer src="https://use.fontawesome.com/releases/v5.0.10/js/all.js" integrity="sha384-slN8GvtUJGnv6ca26v8EzVaR9DC58QEwsIk9q1QXdCU8Yu8ck/tL/5szYlBbqmS+" crossorigin="anonymous"></script>
</head>

<body>
    <nav class="navbar fixed-top navbar-light" style="background-color:rgba(56, 53, 43, 0.582);">
    	<button onclick="openNav()" class="btn btn-outline-warning my-2 my-sm-0" disabled><i class="icon fas fa-bars"></i> MangaTR Menü</button>
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
            <h3 class="title">Bu Ay En Çok Satanlar!</h3>
            <h5 class="title">MangaTR okuyucularının geçtiğimiz ay en çok satın aldıkları mangalar : </h5>
            <div class="card-deck">
                <div class="card border-warning" style="width: 18rem;">
                    <div class="card-body">
                        <img class="card-img-top" src="img/manga/bc-5.jpg" alt="Card image cap">
                        <h5 class="card-title">Black Clover - 5</h5>
                        <h6 class="card-subtitle mb-2 text-muted">Shounen Jump</h6>
                        <a href="#" class="btn btn-outline-success"><i class="icon fas fa-eye"></i>Mangaya Git</a>
                    </div>
                </div>
                <div class="card border-warning" style="width: 18rem;">
                        <div class="card-body">
                            <img class="card-img-top" src="img/manga/h-26.jpg" alt="Card image cap">
                            <h5 class="card-title">Haikyuu!! - 26</h5>
                            <h6 class="card-subtitle mb-2 text-muted">Shounen Jump</h6>
                            <a href="#" class="btn btn-outline-success"><i class="icon fas fa-eye"></i>Mangaya Git</a>
                        </div>
                </div>
                <div class="card border-warning" style="width: 18rem;">
                        <div class="card-body">
                            <img class="card-img-top" src="img/manga/bnha-3.jpg" alt="Card image cap">
                            <h5 class="card-title">My Hero Academia - 3</h5>
                            <h6 class="card-subtitle mb-2 text-muted">Jump</h6>
                            <a href="#" class="btn btn-outline-success"><i class="icon fas fa-eye"></i>Mangaya Git</a>
                        </div>
                </div>
                <div class="card border-warning" style="width: 18rem;">
                        <div class="card-body">
                            <img class="card-img-top" src="img/manga/bleach-71.png" alt="Card image cap">
                            <h5 class="card-title">Bleach - 71</h5>
                            <h6 class="card-subtitle mb-2 text-muted">Jump Weekly</h6>
                            <a href="#" class="btn btn-outline-success"><i class="icon fas fa-eye"></i>Mangaya Git</a>
                        </div>
                </div>
                <div class="card border-warning" style="width: 18rem;">
                        <div class="card-body">
                            <img class="card-img-top" src="img/manga/sns-17.jpg" alt="Card image cap">
                            <h5 class="card-title">Food Wars - 17</h5>
                            <h6 class="card-subtitle mb-2 text-muted">Hana to Yome</h6>
                            <a href="#" class="btn btn-outline-success"><i class="icon fas fa-eye"></i>Mangaya Git</a>
                        </div>
                </div>                
            </div> <!-- Card-Deck'in Kapanışı-->
            <h3 class="title">Yeni Gelenler!</h3>
            <h5 class="title">MangaTR okuyucuları için matbaadan yeni çıkan mangalar : </h5>
            <div class="card-deck">
                <div class="card border-warning" style="width: 18rem;">
                    <div class="card-body">
                        <img class="card-img-top" src="img/manga/fire-punch-1.jpg" alt="Card image cap">
                        <h5 class="card-title">Fire Punch - 1</h5>
                        <h6 class="card-subtitle mb-2 text-muted">Hana to Yume</h6>
                        <a href="#" class="btn btn-outline-success"><i class="icon fas fa-eye"></i>Mangaya Git</a>
                    </div>
                </div>
                <div class="card border-warning" style="width: 18rem;">
                        <div class="card-body">
                            <img class="card-img-top" src="img/manga/gintama-1.jpg" alt="Card image cap">
                            <h5 class="card-title">Gintama - 1</h5>
                            <h6 class="card-subtitle mb-2 text-muted">Shounen Jump</h6>
                            <a href="#" class="btn btn-outline-success"><i class="icon fas fa-eye"></i>Mangaya Git</a>
                        </div>
                </div>
                <div class="card border-warning" style="width: 18rem;">
                        <div class="card-body">
                            <img class="card-img-top" src="img/manga/gintama-2.jpg" alt="Card image cap">
                            <h5 class="card-title">Gintama - 2</h5>
                            <h6 class="card-subtitle mb-2 text-muted">Shounen Jump</h6>
                            <a href="#" class="btn btn-outline-success"><i class="icon fas fa-eye"></i>Mangaya Git</a>
                        </div>
                </div>
                <div class="card border-warning" style="width: 18rem;">
                        <div class="card-body">
                            <img class="card-img-top" src="img/manga/conan-87.jpg" alt="Card image cap">
                            <h5 class="card-title">Detective Conan - 87</h5>
                            <h6 class="card-subtitle mb-2 text-muted">SS Comics</h6>
                            <a href="#" class="btn btn-outline-success"><i class="icon fas fa-eye"></i>Mangaya Git</a>
                        </div>
                </div>
                <div class="card border-warning" style="width: 18rem;">
                        <div class="card-body">
                            <img class="card-img-top" src="img/manga/ac-21.jpg" alt="Card image cap">
                            <h5 class="card-title">Assassination - 21</h5>
                            <h6 class="card-subtitle mb-2 text-muted">Shounen Weekly</h6>
                            <a href="#" class="btn btn-outline-success"><i class="icon fas fa-eye"></i>Mangaya Git</a>
                        </div>
                </div>
            </div> <!-- Card-Deck'in Kapanışı-->
            <h3 class="title">Bir Derdiniz mi Var?</h3>
            <h5 class="title">İstek, şikayet ve önerileriniz için bizimle iletişime geçebilirsiniz : </h5>
            <form>
                <div class="form-group">
                    <textarea class="form-control" id="textarea" cols="10" rows="5"></textarea>
                </div>
                <button type="submit" class="btn btn-outline-success my-2 my-sm-0" type="submit">GÖNDER</button>
            </form>
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
