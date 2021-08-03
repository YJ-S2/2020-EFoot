<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="IncludeTop.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div align="center">
	<form:form commandName="review" method="post" enctype="multipart/form-data">
		<form:errors cssClass="error" />
		<br>
		<br>
		<table id="review">
			<tr>
				<td>
					<h3>
						<font color="darkgreen">Review</font>
					</h3>
					<table class="n13">
						<tr>
							<td>작성자:</td>
							<td><c:out value="${userSession.account.userId}" /></td>
						</tr>
						<tr>
							<td>제목:</td>
							<td><form:input path="title" cssStyle="width:100%;"/>
							<form:errors path="title" cssClass="error" /></td>
						</tr>
						<tr>
							<td>주소:</td>
							<td><form:input path="address" cssStyle="width:100%;" />
							<form:errors path="address" cssClass="error"/></td>
						</tr>
						<tr>
							<td>리뷰:</td>
							<td><form:textarea path="content" cols="50" rows="5" />
							<form:errors path="content" cssClass="error" /></td>
						</tr>
						<tr>
							<td>별점:</td>
							<td><form:select path="gpa">
									<form:option value="5.0">5.0</form:option>
									<form:option value="4.5">4.5</form:option>
									<form:option value="4.0">4.0</form:option>
									<form:option value="3.5">3.5</form:option>
									<form:option value="3.0">3.0</form:option>
									<form:option value="2.5">2.5</form:option>
									<form:option value="2.0">2.0</form:option>
									<form:option value="1.5">1.5</form:option>
									<form:option value="1.0">1.0</form:option>
								</form:select></td>
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
