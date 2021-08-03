<%@ include file="IncludeTop.jsp"%>>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div align="center">
	<form:form commandName="Auction" method="post" >
	<form:errors cssClass="error" /> 
		<br>
		<br>
<input type="hidden" name = "userId" value="${userSession.account.userId}"/>

		<table id="Auction">
		
			<tr>
				<td>
					<h3>
						<font color="darkgreen">ApplyAuctionForm</font>
					</h3>
					<table class="n13">
						<tr>
							<td>Auction ID</td>
							<td><c:out value="${auction.aucId}"/></td>
						</tr>
						<tr>
							<td>user ID:</td>
							<td><c:out  value="${userSession.account.userId}"/></td>
							<!--<c:out value="${auction.userId}" />-->
						</tr>
						<tr>
							<td>name</td>
							<td><c:out value="${auction.name}"/></td>
						</tr>
						<tr>
							<td>price</td>
							<td><form:input path="price"/><form:errors path="price" cssClass="error" /></td>
						</tr>
					<!--  	<tr>
							<td>address</td>
							<td><form:input path="place"/> </td>
						</tr>-->
					</table>
				</td>
			</tr>
		</table>


		<br />
		<input type="image" src="../images/button_submit.gif" name="submit" />
	</form:form>
	<p></p>
</div>



