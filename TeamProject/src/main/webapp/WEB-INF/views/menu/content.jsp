<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/resources/include/h2.jsp"%>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<script type="text/javascript">
	const route = window.location.pathname.replace('/', '');
</script>
<script type="text/javascript">
	const wrap = document.referrer;
</script>
<head>
<style>
.textareas{
    overflow:hidden;
    height:auto;
    }

.min-width {
	width: 1080px;
	margin: 0 auto;
	margin-top: 60px;
	margin-bottom: 50px;
}

.left-box {
	float: left;
}

.writer_info {
	margin-right: 6px;
	font-size: 13px;
	font-weight: 700;
}

.se-section-text.se-l-default .se-text-paragraph {
	line-height: 1.8;
	white-space: break-spaces;
}

.CommentWriter {
	margin: 12px 0 29px;
	padding: 16px 10px 10px 18px;
	border: 2px solid var(- -skinCommentWriterBorder);
	border-radius: 6px;
	box-sizing: border-box;
	background: var(- -skinCommentWriterBg);
}

.CommentWriter textarea {
	height: auto; /* 내용의 길이에 따라 자동으로 높이 조정 */
	resize: none; /* 사용자가 크기를 조정할 수 없도록 함 */
	overflow: auto; /* 내용이 넘칠 경우 스크롤바 생성 */
}

.my-box {
	border: 1px solid;
	padding: 10px;
	width: auto;
	margin: 12px 0 29px;
	padding: 16px 10px 10px 18px;
	border-radius: 6px;
	box-sizing: border-box;
	overflow: auto
}

.right-box {
	float: right;
}

.comment_inbox_text {
	overflow-x: hidden;
	overflow-y: auto;
	display: block;
	width: 100%;
	min-height: 17px;
	padding-right: 1px;
	border: 0;
	font-size: 13px;
	-webkit-appearance: none;
	resize: none;
	box-sizing: border-box;
	background: transparent;
	color: var(- -skinTextColor);
	outline: 0;
}

.comment_info_date {
	margin-right: 8px;
}

.rounded-box {
	border-radius: 10px;
	border: 1px solid #ccc;
	padding: 10px;
	position: relative;
}

.rounded-box .comment-btn {
	margin: 10px;
	position: absolute;
	float: right;
	bottom: 7px;
}

.register_box .button {
	display: inline-block;
	min-width: 46px;
	height: 34px;
	line-height: 36px;
	font-size: 13px;
	color: #b7b7b7;
	border-radius: 6px;
	box-sizing: border-box;
	font-weight: 700;
	text-align: center;
	vertical-align: top;
}

.modify-btn {
	background-color: gray;
	color: #fff;
	border: none;
	border-radius: 10px;
}

.comment-btn {
	background-color: gray;
	color: #fff;
	border: none;
	border-radius: 10px;
}

.delete-btn {
	background-color: gray;
	color: #fff;
	border: none;
	border-radius: 10px;
}

.list-btn {
	background-color: gray;
	color: #fff;
	border: none;
	border-radius: 10px;
}

.modi-btn {
	background-color: gray;
	color: #fff;
	border: none;
	border-radius: 10px;
}

.mt-6 {
	margin-top: 0.5rem !important;
	margin-bottom: 0.8rem;
}

.scroll::-webkit-scrollbar {
	display: none;
}
</style>


</head>

<body class="">
	<div id="layoutSidenav">

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
						<div class="sb-sidenav-menu-heading">DRINK</div>
						<a class="nav-link" href="/drink">
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
											<a class="nav-link" href="aaminLogin">로그인</a>
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

		<div id="layoutSidenav_content" style="bottom: 56px;">

			<main class="min-width">
				
				
				<a style="font-size: 50px">${menu.type}</a>
				<br><br>		
				<h2>${menu.name }</h2>
				<br>
					<c:if test="${not empty menu.filename }">
						<img style="width: 300px; height: auto;" src="/resources/files/${menu.filename }">
						<br>
					</c:if>
					<pre>${menu.content }</pre>
					<div class="num">
					    <span>수량</span>
						<form name="regForm" id="regForm" action="drinkOrder" method="post">
						    <div class="quantity" id="quantity">
						        <button class="minus" type="button">-</button>
						        <span id="result">1</span>
						        <button class="plus" type="button">+</button>
						        <br>
						        <a>금액 : </a><span id ="price">${menu.price }</span>
						    </div>
						    
						    <input type="hidden" id="menuId" name="id" value="${menu.id}">
						    <input type="hidden" id="menuQuantity" name="quantity" value="1">
						    <input type="hidden" id="menuName" name ="menuName" value=${menu.name }>						    
						    <input type="button" id="confirm" onclick="go()" value = "담기">
						</form>
			       	</div>
				
					
				<br>
				<div><input style="float:right; padding:6px 8px" type="button" class="list-btn" value="목록" onclick="listnum()"></div>
                <div>
  					 <%
					    String username = (String) session.getAttribute("username");
					    String displayStyle = (username != null && username.equals("admin")) ? "block" : "none";
					  %>
  					 <button style="float: right; margin-right: 7px; padding: 6px 8px; display: <%= displayStyle %>" class="modi-btn" id="modibtn" onclick="modi()">수정</button>
				</div>
				
			</main>			

<script>
function go() {
	regForm.submit();
}
</script>




<script>
    const plusBtn = document.querySelector('.plus');
    const minusBtn = document.querySelector('.minus');
    const resultSpan = document.querySelector('#result');
    const priceSpan = document.querySelector('#price');
    
    const resultValue = parseInt(resultSpan.textContent);
    const priceValue = parseInt(priceSpan.textContent);
    
    const menuQuantityInput = document.querySelector('#menuQuantity');
    
    plusBtn.addEventListener('click', () => {
        let quantity = parseInt(resultSpan.textContent);
        quantity++;
        resultSpan.textContent = quantity;
        menuQuantityInput.value = quantity;
        priceSpan.textContent = quantity*priceValue;
    });
    
    minusBtn.addEventListener('click', () => {
        let quantity = parseInt(resultSpan.textContent);
        if (quantity > 1) {
            quantity--;
            resultSpan.textContent = quantity;
            menuQuantityInput.value = quantity;
            priceSpan.textContent = quantity*priceValue;
        }
    });
</script>

<script>
    document.addEventListener('DOMContentLoaded', function() {
        const modibtn = document.getElementById('modibtn');
        const username = '<%= session.getAttribute("username") %>';
        
        if (username !== 'admin') {
            modibtn.style.display = 'none';
        }
        
        modibtn.addEventListener('click', function() {
            location.href = 'modifyMenu?id=${menu.id}';
        });
    });
    
    
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
				
				

<%@ include file="/resources/include/footer.jsp"%>