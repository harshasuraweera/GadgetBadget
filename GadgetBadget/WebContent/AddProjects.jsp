<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>ProjectManagementNew</title>
    <link rel="stylesheet" href="assets\assets_hashi/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Abril+Fatface">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Aclonica">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Akaya+Kanadaka">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Amarante">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Averia+Gruesa+Libre">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
    <link rel="stylesheet" href="assets\assets_hashi/fonts/fontawesome-all.min.css">
    <link rel="stylesheet" href="assets\assets_hashi/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="assets\assets_hashi/fonts/ionicons.min.css">
    <link rel="stylesheet" href="assets\assets_hashi/fonts/fontawesome5-overrides.min.css">
    <link rel="stylesheet" href="assets\assets_hashi/css/AddButton.css">
    <link rel="stylesheet" href="assets\assets_hashi/css/AddForm.css">
    <link rel="stylesheet" href="assets\assets_hashi/css/AddHeader.css">
    <link rel="stylesheet" href="assets\assets_hashi/css/Billing-Table-with-Add-Row--Fixed-Header-Feature.css">
    <link rel="stylesheet" href="assets\assets_hashi/css/Button-Ribbon-Effect.css">
    <link rel="stylesheet" href="assets\assets_hashi/css/Drag--Drop-Upload-Form.css">
    <link rel="stylesheet" href="assets\assets_hashi/css/Footer.css">
    <link rel="stylesheet" href="assets\assets_hashi/css/Formulario-Farmacia.css">
    <link rel="stylesheet" href="assets\assets_hashi/css/hashini.css">
    <link rel="stylesheet" href="assets\assets_hashi/css/Registration-Form-with-Photo.css">
    <link rel="stylesheet" href="assets\assets_hashi/css/Responsive-Form-1.css">
    <link rel="stylesheet" href="assets\assets_hashi/css/Responsive-Form.css">
    <link rel="stylesheet" href="assets\assets_hashi/css/styles.css">
    <link rel="stylesheet" href="assets\assets_hashi/css/SucsessMassage.css">
    <link rel="stylesheet" href="assets\assets_hashi/css/ViewAllHeader.css">
    <link rel="stylesheet" href="assets\assets_hashi/css/ViewAllTable.css">
</head>

<body>
    <div>
        <nav class="navbar navbar-light navbar-expand-md">
            <div class="container-fluid"><a class="navbar-brand" href="#"><img src="assets\assets_hashi/img/gg.png" width="150px" height="auto"></a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navcol-1">
                    <ul class="navbar-nav ml-auto" style="width: 310px;">
                        <li class="nav-item" style="width: auto;"><a class="nav-link active" href="#">Home</a></li>
                        <li class="nav-item" style="width: auto;"><a class="nav-link" href="cart.html">Cart</a></li>
                        <li class="nav-item" style="width: auto;"><a class="nav-link" href="#">Selling</a></li>
                        <li class="nav-item dropdown" style="width: auto;"><a class="dropdown-toggle nav-link" aria-expanded="false" data-toggle="dropdown" href="#">My Account</a>
                            <div class="dropdown-menu"><a class="dropdown-item" href="#">Projects</a><a class="dropdown-item" href="#">Settings</a><a class="dropdown-item" href="#">Store</a><a class="dropdown-item" href="#">Logout</a></div>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
    <section class="register-photo" style="background: rgb(231,254,225);">
        <div class="form-container">
        
            <form action ="ProjectSubmitServlet" method="POST" style="margin: 90;border-style: solid;border-color: rgb(37,158,34);background: rgb(255, 255, 255);">
            
                <h3 class="text-center" style="font-family: 'Averia Gruesa Libre', cursive;color: rgb(17,145,15);font-size: 25px;"><strong>- Submit Your Project -</strong></h3>
                <h2 class="text-center" style="text-align: left;"></h2>
                
              
                <hr style="background: #ffffff;border-color: rgb(85,205,83);"><label style="font-family: Lato, sans-serif;font-weight: normal;" for="nombre"></label><label style="font-family: Lato, sans-serif;font-weight: normal;font-size: 13px;" for="nombre"><strong>Project Title :</strong></label>
                <div class="form-group"><input class="form-control" type="text" name="title"></div>
                
                
                <hr><label style="font-family:Lato, sans-serif;font-weight:normal;" for="nombre"><strong>Short Description :</strong></label>
                <div class="form-group" style="height: 60px;"><textarea class="form-control" name="ShortDes" style="height: 90px;"></textarea></div>
                
               
                <hr><label style="font-family:Lato, sans-serif;font-weight:normal;" for="nombre"><strong>Long Description :</strong></label><label style="font-family:Lato, sans-serif;font-weight:normal;" for="nombre"></label>
                <div class="form-group"><textarea class="form-control" name="LongDes" style="height: 170px;"></textarea></div>
                
               
                <label style="font-family:Lato, sans-serif;font-weight:normal;" for="nombre"><strong>Add Images :</strong></label>
                <input class="form-control-file" type="file">
                
                
                <hr><label style="font-family:Lato, sans-serif;font-weight:normal;" for="nombre"><strong>Source Link&nbsp;</strong></label><label style="font-family: 'Averia Gruesa Libre', cursive;font-weight: normal;color: rgb(31,118,50);" for="nombre"><strong>&nbsp; *</strong>(Upload your project into google drive and put the link in below ) :</label>
                <input class="form-control" type="text" name="srcLink">
                
                
                <hr><label style="font-family:Lato, sans-serif;font-weight:normal;" for="nombre"><strong>Video Link :</strong></label><label style="font-family: 'Averia Gruesa Libre', cursive;font-weight: normal;color: rgb(44,118,47);" for="nombre"><strong>&nbsp; &nbsp;*</strong>(Upload your video into google drive or any social media platform and put the link in below)&nbsp;<strong> :</strong></label>
                <input class="form-control" type="text" name="videoLink">
                
                
                <div class="m-5"><button class="btn btn-success ribbon" type="submit" value = "Submit Project">Submit Project</button></div>
                
                <div class="form-group">
                    <div class="m-5">
                        <div class="text-center m-3"></div>
                    </div>
                </div>
            </form>
        </div>
    </section>
    <div class="footer-basic" style="margin-top: 50px;">
        <footer>
            <div class="social"><a href="#"><i class="icon ion-social-instagram"></i></a><a href="#"><i class="icon ion-social-snapchat"></i></a><a href="#"><i class="icon ion-social-twitter"></i></a><a href="#"><i class="icon ion-social-facebook"></i></a></div>
            <ul class="list-inline">
                <li class="list-inline-item"><a href="#">Home</a></li>
                <li class="list-inline-item"><a href="#">Serviços</a></li>
                <li class="list-inline-item"><a href="#">About</a></li>
                <li class="list-inline-item"><a href="#">Dúvidas</a></li>
                <li class="list-inline-item"><a href="#">Politica Privacidade</a></li>
                <li class="list-inline-item"><a href="#">Contactos</a></li>
            </ul>
            <p class="copyright">Irlene Galiza © 2021</p>
        </footer>
    </div>
    <script src="assets\assets_hashi/js/jquery.min.js"></script>
    <script src="assets\assets_hashi/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets\assets_hashi/js/Billing-Table-with-Add-Row--Fixed-Header-Feature.js"></script>
    <script src="assets\assets_hashi/js/Button-Ripple-Effect-Animation-Wave-Pulse.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</body>

</html>