<%@page import="it19180380.DeleteProjects"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String Project_Id=request.getParameter("Project_Id");


DeleteProjects deleteprojects =new DeleteProjects();
deleteprojects.delete_projects(Project_Id);

%>
<script type="text/javascript">
window.location.href="http://localhost:5050/PAF-Project/ViewAllProjects.jsp"
</script>

</body>
</html>