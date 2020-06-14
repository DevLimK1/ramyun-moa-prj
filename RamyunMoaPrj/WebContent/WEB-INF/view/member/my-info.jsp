<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main id="mypage-main">
	<section class="main-section">
		<h1 class="d-none">마이페이지</h1>
		<div class="mypage-context">
		<form action="my-info" method="post">
			<ul>
				<li>내 정보</li>
				<li>닉네임 : ${m.nickName }</li>
				<li>회원등급 : ${r.name }</li>
				<li>이메일 : ${m.email }</li>
				<li>가입일 : ${m.regdate }</li>
			</ul>
			</form>
		</div>
	</section>
</main>