<!DOCTYPE html>
<%@ page import="it19208718.Queries"%>
<%@ page import="com.PaymentServiceDBConnection"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html lang="en">


<%
	//DB connection list
	Connection paymentServiceDBConn = PaymentServiceDBConnection.getConnection();


	
	//logged user - username - from naduns 
	String loggedUsername = "user001";

%>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Welcome to GadgetBadget</title>
    <link rel="stylesheet" href="assets/assets_har/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/assets_har/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="assets/assets_har/fonts/ionicons.min.css">
    <link rel="stylesheet" href="assets/assets_har/css/Animated-Pretty-Product-List-v12.css">
    <link rel="stylesheet" href="assets/assets_har/css/best-carousel-slide.css">
    <link rel="stylesheet" href="assets/assets_har/css/Bold-BS4-Jumbotron-with-Particles-js-1.css">
    <link rel="stylesheet" href="assets/assets_har/css/Bold-BS4-Jumbotron-with-Particles-js.css">
    <link rel="stylesheet" href="assets/assets_har/css/Bootstrap-4---Product-List.css">
    <link rel="stylesheet" href="assets/assets_har/css/Bootstrap-Callout-Success.css">
    <link rel="stylesheet" href="assets/assets_har/css/Footer-1-basic-Irlene-Galiza.css">
    <link rel="stylesheet" href="assets/assets_har/css/gift-product-long.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/css/swiper.min.css">
    <link rel="stylesheet" href="assets/assets_har/css/Lista-Productos-Canito.css">
    <link rel="stylesheet" href="assets/assets_har/css/Pretty-Search-Form.css">
    <link rel="stylesheet" href="assets/assets_har/css/Product-Details.css">
    <link rel="stylesheet" href="assets/assets_har/css/Simple-Slider.css">
    <link rel="stylesheet" href="assets/assets_har/css/styles.css">
    <link rel="stylesheet" href="assets/assets_har/css/Testimonial-Slider-9-1.css">
    <link rel="stylesheet" href="assets/assets_har/css/Testimonial-Slider-9.css">
</head>

<%

	//get cart item count
	int cartItemCount = Queries.getCartItemCountForSpecificUser(paymentServiceDBConn, "user001");

%>

<body style="margin-top: 0;">
    <div>
        <nav class="navbar navbar-light navbar-expand-md">
            <div class="container-fluid"><a class="navbar-brand" href="index.jsp"><img src="assets/assets_har/img/gg.png" width="150px" height="auto"></a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navcol-1">
                    <ul class="navbar-nav ml-auto" style="width: 310px;">
                        <li class="nav-item" style="width: auto;"><a class="nav-link active" href="index.jsp">Home</a></li>
                        <li class="nav-item" style="width: auto;"><a class="nav-link" href="cart.jsp">Cart <sup><% out.print(cartItemCount); %></sup> </a></li>
                        <li class="nav-item" style="width: auto;"><a class="nav-link" href="selling.jsp">Selling</a></li>
                        <li class="nav-item dropdown" style="width: auto;"><a class="dropdown-toggle nav-link" aria-expanded="false" data-toggle="dropdown" href="#">My Account</a>
                            <div class="dropdown-menu"><a class="dropdown-item" href="#">Projects</a><a class="dropdown-item" href="#">Settings</a><a class="dropdown-item" href="#">Store</a><a class="dropdown-item" href="#">Logout</a></div>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
    <div>
        <section id="carousel">
            <div class="carousel slide" data-ride="carousel" id="carousel-1">
                <div class="carousel-inner">
                    <div class="carousel-item">
                        <div class="jumbotron pulse animated hero-nature carousel-hero">
                            <h1 class="hero-title">Sell Your Products Globally</h1>
                            <p class="hero-subtitle">We are globally recognized company that allows to start selling for FREE</p>
                            <p><a class="btn btn-primary hero-button plat" role="button" href="#">Learn more</a></p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <div class="jumbotron pulse animated hero-photography carousel-hero">
                            <h1 class="hero-title">Hero Photography</h1>
                            <p class="hero-subtitle">Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam.</p>
                            <p><a class="btn btn-primary hero-button plat" role="button" href="#">Learn more</a></p>
                        </div>
                    </div>
                    <div class="carousel-item active">
                        <div class="jumbotron pulse animated hero-technology carousel-hero">
                            <h1 class="hero-title">Hero Technology</h1>
                            <p class="hero-subtitle">Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam.</p>
                            <p><a class="btn btn-primary hero-button plat" role="button" href="#">Learn more</a></p>
                        </div>
                    </div>
                </div>
                <div><a class="carousel-control-prev" href="#carousel-1" role="button" data-slide="prev"><i class="fa fa-chevron-left"></i><span class="sr-only">Previous</span></a><a class="carousel-control-next" href="#carousel-1" role="button" data-slide="next"><i class="fa fa-chevron-right"></i><span class="sr-only">Next</span></a></div>
                <ol class="carousel-indicators">
                    <li data-target="#carousel-1" data-slide-to="0"></li>
                    <li data-target="#carousel-1" data-slide-to="1"></li>
                    <li data-target="#carousel-1" data-slide-to="2" class="active"></li>
                </ol>
            </div>
        </section>
    </div>
    <div style="text-align: center;margin-top: 40px;margin-bottom: 40px;">
        <h2>Top Selling</h2>
    </div>
    <div>
        <div class="container">
            <div class="row product-list dev">
               
                <%				
                				//Should be retrive from productServiceDB - tharuni
                                out.print(Queries.fetchTopSellingProducts(paymentServiceDBConn, loggedUsername));
                %>
               
               
            </div>
        </div>
    </div><div style="text-align: center;margin-top: 16px;"><a href="products.jsp"><button class="btn btn-primary align-items-start" type="button" style="color: var(--light);">See More</button></a></div>
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
    <script src="assets/assets_har/js/jquery.min.js"></script>
    <script src="assets/assets_har/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/assets_har/js/Animated-Pretty-Product-List-v12.js"></script>
    <script src="assets/assets_har/js/Bold-BS4-Jumbotron-with-Particles-js.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/js/swiper.jquery.min.js"></script>
    <script src="assets/assets_har/js/Simple-Slider.js"></script>
    <script src="assets/assets_har/js/Testimonial-Slider-9.js"></script>
</body>

</html>