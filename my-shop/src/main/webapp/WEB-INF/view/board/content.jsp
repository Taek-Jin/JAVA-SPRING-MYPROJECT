<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="..resources/css/shop1.css">
<link rel="stylesheet" href="..resources/css/default.css">
<link rel="stylesheet" href="../resources/css/bootstrap.css">
</head>
<body>
	<%@ include file = "../index.jsp" %>
	<div class="container">
		<div class="row">
				<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2" style="background-color: #eeeeee; text-align: center;">게시판 글쓰기 양식</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${board.title}</td>
						</tr>
						<tr>
							<td class="form-control">${board.content}</td>
						</tr>
					</tbody>
				</table>
		</div>
	</div>
</body>
</html>