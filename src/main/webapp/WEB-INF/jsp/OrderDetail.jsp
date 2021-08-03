<%@ include file="IncludeTop.jsp"%>

<table id="main-menu">
  <tr><td>
    <a href='<c:url value="/shop/index.do"/>'>
      <b><font color="black" size="2">&lt;&lt; Main menu</font></b></a>
  </td></tr>
</table>
 <center><h3>My Order Detail</h3></center>
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
      <td>${orderDetail.cardType}</td>
    </tr>
    <tr>
      <td>Card Number:</td>
      <td>${orderDetail.cardNumber}</td>
    </tr>
    <tr>
      <td>Expiry Date (MM/YYYY):</td>
      <td>${orderDetail.expiryDate}</td>
    </tr>
   
    <tr>
      <td>Address:</td>
      <td>${orderDetail.orderAddress}</td>
    </tr>
    <tr>
      <td>Zip:</td>
      <td>${orderDetail.orderZip}</td>
    </tr>
  </table>

</div>