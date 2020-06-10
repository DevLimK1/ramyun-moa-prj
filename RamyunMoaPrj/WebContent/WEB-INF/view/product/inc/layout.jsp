<!-- prod/layout/list -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>

<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/css/reset.css" type="text/css">

<link rel="stylesheet" href="/css/product/list/style.css" type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<script src="https://kit.fontawesome.com/096073a2a8.js"
	crossorigin="anonymous"></script>
<script src="/js/main.js"></script>
<script type="text/javascript" src="/js/member/member.js"></script>
<title>라면모아 - 국내 최대 라면 커뮤니티</title>
</head>

<body>

	<tiles:insertAttribute name="header" />

	<tiles:insertAttribute name="main" />

	<tiles:insertAttribute name="footer" />

	<script src="/js/product/list.js"></script>

</body>

</html>