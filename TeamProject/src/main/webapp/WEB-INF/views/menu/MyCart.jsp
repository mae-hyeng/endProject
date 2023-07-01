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
				<h2 class="mt-4">내 주문내역</h2>
				
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
							        <th>가격</th>
							    </tr>
							    <c:forEach items="${list2}" var="list2">
					                <tr>
					                    <td>${list2.id}</td>
					                    <td>${list2.user.username}</td>
					                    <td>${list2.quantity}</td>
					                    <td>${list2.menu.name}</td>
					                    <td id="price" class="price">${list2.menu.price*list2.quantity }</td>
					                </tr>
					            </c:forEach>
							</table>
							<br>
							<button>주문하기</button>
							총 금액 : <span id="totalPrice"></span>						
							<br>
						</div>
					</div>
				</div>
			</div>
			
<script>
function totalP() {
	var totalPrice = 0;
	var priceElements = document.getElementsByClassName("price");
	
	// 각 가격 값들을 더함
	for (var i = 0; i < priceElements.length; i++) {
	    var price = parseInt(priceElements[i].innerText);
	    totalPrice += price;
	}
	var totalPriceElement = document.getElementById("totalPrice");
    totalPriceElement.innerText = totalPrice;
}

window.onload=totalP;
	     
</script>

</body>
</html>