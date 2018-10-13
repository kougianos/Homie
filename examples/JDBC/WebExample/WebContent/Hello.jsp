<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Hello Servlet</title>
</head>
<body>
<h1>
	Hello <%=request.getParameter("name") %>
</h1>
<h2>
	Changed <%=request.getAttribute("changed") %>	
</h2>

</body>
</html>