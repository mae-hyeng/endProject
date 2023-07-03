<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>	
<html>
<head>
<meta charset="UTF-8">
<title>회원가입확인</title>
</head>
<body>
		<script>
			if('OK' == '${order}'){
				alert("장바구니에 추가했습니다.")
				history.go(-1);
			}else if('login' == '${order}'){
				alert("로그인이 필요한 서비스입니다.")
				location.href="login"
			}
		</script>
</body>
</html>
