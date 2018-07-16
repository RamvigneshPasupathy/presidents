<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Presidents</title>
<style type="text/css">
.button {
	width: 100%;
	padding: 5px;
	background-color: #f0f0f0;
}

.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}

.capitalCase {
	text-transform: capitalize;
}

.error {
	color: red;
}
</style>
</head>
<body>
	<h1>President Form</h1>

	<c:url var="addAction" value="/country/upsert"></c:url>

	<form:form action="${addAction}" commandName="country">
		<table>
			<c:if test="${!empty country.president}">
				<tr>
					<td><form:label path="id">
							<spring:message text="ID" />
						</form:label></td>
					<td><form:input path="id" readonly="true" size="8"
							disabled="true" /> <form:hidden path="id" /></td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="name">
						<spring:message text="Country" />
					</form:label></td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="president">
						<spring:message text="President" />
					</form:label></td>
				<td><form:input path="president" /></td>
				<td><form:errors path="president" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty country.name}">
						<input class="button" type="submit"
							value="<spring:message text="Update President"/>" />
					</c:if> <c:if test="${empty country.name}">
						<input class="button" type="submit"
							value="<spring:message text="Add Country"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<br>
	<c:if test="${!empty presidentsList}">
		<h3>Presidents List</h3>
		<table class="tg">
			<tr>
				<th width="80">Country ID</th>
				<th width="120">Country Name</th>
				<th width="120">President Name</th>
				<th width="60">Update</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${presidentsList}" var="country">
				<tr>
					<td>${country.id}</td>
					<td class="capitalCase">${country.name}</td>
					<td class="capitalCase">${country.president}</td>
					<td><a href="<c:url value='/edit/${country.id}' />">Update</a></td>
					<td><a href="<c:url value='/remove/${country.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>