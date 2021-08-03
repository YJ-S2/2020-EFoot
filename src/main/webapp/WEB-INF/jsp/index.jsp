<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="IncludeTop.jsp"%>



<table style="border: none; border-collapse: collapse; width: 100%">
	<tr>
		<td style="text-align: left; vertical-align: top; width: 100%">
			<table style="border: none; border-collapse: collapse; width: 100%">
				<tr>
					<td valign="top">
						<!-- SIDEBAR -->
						<table id="index">
							<tr>
								<td><c:if test="${!empty userSession.account}">
										<b><i><font size="4" color="RED">Welcome
													${userSession.account.name}!</font></i></b>
									</c:if>&nbsp;</td>
							</tr>
							<tr>
								<td><a
									href="<c:url value="/shop/viewSales.do?categoryId=LIVING"/>">
										living</a></td>
							</tr>
							<tr>
								<td><a
									href="<c:url value="/shop/viewSales.do?categoryId=FURNITURE"/>">
										furniture</a></td>
							</tr>
							<tr>
								<td><a
									href="<c:url value="/shop/viewSales.do?categoryId=APPLIANCE"/>">
										appliance </a></td>
							</tr>
							<tr>
								<td><a
									href="<c:url value="/shop/viewSales.do?categoryId=CLOTHING"/>">
										clothing </a></td>
							</tr>
							<tr>
								<td><a
									href="<c:url value="/shop/viewSales.do?categoryId=BED"/>">
										bed </a></td>
							</tr>
							<tr>
								<td><a
									href="<c:url value="/shop/viewSales.do?categoryId=ETC"/>">
										etc </a></td>
							</tr>
						</table>
					</td>
				<tr>
				
					<td>			
					<a href='<c:url value="/sales/addSalesForm.do">
					<c:param name="userId" value="${userSession.account.userId}" /></c:url>'> 
					Add Sales</a></td>
					
				</tr>
			</table>
			<div align="center">
				 <a href="viewShare.do"><font size="5">나눔</font></a><br> <a
					href="gblist.do"><font size="5">공동 구매</font></a><br> <a
					href="viewAuction.do"><font size="5">경매</font></a><br> <a
					href="review.do"><font size="5">자취방 리뷰</font></a>
			</div>
		</td>
	</tr>
</table>


