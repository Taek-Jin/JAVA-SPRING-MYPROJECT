<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width-device-width", initial-scale="1">
<link rel="stylesheet" href="../resources/css/shop1.css?after12">
<link rel="stylesheet" href="../resources/css/default.css?after">
</head>
<body>
	<div class="lgn_container">
			<div class="lgn_content">
				<form:form modelAttribute="loginCommand">
					<ul>
						<li><h1 style="font-size: 15px; font-weight: bold; padding-bottom: 13px;">로그인</h1></li>
						<li><form:input path="email" type="text" class="form-control" placeholder="아이디"
							maxlength="20" style="width: 250px; height:30px;" /></li>
						<li class="lgn_error"><form:errors path="email"/></li>
						<li><form:input path="password" type="password" class="form-control" placeholder="비밀번호"
							maxlength="20" style="width: 250px; height:30px;" /></li>
						<li class="lgn_error"><form:errors path="password"/></li>
						<li><input type="submit" class="btn_lgn" value="로그인"/></li>
					</ul>
				
					
					<label><form:checkbox path="rememberEmail"/>이메일 저장</label>
					<a class="register_btn" href="<c:url value="/register/step2" />" >회원가입</a>

					
				</form:form>
			</div>
	</div>
</body>
</html>