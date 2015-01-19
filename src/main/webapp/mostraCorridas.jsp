<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Corridas</title>
</head>
<body>
<% 
String oRunString = (String) request.getAttribute("oRunString");

String appName = (String) request.getAttribute("appName");
String caption = (String) request.getAttribute("caption");
String commentsCount = (String) request.getAttribute("commentsCount");
String createdTime = (String) request.getAttribute("createdTime");
String description = (String) request.getAttribute("description");
String endTime = (String) request.getAttribute("endTime");
String profileNameFrom = (String) request.getAttribute("profileNameFrom");
String icon = (String) request.getAttribute("icon");
String fbObjectId = (String) request.getAttribute("fbObjectId");
String likesCount = (String) request.getAttribute("likesCount");
String link = (String) request.getAttribute("link");
String message = (String) request.getAttribute("message");
String messageTags = (String) request.getAttribute("messageTags");
String metadata = (String) request.getAttribute("metadata");
String postName = (String) request.getAttribute("postName");
String objectId = (String) request.getAttribute("objectId");
String picture = (String) request.getAttribute("picture");
String place = (String) request.getAttribute("place");
String privacy = (String) request.getAttribute("privacy");
String properties = (String) request.getAttribute("properties");
String publishTime = (String) request.getAttribute("publishTime");
String sharesCount = (String) request.getAttribute("sharesCount");
String source = (String) request.getAttribute("source");
String startTime = (String) request.getAttribute("startTime");
String statusType = (String) request.getAttribute("statusType");
String story = (String) request.getAttribute("story");
String to = (String) request.getAttribute("to");
String postType = (String) request.getAttribute("postType");
String updatedTime = (String) request.getAttribute("updatedTime");
String withTags = (String) request.getAttribute("withTags");
String noFeedStory = (String) request.getAttribute("noFeedStory");

out.println("Run object String: <br /><br />" + oRunString + "<br /><br />");

out.println("<b>App: </b>" + appName + "<br /><br />");
out.println("<b>Caption: </b>" + caption + "<br /><br />");
out.println("<b>commentsCount: </b>" + commentsCount + "<br /><br />");
out.println("<b>createdTime: </b>" + createdTime + "<br /><br />");
out.println("<b>description: </b>" + description + "<br /><br />");
out.println("<b>endTime: </b>" + endTime + "<br /><br />");
out.println("<b>profileNameFrom: </b>" + profileNameFrom + "<br /><br />");
out.println("<b>icon: </b>" + icon + "<br /><br />");
out.println("<b>fbObjectId: </b>" + fbObjectId + "<br /><br />");
out.println("<b>likesCount: </b>" + likesCount + "<br /><br />");
out.println("<b>link: </b>" + link + "<br /><br />");
out.println("<b>message: </b>" + message + "<br /><br />");
out.println("<b>messageTags: </b>" + messageTags + "<br /><br />");
out.println("<b>metadata: </b>" + metadata + "<br /><br />");
out.println("<b>postName: </b>" + postName + "<br /><br />");
out.println("<b>objectId: </b>" + objectId + "<br /><br />");
out.println("<b>picture: </b>" + picture + "<br /><br />");
out.println("<b>place: </b>" + place + "<br /><br />");
out.println("<b>privacy: </b>" + privacy + "<br /><br />");
out.println("<b>properties: </b>" + properties + "<br /><br />");
out.println("<b>publishTime: </b>" + publishTime + "<br /><br />");
out.println("<b>sharesCount: </b>" + sharesCount + "<br /><br />");
out.println("<b>source: </b>" + source + "<br /><br />");
out.println("<b>startTime: </b>" + startTime + "<br /><br />");
out.println("<b>statusType: </b>" + statusType + "<br /><br />");
out.println("<b>story: </b>" + story + "<br /><br />");
out.println("<b>to: </b>" + to + "<br /><br />");
out.println("<b>postType: </b>" + postType + "<br /><br />");
out.println("<b>updatedTime: </b>" + updatedTime + "<br /><br />");
out.println("<b>withTags: </b>" + withTags + "<br /><br />");
out.println("<b>noFeedStory: </b>" + noFeedStory + "<br /><br />");
%>


</body>
</html>