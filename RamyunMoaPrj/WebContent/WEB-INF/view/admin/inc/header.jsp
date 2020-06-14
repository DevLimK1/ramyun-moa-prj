<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<header>
	<div class="top-header">
		<div class="top-home">RmAdmin</div>
		<select name="search-sc">
			<option value="user-name">이름</option>
			<option value="user-id">아이디</option>
			<option value="user-nickname">닉네임</option>
			<option value="user-cellphone">휴대폰</option>
			<option value="user-email">이메일</option>
			<option value="rm-name">제품명</option>
			<option value="notice-tit">게시글 제목</option>
		</select> <input type="text" name="search-input" placeholder="빠른 검색">
		<ul class="top-header-list">
			<li><a href="">메모</a></li>
			<li><a href="">메뉴얼</a></li>
			<li><a href="">설문조사</a></li>
			<li><a href="">라면모아홈</a></li>
			<li><a href="">로그인</a></li>
		</ul>
	</div>
	<div class="bottom-header">
		<ul class="admin-menu">
			<li><a href=""> <i class="fas fa-th"></i>기본설정
			</a></li>
			<li><a href="/admin/product/main"> <i class="fas fa-boxes"></i>제품관리
			</a></li>
			<li><a href=""> <i class="fas fa-users"></i>회원관리
			</a></li>
			<li><a href="/admin/board/main"> <i
					class="fas fa-clipboard-list"></i>게시판관리
			</a></li>
			<li><a href="/admin/board/notice/list"> <i class="fas fa-headset"></i>고객센터
			</a></li>
			<li><a href=""> RM 게시판 </a></li>
		</ul>
	</div>
</header>