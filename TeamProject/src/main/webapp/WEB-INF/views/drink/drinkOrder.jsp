<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<div class="container-fluid px-4">
				<h2 class="mt-4">음료</h2>
				
				<div>
					<div id="board-list">
						<div class="container">
							<br> 
							<br>
								<c:forEach var="order" items="${olist}">
									<tr>
									<br>
									<td>${order.id}</td>
									<td>${order.date}</td>
									<td>${order.quantity}</td>
									<br>
									</tr>
								</c:forEach>
							<br>
						</div>
					</div>
				</div>
			</div>
</body>
</html>