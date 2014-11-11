<%@ page import="java.util.List" %>

<html>
	<head>
	</head>
	<body>
		<% 
			//out.println("Id: " + request.getAttribute("id_usuario") + "<br />"); 
			//out.println("Nome: " + request.getAttribute("nome_usuario") + "<br />");
			//out.println("Email: " + request.getAttribute("email_usuario") + "<br />");
			//out.println("Data de nascimento: " + request.getAttribute("dtnasc_usuario") + "<br />");
			//out.println("Number of friends: " + request.getAttribute("friendsCount") + "<br />");
			//out.println("Friends: <br />" + request.getAttribute("friendsNames") + "<br />");
			//out.println("Posts: <br />" + request.getAttribute("myPosts") + "<br />");
			String[] profPicUrls= (String[]) request.getAttribute("profPicUrl");
			for(int i=0; i < profPicUrls.length;i++) {
		%> 
			
			<img src="<%=profPicUrls[i]%>" />
		<%
			}
			out.println(request.getAttribute("runsJson"));
		%>
</html>
