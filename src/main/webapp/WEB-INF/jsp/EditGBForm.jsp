<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="IncludeTop.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div align="center">
	<form:form commandName="GroupBuying" method="post">
		<form:errors cssClass="error" />
		<br>
		<br>

		<table id="update groupbuying">
			<tr>
				<td>
					<table class="n13">
						
					</table>

				</td>
			</tr>
		</table>
		
		<table id="update item">
			<tr>
				<td>
					<table class="n13">
						
					</table>

				</td>
			</tr>
		</table>
		<br />
		<input type="image" src="../images/button_submit.gif" name="submit" />
	</form:form>
	<p></p>
</div>

