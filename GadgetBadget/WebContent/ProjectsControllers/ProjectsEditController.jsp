<%@page import="it19180380.EditProjectDetails"%>
<%@page import="it19180380.Projects"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String Project_Id=request.getParameter("Project_Id");
String Project_Title=request.getParameter("Project_Title");
String Project_ShortDes=request.getParameter("Project_ShortDes");
String Project_LongDes=request.getParameter("Project_LongDes");
String Project_Srclink=request.getParameter("Project_Srclink");
String Project_Videolink=request.getParameter("Project_Videolink");

Projects project = new Projects();

project.setProject_Id(Project_Id);
project.setProject_Title(Project_Title);
project.setProject_ShortDes(Project_ShortDes);
project.setProject_LongDes(Project_LongDes);
project.setProject_Srclink(Project_Srclink);
project.setProject_Videolink(Project_Videolink);

EditProjectDetails editprojectDetails = new EditProjectDetails();

editprojectDetails.edit_projects(project);

%>
<script type="text/javascript">
window.location.href="http://localhost:5050/PAF-Project/ViewAllProjects.jsp"
</script>
</body>
</html>