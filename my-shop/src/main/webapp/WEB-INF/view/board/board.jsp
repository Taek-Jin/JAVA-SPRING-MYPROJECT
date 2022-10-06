<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width-device-width", initial-scale="1">
<link rel="stylesheet" href="../resources/css/bootstrap.css">
<link rel="stylesheet" href="resources/css/shop.css">
<link rel="stylesheet" href="resources/css/default.css">
</head>
<body>
	<%@ include file = "../index.jsp" %>
	<div class="container">
		<div class="row">
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color: #eeeeee; text-align: center;">번호</th>
						<th style="background-color: #eeeeee; text-align: center;">제목</th>
						<th style="background-color: #eeeeee; text-align: center;">작성자</th>
						<th style="background-color: #eeeeee; text-align: center;">작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="list">
						<tr>
							<td>${list.board_no}</td>
							<td><a style="color: black;" href="<c:url value="/board/content?board_no=${list.board_no}"/>">${list.title}</a></td>
							<td>${list.writer}</td>
							<td><tf:formatDateTime value="${list.regDate}" pattern="yyyy-MM-dd" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div>
				<div style="position:absolute; left:45%; display:inline-block; width:180px; text-align:center; ">
					<c:if test="${prev}">
						<span>[<a href="<c:url value="/board?num=${startPageNum-1}" />">이전</a>]</span>
					</c:if>
					<c:forEach begin="${startPageNum }" end="${endPageNum}" var="num">
						<span>
							<a href="<c:url value="/board?num=${num}" />">${num}</a>
						</span>
					</c:forEach>
					<c:if test="${next}">
						<span>[<a href="<c:url value="/board?num=${endPageNum+1}" />">다음</a>]</span>
					</c:if>
				</div>
				<a href="<c:url value="/board/write" />" class="btn btn-primary pull-right">글쓰기</a>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="../resources/js/bootstrap.js"></script>
</body>
</html>