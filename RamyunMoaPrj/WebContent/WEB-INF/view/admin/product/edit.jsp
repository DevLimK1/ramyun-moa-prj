<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<section class="contents">

	<h1 class="hidden">상품페이지</h1>
	<div class="title">Update</div>

	<form action="update" method="get">
		<div class="search">
			<div>
				<label>전체</label> <input type="radio" name="m" value=""> <label>농심</label>
				<input type="radio" name="m" value="농심"> <label>삼양</label> <input
					type="radio" name="m" value="삼양"> <label>오뚜기</label> <input
					type="radio" name="m" value="오뚜기"> <label>팔도</label> <input
					type="radio" name="m" value="팔도"> <label>CU</label> <input
					type="radio" name="m" value="cu"> <label>GS25</label> <input
					type="radio" name="m" value="gs25">
			</div>
			<div>
				<label>컵라면</label> <input type="checkbox" name="c" value="컵">
			</div>
			<div>
				<input type="text" name="s" value="${param.s}"
					placeholder="${param.s}"> <input type="submit" value="검색">
			</div>
		</div>
	</form>

	<table class="item-table" border="1">
		<thead>
			<tr>
				<td colspan="2">TITLE</td>
				<td colspan="14" class="line">CONTENT</td>
				<td class="line">BUTTON</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="l" items="${list}">
				<tr class="label">
					<td rowspan="2"><img src="${l.img}"></td>
					<td>${l.name}</td>
					<td class="line fixed">용량</td>
					<td class="line">${l.capacity}</td>
					<td class="fixed">나트륨</td>
					<td>${l.natrium}</td>
					<td class="fixed">탄수화물</td>
					<td>${l.carbohydrate}</td>
					<td class="fixed">당류</td>
					<td>${l.sugars}</td>
					<td class="fixed">지방</td>
					<td>${l.fat}</td>
					<td class="fixed">Likes</td>
					<td>?</td>
					<td class="fixed">제조사</td>
					<td>${l.mfr}</td>
					<td class="line" rowspan="2"><a href="update?id=${l.id}">
					<i class="fas fa-pen-alt fa-2x"></i>
					</a></td>
				</tr>
				<tr class="label">
					<td class="fixed">${l.id}</td>
					<td class="line fixed">열량</td>
					<td class="line">${l.kcal}</td>
					<td class="fixed">트랜스지방</td>
					<td>${l.transfat}</td>
					<td class="fixed">포화지방</td>
					<td>${l.saturatedFat}</td>
					<td class="fixed">콜레스테롤</td>
					<td>${l.cholesterol}</td>
					<td class="fixed">단백질</td>
					<td>${l.protein}</td>
					<td class="fixed">Review</td>
					<td>?</td>
					<td class="fixed">판매량</td>
					<td>${l.amount}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

	<c:set var="page" value="${(empty param.p)?1:param.p}" />
	<c:set var="startNum" value="${page-(page-1)%5}" />
	<c:set var="lastNum"
		value="${fn:substringBefore(Math.ceil(count/10),'.')}" />

	<div class="list">
		<div class="current">${page}</div>
		<div>/</div>
		<div>${lastNum}</div>
		<div>pages</div>
	</div>

	<div class="pager">
		<c:choose>
			<c:when test="${startNum>1}">
				<a href="update?m=${param.m}&p=${startNum-5}&s=${param.s}"> <i
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
						href="update?m=${param.m}&p=${startNum+i}&s=${param.s}">${startNum+i}</a>
					</li>
				</c:if>
			</c:forEach>
		</ul>

		<c:choose>
			<c:when test="${startNum+4<lastNum}">
				<a href="update?m=${param.m}&p=${startNum+5}&s=${param.s}"> <i
					class="fas a-arrow-circle-right fa-2x"></i>
				</a>
			</c:when>
			<c:otherwise>
				<i class="fas fa-arrow-circle-right fa-2x"
					onclick="alert('다음 페이지가 없습니다.');"></i>
			</c:otherwise>
		</c:choose>
	</div>

</section>
