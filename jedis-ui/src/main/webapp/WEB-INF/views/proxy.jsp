<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Proxy Page</title>
</head>
<body>
	<form action="proxy" method="post">
	<input id="url" name="url" type="text" required="required" value="http://118.142.39.93:8080/BetService.asmx?wsdl">
	<input type="submit" value="Get">
	</form>
</body>
</html>