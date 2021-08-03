<%@ include file="IncludeTop.jsp"%>


<table id="main-menu">
	<tr>
		<td><a href='<c:url value="/shop/index.do"/>'><b> <font
					color="black" size="2">&lt;&lt; Main Menu</font></b></a></td>
	</tr>
</table>

<div align="center">
	<h2>
		<c:out value="${category.name}" />
	</h2>
	<table class="n23">
		<tr bgcolor="#CCCCCC">
			<td><b>SELLER</b></td>
			<td><b>NAME</b></td>
		</tr>
		<c:forEach var="sales" items="${salesListdata}">
			<tr bgcolor="#FFFF88">
				<td>
				 	<c:out value="${sales.userId}" />
				</td>
				<td><b><a href='<c:url value="/shop/viewSalesDetail.do"> <c:param name="salesId" value="${sales.saleId}"/></c:url>'>
					<c:out value="${sales.itemName}" /></a>
					</b></td>
			</tr>
		</c:forEach>

	</table>

</div>

