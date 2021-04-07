<!DOCTYPE html>
<%@page import="it19208718.RequiredMethods"%>
<html lang="en">
<%@ page import="it19208718.Queries"%>
<%@ page import="it19208718.DBConnection"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Shopping Cart</title>
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

<body style="margin-top: 0px;">
    <div>
        <nav class="navbar navbar-light navbar-expand-md">
            <div class="container-fluid"><a class="navbar-brand" href="#"><img src="assets/assets_har/img/gg.png" width="150px" height="auto"></a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
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
    <div>
        <h3 class="text-center" style="margin-top: 10px;margin-bottom: 10px;">Shopping Cart</h3><div class="shopping-cart">
<div class="px-4 px-lg-0">

  <div class="pb-5">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

          <!-- Shopping cart table -->
          <div class="table-responsive">
            <table class="table">
              <thead>
                <tr>
                  <th scope="col" class="border-0 bg-light">
                    <div class="p-2 px-3 text-uppercase">Product</div>
                  </th>
                  <th scope="col" class="border-0 bg-light">
                    <div class="py-2 text-uppercase">Price</div>
                  </th>
                  <th scope="col" class="border-0 bg-light">
                    <div class="py-2 text-uppercase">Quantity</div>
                  </th>
                  <th scope="col" class="border-0 bg-light">
                    <div class="py-2 text-uppercase">Remove</div>
                  </th>
                </tr>
              </thead>
              <tbody>
               
                
                <%
                
                	//Load cart items
	                Connection conn = DBConnection.getConnection();
	            	out.print(Queries.fetchCartDetails(conn, "user001"));
                
                %>
                
                
                
              </tbody>
            </table>
          </div>
          <!-- End -->
        </div>
      </div>

      <div class="row py-5 p-4 bg-white rounded shadow-sm">
        <div class="col-lg-6">
          <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Order summary</div>
          
          
          
          <div class="p-4">
            <p class="font-italic mb-4">Service fee and additional costs are calculated based on products and the seller.</p>
            <ul class="list-unstyled mb-4">
              <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Order Subtotal </strong><strong>$<% out.print(Queries.calculateCartTotal(conn, "user001")); %>.00</strong></li>
              <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Service Fee (3%)</strong><strong>$<% out.print(Queries.calculateCartTotal(conn, "user001") *3/100); %> </strong></li>
              <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tax</strong><strong>FREE</strong></li>
              <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Total</strong>
                <h5 class="font-weight-bold">$<% out.print(Queries.calculateCartTotal(conn, "user001") *103/100 ); %>.00 </h5>
              </li>
            </ul>
            
            <br>
            <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Payment Options</div>
            
          	<center><br><a href="https://www.payhere.lk?utm_source=logo" target="_blank"><img src="https://www.payhere.lk/downloads/images/payhere_long_banner.png" alt="PayHere" width="440"/></a></center>
            
            
          </div>
          
        </div>
        <div class="col-lg-6">
          <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Checkout Details </div>
          
          
          <%
          
          	//generate order ID
          	String orderId = RequiredMethods.getOrderId();
          	
          	//product names as a list
          	String productNameList = Queries.getProductNameAsList(conn, "user001");
          
          	
          	//Checkoutdetails - From user table
          		
          		//fname
          		String fname = "";
          		
          		
          		//lanme
          		String lname = "";
          		
          		
          		//email
          		String email = "";
          		
          		
          		//mobile
          		String mobile = "";
          		
          		
          		//city
          		String city = "";
          		
          		
          		//address
          		String address = "";
          		
          		
          	
          	//Create sessions for payment success page
          
         	// session.setAttribute("statusMsg", msg);
         	
         	
         	
         	
         	
         	
         	
         	
         	
         	
          
          %>
          
          <div class="p-4">
          <p class="font-italic mb-4">Checkout details are filling automatically according to your account information.</p>
          
            <form method="post" action="https://sandbox.payhere.lk/pay/checkout">   
			    <input type="hidden" name="merchant_id" value="1217060">    <!-- Replace your Merchant ID -->
			    <input type="hidden" name="return_url" value="http://localhost:7070/GadgetBadget/payment-success.jsp">
			    <input type="hidden" name="cancel_url" value="http://localhost:7070/GadgetBadget/payment-unsuccess.jsp">
			    <input type="hidden" name="notify_url" value="">  
			    
			    <input type="hidden" name="order_id" value="<% out.print(orderId); %>">
			    <input type="hidden" name="items" value="<% out.print(productNameList); %>">
			    <input type="hidden" name="currency" value="USD">
			    <input type="hidden" name="amount" value="<% out.print(Queries.calculateCartTotal(conn, "user001") *103/100); %>">  
			    
			    <input type="hidden" name="country" value="Sri Lanka">
			    
			    <div class="row">
			    	<div class="col">
			    		<label for="first_name">First Name</label>
				    	<input class="form-control" type="text" name="first_name"  >
			    	</div>
			    	<div class="col">
			    		<label for="last_name">Last Name</label>
			    		<input class="form-control" type="text" name="last_name"  >
			    	</div>
				   
			    </div>
			    
			    
			    <div class="row">
				    <div class="col">
					    <label for="email">Email address</label>
					    <input class="form-control" type="text" name="email"  >
				    </div>
			    </div>
			    
			    
			    <div class="row">
			    	<div class="col">
				   		<label for="phone">Mobile</label>
				    	<input class="form-control" type="text" name="phone"  >
				    </div>
				    <div class="col">
				   		<label for="city">City</label>
			    		<input class="form-control" type="text" name="city"  >
				    </div>
			    </div>
			    
			    <div class="row">
				    <div class="col">
					    <label for="address">Address</label>
					    <textarea class="form-control" name="address"  ></textarea>
					</div>
			    </div>
			    <br>
			     <div class="row">
				     <div class="col">
				     <button type="submit" style="width:100%; color:white; background-color:black; border:none; border-radius:10px; outline:none; height:40px;" >Proceed to checkout</button>
				     </div>
			     </div>
			      
			</form> 
          </div>
          
          
        </div>
      </div>

    </div>
  </div>
</div>
</div>
    </div>
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