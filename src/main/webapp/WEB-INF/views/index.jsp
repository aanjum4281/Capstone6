<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
    integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<header> hello world</header>

<form action="/" method= "post">
	
	<table class="table">
            <thead>
                <tr>
                  <th>ID</th><th>Complete</th> <th>Description</th><th>Due Date</th><th> User</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="task" items="${task}">
                
                <tr>
               <td> </td>    <td>${task.complete}</td><td>${task.description}</td><td>${task.dueDate}</td>
                    <td>${task.user}</td>
                    <td>
	
					<a href="/delete?id=${task.id }" class="btn btn-light btn-sm" onclick= "return confirm('are you sure?')">Delete</a>
						
					</td>
                </tr>
               
                </c:forEach>
            </tbody>
        </table>
	
	<p> <a href="/add-task">Add a task</a>  </p>
	
	</form>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" 
integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" 
integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" 
integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>