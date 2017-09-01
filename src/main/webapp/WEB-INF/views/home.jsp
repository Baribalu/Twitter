<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true"%>
<html>
<head>
<title>Twitter</title>
<style>
body {
	text-align: center;
}

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

li {
	float: left;
}

li a {
	display: inline-block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover {
	background-color: #111;
}
</style>
</head>
<body>
	<h1>Twitter</h1>


	<ul>
		<li><a href="home">Home</a></li>
		<c:if test="${empty sessionScope.username}">
			<li><a href="login">Login</a></li>
		</c:if>
		<c:if test="${not empty sessionScope.username}">
			<li><a href="logout">Logout</a></li>
			<li><a href="friends">Friends</a></li>
		</c:if>
	</ul>

	<h2>Hi ${sessionScope.username }!</h2>

	<div>${about}</div>


	<% if(session.getAttribute("username") != null){ %>
	<sf:form modelAttribute="newMessage" action="home" method="POST">
			<sf:input path="content" type="text" />
			<input type="submit" value="Post" />
		</sf:form>
		
		<c:forEach items="${messages}" var="message">
			<div>${message.user}:${message.content}</div>
		</c:forEach>
	<%}%>

</body>


</html>
