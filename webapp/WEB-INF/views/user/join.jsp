<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script src="${pageContext.servletContext.contextPath }/assets/js/jquery/jquery-1.9.0.js" type="text/javascript"></script>
<script type="text/javascript">
$(function() {
		$("#btn-checkid").click(function() {
			console.log("ddddddddddddddddddddddddddddddddddddddddddd");
			var id = $("#blog-id").val();
			if (id == "") {
				return;
			}
			
			$.ajax({
				url:"/jblog4/api/user/checkid?id="+id,
				type:"get",
				data:"",
				dataType:"json", 
				success: function(response){
					if(response.result != "success"){ //실패의 경우
						console.log(response.message);
						return;
					}
					
					if(response.data == "exist"){
						alert("이미 사용 중인 아이디입니다.");
						$("#id").val("").focus();
						return;
					}
					
					
					console.log("성공");
				},
				error: function(xhr, status, e){
					console.error(status + ":" + e);
				}	
		});
	});
		

	
	var form = document.getElementById("join-form");

		form.onsubmit = function() {

			var agreeProv = document.getElementById("agree-prov");
			if (agreeProv.checked == false) {
				alert("서비스 동의를 해주세요.");
				return false;
			}
			return true;
		}

});
</script>
</head>
<body>
	<div class="center-content">
		<h1 class="logo">JBlog</h1>
		<img style="width: 200px;" id="profile"
			src="${pageContext.servletContext.contextPath }/assets/images/logo.jpg" />
		<ul class="menu">
			<li><a href="${pageContext.servletContext.contextPath }/user/login">로그인</a></li>
			<li><a href="${pageContext.servletContext.contextPath }/user/join">회원가입</a></li>
			<li><a href="${pageContext.servletContext.contextPath }/user/logout">로그아웃</a></li>
			<li><a href="${pageContext.servletContext.contextPath }/blog/blog-main">내블로그</a></li>
		</ul>
		<form:form 
			modelAttribute="userVo" 
			class="join-form" 
			id="join-form"  
			method="post" 
			action="${pageContext.servletContext.contextPath }/user/join">
			<label class="block-label" for="name">이름</label> 
			<form:input path="name"/>
			<p style="padding:0; font-weight:bold; text-align:left; color:#f00">
			<form:errors path="name"/>
			
			<label class="block-label" for="blog-id">아이디</label> 
			<form:input path="id"/>
			<p style="padding:0; font-weight:bold; text-align:left; color:#f00">
			<form:errors path="id"/>
			
			
			<input id="btn-checkid" type="button" value="id 중복체크"> 
			<img id="img-checkemail" style="display: none;" src="${pageContext.request.contextPath}/assets/images/check.png">
			
			<label class="block-label" for="password">패스워드</label> 
			<input id="password" name="password" type="password" />
			<spring:hasBindErrors name="userVo">
				<c:if test="${errors.hasFieldErrors('password') }">
					<p style="padding: 0; text-align: left; color: #f00;">
						<spring:message>
					   			code="${errors.getFieldError('password').codes[0] }"
					   			text="${errors.getFieldError('password').defaultMessage }"
					   		</spring:message>
					</p>
				</c:if>
			</spring:hasBindErrors>


			<fieldset>
				<legend>약관동의</legend>
				<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
				<label class="l-float">서비스 약관에 동의합니다.</label>
			</fieldset>

			<input type="submit" value="가입하기">

		</form:form>
	</div>
</body>
</html>
