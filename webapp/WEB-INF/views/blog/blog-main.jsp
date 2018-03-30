<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div id="container">
		<div id="header">
		<c:forEach items="${list }" var ="vo">
			<h1>${vo.title }</h1>
		</c:forEach>
		<c:import url="/WEB-INF/views/includes/blog_header.jsp">
			<c:param name="blog_id" value="basic"/>
		</c:import>
		</div>
		<div id="wrapper">
			<div id="content">
				<div class="blog-content">
					<c:forEach items="${post }" var ="vo">
					<h4>${vo.title }</h4>
					<p>
						${vo.content }
					</p>
					</c:forEach>
				</div>
				
				<ul class="blog-list">
				<c:forEach items="${postList }" var ="vo">
					<li><a href="${pageContext.request.contextPath}/${vo.id}/view?categoryNo=${vo.categoryNo}&postNo=${vo.no}">${vo.title }</a><span>${vo.regDate }</span></li>
				</c:forEach>
				</ul>
			
			</div>
		</div>
		<div id="extra">
			<c:forEach items="${list }" var ="vo">
				<div class="blog-logo">
					<img src="${pageContext.request.contextPath}${vo.logo }">
				</div>
			</c:forEach>
		</div>
		<div id="navigation">
			<h2>카테고리</h2>
			
			<ul>
			<c:forEach items="${categoryList }" var ="vo">
				<li><a href="${pageContext.request.contextPath}/${vo.id}/listview?categoryNo=${vo.no }">${vo.name }</a></li>
				</c:forEach>
			</ul>
			
		</div>
		
		<div id="footer">
			<p>
				<strong>Spring 이야기</strong> is powered by JBlog (c)2016
			</p>
		</div>
	</div>
</body>
</html>