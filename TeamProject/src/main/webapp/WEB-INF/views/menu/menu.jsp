<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/resources/include/h2.jsp"%>
<script type="text/javascript">
	const route = window.location.pathname.replace('/', '');
</script>

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
						</div> 전체 게시판
					</a>
					<div class="sb-sidenav-menu-heading">WRITE</div>
					<a class="nav-link" href="/register">
						<div class="sb-nav-link-icon">
							<i class="fas fa-tachometer-alt"></i>
						</div> 게시글 작성
					</a>
					<div class="sb-sidenav-menu-heading">Genre</div>
					<a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
						<div class="sb-nav-link-icon">
							<i class="fas fa-columns"></i>
						</div> 장르
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
					<div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav">
							<a class="nav-link" href="/ro">로맨스</a> <a class="nav-link" href="/fa">판타지</a> <a class="nav-link" href="/co">코미디</a> <a class="nav-link" href="/act">액션</a> <a class="nav-link" href="/horror">공포</a>
						</nav>
					</div>
					<div class="sb-sidenav-menu-heading">
						<c:choose>
							<c:when test="${sessionScope.username!=null}">
								<span style="color: white; font-size: 15px;">${sessionScope.username } [ ${sessionScope.name } ]</span>
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
										<a class="nav-link" href="login">로그인</a>
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
							<div class="card-body">DRINK</div>
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
							<div class="card-body">DESSERT</div>
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
							<div class="card-body">MD</div>
							<div class="card-footer d-flex align-items-center justify-content-between">
								<a class="small text-white stretched-link" href="md"></a>
								<div class="small text-white">
									<i class="fas fa-angle-right"></i>
								</div>
							</div>
						</div>
					</div>
					<figure>
						<img src="resources/img/tea.jpg"
						style="width:250px; height:250px;" />
						<figcaption>자몽티</figcaption>
					</figure>


<%@ include file="/resources/include/footer.jsp"%>
