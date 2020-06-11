<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<section class="contents">

	<h1 class="hidden">상품페이지</h1>
	<div class="title">Product Main</div>

	<div class="search">
		<div>
			<label for="mfr">제조사</label> <input type="checkbox">
		</div>
		<div>
			<label for="cup">컵라면</label> <input type="checkbox">
		</div>
		<div>
			<input type="text"> <input type="submit" value="검색"
				placeholder="${param.s}">
		</div>
	</div>

	<table class="item-table" border="1">
		<thead>
			<tr>
				<td colspan="2">TITLE</td>
				<td colspan="6" class="line">CONTENT</td>
				<td class="line">BUTTON</td>
			</tr>
		</thead>
		<tbody>
			<tr class="label">
				<td rowspan="4">
					<div class="regImg">
						<img src="" alt="">
					</div>
				</td>
				<td rowspan="2">품명</td>
				<td class="line">용량</td>
				<td>나트륨</td>
				<td>탄수화물</td>
				<td>당류</td>
				<td>지방</td>
				<td>제조사</td>
				<td class="line" rowspan="4"><input type="submit" value="등록">
				</td>
			</tr>
			<tr class="inputs">
				<td class="line"><input type="text" name="name" id="">g</td>
				<td><input type="text" name="capacity" id="">g</td>
				<td><input type="text" name="natrium" id="">g</td>
				<td><input type="text" name="carbohydrate" id="">g</td>
				<td><input type="text" name="sugars" id="">g</td>
				<td><select name="mfr" id="">
						<option value="">농심</option>
						<option value="">삼양</option>
						<option value="">오뚜기</option>
						<option value="">팔도</option>
						<option value="">CU</option>
						<option value="">GS25</option>
						<option value="">세븐일레븐</option>
				</select></td>
			</tr>
			<tr class="label">
				<td rowspan="2"><input class="input-title" type="text"
					name="capacity" id=""></td>
				<td class="line">열량</td>
				<td>트랜스지방</td>
				<td>포화지방</td>
				<td>콜레스테롤</td>
				<td>단백질</td>
				<td>판매량</td>
			</tr>
			<tr class="inputs">
				<td class="line"><input type="text" name="" id="">kcal
				</td>
				<td><input type="text" name="transfat" id="">g</td>
				<td><input type="text" name="saturatedFat" id="">g</td>
				<td><input type="text" name="cholesterol" id="">g</td>
				<td><input type="text" name="protein" id="">g</td>
				<td><input type="text" name="amount" id="">
					<div class="select">
						<select name="year" id="">
							<option value="">2019</option>
							<option value="">2020</option>
							<option value="">2021</option>
							<option value="">2022</option>
							<option value="">2023</option>
						</select> <select name="quarter" id="">
							<option value="">1분기</option>
							<option value="">2분기</option>
							<option value="">3분기</option>
							<option value="">4분기</option>
						</select>
					</div></td>
			</tr>
		</tbody>
	</table>

	<table class="item-table" border="1">
		<thead>
			<tr>
				<td colspan="2">TITLE</td>
				<td colspan="14" class="line">CONTENT</td>
				<td class="line">BUTTON</td>
			</tr>
		</thead>
		<tbody>
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
				<td class="line" rowspan="2"><a href=""> <i
						class="far fa-edit fa-2x"></i>
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
		</tbody>
	</table>


	<table class="item-table" border="1">
		<thead>
			<tr>
				<td colspan="2">TITLE</td>
				<td colspan="14" class="line">CONTENT</td>
				<td class="line">BUTTON</td>
			</tr>
		</thead>
		<tbody>
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
				<td class="line" rowspan="2"><a href=""> <i
						class="fas fa-trash-alt fa-2x"></i>
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

		</tbody>
	</table>

	<section class="pager">
		<h1 class="hidden">pager</h1>

		<c:set var="page" value="${(empty param.p)?1:param.p}" />
		<c:set var="startNum" value="${page-(page-1)%5}" />
		<c:set var="lastNum" value="${fn: substringBefore(count/5+1,'.')}" />

		<a href="update?m=${param.m}&p=${page-1>=1?page-1:1}&s=${param.s}">
			<i class="fas fa-arrow-circle-left"></i>
		</a>

		<ul>
			<c:forEach begin="0" end="4" var="i">
				<li><a href="update?m=${param.m}&p=${startNum+i}&s=${param.s}">${startNum+i}</a>
				</li>
			</c:forEach>
		</ul>

		<a
			href="update?m=${param.m}&p=${(page+1<=lastNum)?page+1:lastNum}&s=${param.s}">
			<i class="fas fa-arrow-circle-right"></i>
		</a>

	</section>

</section>