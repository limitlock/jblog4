<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<ul class="admin-menu">
	<c:choose>
			<c:when test='${param.menu == "category" }'>
			<li><a href="${pageContext.servletContext.contextPath }/${authUser.id }/admin/basic">�⺻����</a></li>
			<li class="selected">ī�װ�</li>
			<li><a href="${pageContext.servletContext.contextPath }/${authUser.id }/admin/write">���ۼ�</a></li>
			</c:when>
			<c:when test='${param.menu == "write" }'>
			<li><a href="${pageContext.servletContext.contextPath }/${authUser.id }/admin/basic">�⺻����</a></li>
			<li><a href="${pageContext.servletContext.contextPath }/${authUser.id }/admin/category">ī�װ�</a></li>
			<li class="selected">���ۼ�</li>
			</c:when>
			<c:otherwise>
			<li class="selected">�⺻����</li>
			<li><a href="${pageContext.servletContext.contextPath }/${authUser.id }/admin/category">ī�װ�</a></li>
			<li><a href="${pageContext.servletContext.contextPath }/${authUser.id }/admin/write">���ۼ�</a></li>
			</c:otherwise>
	</c:choose>
</ul>