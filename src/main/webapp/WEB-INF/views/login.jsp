<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet" href="/style.css" />
</head>
<body>
	
	<h1>Login</h1>
	
	<p class="message">${ message }</p>
	
	<form action="/" method="post">
		<p>
			<label for="username">Email:</label> <input id="username" name="username" type="email" value="${ param.emailAddress }" required minlength="2" />
		</p>		<p>
			<label for="password">Password:</label> <input id="password" type="password" name="password" required minlength="2" />
		</p>
		<p>
			<button>Submit</button>
		</p>
	</form>
	
	or
	
	<!-- <p>
		<a href="https://github.com/login/oauth/authorize?client_id=198982ab57a754ed1f24">Sign in with GitHub</a>
	</p> -->
	<p><a href="/">Back to Home</a> </p>
</body>
</html>