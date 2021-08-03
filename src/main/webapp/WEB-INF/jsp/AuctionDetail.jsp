<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="IncludeTop.jsp"%>
<br/>
<br/>
<div align="center">
<table class="n23">
	<tr bgcolor="#CCCCCC">
		<td><b>SELLER</b></td>
		<td><b>ITEM</b></td>
		<td><b>CONTENT</b></td>
		<td><b>START PRICE</b></td>
		<td><b>FINAL PRICE</b></td>
		<td><b>START DATE</b></td>
		<td><b>PLACE</b></td>
		<td><b>DEADLINE</b></td>
	</tr>

	<tr bgcolor="#FFFF88">
		<td><c:out value="${auctionDetail.userId}" /></td>
		<td><c:out value="${auctionDetail.name}" /></td>
		<td><c:out value="${auctionDetail.content}" /></td>
		<td><c:out value="${auctionDetail.startPrice}" /></td>
		<td></td>
		<td><c:out value="${auctionDetail.startDate}" /></td>
		<td><c:out value="${auctionDetail.place}" /></td>
		<td><c:out value="${auctionDetail.deadLine}" /></td>
	</tr>
<!-- <c:out value="${auctionDetail.finalPrice}" /> -->
</table>

<br/>
<br/>

<h3>사용자 경매 신청 현황</h3>
<table class="n23">
	<tr bgcolor="#CCCCCC">
		<td><b>userId</b></td>
		<td><b>price</b></td>
		

	</tr>
	<c:forEach var="auction" items="${applyAuction}">
		<tr bgcolor="#FFFF88">
			<td><b><c:out value="${auction.userId}" /></b></td>
			<td><c:out value="${auction.price}" /></td>
			
		</tr>
	</c:forEach>

</table>
</div>
   <c:if test="${userSession.account.userId == auctionDetail.userId}">
<center>
	<a
		href='<c:url value="/shop/deleteAuction.do"> <c:param name="aucId" value="${auctionDetail.aucId}"/> </c:url>'>
		delete</a>
	<a
		href='<c:url value="/shop/updateAuction.do"> <c:param name="aucId" value="${auctionDetail.aucId}"/> </c:url>'>
		update</a>
</center>

  </c:if>

