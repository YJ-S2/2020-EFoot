<%@ include file="IncludeTop.jsp"%>

<table id="main-menu">
  <tr><td>
    <a href='<c:url value="/shop/index.do"/>'>
      <b><font color="black" size="2">&lt;&lt; Main Menu</font></b></a>
  </td></tr>
</table>
 
<div align="center">
  <table class="n13">
    <tr>
      <td align="center" colspan="2">
        <font size="4"><b>Order</b></font><br />
        <font size="3">
          <b></b></font>
      </td>
    </tr>
     <tr><td>Card Type:</td>
      <td>${orderForm.cardType}</td>
    </tr>
    <tr>
      <td>Card Number:</td>
      <td>${orderForm.cardNumber}</td>
    </tr>
    <tr>
      <td>Expiry Date (MM/YYYY):</td>
      <td>${orderForm.expiryDate}</td>
    </tr>
   
    <tr>
      <td>Address:</td>
      <td>${orderForm.orderAddress}</td>
    </tr>
    <tr>
      <td>Zip:</td>
      <td>${orderForm.orderZip}</td>
    </tr>
  </table>
  <p>
  <a href='<c:url value="/shop/orderList.do"> <c:param name="userId" value="${userSession.account.userId}"/> </c:url>'>
		
   
      <img border="0" src="../images/button_continue.gif" alt="" /></a>
  </p>
</div>