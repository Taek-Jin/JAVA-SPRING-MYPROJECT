<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../resources/css/shop1.css?after123">
<link rel="stylesheet" href="../resources/css/default.css?after1243">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>
<div class="home_container">
	<%@ include file = "../include/head.jsp" %>

	<div class="wrapper">
		<%@ include file = "../include/left_column.jsp" %>
	
		<div class="write_container">
			<div class="row">
				<form name="productRequest" method="post" action="write2" enctype="multipart/form-data">
				<form:errors />
					<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
						<thead>
							<tr>
								<th colspan="2" style="background-color: #eeeeee; text-align: center;">상품등록</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input name="productsName" type="text" class="form-control" placeholder="제품이름" maxlength="50"/></td>
							</tr>
							
							<tr>
								<td><input name="publeYear" type="date" class="form-control2"/></td>
							</tr>
							<tr>
								<td><input name="productsIntro" type="text" class="form-control" placeholder="제품소개" maxlength="50"/></td>
							</tr>

							<tr>
								<td><input name="files" type="file" class="form-control2" />
								<input class="upload-name" value="첨부파일" placeholder="첨부파일">
    							<label for="files">파일찾기</label> 
   								 <input name="files" type="file" class="files" id="files" /></td>
							</tr>
							
							
							
							<tr>
								<td>
									<select class="cate1">
									    <option selected value="none">선택</option>
									</select>
									<select class="cate2">
									    <option selected value="none">선택</option>
									</select>
									<select name="cateCode" class="cate3">
									    <option selected value="none">선택</option>
									</select>
									<select name="cateName" class="cate4" style="display:none;" >
									    <option selected value="none">선택</option>
									</select>
								</td>
							</tr>
							
							<tr>
								<td><input name="productsPrice" type="text" class="form-control" placeholder="제품가격" maxlength="50"/></td>
							</tr>
							<tr>
								<td><input name="productsStock" type="text" class="form-control" placeholder="재고" maxlength="50"/></td>
							</tr>
						
						</tbody>
					</table>
					<input type="submit" class="btn btn-primary" value="등록">
				</form>
				
			</div>
		</div>
		
	</div>
</div>
	<script>
		let cateList = JSON.parse('${cateList}');
		let cate1Array = new Array();
		let cate2Array = new Array();
		let cate3Array = new Array();
		let cate1Obj = new Object();
		let cate2Obj = new Object();
		let cate3Obj = new Object();
		
		let cateSelect1 = $(".cate1");		
		let cateSelect2 = $(".cate2");
		let cateSelect3 = $(".cate3");
		let cateSelect4 = $(".cate4");
		
		function makeCateArray(obj,array,cateList, tier){
			for(let i = 0; i < cateList.length; i++){
				if(cateList[i].tier === tier){
					obj = new Object();
					
					obj.cateName = cateList[i].cateName;
					obj.cateCode = cateList[i].cateCode;
					obj.cateParent = cateList[i].cateParent;
					
					array.push(obj);				
					
				}
			}
		}
		makeCateArray(cate1Obj,cate1Array, cateList, 1);
		makeCateArray(cate2Obj,cate2Array, cateList, 2);
		makeCateArray(cate3Obj,cate3Array, cateList, 3);
		

		for(let i = 0; i < cate1Array.length; i++){
			cateSelect1.append("<option value="+cate1Array[i].cateCode+">" + cate1Array[i].cateName + "</option>");
		}
		
		$(cateSelect1).on("change",function(){
			
			let selectVal1 = $(this).find("option:selected").val();	
			
			cateSelect2.children().remove();
			
			cateSelect2.append("<option value='none'>선택</option>");

			for(let i = 0; i < cate2Array.length; i++){
				if(selectVal1 == cate2Array[i].cateParent){
					cateSelect2.append("<option value="+cate2Array[i].cateCode+">" + cate2Array[i].cateName + "</option>");	
				}
			}// for
			
		});
		
		$(cateSelect2).on("change",function(){
			
			let selectVal2 = $(this).find("option:selected").val();
			
			cateSelect3.children().remove();
			
			cateSelect3.append("<option value='none'>선택</option>");		
			
			for(let i = 0; i < cate3Array.length; i++){
				if(selectVal2 == cate3Array[i].cateParent){
					cateSelect3.append("<option value="+cate3Array[i].cateCode+" value2="+cate3Array[i].cateName+">" + cate3Array[i].cateName + "</option>");	
				}
			}// for		
			
		});	
		
		
		$(cateSelect3).on("change",function(){
			
			let cateName = $(this).find("option:selected").attr("value2");
			
			cateSelect4.children().remove();
			
			cateSelect4.append("<option value="+cateName+">" + cateName + "</option>");
		});	
		
	</script>
</body>
</html>