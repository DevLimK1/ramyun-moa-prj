<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<section class="notice-review">
	<h1 class="hidden">신고 관리</h1>
	<div class="container">
		<div class="title">신고 관리</div>

		<div class="container-table">
			<div class="top-btn">
				<div>
					<input type="date" name="startDate"> <input type="date"
						name="endDate">
				</div>
				<div class="search-btn flex">
					<select name="field" id="">
						<option value="">제목</option>
						<option value="">내용</option>
						<option value="">작성자</option>
					</select> <input type="text" name="search" placeholder=""> <input
						type="button" value="검색">
				</div>
			</div>
			<table class="notice-table">
				<thead>
					<tr>
						<td>No.</td>
						<td>제목</td>
						<td>작성자</td>
						<td>작성일</td>
						<td>조회수</td>
						<td>삭제</td>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="l" items="${list}">
						<tr>
							<td>${l.id}</td>
							<td><a href="">${l.title}</a></td>
							<td>${l.nickname}</td>
							<td>${l.regdate}</td>
							<td>${l.hit}</td>
							<td><input type="checkbox" name=""></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>

			<c:set var="page" value="${(empty param.p)?1:param.p}" />
			<c:set var="startNum" value="${page-(page-1)%5}" />
			<c:set var="lastNum"
				value="${fn:substringBefore(Math.ceil(count/10),'.')}" />

			<div class="bottom-btn">
				<div class="list">
					<div class="current">${page}</div>
					<div>/</div>
					<div>${lastNum}</div>
				</div>
				<div class="del-btn">
	<input type="button" value="삭제" name="">
				</div>
			</div>
		</div>
		<div class="pager">

			<c:choose>
				<c:when test="${startNum>1}">
					<a href="notice?m=${param.m}&p=${startNum-5}&s=${param.s}"> <i
						class="fas fa-arrow-circle-left fa-2x"></i>
					</a>
				</c:when>
				<c:otherwise>
					<i class="fas fa-arrow-circle-left fa-2x"
						onclick="alert('이전 페이지가 없습니다.');"></i>
				</c:otherwise>
			</c:choose>

			<ul class="flex">
				<c:forEach begin="0" end="4" var="i">
					<c:if test="${startNum+i<=lastNum}">
						<li><a class="${(page==startNum+i)?'current':''}"
							href="notice?m=${param.m}&p=${startNum+i}&s=${param.s}">${startNum+i}</a>
						</li>
					</c:if>
				</c:forEach>
			</ul>

			<c:choose>
				<c:when test="${startNum+4<lastNum}">
					<a href="notice?m=${param.m}&p=${startNum+5}&s=${param.s}"> <i
						class="fas a-arrow-circle-right fa-2x"></i>
					</a>
				</c:when>
				<c:otherwise>
					<i class="fas fa-arrow-circle-right fa-2x"
						onclick="alert('다음 페이지가 없습니다.');"></i>
				</c:otherwise>
			</c:choose>

		</div>
	</div>
</section>