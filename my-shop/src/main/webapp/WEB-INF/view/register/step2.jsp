<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width-device-width", initial-scale="1">
<link rel="stylesheet" href="../resources/css/shop1.css?after1123">
<link rel="stylesheet" href="../resources/css/default.css?after">
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>
	<div class="lgn_container">
			<div class="lgn_content">
				<form:form action="step3" modelAttribute="registerRequest">
				<form:errors />
					<ul>
						<li><h1 style="font-size: 15px; font-weight: bold; padding-bottom: 13px;">회원가입</h1></li>
						<li><form:input path="email" type="text" class="form-control" placeholder="아이디"
							maxlength="20" style="width: 250px; height:30px;"  /></li>
						<li><form:errors path="email"/></li>
						<li><form:input path="name" type="text" class="form-control" placeholder="이름"
							maxlength="20" style="width: 250px; height:30px;" /></li>
						<li><form:errors path="name"/></li>
						<li><form:input path="password" type="password" class="form-control" placeholder="비밀번호"
							maxlength="20" style="width: 250px; height:30px;" /></li>
						<li><form:errors path="password"/></li>
						<li><form:input path="confirmPassword" type="password" class="form-control" placeholder="비밀번호 확인"
							maxlength="20" style="width: 250px; height:30px;" /></li>
						<li><form:errors path="confirmPassword"/></li>
						<li><form:input path="phoneNumber" type="text" class="form-control" placeholder="휴대전화 번호"
							maxlength="20" style="width: 250px; height:30px;" /></li>
						<li class="address1_input"><form:input path="addr1" readonly="readonly" class="address1_input" maxlength="20" style="width: 165px; height:30px;" /></li><a class="address_search_btn" onclick="execution_daum_address()">주소 찾기</a>
						<li><form:input path="addr2" readonly="readonly" class="address2_input" maxlength="20" style="width: 250px; height:30px;" /></li>
						<li><form:input path="addr3" type="text" class="address3_input" maxlength="20" style="width: 250px; height:30px;" /></li>
						<li><input type="submit" class="btn_lgn" value="회원가입"></li>
					</ul>
				
				
				
					
					
			
				</form:form>
				
		
			
			</div>
	</div>
<script>
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