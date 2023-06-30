<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% 
String username = (String)session.getAttribute("username");
Integer quantity = (Integer)session.getAttribute("quantity");
/* String id = (String)session.getAttribute("id"); */
String name = (String)session.getAttribute("name");
%>
</head>
<body>
	<div class="container-fluid px-4">
				<h2 class="mt-4">음료</h2>
				
				<div>
					<div id="board-list">
						<div class="container">
							<br> 
							<br>
							<br>
							<table>
							    <tr>
							        <th>주문 번호</th>
							        <th>아이디</th>
							        <th>수량</th>
							        <th>이름</th>
							    </tr>
							    <c:forEach items="${cartList}" var="cart">
					                <tr>
					                    <td>${cart.id}</td>
					                    <td>${cart.user.username}</td>
					                    <td>${cart.quantity}</td>
					                    <td>${cart.menu.name}</td>
					                </tr>
					            </c:forEach>
							</table>
							<br>

								
							<br>
						</div>
					</div>
				</div>
			</div>
</body>
</html>