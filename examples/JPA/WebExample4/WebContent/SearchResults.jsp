<%@page import="entities.Studentcourse"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="entities.Student, java.util.List, entities.Course" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Courses of User</title>
	<link rel="stylesheet" href="css/my.css">
</head>

<body>
	<%
	Student student = (Student) request.getAttribute("student");
	if (student != null) {
%>
	<p>
	<table class="gridtable2"> <tr> <th>Student Id:</th> <td> <%=student.getId()%></td> </tr>
	<tr> <th>Student Name:</th> <td>  <%=student.getFname()%> </td> </tr>
	<tr> <th>Student Last Name:</th> <td>  <%=student.getLname()%> </td> </tr>
	</table>
	</p>
	<p>
	<table class="gridtable">
		<tr> 	
			<th> Course Id</th>
			<th> Course Name </th>
			<th> Course Description</th>
			<th> Course Grade</th>
		</tr>
		<% 
			List<Studentcourse> courses = student.getStudentcourses();
			
			if (courses != null)
			{
				for (Studentcourse course : courses)
				{
					%>
		<tr> 
			<td> <%=course.getCourse().getId()%> </td>
			<td> <%=course.getCourse().getName() %> </td>
			<td> <%=course.getCourse().getDescription()%> </td>
			<td> <%=course.getGrade() %> </td>
		</tr>
					<% 
				}
			}
		
		%>	

	</table>
	</p>
	<% } %>
</body>
</html>