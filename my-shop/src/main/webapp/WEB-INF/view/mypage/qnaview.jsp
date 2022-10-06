<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width-device-width", initial-scale="1">
<link rel="stylesheet" href="../resources/css/shop1.css?1234">
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
				</ul>
		</div>
		<div class="content_container">
			<section class="cart_content">
				<div class="qna_subject"><span>1:1문의</span></div>
				<table class="subject_table subject_table2 qna_table">
						<thead>
							<tr>
								<th class="td_width_2" style="text-align: center;">번호</th>
								<th class="td_width_3" style="text-align: center;">제목</th>
								<th class="td_width_4" style="text-align: center;">작성자</th>
								<th class="td_width_4" style="text-align: center;">작성일</th>
								<th class="td_width_4" style="text-align: center;">처리상태</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="list">
								<tr>
									<td class="td_width_2">${list.question_no}</td>
									<td class="td_width_3"><a style="color: black;" href="<c:url value="/mypage/question?question_no=${list.question_no}"/>">${list.title}</a></td>
									<td class="td_width_4">${list.writer}</td>
									<td class="td_width_4"><tf:formatDateTime value="${list.regDate}" pattern="yyyy-MM-dd" /></td>
									<c:if test="${list.status > 0}" >
									<td class="td_width_4">답변완료</td>
									</c:if>
									<c:if test="${list.status == 0}" >
									<td>답변대기</td>
									</c:if>
									<c:if test="${authInfo.id_num > 1}" >
									<td><a href="<c:url value="/board/write" />" class="btn btn-primary pull-right">답변하기</a></td>
									</c:if>
								</tr>
							</c:forEach>
						</tbody>
				</table>
				<div class="question_paging">
					<div class="question_paging2">
						<c:if test="${prev}">
							<span>[<a href="<c:url value="/mypage/question?num=${startPageNum-1}" />">이전</a>]</span>
						</c:if>
						<c:forEach begin="${startPageNum }" end="${endPageNum}" var="num">
							<span>
								<a href="<c:url value="/mypage/question?num=${num}" />">${num}</a>
							</span>
						</c:forEach>
						<c:if test="${next}">
							<span>[<a href="<c:url value="/mypage/question?num=${endPageNum+1}" />">다음</a>]</span>
						</c:if>
					</div>
				</div>
			</section>
		</div>
	</div>
</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</body>
</html>