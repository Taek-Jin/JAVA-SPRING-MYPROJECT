<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="resources/css/shop1.css?after123">
<link rel="stylesheet" href="resources/css/default.css?after">
<title>메인</title>
</head>
<body>
<div class="home_container">
		<%@ include file = "include/head.jsp" %>
			<!--사이드-->
	<div class="wrapper">
		<%@ include file = "include/left_column.jsp" %>
	
			
			<!--본문-->
		<div class="content_container">
			<section class="home_content">
				<div class="home_1">
					<c:forEach items="${list}" var="list" >
					<div class="home_2">
						<ul>
							<li>
								<a href="<c:url value="/product/content?productsId=${list.productsId}" />">
								  <div class="img_content1">
									<img style="margin-left:25px; margin-top:20px;" src ="${list.imagePath}" width="150px" height="200px" >
								  </div>
								  <span><strong>${list.publisher}</strong></span>
								  <span>${list.productsIntro}</span>
								  <span>${list.productsPrice}원</span>
								</a>
							</li>
						</ul>
					</div>
					</c:forEach>
				</div>
		

			</section>
			<footer class="home_foot">
				<div class="home_foot1">
			
				</div>
			</footer>
		</div>
	</div>
</div>

</body>
</html>