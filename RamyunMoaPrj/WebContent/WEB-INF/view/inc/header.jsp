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
  
            <!-- 빈 세션일 경우 -->
            <c:if test="${sessionScope.uid==null}">
               <li class="member"><a href="/member/login" onclick="login()">로그인</a></li><span>|</span>
               <li class="member"><a href="/member/member-term" onclick="regist()">회원가입</a></li>
               <li class="member"><a href="/notice/list">고객센터</a></li>
            </c:if>

        	<!-- 로그시 일반 회원 헤더 -->
            <c:if test="${sessionScope.uid!=null && sessionScope.roleId!=7}">
               <li class="member"><a href="/member/mypage" >내정보</a></li><span>|</span>
               <li class="member"><a onclick="logout()" style="cursor:pointer;">로그아웃</a></li>
               <li class="member"><a href="/notice/list">고객센터</a></li>
            </c:if>
  
            <!-- 로그인시 관리자 헤더/ RoleId 7은 관리자 -->
            <c:if test="${sessionScope.roleId==7}">
               <li class="member"><a href="/admin/board/main" >관리자페이지</a></li><span>|</span>
               <li class="member"><a onclick="logout()" style="cursor:pointer;">로그아웃</a></li>
            </c:if>
  
         </ul>
      </div>
   </nav>
</header>