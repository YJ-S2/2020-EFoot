<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="IncludeTop.jsp"%>
<table id="main-menu">
	<tr>
		<td><a href='<c:url value="/shop/index.do"/>'><b> <font
					color="black" size="2">&lt;&lt; Main Menu</font></b></a></td>
	</tr>
</table>

<div align="center">
	<h2>My Point List</h2><br>
	Now Point: ${point}
	<table class="n23">
		<tr bgcolor="#CCCCCC">
			<td><b>PointID</b></td>
			<td><b>USERID</b></td>
			<td><b>HISTORY</b></td>
			<td><b>STATUS</b></td>
			<td><b>AMOUNT</b></td>
			<td><b>DATE</b></td>
		</tr>
		<c:forEach var="point" items="${MyPointList}">
			<tr bgcolor="#FFFF88">
				<td><c:out value="${point.pointId}" /></td>
				<td><c:out value="${point.userId}" /></td>
				<td><c:out value="${point.history}" /></td>
				<td><c:out value="${point.status}" /></td>
				<td><c:out value="${point.amount}" /></td>
				<td><c:out value="${point.date}" /></td>
				
			</tr>
		</c:forEach>


	</table>

</div>
