<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="../css/reset.css">
<link rel="stylesheet" href="../css/board/review/layout.css">
<link rel="stylesheet" href="../css/board/review/review-reg.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<link
	href="https://fonts.googleapis.com/css2?family=Lobster+Two:ital,wght@0,400;0,700;1,400;1,700&display=swap"
	rel="stylesheet">
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
	<!-- ************** 게시판  main ************** -->
	<main id="main">

		<nav class="sub-header">
			<h1 class="d-none">서브 헤더</h1>

			<div class="sub-header-title">후기 등록하기</div>


			<section class="reg-box">
				<h1 class="d-none">서브링크</h1>


				<form action="reg" method="POST" class="sub-link-search-form">

					<fieldset class="perface-field">
						<legend class="d-none">서브링크 검색필드</legend>
						<label class="" for="">제조사-라면</label> <select name="item"
							class="select">
							<option value="오뚜기-진라면">오뚜기-진라면</option>
							<option value="오뚜기-굴진짬뽕">오뚜기-굴진짬뽕</option>
							<option value="삼양-간짬뽕">삼양-간짬뽕</option>
						</select>


					</fieldset>

					<fieldset class="grade-field">
						<legend class="d-none">평점필드</legend>
						<label class="" for="">평점</label> <select name="star-grade"
							class="select">
							<option value="1">집에 있어도 안먹음 ★☆☆☆☆</option>
							<option value="2">내 돈주고 먹지는 않음 ★★☆☆☆</option>
							<option value="3" selected>내 돈주고 사먹을만 함 ★★★☆☆</option>
							<option value="4">맛있어서 가끔 생각남 ★★★★☆</option>
							<option value="5">집에 쌓아놓고 먹고싶음 ★★★★★</option>
						</select>

					</fieldset>


					<div class="title-box">
						<input class="title" name="title" type="text"
							placeholder="제목을 입력하세요." required>
					</div>

					<div class="content-box">
						<textarea class="content" placeholder="내용을 입력하세요. " name="content"
							required></textarea>
					</div>

					<div class="btn-box">
						<div class="btn-box_box">
							<input class="btn-text btn-default" type="submit" value="등록" />
							<a class="btn-text btn-cancel" href="list">취소 </a>
						</div>
					</div>

				</form>

			</section>


		</nav>

		<!-- *************************************** -->

	</main>

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