<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title><spring:message code="change.pwd.done"/></title>
</head>
<body>
	<p>
		<spring:message code="change.pwd.done" />
	</p>
	<p>
		<a href="<c:url value='/main'/>">
			[<spring:message code="go.main"/>]
		</a>
	</p>
</body>
</html>