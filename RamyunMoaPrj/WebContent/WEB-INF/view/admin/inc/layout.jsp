<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>


<!DOCTYPE html>

<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>AdminPage</title>
<script src="https://kit.fontawesome.com/096073a2a8.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="/css/reset.css">
<link href="<tiles:getAsString name="css"/>" type="text/css"
	rel="stylesheet" />
<script src="/js/main.js"></script>
<script type="text/javascript" src="/js/member/member.js"></script>
</head>

<body>

	<!-- header -->

	<tiles:insertAttribute name="header" />

	<!-- main -->

	<tiles:insertAttribute name="main" />

	<!-- footer -->

	<tiles:insertAttribute name="footer" />


</body>

</html>