<%@ page import="java.util.List" %>

<html>
	<head>
	</head>
	<body>
		<% 
			out.println("Id: " + request.getAttribute("id_usuario") + "<br />"); 
			out.println("Nome: " + request.getAttribute("nome_usuario") + "<br />");
			out.println("Email: " + request.getAttribute("email_usuario") + "<br />");
			out.println("Data de nascimento: " + request.getAttribute("dtnasc_usuario") + "<br />");
			out.println("Friends: <br />" + request.getAttribute("friendsNames") + "<br />");
		%>
	</body>
</html>
