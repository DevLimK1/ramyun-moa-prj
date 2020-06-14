<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header class="header">
	<nav class="navbar">
		<div class="navbar-logo">
			<a href="/main">라 면 모 아</a>
		</div>
		<div class="navbar-bottom">
			<ul class="navbar-menu">
				<li><a href="/product/list">라면 소개</a> <span>|</span></li>
				<li><a href="/review/list">후기 게시판</a> <span>|</span></li>
				<li><a href="/discussion/list">라면 토론장</a> <span>|</span></li>
				<li><a href="/recipe/list">레시피 공유</a></li>
			</ul>
			<ul class="navbar-member">
				<c:if test="${sessionScope.uid==null}">
					<li class="member"><a href="/member/login" onclick="login()">로그인</a></li><span>|</span>
					<li class="member"><a href="/member/member-term" onclick="regist()">회원가입</a></li>
					<li class="member"><a href="/notice/list">고객센터</a></li>
				</c:if>

			<!-- 로그인 됐을경우  내정보 / 로그아웃 표시 -->
				<c:if test="${sessionScope.uid!=null && sessionScope.uid!='admin' }">
					<li class="member"><a href="/member/mypage" >내정보</a></li><span>|</span>
					<li class="member"><a onclick="logout()">로그아웃</a></li>
					<li class="member"><a href="/notice/list">고객센터</a></li>
				</c:if>
				<!-- 관리자 로그인   로그아웃 -->
				<c:if test="${sessionScope.uid=='admin'}">
					<li class="member"><a href="/admin/board/main" >관리자페이지</a></li><span>|</span>
					<li class="member"><a onclick="logout()">로그아웃</a></li>
				</c:if>
			</ul>
		</div>
	</nav>
</header>