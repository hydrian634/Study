
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메뉴목록 ${test}</h1>
	<ul>
		<c:forEach var="m" items="${list}">
			<li><a href="detail?id=${m.id}">${m.korName}</a>(${m.engName})</li>
		</c:forEach>
	</ul>
</body>
</html>

