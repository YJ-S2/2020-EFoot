<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="IncludeTop.jsp"%>

<table id="main-menu">
	<tr>
		<td><a href='<c:url value="/shop/index.do"/>'><b> <font
					color="black" size="2">&lt;&lt; Main Menu</font></b></a></td>
	</tr>
</table>

<div align="center">
	<h2>내가 신청한 Share List</h2>
	<table class="n23">
		<tr bgcolor="#CCCCCC">
			<td><b>ShareID</b></td>
			<td><b>NAME</b></td>
			<td><b>CONTENT</b></td>
			<td><b>PLACE</b></td>
		</tr>
		<c:forEach var="share" items="${myShare}">
			<tr bgcolor="#FFFF88">
				<td><c:out value="${share.shId}" /></td>
				<td><c:out value="${share.name}" /></td>
				<td><c:out value="${share.content}" /></td>
				<td><c:out value="${share.place}" /></td>
			</tr>
		</c:forEach>
	</table>
</div>