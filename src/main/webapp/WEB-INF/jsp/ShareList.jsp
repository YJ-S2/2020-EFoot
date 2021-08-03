<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="IncludeTop.jsp"%>
	<table id="main-menu" >
		<tr>
			<td><a href='<c:url value="/shop/index.do"/>'><b> <font
						color="black" size="2">&lt;&lt; Main Menu</font></b></a></td>
		</tr>
	</table>
<div align="center">
	<b><font size="4">SHARE List</font></b>
	<br><br>
	<a href='<c:url value="/shop/addItemToShare.do">
			<c:param name="userId" value="${userSession.account.userId}"/></c:url>'><b>
						<font color="black" size="2"> ADD SHARE</font>
				</b></a>
		<br><br>	
	<table class="n23">
		<tr bgcolor="#CCCCCC">
			<td><b>Share ID</b></td>
			<td><b>USERID</b></td>
			<td><b>NAME</b></td>
			<td><b>CONTENT</b></td>
			<td><b>PLACE</b></td>
			<td><b>COUNT</b></td>
		</tr>
		<c:forEach var="share" items="${shareList}">
			<tr bgcolor="#FFFF88">
				<td><a
					href='<c:url value="/shop/shareDetail.do">
                <c:param name="shId" value="${share.shId}"/></c:url>'>
						<c:out value="${share.shId}" />
				</a></td>
				<td><c:out value="${share.userId}" /></td>
				<td><c:out value="${share.name}" /></td>
				<td><c:out value="${share.content}" /></td>
				<td><c:out value="${share.place}" /></td>
				<td><c:out value="${share.count}" /></td>
			</tr>
		</c:forEach>
		<tr>
		</tr>
	</table>

</div>