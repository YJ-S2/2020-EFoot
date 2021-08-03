<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="IncludeTop.jsp"%>

<table id="main-menu">
	<tr>
		<td><a href='<c:url value="/shop/index.do"/>'><b> <font
					color="black" size="2">&lt;&lt; Main Menu</font></b></a></td>
	</tr>
</table>

<div align="center">
	<h2>
		나의 진행 공동구매 목록
	</h2>
	<table class="n23">
		<tr bgcolor="#CCCCCC">
			<td><b>GBID</b></td>
			<td><b>NAME</b></td>
			<td><b>PRICE</b></td>
			
		</tr>
		<c:forEach var="gb" items="${gbListByHeader}">
			<tr bgcolor="#FFFF88">
				<td><a href='<c:url value="/shop/gbDetail.do"> <c:param name="gbId" value="${gb.gbId}"/></c:url>'>
					<c:out value="${gb.gbId}" /></a>
				</td>
				<td><b>
					<c:out value="${gb.gbName}" />
					</b>
				</td>
				<td>
				 	<c:out value="${gb.item.price}" />
				</td>
			</tr>
		</c:forEach>

	</table>

</div>

