<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<a href="postMessageForm">Post Message</a>

<h2>All messages</h2>

<c:forEach items="${msgs}" var="msg">
    <p>${msg.content} <br> posted on ${msg.date} by ${msg.user.name}</p>
</c:forEach>

</body>
</html>
