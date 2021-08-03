<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h3>
  <font color="darkgreen">Account Information</font>
</h3>

<table class="n13">
  <tr>
    <td>Name:</td>
    <td><form:input path="account.name" />
      <form:errors path="account.name" cssClass="error" /></td>
  </tr>
  <tr>
    <td>Email:</td>
    <td><form:input path="account.email" />
      <form:errors path="account.email" cssClass="error" /></td>
  </tr>
  <tr>
    <td>Phone:</td>
    <td><form:input path="account.phone" /> 
      <form:errors path="account.phone" cssClass="error" /></td>
  </tr>
  <tr>
    <td>Address:</td>
    <td><form:input path="account.address" />
      <form:errors path="account.address" cssClass="error" /></td>
  </tr>
  <tr>
    <td>Zip:</td>
    <td><form:input path="account.zip" /> 
      <form:errors path="account.zip" cssClass="error" /></td>
  </tr>
</table>