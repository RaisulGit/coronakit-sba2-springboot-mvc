<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/header" />
<hr />
	<a href="${pageContext.request.contextPath}/user/show-kit">Show Kit</a>
	<a href="${pageContext.request.contextPath}/user/show-list">List Product</a>
</body>
</html>