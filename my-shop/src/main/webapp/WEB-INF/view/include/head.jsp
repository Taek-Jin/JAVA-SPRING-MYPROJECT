<%@ page contentType="text/html; charset=utf-8" %>
  		<header>
			<h1><a class="navbar-brand" href="<c:url value="/"/>">샵메인</a></h1>
		</header>
		<section class="visual">
			<div class="control">
				<ul>
				<c:if test="${empty authInfo}" >
					<li><a class="lgn" href="<c:url value="/login/" />">로그인</a></li>
					<li><a href="<c:url value="/login/" />">마이페이지</a></li>
					<li><a href="<c:url value="/login/" />">장바구니</a></li>
					<li><a href="<c:url value="/login/" />">1:1문의</a></li>
				</c:if>
				<c:if test="${!empty authInfo}" >
					<li><a href="<c:url value="/mypage/" />">${authInfo.name}님</a></li>
					<li><a href="<c:url value="/cart/" />">마이페이지</a></li>
					<li><a href="<c:url value="/cart/" />">장바구니</a></li>
					<li><a href="<c:url value="/question/write" />">1:1문의</a></li>
					<c:if test="${authInfo.id_num > 0}" >
						<li><a href="<c:url value="/product/write" />">상품등록</a></li>
					</c:if>
					<li><a href="<c:url value="/logout"/>">로그아웃</a></li>
				</c:if>
				</ul>
			</div>
		</section>