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

	<h2>${sessionScope.username}'sFriends!</h2>
	<br />

	<table>
		<tr>
			<th>Full Name</th>
			<th>Username</th>
			<th>Age</th>
			<th>Follow</th>
		</tr>
		<c:forEach items="${friends}" var="friend">
			<tr>
				<td>${friends.fullName}</td>
				<td>${friends.username}</td>
				<td>${friends.age}</td>
				<c:if test="${friends.isFriend} == true">
					<td><button type="submit" value="Unfollow">Unfollow</button></td>
				</c:if>
				<c:if test="${friends.isFriend} == false">
					<td><button type="submit" value="Unfollow">Follow</button></td>
				</c:if>
			</tr>
		</c:forEach>
	</table>

</body>


</html>