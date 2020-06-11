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

		<div class="perface-box detail-margin-top">제조사-품명 :
			${r.mfcProduct}</div>

		<div class="star-grade detail-margin-top">
			평점 : ${r.gdContent }
			 <span class="star"><c:choose>
					<c:when test="${r.gradeId==1}">★☆☆☆☆</c:when>
					<c:when test="${r.gradeId==2}">★★☆☆☆</c:when>
					<c:when test="${r.gradeId==3}">★★★☆☆</c:when>
					<c:when test="${r.gradeId==4}">★★★★☆</c:when>
					<c:when test="${r.gradeId==5}">★★★★★</c:when>
				</c:choose>
			</span>
			[${r.gradeId}점]
		</div>

		<div class="meta-box detail-margin-top">
			<div class="meta-info">
				<div class="detail-regdate">
					<%-- <fmt:parseDate var="date" value="${r.regdate}"
						pattern="yyyy-MM-dd HH:mm" /> --%>
					<fmt:formatDate value="${r.regdate}" pattern="yyyy-MM-dd HH:mm" />
				</div>
				<div class="writer-name">${r.nickname }</div>
			</div>
			<div class="meta-info">
				<div class="hit">조회수 ${r.hit }</div>
				<div class="comment">댓글 ${r.cmtCount}</div>
				<div class="love">
					<span class="love-img">♥</span> ${r.likes}
				</div>
			</div>
		</div>

		<div class="content-box detail-margin-top">
			<div class="content">${r.content}</div>
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
				class="comment-header-cnt">총 ${r.cmtCount}개</span>
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
			<span
				class="comment-write-txt comment-sort-write-btn">댓글쓰기</span>
		</div>
	</div>

	<form class="comment-form comment-first-form d-none" action="detail" method="post">
		<input class="review-detail-id" type="hidden" value="${param.id}">
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

				<textarea class="comment-write-content " name="content"
					placeholder="댓글을 입력해주세요." rows="" cols="" spellcheck="false" required="required"></textarea>
				<div class="comment-container">
					<ul class="comment-btn-list">
						<li class="comment-reg-item">
						<input type="submit" value="등록"
							class="comment-reg-btn comment-first btn-reset" /></li>
						<li class="comment-reg-item margin-left"><a
							class="comment-cancel-btn"> 취소 </a></li>
					</ul>

					<div class="comment-write-count">
						<span class="comment-write-num">0</span>/<span>300</span>
					</div>
				</div>
			</div>

		</div>
	</form>

	<c:forEach var="cmt" items="${cmt}">
	<div class="comment-box">
		<div class="comment-likes">
			<button type="button" class="likes-btn">
				<i class="likes far fa-heart"></i>
				<!--<i class="likes fas fa-heart"></i>-->
			</button>
			<div class="likes-cnt">${cmt.likes}</div>
		</div>

		<div class="comment-box_box">
			<div class="comment-meta-info">
				<a href="" class="user-id">${cmt.writerName }</a>
				<div class="regdate">${cmt.regdate}</div>
				<div class="update">
                        <div class="dots-box">
                            <i class="fas fa-ellipsis-v"></i>
                        </div>
                        <div class="update-box d-none">
                            <div class="update-edit"><span>수정</span></div>
                            <div class="update-delete"><span>삭제</span></div>
                        </div>
                    </div>
			</div>

			<p class="comment-content">${cmt.content}</p>

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
	        
	 <form class="comment-form d-none" action="detail" method="post">
	        <div class="comment-write-box second">
	            <div class="img-box">
	                <img src="../images/right-arrow-64x64.png" alt="">
	            </div>
	
	            <div class="comment-box_box">
	                <div class="comment-meta-info">
	                    <a href="" class="comment-writer-name">id랍니다</a>
	                    <!-- <div class="regdate">2020-06-03 15:23:43</div> -->
	                </div>
	
	                <textarea class="comment-write-content" name="content" placeholder="댓글을 입력해주세요." rows="" cols=""
	                    spellcheck="false" required="required"></textarea>
	                <div class="comment-container">
	                    <ul class="comment-btn-list">
	                        <li class="comment-reg-item"><input type="submit" value="등록"
	                                class="comment-reg-btn comment-second btn-reset" /></li>
	                        <li class="comment-reg-item margin-left"><a class="comment-cancel-btn"> 취소 </a></li>
	                    </ul>
	
	                    <div class="comment-write-count">
	                        <span class="comment-write-num">0</span>/<span>300</span>
	                    </div>
	                </div>
	            </div>
	
	        </div>
       </form>
	</c:forEach>
	
	
</section>

<%-- 
	<!-- <div class="comment-box">
		<div class="comment-likes">
			<button type="button" class="likes-btn">
				<i class="likes far fa-heart"></i>
				<i class="likes fas fa-heart"></i>
			</button>
			<div class="likes-cnt">250</div>
		</div>

		<div class="comment-box_box">
			<div class="comment-meta-info">
				<a href="" class="user-id">id랍니다</a>
				<div class="regdate">2020-06-03 15:23:43</div>
			</div>

			<p class="comment-content">넘나 맛있는 너구리한마리!! 잡고가세요!! 너구리라면이 원래
				최애였는데,, 진라면도 진짜 맛있죠,, 공감됩니다!!</p>

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

	<div class="comment-box">
		<div class="comment-likes">
			<button type="button" class="likes-btn">
				<i class="likes far fa-heart"></i>
				<i class="likes fas fa-heart"></i>
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

	</div> --> --%>





<%-- 
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
--%>