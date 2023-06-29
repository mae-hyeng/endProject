<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/resources/include/h2.jsp"%>
<body>
<script type="text/javascript">
	const route = window.location.pathname.replace('/', '');
	
</script>


    
    
  

	


</body>

<style>
.board-table {
	font-size: 13px;
	width: 100%;
	border-top: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
}

.board-table a {
	color: #333;
	display: inline-block;
	line-height: 1.4;
	word-break: break-all;
	vertical-align: middle;
}

.board-table a:hover {
	text-decoration: underline;
}

.board-table th {
	text-align: center;
}

.board-table .th-num {
	width: 100px;
	text-align: center;
}

.board-table .th-date {
	width: 200px;
}

.board-table th, .board-table td {
	padding: 14px 0;
}

.board-table tbody td {
	border-top: 1px solid #e7e7e7;
	text-align: center;
}

.board-table tbody th {
	padding-left: 28px;
	padding-right: 14px;
	border-top: 1px solid #e7e7e7;
	text-align: left;
}

.board-table tbody th p {
	display: none;
}



</style>
</head>
<div id="layoutSidenav" style="background-color: #FFFFFF;">
	<div id="layoutSidenav_nav">
		<nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
			<div class="sb-sidenav-menu">
				<div class="nav">

					<div class="sb-sidenav-menu-heading">All</div>
					<a class="nav-link" href="/menu">
						<div class="sb-nav-link-icon">
							<i class="fas fa-tachometer-alt"></i>
						</div> 전체 메뉴
					</a>
					<div class="sb-sidenav-menu-heading">WRITE</div>
					<a class="nav-link" href="/menuRegister">
						<div class="sb-nav-link-icon">
							<i class="fas fa-tachometer-alt"></i>
						</div> 메뉴 등록
					</a>
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
					<div class="sb-sidenav-menu-heading">
						<c:choose>
							<c:when test="${sessionScope.username!=null}">
								<span style="color: white; font-size: 15px;">${sessionScope.username }</span>
							</c:when>
						</c:choose>
					</div>
					<a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
						<div class="sb-nav-link-icon">
							<i class="fas fa-book-open"></i>
						</div> 멤버
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
					<div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
							<nav class="sb-sidenav-menu-nested nav">
								<c:choose>
									<c:when test="${sessionScope.username==null}">
										<a class="nav-link" href="adminLogin">로그인</a>
									</c:when>
								</c:choose>
								<a class="nav-link" href="mypage">마이페이지 이동</a> <a class="nav-link" href="update">내 정보변경</a> <a class="nav-link" href="pwupdate">비밀번호 변경</a> <a class="nav-link" href="logout">로그아웃</a>
							</nav>
						</nav>
					</div>
				</div>
			</div>
		</nav>
	</div>

	<div id="layoutSidenav_content">
		<main>
			<div class="container-fluid px-4">
				<h2 class="mt-4">전체 메뉴</h2>
				<div class="row">
					<div class="col-xl-3 col-md-6">
						<div class="card bg-secondary text-white mb-4">
							<div class="card-body">ALL</div>
							<div class="card-footer d-flex align-items-center justify-content-between">
								<a class="small text-white stretched-link" href="menu"></a>
								<div class="small text-white">
									<i class="fas fa-angle-right"></i>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-md-6">
						<div class="card bg-secondary text-white mb-4">
							<div class="card-body">COFFEE</div>
							<div class="card-footer d-flex align-items-center justify-content-between">
								<a class="small text-white stretched-link" href="drink"></a>
								<div class="small text-white">
									<i class="fas fa-angle-right"></i>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-md-6">
						<div class="card bg-secondary text-white mb-4">
							<div class="card-body">MILK TEA & LATTE</div>
							<div class="card-footer d-flex align-items-center justify-content-between">
								<a class="small text-white stretched-link" href="dessert"></a>
								<div class="small text-white">
									<i class="fas fa-angle-right"></i>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-md-6">
						<div class="card bg-secondary text-white mb-4">
							<div class="card-body">JUICE & DRINK</div>
							<div class="card-footer d-flex align-items-center justify-content-between">
								<a class="small text-white stretched-link" href="md"></a>
								<div class="small text-white">
									<i class="fas fa-angle-right"></i>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-md-6">
						<div class="card bg-secondary text-white mb-4">
							<div class="card-body">SMOOTHIE</div>
							<div class="card-footer d-flex align-items-center justify-content-between">
								<a class="small text-white stretched-link" href="md"></a>
								<div class="small text-white">
									<i class="fas fa-angle-right"></i>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-md-6">
						<div class="card bg-secondary text-white mb-4">
							<div class="card-body">TEA & ADE</div>
							<div class="card-footer d-flex align-items-center justify-content-between">
								<a class="small text-white stretched-link" href="md"></a>
								<div class="small text-white">
									<i class="fas fa-angle-right"></i>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-md-6">
						<div class="card bg-secondary text-white mb-4">
							<div class="card-body">BREAD</div>
							<div class="card-footer d-flex align-items-center justify-content-between">
								<a class="small text-white stretched-link" href="md"></a>
								<div class="small text-white">
									<i class="fas fa-angle-right"></i>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-md-6">
						<div class="card bg-secondary text-white mb-4">
							<div class="card-body">DESSERT</div>
							<div class="card-footer d-flex align-items-center justify-content-between">
								<a class="small text-white stretched-link" href="md"></a>
								<div class="small text-white">
									<i class="fas fa-angle-right"></i>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-md-6">
						<div class="card bg-secondary text-white mb-4">
							<div class="card-body">MD</div>
							<div class="card-footer d-flex align-items-center justify-content-between">
								<a class="small text-white stretched-link" href="md"></a>
								<div class="small text-white">
									<i class="fas fa-angle-right"></i>
								</div>
							</div>
						</div>
					</div>
					
					<c:forEach var="vo" items="${list}">
						<c:if test="${not empty vo.filename }">
							<a href="menuContent?id=${vo.id }">
								<img style=
								"width: 300px; height: auto;" src="/resources/files/${vo.filename }" />
							</a>
							<br>
						</c:if>
						<c:out value="${vo.name }" />
						<br>
						<c:out value="${vo.price }" />
						
						<div class="num">
						    <span>수량</span>
						    <div class="quantity">
						      <button class="minus">-</button>
						      <span id="result">1</span>
						      <button class="plus">+</button>
						      <button id="confirm">확인</button>
				       </div>
						    <br><br>
						    
						  </div>
						
						

						
						
					</c:forEach>
					
					

<script>

	/* 수량 증감, 감소 */

    let plus = document.querySelector(".plus");
	let minus = document.querySelector(".minus");
	let result = document.querySelector("#result");
	let totalcost = document.querySelector('.totalcost');
	let i = 1;
	plus.addEventListener("click", () => {
		i++
		result.textContent = i;
	})
	
	minus.addEventListener("click", () => {
		if(i>1) {
			i--
			result.textContent = i;
		}
		
	})
</script>

					

<%@ include file="/resources/include/footer.jsp"%>