<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>MangaTR Yönetici Paneli</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="yp-style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Pangolin|Patrick+Hand" rel="stylesheet">
</head>

<body class="text-center">
    <div class="header">
        <img src="img/1.jpg" alt="MangaTR">
    </div>
    <div class="wrapper">
        <form class="form-signin" action="AdminLogin" method="POST">
        <h2 class="mb-5">Yönetici paneli için lütfen giriş yapınız.</h2>
        <input type="email" id="inputEmail" name="email" class="form-control" placeholder="E-mail adresi" required autofocus>
        <input type="password" id="inputPassword" name="parola" class="form-control" placeholder="Parola" required>
        <div class="checkbox mb-3">
            <input type="checkbox" value="remember-me"> Beni Hatırla
        </div>
        <button class="btn btn-block" type="submit">GİRİŞ</button>
        </form>
    </div>
</body>
<footer>
    <p class="mt-5 mb-3">&copy; 2017-2018 <br> Tüm Hakları Saklıdır</p>
</footer>
</html>

	