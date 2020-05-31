
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="../css/reset.css">
<link rel="stylesheet" href="../css/board/review/layout.css">
<link rel="stylesheet" href="../css/board/review/review-detail.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<!-- <link
	href="https://fonts.googleapis.com/css2?family=Lobster+Two:ital,wght@0,400;0,700;1,400;1,700&display=swap"
	rel="stylesheet"> -->
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

		<section class="detail">

			<h1 class="d-none">디테일</h1>

			<div class="mini-title-box">
				<a href="list" class="mini-title">후기게시판 전체목록</a>
			</div>
			<div class="title-box">
				<div class="title fnt_jua">${r.title }</div>

			</div>

			<div class="perface-box detail-margin-top">제조사-품명 : ${r.item }</div>

			<div class="star-grade detail-margin-top">
				평점 : ${r.gradeTitle } <span class="star">${r.star }</span>
				[${r.starGrade }점]
			</div>

			<div class="meta-box detail-margin-top">
				<div class="meta-info">
					<div class="regdate">
						<fmt:parseDate var="date" value="${r.regdate}"
							pattern="yyyy-MM-dd HH:mm" />
						<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm" />
					</div>
					<div class="writer-name">${r.writerName }</div>
				</div>
				<div class="meta-info">
					<div class="hit">조회수 ${r.hit }</div>
					<div class="comment">댓글 ${r.comment }</div>
					<div class="love"><span class="love-img">♥</span> ${r.likes }</div>
				</div>
			</div>

			<!-- <div class="title-box detail-margin-top">
                <input class="title-text" type="text" placeholder="제목" value="제목이랍니다" readonly required>
            </div> -->

			<div class="content-box detail-margin-top">
				<div class="content">${r.content }</div>
			</div>

			<form action="" method="POST">
				<div class="btn-box">
					<input type="button" class="btn-text love-btn" value="공감♡"></input>
				</div>
			</form>

			<div class="btn-box">
				<div class="btn-box_box">
					<a class="btn-text btn-cancel btn-hover" href="list">이전 목록</a> <a
						class="btn-text btn-default btn-hover" href="edit?id=${r.id }">수정</a>
					<a class="btn-text btn-default btn-hover" href="del?id=${r.id }">삭제</a>
				</div>
			</div>

		</section>



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


<%-- <!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/detail-review-style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
    <link href="https://fonts.googleapis.com/css2?family=Lobster+Two:ital,wght@0,400;0,700;1,400;1,700&display=swap"
        rel="stylesheet">
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

        <section class="detail">
            <h1 class="d-none">디테일</h1>

            <div class="detail-title fnt_jua">${r.title }</div>

            <div class="perface detail-margin-top">
                제조사-품명 : ${r.item }
            </div>

            <div class="star-grade detail-margin-top">
                 평점 : <c:choose>
         <c:when test = "${r.starGrade==1}">
            집에 있어도 안먹음  
         </c:when>
         <c:when test = "${r.starGrade== 2}">
            내 돈주고 먹지는 않음
         </c:when>
          <c:when test = "${r.starGrade==3}">
            내 돈주고 사먹을만 함
         </c:when>
          <c:when test = "${r.starGrade== 4}">
            맛있어서 가끔 생각남
         </c:when>
           <c:otherwise>
            집에 쌓아놓고 먹고싶음 
         </c:otherwise>
       
      </c:choose>
       ${r.star }
            </div>

            <div class="title-box detail-margin-top">
                <input class="title-text" type="text" placeholder="제목" value="${r.title }" readonly required>
            </div>

            <div class="content-box detail-margin-top">
                <div class="content">${r.content }
                </div>
            </div>


            <div class="btn-box">
                <div class="btn-box_box">
                    <a class="btn-text btn-cancel" href="list">목록</a>
                    <a class="btn-text btn-default" href="edit?id=${r.id }">수정</a>
                    <a class="btn-text btn-default" href="del">삭제</a>
                </div>
            </div>

        </section>



        <!-- *************************************** -->

    </main>

</body>

</html> --%>


<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/add-review-style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
    <link href="https://fonts.googleapis.com/css2?family=Lobster+Two:ital,wght@0,400;0,700;1,400;1,700&display=swap" rel="stylesheet">
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
            
            <div class="sub-header-title">${r.title }</div>
         

            <div class="margin-top first">
                <h3 class="d-none">공지사항 내용</h3>
                <table class="table">
                    <tbody>
                      
                        <tr>
                            <th>작성일</th>
                            <td class="text-align-left text-indent" colspan="3">${r.regdate} </td>
                        </tr>
                        <tr>
                            <th>작성자</th>
                            <td>${r.writerName }</td>
                            <th>조회수</th>
                            <td>${r.hit }</td>
                        </tr>
                
                        <tr class="content">
                            <td colspan="4">
                         	${r.content }
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>

            <div class="margin-top text-align-center">
                <a class="btn-text btn-cancel" href="list">목록</a>
                <a class="btn-text btn-default" href="edit?id=${r.id}">수정</a>
                <a class="btn-text btn-default" href="del?id=${r.id }">삭제</a>
            </div>
               
        </nav>

        <!-- *************************************** -->
       


        
    </main>

</body>

</html> --%>