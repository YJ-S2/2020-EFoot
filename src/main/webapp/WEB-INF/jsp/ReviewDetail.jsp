<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="IncludeTop.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table id="main-menu">
	<tr>
		<td><a href='<c:url value="/shop/review.do"/>'> <b><font
					color="black" size="2"> &lt;&lt; ReviewList</font></b></a></td>
	</tr>
</table>

<p>
<div align="center">
	<table class="n23" style="width: 700;">
		
		<c:if test="${!empty review.image}">
		<tr bgcolor="#FFFF88">
			<td bgcolor="#FFFFFF"><img src="../upload/${review.image}" width="400" /> </td>
		</tr>
		</c:if>
		<tr bgcolor="#FFFF88">
			<td width="100%" bgcolor="#CCCCCC"><b><c:out
						value="${review.revId}" /></b></td>
		</tr>
		<tr bgcolor="#FFFF88">
			<td><b><font size="4"> <c:out value="${review.title}" />
				</font></b></td>
		</tr>
		<tr bgcolor="#FFFF88">
			<td><font size="3">
			<i><c:out value="${review.address}" /></i></font></td>
		</tr>
		<tr bgcolor="#FFFF88">
			<td><c:out value="${review.content}" /></td>
		</tr>
		<tr bgcolor="#FFFF88">
			<td>별점: <c:out value="${review.gpa}" />
			</td>
		</tr>
		<tr bgcolor="#FFFF88">
			<td>작성자: <c:out value="${review.userId}" /></td>
		</tr>
		<c:if test="${userSession.account.userId == review.userId}">
			<tr bgcolor="#FFFF88">
				<td><a
					href='<c:url value="/shop/updateReview.do">
          <c:param name="revId" value="${review.revId}"/></c:url>'>
						수정하기</a> <a
					href='<c:url value="/shop/deleteReview.do">
          <c:param name="revId" value="${review.revId}"/></c:url>'>
						삭제하기</a></td>
				<td style="text-align: right;"><a href='<c:url value="/shop/myReview.do"> 
 					<c:param name="userId" value="${review.userId}"/></c:url>'>
 					MyReview</a></td>
			</tr>
		</c:if>
	</table>
</div>
