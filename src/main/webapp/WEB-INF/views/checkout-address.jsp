<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CMS</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
<section>
<jsp:include page="${pageContext.request.contextPath}/header" />
	<div class="col-sm-4">	
	<%-- <form:form  class="form" action='${pageContext.request.contextPath}/user/finalize' method="POST" modelAttribute="product">
		<div class="form-group">
			<form:label path="productName">Enter Delivery Address</form:label>
			<form:input type="text" path="productName" class="form-control"/>
			<form:errors path="productName" class="alert alert-danger"/>
		</div>
		<div class="form-group text-right">
		<button type="submit" class="btn btn-primary">SAVE</button>
		</div>
	</form:form> --%>
	<label>Enter Address</label>
	<input type="text" name="address" />
	<a class="btn btn-sm btn-danger" href="${pageContext.request.contextPath}/user/finalize?address=${address}">SAVE</a>
	</div>
	</section>
</body>
</html>