<!-- prod/list -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<main id="body">

	<h1 class="hidden">Body</h1>

	<div id="container">

		<section class="noodle-list">
			<h1 class="hidden">noodle-list</h1>

			<nav class="noodle-list-category">
				<h1 class="hidden">notice-list-category</h1>
				<ul>
					<li><a href="list-data?m=&p=1&s=${param.s}">전체</a></li>
					<li><a href="list-data?m=농심&p=1&s=${param.s}">농심</a></li>
					<li><a href="list-data?m=삼양&p=1&s=${param.s}">삼양</a></li>
					<li><a href="list-data?m=오뚜기&p=1&s=${param.s}">오뚜기</a></li>
					<li><a href="list-data?m=팔도&p=1&s=${param.s}">팔도</a></li>
					<li><a href="list-data?m=PB&p=1&s=${param.s}">PB</a></li>
					<li>
						<form action="list" method="get">
							<input class="search" type="text" name="s" value="${param.s}"
								placeholder="검색"> <input type="submit" value="&#xf002">
						</form>
					</li>
					<li><label>컵라면</label> <input type="checkbox"></li>
				</ul>
			</nav>

			<c:set var="page" value="${(empty param.p)?1:param.p}" />
			<c:set var="lastNum" value="${fn: substringBefore(count/20+1,'.')}" />

			<section class="noodle-img">
				<h1 class="hidden">noodle-image</h1>
				<div class="noodle-list-img">

					<c:forEach var="l" items="${list}">

						<div class="item">
							<div class="item-img">
								<img class="rm-img list" src="${l.img}" value="${l.id}">
							</div>
							<div class="item-name">
								<span>${l.name}</span>
							</div>
							<div class="review-link">
								<div>
									<a href=""> <i class="far fa-comment-dots"></i> <span>${999}</span>
									</a>
								</div>
								<div>
									<a href=""> <i class="far fa-heart"></i> <span>${999}</span>
									</a>
								</div>
							</div>
						</div>

					</c:forEach>
				</div>
			</section>

			<section class="pager">
				<h1 class="hidden">pager</h1>

				<ul>
					<c:forEach begin="1" end="${lastNum}" var="i">
						<li><a href="list-data?m=${param.m}&p=${i}&s=${param.s}">${i}</a>
						</li>
					</c:forEach>
				</ul>


			</section>
		</section>

		<section class="noodle-ranking">
			<h1 class="hidden">noodle-ranking</h1>

			<div class="ranking-menu">
				<div>
					<span class="table-title">Ranking</span>
					<div class="table-sub-left">
						<span>(2019년 3분기 매출액 - 단위:백만원)</span>
					</div>
				</div>

				<div class="radio">
					<div>
						<label for="">판매량</label> <input type="radio" name="ranking"
							value="sales">
					</div>
					<div>
						<label for="">좋아요</label> <input type="radio" name="ranking"
							value="likes">
					</div>
				</div>
			</div>

			<table class="noodle-ranking-table">

				<c:forEach var="r" items="${rankingList}" varStatus="rankingList">
					<tr>
						<td class="cell-rank">${rankingList.index+1}</td>
						<td class="cell-rank">(-)</td>
						<td class="cell-img"><img class="rm-img ranking"
							src="${r.img}" value="${r.id}"></td>
						<td><fmt:formatNumber value="${r.sales}" type="number" /></td>
						<td class="value"><a href="">★★★☆☆</td>
						<td><a href=""><i class="fas fa-heart"
								style="color: #ff3575"></i><br /></a>${999}</a></td>
						<td><img class="logo-img" src="${r.logo}" alt=""></td>
					</tr>
				</c:forEach>

			</table>

			<div class="table-sub-right">

				<span>(판매량 출처: FIS 식품산업통계정보)</span>

			</div>
		</section>

	</div>

</main>