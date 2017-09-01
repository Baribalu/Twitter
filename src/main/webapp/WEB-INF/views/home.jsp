<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Twitter</h1>

	<c:forEach items="${accounts}" var="account">
		<c:forEach items="${account.messages}" var="message">
			<div style="background-color: red">
				${account.fullName}:${message}
			</div>
		</c:forEach>
	</c:forEach>

</body>
</html>
