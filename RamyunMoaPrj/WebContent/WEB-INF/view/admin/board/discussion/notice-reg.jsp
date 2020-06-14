<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/fmt"%>

<section class="notice-review">
	<h1 class="hidden">공지사항 등록</h1>
	<div class="container">
		<div class="title">공지사항 등록</div>


		<jsp:useBean id="now" class="java.util.Date" />
		<fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss"
			var="regdate" />
		<c:out value="${regdate}"/>


		<div class="container-table">

			<form action="notice-date" method="post">
				<table class="notice-table">
					<thead>
						<tr>
							<th>No.</th>
							<td></td>
						</tr>
						<tr>
							<th>작성일</th>
							<td></td>
						</tr>
						<tr>
							<th>작성자</th>
							<td>zzz</td>
						</tr>
						<tr>
							<th>제 목</th>
							<td><input type="text" name="" id=""></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td colspan="6"><textarea name="" id="" cols="30" rows="10"></textarea>
							</td>
						</tr>
					</tbody>
				</table>

				<div class="bottom-btn">
					<input type="submit" value="작성"> <a href="notice"><input
						type="button" value="취소"></a>
				</div>
			</form>
		</div>

	</div>
</section>