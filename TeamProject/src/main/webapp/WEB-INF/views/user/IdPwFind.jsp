<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/resources/include/header.jsp" %>

<div class="login-box">
  <h2>아이디/비밀번호 찾기</h2>
  <form name="regForm" action="login" method="post">
    <div class="user-box">
      <input type="text" name="username"  required="true">
      <label>이름</label>
 	 </div>
     <div class="user-box">
      <input type="text" name="phone" required="true">
      <label>핸드폰 번호</label>
    </div>
	<div>
		<input type="button" value ="검색" class="btn first" onclick=check()>
	</div>
  </form>
</div>
<script>
    function mailcheck() {
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
	<%@include file ="/resources/include/footer.jsp" %>
