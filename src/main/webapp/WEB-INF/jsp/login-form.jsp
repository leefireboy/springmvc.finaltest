<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Form</title>
<link rel="stylesheet" type="text/css" href="/styles.css"/>
</head>
<body>
	<h6>${message}</h6>
	<form method="post" action="/login/login-action1.do">
		<div>
			<h2>登录 login-action1.do</h2>
			<p><label>用户</label><input type="text" name="name"></p>
			<p><label>密码</label><input type="password" name="pwd"></p>
			<h3><input type="submit" value="登录"></h3>
		</div>
	</form>
	
	<form method="post" action="/login/login-action2.do">
		<div>
			<h2>登录 login-action2.do</h2>
			<p><label>用户</label><input type="text" name="name"></p>
			<p><label>密码</label><input type="password" name="pwd"></p>
			<h3><input type="submit" value="登录"></h3>
		</div>
	</form>
	
	<form method="post" action="/login/login-action3.do">
		<div>
			<h2>登录 login-action3.do</h2>
			<p><label>用户</label><input type="text" name="name"></p>
			<p><label>密码</label><input type="password" name="pwd"></p>
			<h3><input type="submit" value="登录"></h3>
		</div>
	</form>
	
	<form method="post" action="/login/login-action4.do">
		<div>
			<h2>登录 login-action4.do</h2>
			<p><label>用户</label><input type="text" name="name"></p>
			<p><label>密码</label><input type="password" name="pwd"></p>
			<h3><input type="submit" value="登录"></h3>
		</div>
	</form>
	
	<form method="post" action="/login/login-action5.do">
		<div>
			<h2>登录 login-action5.do</h2>
			<p><label>用户</label><input type="text" name="name"></p>
			<p><label>密码</label><input type="password" name="pwd"></p>
			<h3><input type="submit" value="登录"></h3>
		</div>
	</form>
	
	<form method="post" action="/login/login-action6.do">
		<div>
			<h2>登录 login-action6.do</h2>
			<p>${next }</p>
			<p><label>用户</label><input type="text" name="name" value="${name }"></p>
			<p><label>密码</label><input type="password" name="pwd"></p>
			<h3><input type="submit" value="登录"></h3>
		</div>
	</form>
</body>
</html>