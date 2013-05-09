<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show value</title>
</head>
<body>
	<div style="width: 433px;">
		<p>ttl:${ttl }</p>
<%-- 		<p>expire time(yyyy-MM-dd hh:mm:ss):${expireTime }</p> --%>
		value:
		<textarea rows="20" cols="60">${value }</textarea>
	</div>
</body>
</html>