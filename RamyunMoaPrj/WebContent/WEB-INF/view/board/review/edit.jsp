<!--200524 edit.html->edit.jsp  -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- ************** 게시판  main ************** -->
<main id="main">

	<section class="edit">

		<h1 class="d-none">수정</h1>

		<div class="mini-title-box">
			<a href="list" class="mini-title">후기게시판 전체목록</a>
		</div>

		<form action="" class="sub-link-search-form">

			<div class="title-box detail-margin-top">
				<!-- <div class="title fnt_jua">라면은 정말맛있어 정말맛있어요!!</div> -->
				<input class="title" name="title" type="text"
					placeholder="제목을 입력하세요." value="${r.title }" required>
			</div>

			<fieldset class="perface-field">
				<legend class="d-none">서브링크 검색필드</legend>
				<label class="" for="">제조사-라면:</label> <input style="width: 350px;"
					placeholder="입력하시면 더 빨리 찾을 수 있어요 :)" type="text" name="mfc-product"
					list="product" required="required" value="${r.mfcProduct }">
				<datalist id="product">
					<c:forEach var="mpv" items="${mpv}">
						<option value="${mpv.mfcProduct}"></option>
						<%-- <input type="hidden" name="mpvId" value="${mpv.id}"> --%>
					</c:forEach>
				</datalist>
			</fieldset>



			<%-- 	<fieldset class="perface-field detail-margin-top">
				<legend class="d-none">서브링크 검색필드</legend>
				<label class="" for="">제조사-라면</label> <select name="item"
					class="select">
					<!-- 나중에 제조사-라면 데이터베이스 해결하면 적용시킬 코드  -->
					<c:forEach var="list" items="${list}" varStatus="status">
							<option value="${list.item }" ${list.item==r.item ? "selected" : ""}>${list.item }</option>
						</c:forEach>
					<option value="오뚜기-진라면" ${r.item == "오뚜기-진라면" ? "selected" : "" }>오뚜기-진라면</option>
					<option value="오뚜기-굴진짬뽕" ${r.item == "오뚜기-굴진짬뽕" ? "selected" : "" }>오뚜기-굴진짬뽕</option>
					<option value="삼양-간짬뽕" ${r.item == "삼양-간짬뽕" ? "selected" : "" }>삼양-간짬뽕</option>
				</select>
			</fieldset> --%>

			<fieldset class="grade-field">
				<legend class="d-none">평점필드</legend>
				<label class="" for="">평점:</label> <select name="grade"
					class="select star-grade-select">
					<c:forEach var="grade" items="${grade}">
						<option value="${grade.id}" ${grade.id == r.gradeId ? "selected" : ""}>${grade.content}
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

			</fieldset>

			<%-- 		<fieldset class="grade-field detail-margin-top">
				<legend class="d-none">평점필드</legend>
				<label class="" for="">평점</label> <select name="star-grade"
					class="select">
					<option value="1" ${r.starGrade == 1 ? "selected" : "" }>집에
						있어도 안먹음 ★☆☆☆☆</option>
					<option value="2" ${r.starGrade == 2 ? "selected" : "" }>내
						돈주고 먹지는 않음 ★★☆☆☆</option>
					<option value="3" ${r.starGrade == 3 ? "selected" : "" }>내
						돈주고 사먹을만 함 ★★★☆☆</option>
					<option value="4" ${r.starGrade == 4 ? "selected" : "" }>맛있어서
						가끔 생각남 ★★★★☆</option>
					<option value="5" ${r.starGrade == 5 ? "selected" : "" }>집에
						쌓아놓고 먹고싶음 ★★★★★</option>
				</select>

			</fieldset> --%>

			<div class="meta-box detail-margin-top">
				<div class="meta-info">
					<div class="regdate">${r.regdate }</div>
					<div class="writer-name">${r.writerName}</div>
				</div>
				<div class="meta-info">
					<div class="hit">조회수 ${r.hit }</div>
					<div class="comment">댓글 ${r.cmtCount }</div>
					<div class="love">♥ ${r.likes }</div>
				</div>
			</div>

			<!-- <div class="title-box detail-margin-top">
                <input class="title-text" type="text" placeholder="제목" value="제목이랍니다" readonly required>
            </div> -->


		<div class="content-box">
					<div class="toolbar">
						<button class="btn-bold"><i class="fas fa-bold"></i></button>
						<button class="btn-italic"><i class="fas fa-italic"></i></button>
						<button class="btn-underline"><i class="fas fa-underline"></i></button>
						<button class="btn-img"><i class="far fa-image"></i></button>
						<input multiple="multiple" type="file" class="d-none btn-file">
					</div>
					<div class="content-area" data-placeholder="내용을 입력해주세요." contenteditable="true">${r.content }</div>
					<!-- <textarea class="content" placeholder="내용을 입력하세요." name="content"
						required></textarea> -->
				</div>

			<%-- <div class="content-box">
				<textarea class="content" placeholder="내용을 입력하세요." name="content"
					required>${r.content }</textarea>
			</div> --%>

			<!-- <form action="" method="POST">
				<div class="btn-box">
					<input type="button" class="btn-text love-btn" value="공감♡"></input>
				</div>
			</form> -->

			<div class="btn-box">
				<div class="btn-box_box">
					<input type="hidden" name="id" value="${r.id }" /> <input
						class="btn-text btn-save btn-hover" type="submit" value="저장" /> <a
						class="btn-text btn-cancel btn-hover" href="detail?id=${r.id}">취소</a>
				</div>
			</div>

		</form>

	</section>



	<!-- *************************************** -->

</main>
<script type="text/javascript" src="/js/board/review/reg.js"></script>


<%-- 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/edit-review-style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<link
	href="https://fonts.googleapis.com/css2?family=Lobster+Two:ital,wght@0,400;0,700;1,400;1,700&display=swap"
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

		<section class="edit">
			<h1 class="d-none">수정</h1>

			      <div class="detail-title fnt_jua">${r.title }</div>
			<form action="edit" method="POST" class="edit-form">

				<fieldset class="perface-field">
					<legend class="d-none">서브링크 검색필드</legend>
					<label class="" for="">제조사-라면</label> <select name="item"
						class="select">
						<option value="오뚜기-진라면">오뚜기-진라면</option>
						<option value="오뚜기-굴진짬뽕">오뚜기-굴진짬뽕</option>
						<option value="삼양-간짬뽕">삼양-간짬뽕</option>
					</select>


				</fieldset>

				<fieldset class="grade-field">
					<legend class="d-none">평점필드</legend>
					<label class="" for="">평점</label> <select name="edit-margin-top star-grade"
						class="select">
						<option value="1">집에 있어도 안먹음 ★☆☆☆☆</option>
						<option value="2">내 돈주고 먹지는 않음 ★★☆☆☆</option>
						<option value="3" selected>내 돈주고 사먹을만 함 ★★★☆☆</option>
						<option value="4">맛있어서 가끔 생각남 ★★★★☆</option>
						<option value="5">집에 쌓아놓고 먹고싶음 ★★★★★</option>
					</select>

				</fieldset>

				<div class="title-box edit-margin-top">
					<input class="title" type="text" placeholder="제목"
						value="${r.title }" required>
				</div>

				<div class="content-box edit-margin-top">
					<textarea class="content" placeholder="내용을 입력하세요. " name="content"
						required>${r.content }</textarea>
				</div>


				<div class="btn-box">
					<div class="btn-box_box">
						<a class="btn-text btn-cancel" href="list">목록</a> <a
							class="btn-text btn-default" href="edit?id=${r.id }">수정</a> <a
							class="btn-text btn-default" href="del">삭제</a>
					</div>
				</div>
				 <div class="margin-top text-align-center">
                    <input type="hidden" name="id" value="${r.id }" /> <input
                        class="btn-text btn-default" type="submit" value="저장" /> <a
                        class="btn-text btn-cancel" href="detail?id=${r.id }">취소</a>
                </div>
			</form>
		</section>



		<!-- *************************************** -->

	</main>

</body>

</html>


<%@ page language="java" contentType="text/html; charset=UTF-8"
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

</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
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
        	<form action="edit" method="post" >
                <div class="margin-top first">
                    <h3 class="d-none">공지사항 수정</h3>
                    <table class="table">
                        <tbody>
                            <tr>
                                <th>제목</th>
                                <td class="text-align-left text-indent text-strong text-orange"
                                    colspan="3"><input type="text" name="title"
                                    value="${r.title}" /></td>
                            </tr>
                            <tr>
                                <th>작성일</th>
                                <td class="text-align-left text-indent" colspan="3">${r.regdate}
                                </td>
                            </tr>
                            <tr>
                                <th>작성자</th>
                                <td>${r.writerName }</td>
                                <th>조회수</th>
                                <td>${r.hit}</td>
                            </tr>
                            <!-- <tr>
                             <th>첨부파일</th>
                             <td colspan="3"><input type="file" name="file" /> </td>
                          </tr> -->
                            <tr class="content">
                                <td colspan="4"><textarea class="content" name="content">
                                ${r.content }
                                </textarea></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
        
                <div class="margin-top text-align-center">
                    <input type="hidden" name="id" value="${r.id }" /> <input
                        class="btn-text btn-default" type="submit" value="저장" /> <a
                        class="btn-text btn-cancel" href="detail?id=${r.id }">취소</a>
                </div>
            </form>
           
        </nav>

        <!-- *************************************** -->
       


        
    </main>

</body>

</html> --%>