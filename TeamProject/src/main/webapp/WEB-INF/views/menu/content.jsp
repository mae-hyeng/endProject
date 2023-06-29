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
					    <div class="quantity">
					      <button class="minus">-</button>
					      <span id="result">1</span>
					      <button class="plus">+</button>
					   
					      <form action="/cart">
					      	<button id="confirm">확인</button>
					      </form>
					      
					      
			       		</div>
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
	function modi() {
		  const modibtn = document.getElementById('modibtn');
		  const username = '<%= session.getAttribute("username") %>';
	
		  if (username !== 'admin') {
		    modibtn.style.display = 'none';
		  }
	
		  // 버튼 클릭 시 실행할 동작 추가
		  location.href = 'modifyMenu?id=${menu.id}';
		}

</script>

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


<script>
   function listnum(){
      if(${sessionScope.listnum} == '1'){
         history.go(-1);
         return;
      }else if(${sessionScope.listnum} == '2'){
         history.go(-2);
      }else if(${sessionScope.listnum} == '3'){   
         history.go(-3);
      }
   }
</script>
				

<%@ include file="/resources/include/footer.jsp"%>