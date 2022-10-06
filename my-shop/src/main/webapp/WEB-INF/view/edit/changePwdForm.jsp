<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width-device-width", initial-scale="1">
<link rel="stylesheet" href="../resources/css/shop1.css?after">
<link rel="stylesheet" href="../resources/css/default.css?after">
</head>
<body>
	<div class="lgn_container">
			<div class="lgn_content">
				<form:form modelAttribute="changePwdCommand">
					<ul>
						<li><h1 style="font-size: 15px; font-weight: bold; padding-bottom: 13px;">비밀번호 변경</h1></li>
						<li><form:input path="currentPassword" type="password" class="form-control" placeholder="비밀번호"
							maxlength="20" style="width: 250px; height:30px;" /></li>
						<li class="lgn_error"><form:errors path="currentPassword"/></li>
						<li><form:input path="newPassword" type="password" class="form-control" placeholder="새로운 비밀번호"
							maxlength="20" style="width: 250px; height:30px;" /></li>
						<li class="lgn_error"><form:errors path="newPassword"/></li>
						<li><input type="submit"  class="btn_lgn" value="<spring:message code="change.btn"/>"></li>
					</ul>

					
				</form:form>
			</div>
	</div>
</body>
</html>