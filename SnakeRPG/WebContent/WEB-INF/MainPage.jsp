<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Snake RPG</title>
</head>
<body>
	<h1>Main Page</h1>
	<div>
		<img src="images/zozio.jpg" alt="" />
	</div>
	  <ul>
        <c:forEach var="snake" items="${ snakes }">
            <li><c:out value="${ snake.pseudo }" /> <c:out value="${ snake.password }" /></li>
        </c:forEach>
    </ul>  
</body>

</html>