<%@ include file="IncludeTop.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div align="center">
<form:form commandName="Order" method="post">
   <br><br>
 <input type="hidden" name = "userId" value="${userSession.account.userId}"/>

  <table class="n13">
    <tr>
      <td colspan="2">
        <font color="green" size="4"><b>Payment Details</b></font></td>
    </tr>
    <tr>
      <td>Card Type:</td>
      <td><form:input path="cardType" /><form:errors path="cardType" cssClass="error" />
        </td>
    </tr>
    <tr>
      <td>Card Number:</td>
      <td><form:input path="cardNumber" /> <form:errors path="cardNumber" cssClass="error" />
        <font color="red" size="2"></font>
       </td>
    </tr>
    <tr>
      <td>Expiry Date (MM/YYYY):</td>
      <td><form:input path="expiryDate" /><form:errors path="expiryDate" cssClass="error" /> 
        </td>
    </tr>
    <tr>
      <td colspan="2">
        <font color="green" size="4"><b>Billing Address</b></font></td>
    </tr>
    <tr>

    <tr>
      <td>Address:</td>
      <td><form:input path="orderAddress" /><form:errors path="orderAddress" cssClass="error"/></td>
    </tr>
    <tr>
      <td>Zip:</td>
      <td><form:input path="orderZip" /><form:errors path="orderZip" cssClass="error"/> </td>
    </tr>

  </table>
  <p>
    <input type="image" src="../images/button_submit.gif">
  </p>
</form:form>
</div>