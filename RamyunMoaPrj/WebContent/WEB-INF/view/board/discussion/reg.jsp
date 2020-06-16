<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- ************** 게시판  main ************** -->
<main id="main">

	<nav class="sub-header">
		<h1 class="d-none">서브 헤더</h1>

		<div class="sub-header-title">토론주제 등록하기</div>


		<section class="reg-box">
			<h1 class="d-none">서브링크</h1>


<!-- 			<form action="reg" method="POST" class="sub-link-search-form"> -->
<form action=""  class="sub-link-search-form">
				<input type="hidden" name="writerId" value="${member.id}">
				<div class="reg-writerName">
					작성자: <span class="writerName-txt">${member.nickname}</span>
				</div>

				<fieldset class="perface-field">
					<legend class="d-none">서브링크 검색필드</legend>
					<label class="" for="">제조사-라면:</label> <input style="width: 350px;"
						placeholder="입력하시면 더 빨리 찾을 수 있어요 :)" type="text"
						name="topic" list="topic" required="required">
					<datalist id="topic">
						<c:forEach var="topic" items="${topic}">
							<option value="${topic.title}"></option>
							<%-- <input type="hidden" name="mpvId" value="${mpv.id}"> --%>
						</c:forEach>
					</datalist>
				</fieldset>

		<%-- 		<fieldset class="grade-field">
					<legend class="d-none">평점필드</legend>
					<label class="" for="">평점:</label> <select name="grade"
						class="select star-grade-select">
						<c:forEach var="grade" items="${grade}">
							<option value="${grade.id}" ${grade.id==3 ? "selected" : ""}>${grade.content}
								<c:choose>
									<c:when test="${grade.value==1}">★☆☆☆☆</c:when>
									<c:when test="${grade.value==2}">★★☆☆☆</c:when>
									<c:when test="${grade.value==3}">★★★☆☆</c:when>
									<c:when test="${grade.value==4}">★★★★☆</c:when>
									<c:when test="${grade.value==5}">★★★★★</c:when>
								</c:choose>
							</option>
						</c:forEach>
						<!-- <option value="1">집에 있어도 안먹음 ★☆☆☆☆</option>
						<option value="2">내 돈주고 먹지는 않음 ★★☆☆☆</option>
						<option value="3" selected>내 돈주고 사먹을만 함 ★★★☆☆</option>
						<option value="4">맛있어서 가끔 생각남 ★★★★☆</option>
						<option value="5">집에 쌓아놓고 먹고싶음 ★★★★★</option> -->
					</select>

				</fieldset> --%>


				<div class="title-box">
					<input class="title" name="title" type="text"
						placeholder="제목을 입력하세요." required>
				</div>

				<div class="content-box">
					<div class="toolbar">
						<button class="btn-bold"><i class="fas fa-bold"></i></button>
						<button class="btn-italic"><i class="fas fa-italic"></i></button>
						<button class="btn-underline"><i class="fas fa-underline"></i></button>
						<select name="set_headingSize">
							<option value="1">제목1</option>
							<option value="2">제목2</option>
							<option value="3">제목3</option>
							<option value="4">본문1</option>
							<option value="5">본문2</option>
							<option value="6">본문3</option>
						</select>
						<button class="btn-img"><i class="far fa-image"></i></button>			
						<input multiple="multiple" type="file" class="d-none btn-file">
					</div>
					<div class="content-area" data-placeholder="내용을 입력해주세요." contenteditable="true"></div>
					<!-- <textarea class="content" placeholder="내용을 입력하세요." name="content"
						required></textarea> -->
				</div>

				<div class="btn-box">
					<div class="btn-box_box">
						<input class="btn-text btn-default btn-submit" type="submit" value="등록" /> <a
							class="btn-text btn-cancel" href="list">취소 </a>
					</div>
				</div>

			</form>

		</section>


	</nav>

	<!-- *************************************** -->
	<!-- --------------js--------------- -->
	<script type="text/javascript" src="../js/utils.js"></script>
	<script type="text/javascript" src="../js/board/discussion/list.js"></script>
	<script type="text/javascript" src="../js/board/discussion/reg.js"></script>
</main>
