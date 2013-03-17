<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Post message</title>
</head>
<body>

<form action="postMsg" method="post">
	Enter message: <br> <textarea rows="5" cols="40" name="content"></textarea> 
	<br>
	Name(optional): <input type="text" name="username">
	<br>
	<input type="submit" value="Submit" >
</form>


</body>
</html>