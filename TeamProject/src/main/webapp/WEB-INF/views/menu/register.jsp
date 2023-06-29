<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/resources/include/h2.jsp"%>

<script type="text/javascript">
const route = window.location.pathname.replace('/','');
</script>

<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>

<%
if (session.getAttribute("username") == null) {
	response.sendRedirect("/adminSessionover");
}
%>
<style>
div#px-6 {
	width: 1200px;
	height: 600px;
	margin-top: 100px;
	margin-left: 200px;
}

.writer_info1 {
	display: none;
	margin-right: 6px;
	font-weight: 700;
}
</style>
</head>
<body class="sb-nav-fixed">
	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<nav class="sb-sidenav accordion sb-sidenav-dark"
				id="sidenavAccordion">
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
						<div class="sb-sidenav-menu-heading">
							<c:choose>
								<c:when test="${sessionScope.username!=null}">
									<span style="color: white; font-size: 15px;">${sessionScope.username }</span>
								</c:when>
							</c:choose>
						</div>
						<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
							data-bs-target="#collapsePages" aria-expanded="false"
							aria-controls="collapsePages">
							<div class="sb-nav-link-icon">
								<i class="fas fa-book-open"></i>
							</div> 멤버
							<div class="sb-sidenav-collapse-arrow">
								<i class="fas fa-angle-down"></i>
							</div>
						</a>
						<div class="collapse" id="collapsePages"
							aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav accordion"
								id="sidenavAccordionPages">
								<nav class="sb-sidenav-menu-nested nav">
									<c:choose>
										<c:when test="${sessionScope.username==null}">
											<a class="nav-link" href="adminLogin">로그인</a>
										</c:when>
									</c:choose>
									<a class="nav-link" href="mypage">마이페이지 이동</a> <a
										class="nav-link" href="update">내 정보변경</a> <a class="nav-link"
										href="pwupdate">비밀번호 변경</a> <a class="nav-link" href="logout">로그아웃</a>
								</nav>
							</nav>
						</div>
					</div>
				</div>
			</nav>
		</div>
		<div id="layoutSidenav_content">
			<main>
				<form class="menuRegister" method="POST" action="/menuSave"
					enctype="multipart/form-data">
					<div id="px-6">
						<h2 class="mt-4" style="text-align: center;">게시글 작성</h2>
						<ol class="breadcrumb mb-4">
							<li class="breadcrumb-item active"></li>
						</ol>

						<div class="row">
							<div class="row-col-xl-1">
								<div class="card mb-4">
									<div class="card-header">
										<h3 class="left-box"></h3>
									</div>
									<div class="card-body">
										메뉴명 : <input type="text" name="name" id="name" required>
										<hr>
										작성자 : <input type="text" name="writer" id="writer"
											value="${sessionScope.username }" readonly>
										<hr>
										상품 구분 : <select id="type" name="type" required>
											<option value="">=선택=</option>
											<option value="COFFEE">COFFEE</option>
											<option value="MILK TEA & LATTE">MILKTEA & LATTE</option>
											<option value="JUICE & DRINK">JUICE & DRINK</option>
											<option value="SMOOTHIE">SMOOTHIE</option>
											<option value="TEA & ADE">TEA & ADE</option>
											<option value="BREAD">BREAD</option>
											<option value="DESSERT">DESSERT</option>
											<option value="MD">MD</option>
										</select>
										<hr>
										가격 : <input type="text" name="price" id="price" required>
										<hr>
										<input type="file" name="file" id="file">
										<hr>
										내용 : <br>
										<div class="text_box">
											<textarea name="content" id="content"
												placeholder="내용을 입력해주세요." class="text" style="resize: none;"
												cols="150px;" rows="5px;" required></textarea>
											<div class="count">
												<span>0</span>/500
											</div>
											<br>
										</div>
										<div class="button">
												<br> 
													<input type="submit" style="float: right" value="등록"> 
													<input type="button" style="float: right" value="목록" onclick="history.go(-1); return false;">
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</form>
				
				
<script>
function listnum(){
	if(${sessionScope.listnum} == '1'){
		history.go(-1);
		return;
	}else if(${sessionScope.listnum} == '2'){
		history.go(-2);
	}else if(${sessionScope.listnum} == '3'){   
		history.go(-3);
	}else if(${sessionScope.listnum} == null){
		location.href="board?page="+"${param.page}"+"&keyword="+"${param.keyword }";
	}
}   

</script>

<script>
	$('.text_box textarea').keyup(function(){
		var content = $(this).val();
	$('.text_box .count span').html(content.length);
		if (content.length > 500){
		alert("최대 500자까지 입력 가능합니다.");
	$(this).val(content.substring(0, 500));
	$('.text_box .count span').html(500);
		}
	});
</script>

<script>
	function menuRegister(){
		var ok;
		ok = confirm("게시글을 등록하시겠습니까?");
		
		if(ok){
			document.getElementById('registerOk').submit();
		} else {
			return false;
		}
	}
</script>

<script>
   function listnum(){
      if(${sessionScope.listnum} == '1'){
         history.go(-1);
         return;
      }else if(${sessionScope.listnum} == '2'){
         history.go(-2);
      }else if(${sessionScope.listnum} == '3'){   
         history.go(-2);
      }
   }
</script>

</main>
<%@ include file="/resources/include/footer.jsp"%>