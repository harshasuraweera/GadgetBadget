<%@page import="it19180380.Projects"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%    
String id = request.getParameter("id");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "projectservice";
String username = "root";
String password = "hashini";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>

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
    <hr>
    <div class="di"></div><button  class="btn btn-info btn-block btn-sm add-row btn-xs" type="button" style="height: 35px;background: rgb(79,170,88);font-size: 13px;font-family: 'Averia Gruesa Libre', cursive;color: rgb(0,0,0);"><i class="fa fa-plus"></i><strong>&nbsp;Add New Project</strong></button><label style="font-family: 'Averia Gruesa Libre', cursive;font-weight: normal;font-size: 16px;color: rgb(64,157,56);" for="nombre"><strong>&nbsp; Your Projects :</strong></label>
    <div class="di">
        <div class="table-responsive d-lg-flex align-items-lg-end" style="filter: saturate(162%) sepia(0%);">
            <table class="table">
                <thead>
                    <tr>
                        <th><strong>ID</strong></th>
                        <th><strong>Image</strong></th>
                        <th><strong>Title</strong></th>
                        <th><br><strong>Short Description</strong></th>
                        <th><strong>Source Link</strong></th>
                        <th><strong>VdieoLink</strong></th>
                        <th><strong>status</strong></th>
                        <th><strong>Edit</strong></th>
                        <th><strong>Delete</strong></th>
                    </tr>
					<%
						try{
								connection = DriverManager.getConnection(connectionUrl+database, username, password);
								statement=connection.createStatement();
								String sql ="select * from projects";
								resultSet = statement.executeQuery(sql);
								while(resultSet.next()){
									
									Projects project = new Projects();
					%>
                </thead>
                <tbody>
                    <tr>
                        <td><%=resultSet.getString("Project_Id") %></td>
                        <td><img src="assets\assets_hashi/img/aicare.jpeg" style="width: 120px;height: 90pxpx;"></td>
                        <td><br><%=resultSet.getString("Project_Title") %><br><br></td>
                        <td style="width: 500px;font-size: 12px;"><%=resultSet.getString("Project_ShortDes") %><br><br></td>
                        <td style="font-size: 12px;"><%=resultSet.getString("Project_Srclink") %></td>
                        <td style="font-size: 12px;"><%=resultSet.getString("Project_Videolink") %></td>
                        <td style="color: rgb(255,0,0);"><strong>select</strong></td>
                        <td><a href="EditProjectDetails.jsp?Project_Id=<%=resultSet.getString("Project_Id") %>" class="btn btn-success" role="button" style="background: rgb(11,171,56);margin: 2px;"><i class="fas fa-pencil-alt"></i></a></td>
                        <td><a href="ProjectsControllers/ProjectDeleteController.jsp?Project_Id=<%=resultSet.getString("Project_Id") %>"class="btn btn-danger" role="button" style="margin: 2px;background: rgb(255,1,1);"><i class="fas fa-trash"></i></a></td>
                    </tr>
                 <%
						}
							connection.close();
						} catch (Exception e) {
							e.printStackTrace();
					}
				%>

                 
                  
                </tbody>
            </table>
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
    <script src="assets\assets_hashi/js/jquery.min.js"></script>
    <script src="assets\assets_hashi/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets\assets_hashi/js/Billing-Table-with-Add-Row--Fixed-Header-Feature.js"></script>
    <script src="assets\assets_hashi/js/Button-Ripple-Effect-Animation-Wave-Pulse.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</body>

</html>