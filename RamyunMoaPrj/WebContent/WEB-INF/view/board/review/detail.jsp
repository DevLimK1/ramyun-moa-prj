
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!-- 200604 detail.html -> jsp -->
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
				<div class="detail-regdate">
					<fmt:parseDate var="date" value="${r.regdate}"
						pattern="yyyy-MM-dd HH:mm" />
					<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm" />
				</div>
				<div class="writer-name">${r.writerName }</div>
			</div>
			<div class="meta-info">
				<div class="hit">조회수 ${r.hit }</div>
				<div class="comment">댓글 ${r.comment }</div>
				<div class="love">
					<span class="love-img">♥</span> ${r.likes }
				</div>
			</div>
		</div>

		<div class="content-box detail-margin-top">
			<div class="content">${r.content }</div>
		</div>

		<form action="" method="POST">
			<div class="btn-box">
				<!--<input type="button" class="btn-text love-btn" value="공감♡"></input>-->
				<button type="button" class="love-btn ">
					<span class="love-btn-txt">공감</span><i
						class="love-img far fa-heart"></i>
					<!--<i class="likes fas fa-heart"></i>-->
				</button>
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

</main>


<!-- ------------- comment ------------------ -->

<section id="comment">
	<h1 class="d-none">댓글</h1>

	<header class="comment-header">
		<div class="comment-header-info">
			<span class="comment-header-title">댓글</span> <span
				class="comment-header-cnt">총 150개</span>
		</div>
		<div class="comment-header-refresh">
			<i class="fas fa-sync"></i> <span class="refresh-txt">새로고침</span>
		</div>
	</header>

	<div class="comment-sort">
		<ul class="comment-sort-list">
			<li class="comment-sort-item">인기순</li>
			<li class="comment-sort-item">최신순</li>
		</ul>
		<div class="comment-sort-write">
			<i class="far fa-plus-square comment-sort-write-btn"></i>
			<span class="comment-write-txt comment-sort-write-btn">댓글쓰기</span>
		</div>
	</div>
	
	<form class="comment-form d-none" action="" method="post">
		<div class="comment-write-box">
			<div class="comment-likes">
				<button type="button" class="likes-btn">
					<i class="likes far fa-heart"></i>
					<!--<i class="likes fas fa-heart"></i>-->
				</button>
				<div class="likes-cnt">0</div>
			</div>
	
			<div class="comment-box_box">
				<div class="comment-meta-info">
					<a href="" class="comment-writer-name">id랍니다</a>
					<!-- <div class="regdate">2020-06-03 15:23:43</div> -->
				</div>
	
				<textarea class="comment-write-content" name="contents" placeholder="댓글을 입력해주세요." rows="" cols="" spellcheck="false"></textarea>
				<div class="comment-container">
					<ul class="comment-btn-list">
						<li class="comment-reg-item">
							<input type="submit" value="등록" class="comment-reg-btn btn-reset"/>
						</li>
						<li class="comment-reg-item margin-left">
							<a class="comment-cancel-btn">
								취소
							</a>
						</li>
					</ul>
					
					<div class="comment-write-count">
						<span class="comment-write-num">0</span>/<span>300</span>
					</div>
				</div>
			</div>
	
		</div>
	</form>

	<div class="comment-box">
		<div class="comment-likes">
			<button type="button" class="likes-btn">
				<i class="likes far fa-heart"></i>
				<!--<i class="likes fas fa-heart"></i>-->
			</button>
			<div class="likes-cnt">250</div>
		</div>

		<div class="comment-box_box">
			<div class="comment-meta-info">
				<a href="" class="user-id">id랍니다</a>
				<div class="regdate">2020-06-03 15:23:43</div>
			</div>

			<p class="comment-content">너구리라면이 원래 최애였는데,,
                진라면도 진짜 맛있죠,,
                공감됩니다!!
                너구리라면이 원래 최애였는데,,
                진라면도 진짜 맛있죠,,
                공감됩니다!!
                너구리라면이 원래 최애였는데,,
                진라면도 진짜 맛있죠,,
                공감됩니다!!
            </p>

			<ul class="comment-btn-list">
				<li class="comment-item">
					<button class="comment-item-btn btn-reset comment-report-btn">
						<img src="../../../../images/board/siren-2859791_640.png"
							width="16px" height="16px" alt="">신고
					</button>
				</li>
				<li class="comment-item">
					<button class="comment-item-btn btn-reset comment-write-btn">
						<i class="fas fa-comment-medical"></i>댓글 쓰기
					</button>
				</li>
			</ul>
		</div>

	</div>

	<div class="comment-box">
		<div class="comment-likes">
			<button type="button" class="likes-btn">
				<i class="likes far fa-heart"></i>
				<!--<i class="likes fas fa-heart"></i>-->
			</button>
			<div class="likes-cnt">250</div>
		</div>

		<div class="comment-box_box">
			<div class="comment-meta-info">
				<a href="" class="user-id">id랍니다</a>
				<div class="regdate">2020-06-03 15:23:43</div>
			</div>

			<p class="comment-content">넘나 맛있는 너구리한마리!!
			잡고가세요!!
			너구리라면이 원래 최애였는데,, 진라면도 진짜 맛있죠,,
				공감됩니다!!</p>

			<ul class="comment-btn-list">
				<li class="comment-item">
					<button class="comment-item-btn btn-reset comment-report-btn">
						<img src="../../../../images/board/siren-2859791_640.png"
							width="16px" height="16px" alt=""> 신고
					</button>
				</li>
				<li class="comment-item">
					<button class="comment-item-btn  comment-write-btn btn-reset">
						<i class="fas fa-comment-medical"></i>댓글 쓰기
					</button>
				</li>
			</ul>
		</div>

	</div>

	<div class="comment-box">
		<div class="comment-likes">
			<button type="button" class="likes-btn">
				<i class="likes far fa-heart"></i>
				<!--<i class="likes fas fa-heart"></i>-->
			</button>
			<div class="likes-cnt">250</div>
		</div>

		<div class="comment-box_box">
			<div class="comment-meta-info">
				<a href="" class="user-id">id랍니다</a>
				<div class="regdate">2020-06-03 15:23:43</div>
			</div>

			<p class="comment-content">너구리라면이 원래 최애였는데,, 진라면도 진짜 맛있죠,,
				공감됩니다!!</p>

			<ul class="comment-btn-list">
				<li class="comment-item">
					<button class="comment-item-btn btn-reset comment-report-btn">
						<img src="../../../../images/board/siren-2859791_640.png"
							width="16px" height="16px" alt=""> 신고
					</button>
				</li>
				<li class="comment-item">
					<button class="comment-item-btn comment-write-btn btn-reset">
						<i class="fas fa-comment-medical"></i>댓글 쓰기
					</button>
				</li>
			</ul>
		</div>

	</div>

</section>




<!-- ************** 게시판  main ************** -->
<!-- <main id="main">

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
				<div class="love">
					<span class="love-img">♥</span> ${r.likes }
				</div>
			</div>
		</div> -->

<!-- <div class="title-box detail-margin-top">
                <input class="title-text" type="text" placeholder="제목" value="제목이랍니다" readonly required>
            </div> -->

<!-- <div class="content-box detail-margin-top">
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

</main> -->

<!-- ------------------------------------ -->


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