<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/board/review/layout.css">
<link rel="stylesheet" href="css/board/review/review-list.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<!-- <link
	href="https://fonts.googleapis.com/css2?family=Lobster+Two:ital,wght@0,400;0,700;1,400;1,700&display=swap"
	rel="stylesheet"> -->
</head>

<body>

	<!-- ************** header ************** -->
	<header class="rm-header">
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
	</header>
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
							<label class="d-none" for="">검색분류</label> <select name=""
								class="select">
								<option value="">제목</option>
								<option value="">작성자</option>
								<option value="">내용</option>
							</select> <label class="d-none" for="">검색어</label> <input type="text">
							<input type="submit" value="검색">

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
				<a href="reg"><i class="fas fa-edit"></i></a>
			</div>

 			<c:forEach var="list" items="${list}">
			<div class="review-list-box">

				<div class="review-list-box_group">
					<a class="fnt_sunflower" href="#">${list.item}</a>
				</div>

				<div class="review-list-box_vote">
					<!-- <i class="far fa-thumbs-up"></i> -->
					<div class="star">${list.star }
					</div>
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
						<fmt:parseDate var="date" value="${list.regdate}" pattern="yyyy-MM-dd HH:mm"/>
						<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm"/></div>
						<div class="review-list-box-meta_author">${list.writerName }</div>
					</div>
				</div>


			</div>
			</c:forEach>

		
		</section>



	</main>

</body>

</html>