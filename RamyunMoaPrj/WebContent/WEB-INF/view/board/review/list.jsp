<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


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
						<a class="fnt_sunflower" href="#">${list.mfcProduct}</a>
					</div>

					<div class="review-list-box_vote">
						<!-- <i class="far fa-thumbs-up"></i> -->
						<div class="star">
							<c:choose>
								<c:when test="${list.gradeId==1}">★☆☆☆☆</c:when>
								<c:when test="${list.gradeId==2}">★★☆☆☆</c:when>
								<c:when test="${list.gradeId==3}">★★★☆☆</c:when>
								<c:when test="${list.gradeId==4}">★★★★☆</c:when>
								<c:when test="${list.gradeId==5}">★★★★★</c:when>
							</c:choose>
						</div>
					</div>

					<div class="review-list-box_content">

						<div class="review-list-box_title">
							<div class="span-title">
								<a class="review-title" href="detail?id=${list.id}">${list.title}</a>
							</div>

							<span class="review-comment">[${list.cmtCount}]</span>
						</div>


						<div class="review-list-box-meta">
							<div class="review-list-box-meta_regdate">
								${list.regdate}
								<%-- 	<fmt:parseDate var="date" value="${list.regdate}"
										pattern="yyyy-MM-dd HH:mm" />
									<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm" /> --%>
								<%-- <fmt:formatDate value="${list.regdate}" pattern="yyyy-MM-dd HH:mm" /> --%>
							</div>
							<div class="review-list-box-meta_author">${list.nickname }</div>
						</div>
					</div>


				</div>
			</c:forEach>
		</div>

	</section>

	<c:set var="page" value="${ (empty param.p) ? 1:param.p }" />
	<c:set var="startNum" value="${page-(page-1)%5 }" />
	<!--ex)page: 23 -> 23 - (23-1)%5 = 21~25 -->
	<c:set var="lastNum"
		value="${fn:substringBefore(Math.ceil(count/10),'.')}" />

	<div class="indexer-box">
		<h1 class="d-none">현재 페이지</h1>
		<div>
			<span class="index-num">${(empty param.p)? 1:param.p}</span>/${lastNum }
			pages
		</div>
	</div>


	<div class="pager-box">
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
				<c:if test="${(startNum+i) <= lastNum }">
					<li class="pager-item"><a
						class="pager-num ${(page==(startNum+i)) ? 'orange' : ''  }"
						href="?p=${startNum+i}&f=${param.f }&q=${param.q}">${startNum+i}</a></li>
				</c:if>
			</c:forEach>
		</ul>

		<div class="next-box">
			<c:if test="${startNum+5<=lastNum }">
				<a class="next" href="?p=${startNum+5}&f=${param.f }&q=${param.q}"><i
					class="fas fa-angle-right"></i></a>
			</c:if>
			<c:if test="${startNum+5>=lastNum }">
				<i class="fas fa-angle-right" onclick="alert('다음 페이지가 없습니다.')"></i>
			</c:if>
		</div>

	</div>
	<!-- --------------js--------------- -->
	<script type="text/javascript" src="../js/utils.js"></script>
	<script type="text/javascript" src="../js/board/review/list.js"></script>
</main>

