<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<!-- <link rel="stylesheet" href="../css/reset.css"> -->
<link rel="stylesheet" href="../css/board/review/layout.css">
<!-- <link rel="stylesheet" href="../css/board/review/review-list.css"> -->
<!-- <link rel="stylesheet" href="../css/board/review/review-reg.css"> -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<!-- <link
	href="https://fonts.googleapis.com/css2?family=Lobster+Two:ital,wght@0,400;0,700;1,400;1,700&display=swap"
	rel="stylesheet"> -->
<script type="text/javascript" src="../js/utils.js"></script>
<script type="text/javascript" src="../js/review/list.js"></script>
</head>

<body>

	<!-- ************** header ************** -->
	<header class="header">
		<div class="box">
			<nav class="navbar flex">
				<div class="navbar-logo flex">
					<a href="/main">라면모아</a>
				</div>
				<ul class="navbar-menu flex">
					<li><a href="">라면 소개</a></li>
					<li><a href="list">후기 게시판</a></li>
					<li><a href="">라면 토론장</a></li>
					<li><a href="">레시피 공유</a></li>
				</ul>
				<ul class="navbar-member flex">
					<li><a class="member-first " href="">로그인</a></li>
					<li><a class="member-first " href="">회원가입</a></li>
					<li><a class="member-second " href="">고객센터</a></li>
				</ul>
			</nav>
		</div>
	</header>
	<!-- <header class="rm-header">
		<h1 class="d-none">라면모아 헤더</h1>
		<ul class="rm-menu-top">
			<li><a href="">라면 모아</a></li>
			<li><a href="">로그인</a></li>
			<li><a href="">회원가입</a></li>
			<li><a href="">고객센터</a></li>
		</ul>
		<ul class="rm-menu-bottom">
			<li><a href="">#공지사항</a></li>
			<li><a href="">라면 소개</a></li>
			<li><a href="">후기 게시판</a></li>
			<li><a href="">레시피 공유</a></li>
			<li><a href="">라면 토론장</a></li>
		</ul>
	</header> -->
	<!-- ************** 게시판  main ************** -->
	<main id="main">

		<nav class="sub-header">
			<h1 class="d-none">서브 헤더</h1>

			<div class="sub-header-title">후기 게시판</div>


			<section class="sub-link">
				<h1 class="d-none">서브링크</h1>

				<ul class="sub-link-list">
					<li class="sub-link-item"><a href=""><i class="fas fa-sun"></i>최근순</a></li>
					<li class="sub-link-item"><a href=""><i
							class="fas fa-fire-alt"></i>인기</a></li>
					<li class="sub-link-item"><a href=""><i
							class="fas fa-crown"></i>TOP</a></li>
					<li class="sub-link-item"><a href=""><i
							class="fas fa-filter"></i>라면별 후기</a></li>
				</ul>

				<section class="sub-link-search">
					<h1 class="d-none">서브링크 검색폼</h1>
					<form class="sub-link-search-form">
						<fieldset>
							<legend class="d-none">서브링크 검색필드</legend>
							<label class="d-none" for="">검색분류</label> <select name="f"
								class="select">
								<option ${param.f=="title" ? "selected" : "" } value="title">제목</option>
								<option ${param.f=="writerName" ? "selected" : "" }
									value="writerName">작성자</option>
								<option ${param.f=="content" ? "selected" : "" } value="content">내용</option>
							</select> <label class="d-none" for="">검색어</label> <input type="text"
								name="q" value="${param.q }"> <input type="submit"
								value="검색">

						</fieldset>
					</form>

				</section>
			</section>


		</nav>

		<!-- *************************************** -->
		<section class="review-board">
			<h1 class="d-none">리뷰게시판 목록</h1>

			<!-- 글쓰기 -->
			<div class="write-btn">
				<a href="reg" class="reg-btn"><i class="fas fa-edit"></i></a>
			</div>

			<div class="review-board-box">
				<c:forEach var="list" items="${list}">
					<div class="review-list-box">

						<div class="review-list-box_group">
							<a class="fnt_sunflower" href="#">${list.item}</a>
						</div>

						<div class="review-list-box_vote">
							<!-- <i class="far fa-thumbs-up"></i> -->
							<div class="star">${list.star }</div>
						</div>

						<div class="review-list-box_content">

							<div class="review-list-box_title">
								<div class="span-title">
									<a class="title" href="detail?id=${list.id}">${list.title }</a>
								</div>

								<span class="comment">[${list.comment}]</span>
							</div>


							<div class="review-list-box-meta">
								<div class="review-list-box-meta_regdate">
									${list.regdate }
									<%-- 	<fmt:parseDate var="date" value="${list.regdate}"
										pattern="yyyy-MM-dd HH:mm" />
									<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm" /> --%>
									<%-- <fmt:formatDate value="${list.regdate}" pattern="yyyy-MM-dd HH:mm" /> --%>
								</div>
								<div class="review-list-box-meta_author">${list.writerName }</div>
							</div>
						</div>


					</div>
				</c:forEach>
			</div>

		</section>

		<div class="pager-box">

			<c:set var="page" value="${ (empty param.p) ? 1:param.p }" />
			<c:set var="startNum" value="${page-(page-1)%5 }" />
			<!--ex)page: 23 -> 23 - (23-1)%5 = 21~25 -->
			<c:set var="lastNum" value="23" />

			<div class="prev-box">
				<c:if test="${startNum-1>0 }">
					<a class="prev" href="?p=${startNum-1}&f=${param.f }&q=${param.q}"><i
						class="fas fa-angle-left"></i></a>
				</c:if>
				<c:if test="${startNum-1<=0 }">
					<i class="fas fa-angle-left" onclick="alert('이전 페이지가 없습니다.')"></i>
				</c:if>
			</div>


			<ul class="pager">
				<c:forEach var="i" begin="0" end="4">
					<li class="pager-item">
					<a class="pager-num ${(page==(startNum+i)) ? 'orange' : ''  }" href="?p=${startNum+i}&f=${param.f }&q=${param.q}">${startNum+i}</a></li>
				</c:forEach>
			</ul>

			<div class="next-box">
				<c:if test="${startNum+5<lastNum }">
					<a class="next" href="?p=${startNum+5}&f=${param.f }&q=${param.q}"><i
						class="fas fa-angle-right"></i></a>
				</c:if>
				<c:if test="${startNum+5>=lastNum }">
					<i class="fas fa-angle-right" onclick="alert('다음 페이지가 없습니다.')"></i>	
				</c:if>
			</div>

		</div>
	</main>

	<!-- --------------footer--------------- -->
	<footer class="footer">
		<div class="box flex">
			<ul class="foot-list">
				<li><a class="privacy" href="">개인정보 처리방침</a></li>
				<li><a href="">라면모아 소개</a></li>
				<li><a href="">고객센터</a></li>
				<li><a href="">처음이세요?</a></li>
				<li><a href="">제휴</a></li>
			</ul>
			<div class="foot-info">
				<ul class="info-list">
					<li>라면모아</li>
					<li>라면모아 이메일 :</li>
					<li>라면모아 팀 :</li>
					<li>고객센터 전화번호</li>
				</ul>
				<p class="copy">Copyright 2020. RamyunMoa All rights reserved.</p>
			</div>
			<ul class="foot-sns">
				<i class="fab fa-facebook"></i>
				<i class="fab fa-instagram"></i>
				<i class="fab fa-youtube"></i>
			</ul>
		</div>
	</footer>

</body>

</html>