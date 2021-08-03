<%@ include file="IncludeTop.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<center>
	<h3>내 주문 내역</h3>
</center>
<table class="n13">
	<tr>
		<td><b>Order Id</b></td>
	</tr>


	<c:forEach items="${orderList}" var="order">

		<tr>
			<td><b><a
					href='<c:url value="/shop/viewOrder.do"> <c:param name="orderId" value="${order.orderId}"/></c:url>'>
						<c:out value="${order.orderId}" />
				</a> </b></td>
		</tr>

	</c:forEach>
</table>
