<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../resources/css/shop1.css?after124">
<link rel="stylesheet" href="../resources/css/default.css?after1">
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://stgstdpay.inicis.com/stdjs/INIStdPay.js" charset="UTF-8"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
<div class="home_container_order">
		<%@ include file = "../include/head.jsp" %>
			<!--사이드-->
	<div class="wrapper">
		<%@ include file = "../include/left_column.jsp" %>	
		
		<div class="order_container">
			<section class="order_content">
				<div class="content_subject"><span>Order / Payment</span></div>
				<div class="recipient_info">
					<div class="recipient_subject"><span>Recipient Info</span></div>
					<table class="recipient_info_table">
						<thead>
							<tr class="recipient_info_row">
							 	<th>배송지</th>
								<td><input class="address_input_radio_1" type="radio" onclick="showAdress('1')" checked/>${authInfo.name}님 배송지  <input class="address_input_radio_2" type="radio" onclick="showAdress('2')"/>신규 배송지</td>
							</tr>
						</thead>
						<tbody class="address_input_tbody_1">
							<tr class="recipient_info_row">	
								<th>주문자</th>
								<td>${member.name}</td>
							</tr>
							<tr class="recipient_info_row">	
								<th>전화번호</th>
								<td>${member.phoneNumber}</td>
							</tr>
							<tr>	
								<th rowspan="3">배송지 주소</th>
								<td rowspan="3">${member.addr1}<br><br>
								${member.addr2}<br><br>${member.addr3}</td>
							</tr>
							<tr>	
								<th></th>
								<td></td>
							</tr>
							<tr>	
								<th></th>
								<td></td>
							</tr>
						</tbody>
						<tbody class="address_input_tbody_2">
							<tr class="recipient_info_row">	
								<th>주문자</th>
								<td><input type="text" class="new_buyerName_input"></td>
							</tr>
							<tr class="recipient_info_row">	
								<th>전화번호</th>
								<td><input type="text" class="new_buyerPhone_input"></td>
							</tr>
							<tr>	
								<th rowspan="3">배송지 주소</th>
								<td rowspan="3"><input name="addr1" readonly="readonly" class="address1_input" style="width:90px;"><a class="address_search_btn" onclick="execution_daum_address()">주소 찾기</a><br><br>
								<input name="addr2" readonly="readonly" class="address2_input"><br><br>
								<input name="addr3" readonly="readonly" class="address3_input"></td>
							</tr>
							<tr>	
								<th></th>
								<td></td>
							</tr>
							<tr>	
								<th></th>
								<td></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="product_info_1">
						<div class="product_subject"><span>Product Info</span></div>
						<table class="order_product_table">
							<thead>
								<tr>
									<th class="td_width_3">상품명</th>
									<th class="td_width_4">가격</th>
									<th class="td_width_4">수량</th>
									<th class="td_width_4">합계</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${opv}" var="opv">
									<tr>
										<td class="cart_info_td" style="display:none;">
											<input type="hidden" class="individual_buyerName_input" value="${authInfo.name}">
											<input type="hidden" class="individual_productsPrice_input" value="${opv.productsPrice}">
											<input type="hidden" class="individual_productsCount_input" value="${opv.productsCount}">
											<input type="hidden" class="individual_totalPrice_input" value="${opv.totalPrice}">
											<input type="hidden" class="individual_productsId_input" value="${opv.productsId}">
											<input type="hidden" class="individual_deliveryPrice_input" value="${opv.deliveryPrice}">
										</td>
										<td class="td_width_3 productsid_td"><a href="<c:url value="/product/content?productsId=${opv.productsId}" />">${opv.productsName}</a></td>
										<td class="td_width_4 price_td">
											<fmt:formatNumber value="${opv.productsPrice}" pattern="#,### 원" />
										</td>
										<td class="td_width_4 table_text_align_center">
											<div class="table_text_align_center quantity_div">
												${opv.productsCount}
											</div>
										</td>
										<td class="td_width_4 table_text_align_center">
											<fmt:formatNumber value="${opv.totalPrice}" pattern="#,### 원" />
										</td>
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
				</div>
				<div class="payment_info">
						<div class="payment_subject"><span>Payment Info / Agreement</span></div>
						<table class="payment_info_table">
							<tbody>
								<tr class="payment_info_row payment_td_height">	
									<th>결제수단</th>
									<td><input type="radio" checked/>일반결제 </td>
								</tr>
								<tr class="payment_info_row payment_td_height2">	
									<th>결제안내</th>
									<td><label class="paym_01"><input type="radio" class="paym_0_1"/><span>카카오페이</span></label>	
									</td>
								</tr>
								<tr class="payment_info_row payment_td_height3">	
									<th>품절 시 환불 안내</th>
									<td>결제하신 수단으로 취소됩니다.</td>
								</tr>
								<tr class="payment_info_row payment_td_height4">	
									<th>주문자 동의</th>
									<td>회원 본인은 구매 조건, 주문 내용 확인 및 결제에 동의합니다</td>
								</tr>	
							</tbody>
						</table>
						<div class="order_btn_sector">
							<button class="order_btn" onclick="requestPay()" onmousedown="paymentRecord();" style="cursor:pointer;" >주문하기</button>
						</div>
				</div>	
			</section>
			<form action="/payment" method="post" class="order_form">
				<input name="ID" value="${authInfo.id}" type="hidden">
				
				<input name="addressName" type="hidden">
				<input name="memberAddr1" type="hidden">
				<input name="memberAddr2" type="hidden">
				<input name="memberAddr3" type="hidden">

			</form>
		</div>		
	</div>
</div>
<script>
let totalPrice = 0;				// 총 가격
let totalCount = 0;				// 총 갯수
let deliveryPrice = 0;			// 배송비
let finalTotalPrice = 0; 		// 최종 가격(총 가격 + 배송비)	
let buyerName;
let buyerPhone;
let byyerAddr1;
let byyerAddr2;
let byyerAddr3;
let byyerAddr;

$(document).ready(function(){
	setTotalInfo();
});
$(".address_input_tbody_2").css('display', 'none');
function showAdress(className){
if(className == 1){
	$(".address_input_tbody_2").css('display', 'none');
	$(".address_input_radio_2").prop("checked", false);
	$(".address_input_tbody_1").css('display', '');
}
if(className == 2){
	$(".address_input_tbody_1").css('display', 'none');
	$(".address_input_radio_1").prop("checked", false);
	$(".address_input_tbody_2").css('display', '');
}
}


function setTotalInfo(){
	

	
	$(".cart_info_td").each(function(index, element){

			// 총 가격
			totalPrice += parseInt($(element).find(".individual_totalPrice_input").val());
			// 총 갯수
			totalCount += parseInt($(element).find(".individual_productsCount_input").val());
		
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
function paymentRecord() {
	if($(".address_input_radio_1").is(':checked')){
		let buyerName = $(element).find(".individual_buyerName_input").val();
		let buyerPhone = $(element).find(".individual_buyerPhone_input").val();
		let byyerAddr =	$(element).find(".individual_buyerAddr_input").val();
	}
	else if($(".address_input_radio_2").is(':checked')){
		let buyerName = $(element).find(".new_buyerName_input").val();
		let buyerPhone = $(element).find(".new_buyerPhone_input").val();
		let buyerAddr1 = $(element).find(".new_buyerAddr1_input").val();
		let buyerAddr2 = $(element).find(".new_buyerAddr2_input").val();
		let buyerAddr3 = $(element).find(".new_buyerAddr3_input").val();
		let buyerAddr = buyerAddr1 + buyerAddr2 + buyerAddr3
	}
}

$(".order_btn").click(function () {
		if($(".paym_0_1").is(':checked')){
		var IMP = window.IMP; // 생략가능
		IMP.init('imp44738508'); 
		// i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드
		// ''안에 띄어쓰기 없이 가맹점 식별코드를 붙여넣어주세요. 안그러면 결제창이 안뜹니다.
		IMP.request_pay({
			pg: 'kakaopay',
			pay_method: 'card',
			merchant_uid: 'ORD20180131-0000011' + new Date().getTime(),
			/* 
			 *  merchant_uid에 경우 
			 *  https://docs.iamport.kr/implementation/payment
			 *  위에 url에 따라가시면 넣을 수 있는 방법이 있습니다.
			 */
			name: '샵메인',
			// 결제창에서 보여질 이름
			// name: '주문명 : ${auction.a_title}',
			// 위와같이 model에 담은 정보를 넣어 쓸수도 있습니다.
			amount: finalTotalPrice,
			// amount: ${bid.b_bid},
			// 가격 
			buyer_name: buyerName,
			// 구매자 이름, 구매자 정보도 model값으로 바꿀 수 있습니다.
			// 구매자 정보에 여러가지도 있으므로, 자세한 내용은 맨 위 링크를 참고해주세요.
			buyer_addr: buyerAddr,
			buyer_postcode: buyerPhone,
			}, function (rsp) {
				console.log(rsp);
			if (rsp.success) {
				var msg = '결제가 완료되었습니다.';
				msg += '결제 금액 : ' + rsp.paid_amount;
				// success.submit();
				// 결제 성공 시 정보를 넘겨줘야한다면 body에 form을 만든 뒤 위의 코드를 사용하는 방법이 있습니다.
				// 자세한 설명은 구글링으로 보시는게 좋습니다.
			} else {
				var msg = '결제에 실패하였습니다.';
				msg += '에러내용 : ' + rsp.error_msg;
			}
			alert(msg);
		});
		}
	});
function execution_daum_address(){
		console.log("동작");
   new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            
        	// 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
             	// 추가해야할 코드
                // 주소변수 문자열과 참고항목 문자열 합치기
                  addr += extraAddr;
            
            } else {
            	addr += ' ';
            }

         	// 제거해야할 코드
            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            $(".address1_input").val(data.zonecode);
            $(".address2_input").val(addr);				
            // 커서를 상세주소 필드로 이동한다.
            $(".address3_input").attr("readonly", false);
            $(".address3_input").focus();	 
            
            
        }
    }).open();  	

}
</script>
</body>
</html>