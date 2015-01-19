<%@ page import="java.util.List" %>
<% 
	//out.println("Id: " + request.getAttribute("id_usuario") + "<br />"); 
	//out.println("Nome: " + request.getAttribute("nome_usuario") + "<br />");
	//out.println("Email: " + request.getAttribute("email_usuario") + "<br />");
	//out.println("Data de nascimento: " + request.getAttribute("dtnasc_usuario") + "<br />");
	//out.println("Number of friends: " + request.getAttribute("friendsCount") + "<br />");
	//out.println("Friends: <br />" + request.getAttribute("friendsNames") + "<br />");
	//out.println("Posts: <br />" + request.getAttribute("myPosts") + "<br />");
	String[] profPicUrls= (String[]) request.getAttribute("profPicUrl");
	String[] ids = (String[]) request.getAttribute("ids");
	String token = (String) request.getAttribute("token");
%>

<html>
	<head>
	<script type="text/javascript" src="js/jquery-1.11.2.js"></script>
	<script type="text/javascript">
		var profile = [];
		
	
		function selectProfile(a) {
			$("img").css("border", "").css("border-style", "").css("border-width", "");
			$("#" + a.id).css("border", "blue").css("border-style", "solid").css("border-width", "thin");
			profile["htmlIdSelected"] = a.id;
			profile["fbIdSelected"] = a.getAttribute("fb-id");
		}
		
		function submitExtract() {
			if($("#dropDownMenuExtractMode option:selected").index() == 0) 
				if($("#dropDownMenuFitnessCategory option:selected").index() == 0)
					window.location = "RecuperaFitness?categoria=" + $("#dropDownMenuFitnessCategory option:selected").val() + "&id=" + profile["fbIdSelected"] + "&token=<%=token%>";
			else
				alert("Está opção está sendo implementada. Aguarde...");
<%-- 				window.location = "RecuperaFitnessJsoup?token=<%=token%>&fase=inicio&id=" + profile["fbIdSelected"] ; --%>
		}
	</script>
	</head>
	<body>
		<%			
			for(int i=0; i < profPicUrls.length;i++) {
		%> 
			
<%-- 			<a href="RecuperaCorridas?id=<%=ids[i]%>&token=<%=token%>&fase=inicio" > --%>
			<img src="<%=profPicUrls[i]%>" id="profile<%=i%>" fb-id="<%=ids[i]%>" onclick="selectProfile(this)"/><%-- </a> --%>
		<%
			}
		%>
		
		<div>
			<select id="dropDownMenuExtractMode">
				<option>Facebook Graph API</option>
				<option disabled="disabled">JSOUP</option>
			</select>
		</div>
		
		<div>
			<select id="dropDownMenuFitnessCategory">
				<option value="runs">Corridas (Runs)</option>
				<option disabled="disabled">Caminhadas (Walks)</option>
				<option disabled="disabled">Pedaladas (Bikes)</option>
			</select>
		</div>
		
		<input type="button" value="Extrair" onclick="submitExtract()">
</html>
