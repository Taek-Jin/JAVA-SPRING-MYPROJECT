<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width-device-width", initial-scale="1">
<link rel="stylesheet" href="../resources/css/shop1.css">
<link rel="stylesheet" href="../resources/css/default.css">
</head>
<body>
<div class="home_container">
		<%@ include file = "../include/head.jsp" %>
			<!--사이드-->
	<div class="wrapper">
		<%@ include file = "../include/left_column.jsp" %>
	
		<div class="content_container">
			<section class="home_content">
			<form action="write2" name="questionRequest" method="post">
				<div class="question_contaniner">
					<div class="question_top">
						<div><h1>문의 작성</h1></div>
					</div>
					<div class="question_middle">
						<ul>
							<li>
								<div class="question_middle_div1"><p>작성자</p></div>
								<div><p>${authInfo.name }</p></div>
							</li>
							<li>
								<div class="question_middle_div1"><p>이메일</p></div>
								<div><p>${authInfo.email }</p></div>
							</li>
						</ul>
					</div>
					<div class="question_middle2">
						<ul>
							<li>
								<div class="question_middle_div1"><p>제목</p></div>
								<div><input name="title" type="text" placeholder="제목을 입력해주세요" maxlength="50" style="width: 500px;"/></div>
							</li>
							<li>
								<div class="question_middle_div2"><p>문의내용</p></div>
								<div class="question_middle_div3"><textarea name="content" placeholder="내용을 입력해주세요" maxlength="2048" style="width: 502px; height: 200px;" ></textarea></div>
							</li>
							<li>
								<input type="submit" class="btn" value="등록">
							</li>
						</ul>
					</div>
				</div>	
			</form>
			</section>
			<footer class="home_foot">
				<div class="home_foot1">
			
				</div>
			</footer>
		</div>
	</div>
</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="../resources/js/bootstrap.js"></script>
</body>
</html>