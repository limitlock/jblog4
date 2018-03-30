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
			<c:import url="/WEB-INF/views/includes/blog_header.jsp"/>
		</div>
		<div id="wrapper">
			<div id="content" class="full-screen">
			<c:import url="/WEB-INF/views/includes/admin-menu.jsp">
				<c:param name="menu" value="basic"/>
			</c:import>
				<form action="${pageContext.servletContext.contextPath }/${authUser.id }/admin/basic" method="post" enctype="multipart/form-data" >
						<table class="admin-config">
			      		<tr>
			      			<td class="t">블로그 제목</td>
			      			<td><input type="text" size="40" name="title" value=""></td>
			      		</tr>
			      		<tr>
			      			<td class="t">로고이미지</td>
							<c:forEach items="${list }" var ="vo">
								<td><img src="${pageContext.request.contextPath}${vo.logo }"></td>
							</c:forEach>  			
			      		</tr>      		
			      		<tr>
			      			<td class="t"></td>
			      			<td><input type="file" name="logo"></td>      			
			      		</tr>           		
			      		<tr>
			      			<td class="t"></td>
			      			<td class="s"><input type="submit" value="기본설정 변경"></td>      			
			      		</tr>           		
			      	</table>
				</form>
			</div>
		</div>
		<div id="footer">
			<p>
				<strong>Spring 이야기</strong> is powered by JBlog (c)2016
			</p>
		</div>
	</div>
</body>
</html>