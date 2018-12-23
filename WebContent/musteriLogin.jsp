<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html lang="en">
<head>
    <title>MangaTR Kullanıcı Girişi</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="login-style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Pangolin|Patrick+Hand" rel="stylesheet">
    <script defer src="https://use.fontawesome.com/releases/v5.0.10/js/all.js" integrity="sha384-slN8GvtUJGnv6ca26v8EzVaR9DC58QEwsIk9q1QXdCU8Yu8ck/tL/5szYlBbqmS+" crossorigin="anonymous"></script>
</head>

<body>
    <nav class="navbar fixed-top navbar-light" style="background-color:rgba(56, 53, 43, 0.582);">
    	<button onclick="openNav()" class="btn btn-outline-warning my-2 my-sm-0" disabled><i class="icon fas fa-bars"></i> MangaTR Menü</button>
        <form class="form-inline">
            <div class="dropdown">
                <button class="btn btn-outline-warning dropdown-toggle my-2 my-sm-0" type="button" id="signOrlog" 
                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Üye Girişi<span class="caret"></span></button>
                <ul class="dropdown-menu" aria-labelledby="signOrlog">
                    <li><a class="dropdown-item" href="giris">Giriş Yap</a></li>
                    <li><a class="dropdown-item" href="kayitOl">Üye Ol</a></li>
                </ul>
            </div>
            <button onclick="permDenied()" class="btn btn-outline-warning my-2 my-sm-0">Sepetim</button>
            <button onclick="permDenied()" class="btn btn-outline-warning my-2 my-sm-0">Siparişlerim</button>
        </form>
    </nav>
    <div id="mySidenav" class="sidenav">
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
        <ul class="list">
            <li class="title">TÜR</li>
            <li><a href="#">Shoujo</a></li>
            <li><a href="#">Shounen</a></li>
            <li><a href="#">Seinen</a></li>
            <li><a href="#">Eğlence</a></li>
            <li><a href="#">Macera</a></li>
            <li><a href="#">Spor</a></li>
            <li class="title">YAYINEVİ</li>
            <li><a href="#">Akılçelen</a></li>
            <li><a href="#">Gerekli Şeyler</a></li>
        </ul>
    </div>
    <div class="wrapper">
        <div class="container">
            <div class="header">
                <center><a href="anasayfa"><img class="banner" src="img/2.jpg" alt="MangaTR"></a>
            </div>
            <div class="login">
                <h4>Alışverişe başlamadan önce MangaTR'ye üye girişi yapmalısınız, üye değilseniz <a href="kayitOl">buradan</a> üye olabilirsiniz.</h3>
                <form action="MusteriLogin" method="POST">
                    <div class="form-group row">
                        <label>E-mail : </label>
                        <input type="email" class="form-control" id="m-email" name="email" aria-describedby="emailHelp" placeholder="E-mail Adresinizi Giriniz" required autofocus>
                    </div>
                    <div class="form-group row">
                        <label>Parola : </label>
                        <input type="password" class="form-control" id="m-password" name="parola" placeholder="Parolanızı Giriniz" required>
                    </div>
                    <div class="form-group form-check">
                        <input type="checkbox" class="form-check-input" id="beniHatirla">
                        <label class="form-check-label">Beni Hatırla</label>
                    </div>
                    <button type="submit" class="btn btn-outline-success btn-lg">GİRİŞ</button>
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
			