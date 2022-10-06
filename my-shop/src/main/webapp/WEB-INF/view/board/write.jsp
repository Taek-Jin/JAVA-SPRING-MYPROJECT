<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width-device-width", initial-scale="1">
<link rel="stylesheet" href="../resources/css/bootstrap.css">
<link rel="stylesheet" href="../resources/css/shop1.css">
<link rel="stylesheet" href="../resources/css/default.css">
</head>
<body>
	<%@ include file = "../index.jsp" %>
	<div class="container">
		<div class="row">
			<form:form action="write2" modelAttribute="boardRequest">
			<form:errors />
				<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2" style="background-color: #eeeeee; text-align: center;">게시판 글쓰기 양식</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><form:input path="title" type="text" class="form-control" placeholder="제목" maxlength="50"/></td>
						</tr>
						<tr>
							<td><form:textarea path="content" type="text" class="form-control" placeholder="내용" name="bbsContent" maxlength="2048" style="height: 350px;" /></td>
						</tr>
					</tbody>
				</table>
				<input type="submit" class="btn btn-primary pull-right" value="등록">
			</form:form>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="../resources/js/bootstrap.js"></script>
</body>
</html>