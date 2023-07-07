<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<head>
		<meta charset="UTF-8">
		<title>권한 없음 접근불가</title>
	</head>
	<body>
			<script>
			if('NO' == '${noPermission}'){
				alert("접근 권한이 없습니다.")
				location.href='/';
			}
		</script>
		
</html>