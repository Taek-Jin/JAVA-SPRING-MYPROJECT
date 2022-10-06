<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width-device-width", initial-scale="1">
<link rel="stylesheet" href="../resources/css/shop1.css?a133r">
<link rel="stylesheet" href="../resources/css/default.css?after">
</head>
<body>
<div class="home_container_cart">
		<%@ include file = "../include/head.jsp" %>

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
				<div class="content_subject"><span>Order / Payment</span></div>
					<table class="subject_table subject_table2">
						<tbody>
							<tr>
								<th class="td_width_1"></th>
								<th class="td_width_2"><input type="checkbox" class="all_check_input" checked="checked"></th>
								<th class="td_width_3">상품명</th>
								<th class="td_width_4">가격</th>
								<th class="td_width_4">수량</th>
								<th class="td_width_4">합계</th>
								<th class="td_width_4">주문관리</th>
							</tr>
						</tbody>
					</table>
					<table class="subject_table2">
						<tbody>
							<c:forEach items="${cartInfo}" var="ci">
								<tr>
									<td class="td_width_2 cart_info_td">
										<input type="checkbox" class="individual_cart_checkbox input_size_20" checked="checked">
										<input type="hidden" class="individual_productsId_input" value="${ci.productsId}">
										<input type="hidden" class="individual_productsPrice_input" value="${ci.productsPrice}">
										<input type="hidden" class="individual_productsCount_input" value="${ci.productsCount}">
										<input type="hidden" class="individual_productsName_input" value="${ci.productsName}">
										<input type="hidden" class="individual_totalPrice_input" value="${ci.productsPrice * ci.productsCount}">
									</td>
									<td class="td_width_3"><a href="<c:url value="/product/content?productsId=${ci.productsId}" />">${ci.productsName}</a></td>
									<td class="td_width_4 price_td">
										<del><fmt:formatNumber value="${ci.productsPrice}" pattern="#,### 원" /></del><br>
										<span class="red_color"><fmt:formatNumber value="${ci.salePrice}" pattern="#,### 원"/></span>
									</td>
									<td class="td_width_4 table_text_align_center">
										<div class="table_text_align_center quantity_div">
											<button class="quantity_btn minus_btn" data-cartId="${ci.cartId}">-</button>
											<input type="text" value="${ci.productsCount}" class="quantity_input" style="width: 15px;">	
											<button class="quantity_btn plus_btn" data-cartId="${ci.cartId}">+</button>
										</div>
									</td>
									<td class="td_width_4 table_text_align_center">
										<fmt:formatNumber value="${ci.salePrice * ci.productsCount}" pattern="#,### 원" />
									</td>
									<td class="td_width_4 table_text_align_center delete_btn" data-cartId="${ci.cartId}"><button>삭제</button></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
			<div class="content_total_section">
				<div class="total_wrap">
					<table>
						<tr>
							<td>
								<table>
									<tr>
										<td>총 상품 가격</td>
										<td>
											<span class="totalPrice_span"></span> 원
										</td>
									</tr>
									<tr>
										<td>배송비</td>
										<td>
											<span class="delivery_price"></span> 원
										</td>
									</tr>									
									
								</table>
							</td>
							<td>
								<table>
									<tr>
										<td></td>
										<td></td>
									</tr>
								</table>							
							</td>
						</tr>
					</table>
					<div class="boundary_div"></div>
					<table>
						<tr>
							<td>
								<table>
									<tbody>
										<tr>
											<td>
												<strong>최종 결제 금액</strong>
											</td>
											<td>
												<span class="finalTotalPrice_span"></span> 원
											</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
					</table>
				</div>
			</div>
			<div class="buy_section">
				<div class="buy_wrap">
					<a class="btn_buy"  style="cursor:pointer;">주문하기</a>
				</div>
			</div>
			<form action="update" method="post" class="quantity_update_form">
				<input type="hidden" name="cartId" class="update_cartId">
				<input type="hidden" name="productsCount" class="update_productsCount">
			</form>
			<form action="delete" method="post" class="quantity_delete_form">
				<input type="hidden" name="cartId" class="update_cartId">
			</form>
			<form action="../order/view" method="post" class="order_form" name="orderPageVO">
				
			</form>
			</section>			
		</div>
	</div>
</div>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script>
$(document).ready(function(){
	setTotalInfo();
});

$(".individual_cart_checkbox").on("change", function(){

	setTotalInfo($(".cart_info_td"));
});

$(".all_check_input").on("click", function(){

	/* 체크박스 체크/해제 */
	if($(".all_check_input").prop("checked")){
		$(".individual_cart_checkbox").prop("checked", true);
	} else{
		$(".individual_cart_checkbox").prop("checked", false);
	}
	setTotalInfo($(".cart_info_td"));
});

$(".plus_btn").on("click", function(){
	let quantity = $(this).parent("div").find("input").val();
	$(this).parent("div").find("input").val(++quantity);
	let cartId = $(this).data("cartid");
	let productsCount = $(this).parent("div").find("input").val();
	$(".update_cartId").val(cartId);
	$(".update_productsCount").val(productsCount);
	$(".quantity_update_form").method = 'POST';
	$(".quantity_update_form").submit();
});
$(".minus_btn").on("click", function(){
	let quantity = $(this).parent("div").find("input").val();
	if(quantity > 1){
		$(this).parent("div").find("input").val(--quantity);
		let cartId = $(this).data("cartid");
		let productsCount = $(this).parent("div").find("input").val();
		$(".update_cartId").val(cartId);
		$(".update_productsCount").val(productsCount);
		$(".quantity_update_form").method = 'POST';
		$(".quantity_update_form").submit();
	}
});
$(".delete_btn").on("click", function(){
	let cartId = $(this).data("cartid");
	$(".update_cartId").val(cartId);
	$(".quantity_delete_form").method = 'POST';
	$(".quantity_delete_form").submit();
});

function setTotalInfo(){
	
	let totalPrice = 0;				// 총 가격
	let totalCount = 0;				// 총 갯수
	let deliveryPrice = 0;			// 배송비
	let finalTotalPrice = 0; 		// 최종 가격(총 가격 + 배송비)	
	
	$(".cart_info_td").each(function(index, element){
		
		if($(element).find(".individual_cart_checkbox").is(":checked") == true){	//체크여부
			
			// 총 가격
			totalPrice += parseInt($(element).find(".individual_totalPrice_input").val());
			// 총 갯수
			totalCount += parseInt($(element).find(".individual_productsCount_input").val());
		}
	});
	
	if(totalPrice >= 30000){
		deliveryPrice = 0;
	} else if(totalPrice == 0){
		deliveryPrice = 0;
	} else {
		deliveryPrice = 3000;	
	}
	finalTotalPrice = totalPrice + deliveryPrice;
	
	$(".totalPrice_span").text(totalPrice.toLocaleString());
	$(".delivery_price").text(deliveryPrice);	
	$(".finalTotalPrice_span").text(finalTotalPrice.toLocaleString());
}



$(".btn_buy").on("click", function(){
	
	let form_contents ='';
	let orderNumber = 0;
	let deliveryPrice = 0;
	
	$(".cart_info_td").each(function(index, element){
		
		if($(element).find(".individual_cart_checkbox").is(":checked") === true){	//체크여부
			
			let productsId = $(element).find(".individual_productsId_input").val();
			let productsPrice = $(element).find(".individual_productsPrice_input").val();
			let productsCount = $(element).find(".individual_productsCount_input").val();
			let totalPrice = $(element).find(".individual_totalPrice_input").val();
			let productsName = $(element).find(".individual_productsName_input").val();
			
			if(totalPrice >= 30000){
				deliveryPrice = 0;
			} else if(totalPrice == 0){
				deliveryPrice = 0;
			} else {
				deliveryPrice = 3000;	
			}
				
			let productsId_input = "<input name='orders[" + orderNumber + "].productsId' type='hidden' value='" + productsId + "'>";
			form_contents += productsId_input;
			
			let productsPrice_input = "<input name='orders[" + orderNumber + "].productsPrice' type='hidden' value='" + productsPrice + "'>";
			form_contents += productsPrice_input;
			
			let productsCount_input = "<input name='orders[" + orderNumber + "].productsCount' type='hidden' value='" + productsCount + "'>";
			form_contents += productsCount_input;
			
			let totalPrice_input = "<input name='orders[" + orderNumber + "].totalPrice' type='hidden' value='" + totalPrice + "'>";
			form_contents += totalPrice_input;
			
			let productsName_input = "<input name='orders[" + orderNumber + "].productsName' type='hidden' value='" + productsName + "'>";
			form_contents += productsName_input;
			
			let deliveryPrice_input = "<input name='orders[" + orderNumber + "].deliveryPrice' type='hidden' value='" + deliveryPrice + "'>";
			form_contents += deliveryPrice_input;
			
			orderNumber += 1;
		}
	});	
$(".order_form").html(form_contents);
$(".order_form").method = 'POST';
$(".order_form").submit();
});
</script>
</body>
</html>