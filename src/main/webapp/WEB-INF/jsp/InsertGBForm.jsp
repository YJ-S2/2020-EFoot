<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="IncludeTop.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div align="center">
	<h2>
		공동구매 등록하기
	</h2>
	<form:form commandName="GroupBuying" method="post" enctype="multipart/form-data">
		<form:errors cssClass="error" />
		<br>
		<br>

		<table id="GroupBuying">
			<tr>
				<td>
					<table class="n13">
						<tr> 
							<td> 진행자 id </td> 
							<td> <c:out value="${userSession.account.userId}"/></td>
						</tr>
						<tr> 
							<td> 제품 이름 </td> 
							<td> <form:input path="gbName"/>
								 <form:errors path="gbName" cssClass="error" /> </td>
						</tr>
						<tr> 
							<td> 모집 인원 </td>
							<td> <form:input path="count"/> 
								 <form:errors path="count" cssClass="error" /></td>
						</tr>
						<tr> 
							<td> 마감 기한 </td>
							<td> <form:input type = "date" path="deadLine"/> 
								</td>
						</tr>
						<tr> 
							<td> 배부 장소 </td>
							<td> <form:input path="place"/> 
								 <form:errors path="place" cssClass="error" /></td>
						</tr>
						<tr> 
							<td> 내용 </td>
							<td> <form:input path="content"/>
								 <form:errors path="content" cssClass="error" /></td>
						</tr>
						<tr>
							<td>이미지:</td>
							<td><input type="file" name="imageFile" /></td>
						</tr>
						
					</table>

				</td>
			</tr>
		</table>
		
		 <table id="Item">
			<tr>
				<td>
					<table class="n13">
						<tr> 
							<td> 제품 이름 </td> 
							<td><form:input path="item.name"/> 
								<form:errors path="item.name" cssClass="error" /></td>
						</tr>
						<tr> 
							<td> 가격 </td> 
							<td><form:input path="item.price" />
							<form:errors path="item.price" cssClass="error" /></td>
						</tr>
					</table>

				</td>
			</tr>
		</table>
		<br />
		<input type="image" src="../images/button_submit.gif" name="submit" />
	</form:form>
	<p></p>
</div>

