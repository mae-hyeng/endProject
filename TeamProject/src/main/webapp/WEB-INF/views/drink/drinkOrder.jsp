<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
							        <th>주문 날짜</th>
							        <th>수량</th>
							    </tr>
							    <tr>
							        <td>${order.id}</td>
							        <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${order.orderDate}" /></td>
							        <td>${order.quantity}</td>
							    </tr>
							</table>
							<br>

								
							<br>
						</div>
					</div>
				</div>
			</div>
</body>
</html>