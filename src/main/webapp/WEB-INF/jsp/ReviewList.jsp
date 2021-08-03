<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="IncludeTop.jsp"%>

<table id="main-menu">
	<tr>
		<td><a href='<c:url value="/shop/index.do"/>'><b> <font
					color="black" size="2">&lt;&lt; Main Menu</font></b></a></td>
	</tr>
</table>

<div align="center">
	<c:if test="${login == 1}">
	<b><font size="3">내 포인트: <c:out value="${point}"></c:out></font></b> <br>
	</c:if>
	<c:if test="${noPoint == -1}">
	<font style="color:red; font-weight:bold;">리뷰를 열람할 포인트가 부족합니다.</font>
	</c:if>
	<br><br>
	<b><font size="4">자취방 리뷰</font></b> <br>
	<a href='<c:url value="/shop/addReview.do"/>'>리뷰 등록</a>
	<table class="n23">
		<tr bgcolor="#CCCCCC">
			<td><b>Review ID</b></td>
			<td><b>Title</b></td>
		</tr>
		<c:forEach var="review" items="${reviewList}">
			<tr bgcolor="#FFFF88">
				<td><b> <a
						href='<c:url value="/shop/viewReview.do">
            <c:param name="revId" value="${review.revId}"/></c:url>'>
							<c:out value="${review.revId}" />
					</a></b></td>
				<td><c:out value="${review.title}" /></td>
			</tr>
		</c:forEach>
	</table>
</div>
