<%@ include file="IncludeTop.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div align="center">
<table class="n23">
	<tr bgcolor="#CCCCCC">
		<td><b>Auction ID</b></td>
		<td><b>User ID</b></td>
		<td><b>NAME</b></td>
		<td><b>START PRICE</B></td>
	</tr>


	<c:forEach items="${auctionList}" var="auction">

		<tr bgcolor="#FFFF88">
			<td><b><a
					href='<c:url value="/shop/viewAuctionDetail.do"> <c:param name="aucId" value="${auction.aucId}"/></c:url>'>
						<c:out value="${auction.aucId}" />
				</a> </b></td>
			<td>${auction.userId}</td>
			<td>${auction.name}</td>
			<td>${auction.startPrice}</td>
			 <c:if test="${userSession.account.userId != auction.userId}">
			<td><a
				href='<c:url value="/shop/ApplyAuctionForm.do">
				<c:param name="aucId" value="${auction.aucId}"/></c:url>'>
						
					apply </a></td>
					</c:if>
		</tr>

</c:forEach>

	
	
</table>
</div>
<center>
<p>
	<a
		href='<c:url value="/shop/aucByHeader.do"> <c:param name="userId" value="${userSession.account.userId}"/></c:url>'>
		나의 경매 목록</a>
<p>
<p>
	<a
		href='<c:url value="/shop/myAuction.do"> <c:param name="userId" value="${userSession.account.userId}"/> </c:url>'>
		내가 신청한 경매 목록</a>
<p>
<p>
	<a
		href='<c:url value="/shop/addAuction.do">  </c:url>'>
		경매 등록  </a>
<p>
</center>
