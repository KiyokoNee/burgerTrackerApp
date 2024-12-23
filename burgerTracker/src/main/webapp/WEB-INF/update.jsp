<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Edit Burger</title>
		<link rel="stylesheet" href="/css/style.css" />
	</head>
	<body>
		<div class="flex">
			<h1>Edit Burger</h1>
			<a href="/burgers">Go Back</a>
		</div>
		<form:form action="/burgers/${burger.id}" method="put" modelAttribute="burger">
			<p>
				<form:label path="burgerName">Burger Name</form:label>
				<form:errors path="burgerName" />
				<form:input path="burgerName" />
			</p>
			<p>
				<form:label path="restaurantName">Restaurant Name</form:label>
				<form:errors path="restaurantName" />
				<form:input path="restaurantName" />
			</p>
			<p>
				<form:label path="rating">Rating</form:label>
				<form:errors path="rating" />
				<form:input path="rating" />
			</p>
			<p>
				<form:label path="notes">Notes</form:label>
				<form:errors path="notes" />
				<form:input path="notes" />
			</p>
			<button type="submit">Submit</button>
		</form:form>
	</body>
</html>