<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="IncludeTop.jsp"%>
<table id="main-menu">
	<tr>
		<td><a href='<c:url value="/shop/index.do"/>'><b> <font
					color="black" size="2">&lt;&lt; Main Menu</font></b></a></td>
	</tr>
</table>

<div align="center">
	<h2>My Sales List</h2>
	<table class="n23">
		<tr bgcolor="#CCCCCC">
			<td><b>SalesID</b></td>
			<td><b>USERID</b></td>
			<td><b>ITEMNAME</b></td>
			<td><b>CATEGORY</b></td>
			<td><b>PRICE</b></td>
			<td><b>CONTENT</b></td>
		</tr>
		<c:forEach var="sales" items="${MySales}">
			<tr bgcolor="#FFFF88">
				<td><c:out value="${sales.saleId}" /></td>
				<td><c:out value="${sales.userId}" /></td>
				<td><c:out value="${sales.itemName}" /></td>
				<td><c:out value="${sales.cateId}" /></td>
				<td><c:out value="${sales.item.price}" /></td>
				<td><c:out value="${sales.content}" /></td>
				<td><a href='<c:url value="/shop/viewSalesDetail.do">
				<c:param name="salesId" value="${sales.saleId}" /></c:url>'>
					상세보기</a></td>
				
			</tr>
		</c:forEach>


	</table>

</div>
