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
		내가 신청한 경매 목록
	</h2>
	<table class="n13">
		<tr>
		<td><b>headerId</b></td>
			<td><b>AUCID</b></td>
			<td><b>NAME</b></td>
			<td><b>PRICE</b></td>
		
		</tr>
		<c:forEach var="auction" items="${MyAuctionList}">
			<tr bgcolor="#FFFF88">
			<td>
					<c:out value="${auction.userId}" />
				</td>
				<td>
					<c:out value="${auction.aucId}" />
				</td>
				<td><b>
					<c:out value="${auction.name}" />
					</b>
				</td>
				<td>
				 	<c:out value="${auction.price}" />
				</td>                                                           
				<td><a href='<c:url value="/shop/cancelAuction.do"> 
				<c:param name="aucId" value="${auction.aucId}"/>
				<c:param name="userId" value="${userSession.account.userId}"/></c:url>'>
					신청취소</a></td>
			</tr>
		</c:forEach>

 
	</table>

</div>

