<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="IncludeTop.jsp"%>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script>
	function getReview(revId) {
		var reqUrl = "../rest/review/" + revId;
		$.ajax({
			type : "get",
			url : reqUrl,
			dataType : 'json',
			async : false,
			processData : false,
			success : function(responseJson) { // object parsed from JSON text	
				$("#detail").html("<ul></ul>");
				$("#detail > ul").append("<li> Review Id: " + responseJson.revId + "</li>");
				$("#detail > ul").append("<li> User Id: " + responseJson.userId + "</li>");
				$("#detail > ul").append("<li> Review Date: " + new Date(responseJson.timestamp) + "</li>");
				$("#detail > ul").append("<li> Title: " + responseJson.title + "</li>");
				$("#detail > ul").append("<li> Address: " + responseJson.address + "</li>");
				$("#detail > ul").append("<li> Content: " + responseJson.content + "</li>");
				$("#detail > ul").append("<li> Gpa: " + responseJson.gpa + "</li>");

			},
			error : function() {
				alert("ERROR", arguments);
			}
		});
	};
</script>

<div align="center">
	<table>
		<tr>
			<td>
				<div id="detail"></div>
			</td>
		</tr>
	</table>
</div>

<table id="main-menu">
	<tr>
		<td><a href='<c:url value="/shop/editAccount.do"/>'><b> <font
					color="black" size="2">&lt;&lt; My Account</font></b></a></td>
	</tr>
</table>

<div align="center">
	<b><font size="4">내 리뷰 조회</font></b>
	<table class="n23">
		<tr bgcolor="#CCCCCC">
			<td><b>REVIEW ID</b></td>
			<td><b>TITLE</b></td>
			<td><b>CONTENT</b></td>
			<td><b>DATE</b></td>
		</tr>
		<c:forEach var="review" items="${myReview}">
			<tr bgcolor="#FFFF88">
				<td onClick="getReview('${review.revId}');"><b>
				<c:out value="${review.revId}" /></b></td>
				<td><b><c:out value="${review.title}" /></b></td>
				<td><c:out value="${review.content}" /></td>
				<td><fmt:formatDate value="${review.timestamp}"
            pattern="yyyy/MM/dd hh:mm:ss" /></td>
				<td><a
					href='<c:url value="/shop/viewReview.do">
				<c:param name="revId" value="${review.revId}" /></c:url>'>
						상세보기</a>
			</tr>
		</c:forEach>
	</table>
</div>
