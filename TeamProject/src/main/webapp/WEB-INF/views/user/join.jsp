<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/resources/include/header.jsp" %>
<div class="login-box">
  <h2>Join</h2>
  <form name="regForm" action="join" method="post">
    <div class="user-box">
      <input type="text" name="username"  required="true">
      <label>아이디를 입력하세요</label>
    </div>
    <div class="user-box">
      <input type="password" name="password" required="true">
      <label>비밀번호를 입력하세요</label>
    </div>
    <div class="user-box">
      <input type="password" name="password_check" required="true">
      <label>비밀번호 확인</label>
    </div>
    <div class="user-box">
      <input type="text" name="name" required="true">
      <label>이름을 입력하세요</label>
    </div>
    <div class="user-box">
      <input type="tel" name="phone" required="true">
      <label>전화번호는 '-'를 빼고 입력하세요</label>
    </div>	
    <div class="user-box">
      <input type="text" name="email" required="true">
      <label>이메일을 입력하세요</label>
      </div>
	<input type="button" value="메일발송" class="btn first" onclick=mailcheck()>

	
	<div class="user-box">
     <input type="text" name="email_check_number" maxlength="10" required="true">
      <label>메일로 발송된 인증번호 6자리를 입력해주세요</label>
    </div>	
     <div class="user-box">
      <input type="text" name="address" required="true">
      <label>주소를 입력하세요</label>
    </div>		
<div>
<input type="button" value="회원가입" class="btn first" onclick="check()" style="margin-left: 55px">
<input type="button" value="로그인" class="btn second" onclick="location.href='login'">
</div>
  </form>
</div>

<script>
     function check(){
        let reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
        let pnum = /^[0-9]+$/;   
        let regExp = /[ㄱ-ㅎㅏ-ㅣ가-힣]/g;
        //form은 document.태그이름.태그이름으로 하위태그에 접근이 가능함...(dom접근)
        //console.log(documnet.regform.id.value); 공백이 출력됨
        if(regForm.username.value == ''){
           alert("아이디를 입력하세요.")
           return;
        }else if(regExp.test(regForm.username.value)){
           alert("아이디는 영문만 가능합니다")
           return;
        }else if(regForm.username.value.search(" ") != -1){
              alert("아이디   는 공백을 포함 할 수 없습니다.")
              return;
        }else if(regForm.username.value.length < 4 || regForm.username.value.length > 12){
           alert("아이디는 4글자 이상 12글자 이하로 입력하세요.")
           return;
        }else if(regForm.password.value == ''){
           alert("비밀번호를 입력하세요.")
           return;
        }else if(!reg.test(regForm.password.value)){
           alert("비밀번호는 8자 이상, 영문 대문자, 소문자, 특수문자, 숫자를 모두 포함해야합니다.")
        }else if(/(\w)\1\1\1/.test(regForm.password.value)){
           alert("비밀번호에 같은 문자를 4번이상 연속해서 사용할 수 없습니다.")
           return;
        }else if(regForm.password.value.search(" ") != -1){
           alert("비밀번호는 공백을 포함 할 수 없습니다.")
           return;
        }else if(regForm.password.value != regForm.password_check.value){
           alert("비밀번호 확인란을 확인해주세요. ")
           return;
        }else if(regForm.name.value ==''){
           alert("이름을 입력하세요.")
           return;
        }else if(regForm.phone.value ==''){
           alert("전화번호를 입력하세요.")
           return;
        }else if(!pnum.test(regForm.phone.value)){
           alert("전화 번호는 숫자만 입력 가능합니다.")
           return;
        }else if(regForm.phone.value.search("-") != -1){
           alert("전화번호에 '-'는 사용불가합니다.")
           return;
        
        }else if(regForm.email_check_number.value != sessionCode){
        	 alert("인증번호 오류! 인증번호를 확인해 주세요.");
            return;
         }else if(regForm.address.value ==''){
           alert("주소를 입력하세요.")
           return;
        }else if(confirm("회원 가입을 하시겠습니까?")){
           regForm.submit(); //자바스크립트의 submit()는 form태그 submit기능
           
        }
     }
     
  </script>

<script>
    function mailcheck() {
    	let reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
        let pnum = /^[0-9]+$/;   
        let regExp = /[ㄱ-ㅎㅏ-ㅣ가-힣]/g;
        //form은 document.태그이름.태그이름으로 하위태그에 접근이 가능함...(dom접근)
        //console.log(documnet.regform.id.value); 공백이 출력됨
        if (regForm.email.value == '') {
            alert("이메일을 입력하세요.");
            return;
        } else if (regForm.email.value.search("@") == -1 || regForm.email.value.search(".") == -1) {
            alert("이메일 형식 오류입니다.");
            return;
        } else {
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "/mailcheck", true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

            // 요청 파라미터 설정
            var email = "email=" + encodeURIComponent(regForm.email.value);

            xhr.onreadystatechange = function () {
                if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
                    // 요청이 성공적으로 처리되었을 때 실행할 로직
                    alert("메일이 발송되었습니다.");
                    var response = xhr.responseText;

                    // 새로운 인증번호 세션에 저장
                    sessionCode = response;
                }
            };

            xhr.send(email);
        }
    }
</script>

<script>
   function injeong() {
       if (regForm.email_check_number.value == sessionCode) {
           alert("인증 성공");
           // 인증 성공한 경우 처리할 로직 추가
           // 회원가입 진행 등
       } else {
           alert("인증 실패");
       }
   }
</script>

<%@include file="/resources/include/footer.jsp" %>