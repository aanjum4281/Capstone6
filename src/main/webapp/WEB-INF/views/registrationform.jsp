<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- Bootstrap -->
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
    integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    
<title>Insert title here</title>

<!-- link to the css file> -->
<link rel= "stylesheet" href= "/style.css"/> 
</head>
<body>
<!-- Form action determines the next URL path
	     These match the @RequestMapping path in the controller
	     that handles the form submission. -->
	<form action="/" method= "post">
	<!-- Input names determine the URL parameters.
			     These match the @RequestParam annotations
			     in the controller that handles the form submission. -->	     
			      <div>
			     <h1> Registration 
			      </h1>
			      
		<div> 	    
	
		<p> Email: <input  type="email" name="emailAddress" required minlength="8" required/> </p>
		<p> Password: <input type= "password" name="password" required/> </p>
		
		</div>
		<p>
			<!-- Clicking a button will submit the form. -->
			<button type="submit" class="btn-btn-primary mb-2"> Register!</button>
			<!-- <button type="clear" class="btn-btn-secondary mb-2"> clear</button> -->
			
		</p>
		
		<p><a href="/">Back to Home</a> </p>
		
		</div>
	</form>
<!-- Bootstrap -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" 
integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" 
integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" 
integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>