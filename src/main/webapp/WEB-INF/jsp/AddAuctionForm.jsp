<%@ include file="IncludeTop.jsp"%>>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div align="center">
	<form:form commandName="Auction" method="post">
		<form:errors cssClass="error" />
		<br>
		<br>

		<input type="hidden" name="userId"
			value="${userSession.account.userId}" />
		<table id="Auction">

			<tr>
				<td>
					<h3>
						<font color="darkgreen">AddAuctionForm</font>
					</h3>
					<table class="n13">

						<tr>
							<td>header ID:</td>
							<td><c:out value="${userSession.account.userId}" /></td>

						</tr>
						<tr>
							<td>name</td>
							<td><form:input path="name" /><form:errors path="name" cssClass="error" /></td>
						</tr>
						<tr>
							<td>startPrice</td>
							<td><form:input path="startPrice" /><form:errors path="startPrice" cssClass="error" /></td>
						</tr>
						<tr>
							<td>content</td>
							<td><form:input path="content" /><form:errors path="content" cssClass="error" /></td>
						</tr>
						<tr>
							<td>DeadLine</td>
							<td><form:input type="date" path="deadLine" /></td>
						</tr>
						<tr>
							<td>place</td>
							<td><form:input path="place" /><form:errors path="place" cssClass="error" /></td>
						</tr>
						<tr>
							<td>startDate</td>
							<td><form:input type="date" path="startDate" /></td>
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


