<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="base" value="/" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success</title>
<link rel="stylesheet" type="text/css" href="${base}styles.css">
</head>
<body>
	<h6>${user.name}登录成功！！！</h6>
	<h6>${user.pwd}这是登录密码。。。</h6>
</body>
</html>