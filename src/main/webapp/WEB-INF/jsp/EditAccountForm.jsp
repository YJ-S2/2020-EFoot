<%@ include file="IncludeTop.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div align="center">
   <form:form commandName="accountForm" method="post">
      <form:errors cssClass="error" />
      <br>
      <br>

      <table id="account">
         <tr>
            <td>
               <h3>
                  <font color="darkgreen">User Information</font>
               </h3>
               <table class="n13">
                  <tr>
                     <td>User ID:</td>
                     <td><c:if test="${accountForm.newAccount}">
                           <form:input path="account.userId" />
                           <B><form:errors path="account.userId" cssClass="error" /></B>
                        </c:if> <c:if test="${!accountForm.newAccount}">
                           <c:out value="${accountForm.account.userId}" />
                        </c:if></td>
                  </tr>
                  <tr>
                     <td>New password:</td>
                     <td><form:password path="account.password" /> <B><form:errors
                              path="account.password" cssClass="error" /></B></td>
                  </tr>
                  <tr>
                     <td>Repeat password:</td>
                     <td><form:password path="repeatedPassword" /> <B><form:errors
                              path="repeatedPassword" cssClass="error" /></B></td>
                  </tr>
               </table> <%@ include file="IncludeAccountFields.jsp"%>

            </td>
         </tr>
      </table>
      <br />
      <input type="image" src="../images/button_submit.gif" name="submit"
         value="Save Account Information" />
   </form:form>
   
   <br>
   
   <c:if test="${!empty userSession.account.userId}">
   		  <h3>
	         <b><a href='<c:url value="/shop/viewCart.do"/>'> My Cart </a></b>
	      </h3>
	      <h3>
	         <b><a href='<c:url value="/shop/orderList.do"> <c:param name="userId" value="${userSession.account.userId}"/> </c:url>'>My Order</a></b>
	      </h3>
	      <h3>
	         <b><a href='<c:url value="/shop/myReview.do"/>'>My Review</a></b>
	      </h3>
	      <h3>
	         <b><a href='<c:url value="/shop/mySales.do"> <c:param name="userId" value="${accountForm.account.userId}"/></c:url>'>My Sell</a></b>
	      </h3>
	      <h3>
	         <b><a href='<c:url value="/shop/myPointHistory.do"> <c:param name="userId" value="${accountForm.account.userId}"/></c:url>'>My Point</a></b>
	      </h3>
	      <h3>
	         <b><a href='<c:url value="/shop/myAuction.do"> <c:param name="userId" value="${accountForm.account.userId}"/> </c:url>'> My Auction</a></b>
	      </h3>
	      <h3>
	         <b><a href='<c:url value="/shop/gbByHeader.do"> <c:param name="userId" value="${accountForm.account.userId}"/></c:url>'> My GroupBuying </a></b>
	      </h3>
	      	      <h3>
	         <b><a href='<c:url value="/shop/myShareList.do"> <c:param name="userId" value="${accountForm.account.userId}"/></c:url>'> My Share </a></b>
	      </h3>

   </c:if>

</div>