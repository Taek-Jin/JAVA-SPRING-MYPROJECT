<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../resources/css/shop1.css?after13">
<link rel="stylesheet" href="../resources/css/default.css?after1">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
</head>
<body>
<div class="home_container">
		<%@ include file = "../include/head.jsp" %>
			<!--사이드-->
	<div class="wrapper">
		<%@ include file = "../include/left_column.jsp" %>	
		
		<div class="product_container">
			<section class="product_content">
				<div class="product_1">
					<div class="product_0"><span>${product.productsName }</span></div>
					<div class="product_2">
						<ul>
							<li>
								<div class="img_content1">
									<img style="border:1px solid #000;" src ="../${product.imagePath}" width="300px" height="350px" >
								</div>
							</li>
						</ul>
					</div>
					<div class="info_container">
						<div class="product_info_h"><span>Product Info</span></div>
						<div class="product_info">
							<div class="product_info_subject"><span>브랜드</span><span>출시일</span><span>판매가</span></div>
							<div><span>${product.publisher}</span><span>${product.publeYear}</span><span>${product.productsPrice}</span></div>
						</div>
						<div class="product_info_h"><span>Delivery Info</span></div>
						<div class="product_info">
							<div class="product_info_subject"><span>출고정보</span><span>배송비</span></div>
							<div><span>결제 3일 이내 출고</span><span>3000원</span></div>
						</div>
						<div class="product_info_h"><span>주문수량</span></div>
						<div class="product_info">
							<div class="button_quantity">
								<span>
									<button class="minus_btn">-</button>
									<input type="text" class="quantity_input" value="1" />
									<button class="plus_btn">+</button>
								</span>
							</div>
						</div>
						<div class="product_info">
							<div class="button_set">
								<a class="btn_buy"  style="cursor:pointer;">바로구매</a>
								<a class="btn_cart" style="cursor:pointer;"><span class="material-symbols-outlined">shopping_bag</span></a>
							</div>
						</div>
						<div class="product_info_foot">
							<span>3만원 이상 결제시 배송비 무료</span>
						</div>
					</div>
				</div>
					
			</section>
			<footer class="home_foot">
				<div class="home_foot1">
			
				</div>
			</footer>
		</div>
		
	</div>
</div>

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script>
	
	let quantity = $(".quantity_input").val()	
	
	$(".plus_btn").on("click", function(){
		$(".quantity_input").val(++quantity);
	});
	$(".minus_btn").on("click", function(){
		if(quantity > 1){
			$(".quantity_input").val(--quantity);
		}
	});
	
	const form = {
		EMAIL : '${authInfo.email}',
		productsId : '${product.productsId}',
		productsCount : ''
	}

	$(".btn_cart").on("click", function(e){
		form.productsCount = $(".quantity_input").val();
		$.ajax({
			url: '../cart/add',
			type: 'POST',
			data: form,
			success: function(result){
				cartAlert(result);
			}
		
		})
	});
	function cartAlert(result){
		if(result == '0'){
			alert("장바구니에 추가를 하지 못하였습니다.");
		} else if(result == '1'){
			alert("장바구니에 추가되었습니다.");
		} else if(result == '2'){
			alert("장바구니에 이미 추가되어져 있습니다.");
		}
		  else if(result == '3'){
			alert("재고가 부족합니다.");
		}
		  else if(result == '5'){
			alert("로그인이 필요합니다.");
		}
	}
</script>
</body>
</html>