<%@ include file="IncludeTop.jsp"%>

<table id="main-menu">
	<tr>
		<td><a href='<c:url value="/shop/index.do"/>'><b> <font
					color="black" size="2">&lt;&lt; Main Menu</font></b></a></td>
	</tr>
</table>

<div align="center">
	
	<h3>IN SALES!</h3>
	<table class="n23">
		<tr bgcolor="#CCCCCC">
			<td><b>ItemName</b></td>
			<td><b>Price</b></td>
		</tr>
		<c:forEach var="s" items="${Sales}">
			<tr bgcolor="#FFFF88">
				<td><c:out value="${s.name}" /></td>
				<td><c:out value="${s.price}" /></td>
			</tr>
		</c:forEach>
	</table>
	
	<h3>IN AUCTION!</h3>
	<table class="n23">
		<tr bgcolor="#CCCCCC">
			<td><b>ItemName</b></td>
			<td><b>Price</b></td>
		</tr>
		<c:forEach var="s" items="${Auction}">
			<tr bgcolor="#FFFF88">
				<td><c:out value="${s.name}" /></td>
				<td><c:out value="${s.price}" /></td>
			</tr>
		</c:forEach>
	</table>
	
	<h3>IN GroupBuying!</h3>
	<table class="n23">
		<tr bgcolor="#CCCCCC">
			<td><b>ItemName</b></td>
			<td><b>Price</b></td>
		</tr>
		<c:forEach var="s" items="${GB}">
			<tr bgcolor="#FFFF88">
				<td><c:out value="${s.name}" /></td>
				<td><c:out value="${s.price}" /></td>
			</tr>
		</c:forEach>
	</table>
</div>

