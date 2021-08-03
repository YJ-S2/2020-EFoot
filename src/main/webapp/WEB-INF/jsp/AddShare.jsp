<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="IncludeTop.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div align="center">
	<form:form commandName="share" method="post">
		<form:errors cssClass="error" />
		<br>
		<br>
		<table id="share">
			<tr>
				<td>
					<h3>
						<font color="darkgreen">Add Share</font>
					</h3>
					<table class="n13">
						<tr>
							<td>작성자:</td>
							<td><c:out value="${userSession.account.userId}" /></td>
						</tr>
						<tr>
							<td>나눔명:</td>
							<td><form:input path="name" /></td>
							<td><form:errors path="name" cssClass="error" /></td>

						</tr>
						<tr>
							<td>내용:</td>
							<td><form:input path="content" /></td>
							<td><form:errors path="content" cssClass="error" /></td>

						</tr>
						<tr>
							<td>장소:</td>
							<td><form:input path="place" /></td>
							<td><form:errors path="place" cssClass="error" /></td>

						</tr>
						<tr>
							<td>수량:</td>
							<td><form:input path="count" /></td>
							<td><form:errors path="count" cssClass="error" /></td>

						</tr>
						<tr>
							<td>마감기한:</td>
							<td><form:input type="date" path="deadLine" /></td>
							<form:errors path="deadLine" cssClass="error" />

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
