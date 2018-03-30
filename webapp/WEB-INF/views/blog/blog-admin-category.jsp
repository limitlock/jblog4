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
<script src="${pageContext.servletContext.contextPath }/assets/js/jquery/jquery-1.9.0.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function(){
	getlistCategory();
	$(document).on("click", ".dete", function(){
		
		var category_no = $(this).attr("id");
		
		if(category_no==""){
			return;
		}
	
		
		$.ajax({
			url:"/jblog4/${authUser.id}/admin/category/del",
			type:"post",
			data:{categoryNo:category_no},
			dataType:"json", 
			success: function(response){
				if(response.result != "success"){ //실패의 경우
					console.log(response.message);
					return;
				}
				getlistCategory();
			},
			error: function(xhr, status, e){
				console.error(status + ":" + e);
			}	
		});
	})
	$(function(){
		$("#d"+1).on("click", function(){
			alert("ddd");
	        


			
		});
	});
});


function getlistCategory(){
	$.ajax({
		url:"/jblog4/${authUser.id}/admin/categoryAjax",
		type:"get",
		data:"",
		dataType:"json", 
		success: function(list){
			console.log("dddd");
			var innerHTML = "";
			$.each(list.data, function(index,item){
				
				  var no = item.no;
				  var name = item.name;
				  var postNum = item.postNum;
				  var content = item.content;
				  
				  innerHTML += "<tr><td>"+(index+1)+"</td>";
				  innerHTML += "<td>"+name+"</td>";
				  innerHTML += "<td>"+postNum+"</td>";
				  innerHTML += "<td>"+content+"</td>";
				  innerHTML += "<td id="+no+" class='dete'><img src='${pageContext.request.contextPath}/assets/images/delete.jpg'></td></tr>";
				 
				  $("#category-list").html(innerHTML);  
				  
				  
			});
			
		},
		error: function(xhr, status, e){
			console.error(status + ":" + e);
		}	
	});
}

$(function(){
	$("#btn-category").click(function(){
		
		var category_name = $("#name").val();
		if(category_name==""){
			return;
		}
		var category_desc = $("#desc").val();
		if(category_desc==""){
			return;
		}
		
		$.ajax({
			url:"/jblog4/${authUser.id}/admin/category/category_write",
			type:"post",
			data:{name:category_name, content:category_desc},
			dataType:"json", 
			success: function(response){
				if(response.result != "success"){ //실패의 경우
					console.log(response.message);
					return;
				}
				console.log("성공");
				getlistCategory();
			},
			error: function(xhr, status, e){
				console.error(status + ":" + e);
			}	
		});
	});
});
</script>
</head>
<body>
	<div id="container">
		<div id="header">
			<%-- <c:forEach items="${list }" var ="vo"> --%>
			<h1>이 부분 수정해야합니다.</h1>
			<%-- </c:forEach> --%>
			<c:import url="/WEB-INF/views/includes/blog_header.jsp"/>
		</div>
		<div id="wrapper">
			<div id="content" class="full-screen">
				<c:import url="/WEB-INF/views/includes/admin-menu.jsp">
					<c:param name="menu" value="category"/>
				</c:import>
		      	<table id="category-list" class="admin-cat">
		      		<tr>
		      			<th>번호</th>
		      			<th>카테고리명</th>
		      			<th>포스트 수</th>
		      			<th>설명</th>
		      			<th>삭제</th>      			
		      		</tr>
				</table>
      			<h4 class="n-c">새로운 카테고리 추가</h4>
		      	<table id="admin-cat-add">
		      		<tr>
		      			<td class="t">카테고리명</td>
		      			<td><input type="text" name="name" id="name"></td>
		      		</tr>
		      		<tr>
		      			<td class="t">설명</td>
		      			<td><input type="text" name="desc" id="desc"></td>
		      		</tr>
		      		<tr>
		      			<td class="s">&nbsp;</td>
		      			<td><input type="submit" id="btn-category" value="카테고리 추가"></td>
		      		</tr>      		      		
		      	</table> 
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