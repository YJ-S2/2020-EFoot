<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="IncludeTop.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- <div style="text-align:center;">
    <spring:hasBindErrors name="accountForm" />
    <form:errors path="accountForm" cssClass="error" />
</div>
 -->

<div align="center">
	<form:form commandName="sales" method="post" enctype="multipart/form-data">
		<form:errors cssClass="error" />
		<br>
		<br>

		<table id="sales">
			<tr>
				<td>
					<h3>
						<font color="darkgreen">수정</font>
					</h3>
					<table class="n13">
						<tr>
							<td>SELLER</td>
							<td><c:out value="${sales.userId}" /></td>
						</tr>
						<tr>
							<td>ITEM</td>
							<td><form:input path="ItemName" />
							<form:errors path="ItemName" cssClass="error" /></td>
						</tr>
					     <tr>
							<td>CATEGORY</td>
							<td><form:select path="cateId">
									<form:option value="LIVING">LIVING</form:option>
									<form:option value="APPLIANCE">APPLIANCE</form:option>
									<form:option value="CLOTHING">CLOTHING</form:option>
									<form:option value="BED">BED</form:option>
									<form:option value="ETC">ETC</form:option>
								</form:select></td>
						</tr>
						<tr>
							<td>PRICE</td>
							<td><form:input path="item.price" />
							<form:errors path="item.price" cssClass="error" /></td>
						</tr> 
						<tr>
							<td>CONTENT</td>
							<td><form:textarea path="content" cols="50" rows="5" />
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
		<br />
		<input type="image" src="../images/button_submit.gif" name="submit" />
	</form:form>
	<p></p>
</div>

