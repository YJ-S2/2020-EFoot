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
		공동구매 상세보기
	</h2>
	<table class="n23">
	<!-- 공동구매 -->
		<tr bgcolor="#FFFF88">
			<td bgcolor="#FFFFFF"><img src="../upload/${gb.image}" width="400" /> </td>
		</tr>
		<tr bgcolor="#CCCCCC"> <td colspan="2"  align=center ><b> 공동구매 정보 </b></td></tr>
		<tr>
			<td bgcolor="#CCCCCC"><b>공동구매 ID</b></td>
			<td bgcolor="#FFFF88">
				 <c:out value="${gb.gbId}" />
			</td>
		</tr>
		<tr>
			<td bgcolor="#CCCCCC"><b> 제목 </b></td>
			<td bgcolor="#FFFF88">
				 <c:out value="${gb.gbName}" />
			</td>
		</tr>
		<tr>
			<td bgcolor="#CCCCCC"><b>진행자</b></td>
			<td bgcolor="#FFFF88">
				 <c:out value="${gb.userId}" />
			</td>
		</tr>
		<tr>
			<td bgcolor="#CCCCCC"><b>모집 인원</b></td>
			<td bgcolor="#FFFF88">
				 <c:out value="${gb.count}" />
			</td>
		</tr>
		<tr>
			<td bgcolor="#CCCCCC"><b>마감 기한</b></td>
			<td bgcolor="#FFFF88">
				 <c:out value="${gb.deadLine}" />
			</td>
		</tr>
		<tr>
			<td bgcolor="#CCCCCC"><b>배부 장소</b></td>
			<td bgcolor="#FFFF88">
				 <c:out value="${gb.place}" />
			</td>
		</tr>
		<tr>
			<td bgcolor="#CCCCCC"><b>내용</b></td>
			<td bgcolor="#FFFF88">
				 <c:out value="${gb.content}" />
			</td>
		</tr>
		<tr>
			<td bgcolor="#CCCCCC"><b>게시일</b></td>
			<td bgcolor="#FFFF88">
				 <c:out value="${gb.timestamp}" />
			</td>
		</tr>
	
	<!-- 공동구매 item -->
		<tr bgcolor="#CCCCCC"> <td colspan="2" align=center><b> item 정보 </b></td></tr>
		<tr>
			<td bgcolor="#CCCCCC">item ID</td>
			<td bgcolor="#FFFF88">
				 <c:out value="${gb.item.itemId}" />
			</td>
		</tr>
		<tr>
			<td bgcolor="#CCCCCC">이름</td>
			<td bgcolor="#FFFF88">
				 <c:out value="${gb.item.name}" />
			</td>
		</tr>
		<tr>
			<td bgcolor="#CCCCCC">가격</td>
			<td bgcolor="#FFFF88">
				 <c:out value="${gb.item.price}" />
			</td>
		</tr>
		
	<!-- 공동구매 신청자 - id, name, phone -->
		<tr bgcolor="#CCCCCC">
			<td colspan="2" align=center><b>현재 공동구매 신청자 : <c:out value="${gb.gbApplyer.size()}" />명 </b></td>
		</tr>
		<c:forEach var="applyer" items="${gb.gbApplyer}">
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
		<c:if test="${userSession.account.userId != gb.userId}">
			<c:set var="applyed" value="false"> </c:set>
			<c:forEach var="applyer" items="${gb.gbApplyer}">
				<c:if test="${userSession.account.userId == applyer.userId}">
					<c:set var="applyed" value="true"> </c:set>
				</c:if>
			</c:forEach>
			
			<c:if test="${applyed == false}">
				<c:choose>
					<c:when test="${gb.count > gb.gbApplyer.size()}">
						<p><a href='<c:url value="/shop/applyGB.do"> <c:param name="userId" value="${userSession.account.userId}"/>
																 <c:param name="gbId" value="${gb.gbId}"/></c:url>'>
							공동구매 신청 </a>
						</p>
					</c:when>
					<c:when test="${gb.count <= gb.gbApplyer.size()}">
						<p style="color:gray;">공동구매 신청 불가 (인원 마감)</p>
					</c:when>
				</c:choose>
			</c:if>
			
			<c:if test="${applyed == true}">
				<p><a href='<c:url value="/shop/cancelGB.do"> <c:param name="gbId" value="${gb.gbId}"/>
																<c:param name="userId" value="${userSession.account.userId}"/></c:url>'>
					공동구매 신청 취소</a>
				</p>
			</c:if>
 
		</c:if>
	
	
	
		<c:if test="${userSession.account.userId == gb.userId}">
			<p>
				<a href='<c:url value="/shop/updateGB.do"> <c:param name="gbId" value="${gb.gbId}"/>
														<c:param name="userId" value="${userSession.account.userId}"/>
				</c:url>'> 수정 </a>
			<p>
	       		
	       	<p>
				<a href='<c:url value="/shop/deleteGB.do"> <c:param name="gbId" value="${gb.gbId}"/></c:url>'> 삭제  </a>
			<p>
		</c:if>
	</c:if>
</div>

