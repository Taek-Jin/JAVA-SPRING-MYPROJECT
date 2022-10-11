<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width-device-width", initial-scale="1">
<link rel="stylesheet" href="../resources/css/shop1.css?124234">
<link rel="stylesheet" href="../resources/css/default.css?123">
</head>
<body>
<div class="home_container_cart">
		<%@ include file = "../include/head.jsp" %>
			<!--사이드-->
	<div class="wrapper_cart">
		<div class="sidebar_cart">
				<ul>
					<li>			
						<span class="item"><h1 style="font-size: 16px; font-weight: bold;">나의 활동/정보</h1></span>
					</li>
					<li>
						<a href="<c:url value="/mypage/" />" class="active">
							<span class="item">내 정보</span>
						</a>
					</li>
					<li>
						<a href="<c:url value="/mypage/question?num=1" />">
							<span class="item">문의내역</span>
						</a>
					</li>
					<li>
						<a href="<c:url value="/cart/" />">
							<span class="item">장바구니</span>
						</a>
					</li>
					<li>
						<a href="<c:url value="/mypage/order" />">
							<span class="item">주문내역</span>
						</a>
					</li>
				</ul>
		</div>
		<div class="content_container">
			<section class="cart_content">
				<div class="qna_subject"><span>나의 기본정보</span></div>
				<div class="mypage_content">
					<div><span class="mypage_span_width1">아이디</span><span class="mypage_span_width2">${authInfo.id}</span><span class="mypage_span_width3"></span></div>
					<div><span class="mypage_span_width1">비밀번호</span><span class="mypage_span_width2">*******</span><span class="mypage_span_width3"><a href="<c:url value="/edit/changePassword"/>" class="changepassword_btn">비밀번호 변경</a></span></div>
					<div><span class="mypage_span_width1">이름</span><span class="mypage_span_width2">${authInfo.name}</span><span class="mypage_span_width3"></span></div>
					<div><span class="mypage_span_width1">이메일</span><span class="mypage_span_width2">${authInfo.email}</span><span class="mypage_span_width3"></span></div>
				</div>
			</section>
		</div>
	</div>
</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</body>
</html>