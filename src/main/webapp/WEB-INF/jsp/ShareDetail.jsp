<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="IncludeTop.jsp"%>
<table id="main-menu">
	<tr>
		<td><a href='<c:url value="/shop/viewShare.do"/>'> <b><font
					color="black" size="2"> &lt;&lt; ShareList</font></b></a></td>
	</tr>
</table>

<div align="center">
	<br>
	<br>
	<br>
	<br> <b><font size="4"><c:out
				value="${shareDetail.name}" /></font></b> <br> <br>
	<table class="n23">
		<tr bgcolor="#CCCCCC">
			<td><b>Share ID</b></td>
			<td><b>USERID</b></td>
			<td><b>COMMENT</b></td>
			<td><b>PLACE</b></td>
			<td><b>COUNT</b></td>
			<td><b>DATE</b></td>
			<td><b>DEADLINE</b></td>

		</tr>
		<tr bgcolor="#FFFF88">
			<td><c:out value="${shareDetail.shId}" /></td>
			<td><c:out value="${shareDetail.userId}" /></td>
			<td><c:out value="${shareDetail.content}" /></td>
			<td><c:out value="${shareDetail.place}" /></td>
			<td><c:out value="${shareDetail.count}" /></td>
			<td><c:out value="${shareDetail.timestamp}" /></td>
			<td><c:out value="${shareDetail.deadLine}" /></td>
		</tr>

	</table>
<br><br>
<!-- =============================================================== -->

<table class="n23">
		<tr bgcolor="#CCCCCC">
			<td colspan="2" align=center><b>현재 나눔 신청자 : <c:out value="${shareDetail.shareApplyer.size()}" />명 </b></td>
		</tr>
		<c:forEach var="applyer" items="${shareDetail.shareApplyer}">
			<tr bgcolor="#FFFF88">
				<td>
				 	<c:out value="${applyer.userId}" />
				</td>
				<td>
				 	<c:out value="${applyer.name}" />
				</td>
				<td>
				 	<c:out value="${applyer.phone}" />
				</td>
			</tr>
		</c:forEach>

	</table>



	<c:if test="${userSession.account.userId != null}">
		<c:if test="${userSession.account.userId != shareDetail.userId}">
			<c:set var="applyed" value="false"> </c:set>
			<c:forEach var="applyer" items="${shareDetail.shareApplyer}">
				<c:if test="${userSession.account.userId == applyer.userId}">
					<c:set var="applyed" value="true"> </c:set>
				</c:if>
			</c:forEach>
			
			<c:if test="${applyed == false}">
				<c:choose>
					<c:when test="${shareDetail.count > shareDetail.shareApplyer.size()}">
						<p><a href='<c:url value="/shop/applyShare.do">
							<c:param name="shId" value="${shareDetail.shId}"/>	
							<c:param name="userId" value="${userSession.account.userId}"/>
				            </c:url>'> 나눔 신청 </a>
						</p>
					</c:when>
					<c:when test="${shareDetail.count <= shareDetail.shareApplyer.size()}">
						<p style="color:gray;">나눔 신청 불가 (인원 마감)</p>
					</c:when>
				</c:choose>
			</c:if>
			
			<c:if test="${applyed == true}">
				<p><a href='<c:url value="/shop/cancelShare.do"> 
							<c:param name="shId" value="${shareDetail.shId}"/>	
							<c:param name="userId" value="${userSession.account.userId}"/>
       				</c:url>'>나눔 신청 취소 </a>
				</p>
			</c:if>
 
		</c:if>
		</c:if>
<br>
	<c:if test="${userSession.account.userId == shareDetail.userId}">
		<tr>
			<td><a href='<c:url value="/shop/updateShare.do">
          <c:param name="shId" value="${shareDetail.shId}"/></c:url>'>
					수정하기</a>
			<td><a href='<c:url value="/shop/deleteShare.do"></td>
           <c:param name="shId" value="${shareDetail.shId}"/></c:url>'> 삭제하기</a></td>

			
		</tr>
	</c:if>
	</div>