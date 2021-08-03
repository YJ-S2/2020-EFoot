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
		나의 진행 경매 목록
	</h2>
	<table class="n23">
		<tr bgcolor="#CCCCCC">
			<td><b>AUCID</b></td>
			<td><b>NAME</b></td>
			<td><b>START-PRICE</b></td>
			
		</tr>
		<c:forEach var="auction" items="${auctionListByHeader}">
			<tr bgcolor="#FFFF88">
				<td>
					<c:out value="${auction.aucId}" />
				</td>
				<td><b>
					<c:out value="${auction.name}" />
					</b>
				</td>
				<td>
				 	<c:out value="${auction.startPrice}" />
				</td>
			</tr>
		</c:forEach>

	</table>

</div>
