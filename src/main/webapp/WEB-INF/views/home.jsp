<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<a href="postMessageForm">Post Message</a>

<h2>All messages</h2>

<c:forEach items="${msgs}" var="msg">
    <p><b>${msg.content}</b> <br> 
    posted on <fmt:formatDate value="${msg.date}" pattern="dd/MM/yyyy HH:mm:ss" /> 
    by ${msg.user.name}</p>
</c:forEach>

</body>
</html>
