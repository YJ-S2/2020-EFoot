<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="IncludeTop.jsp"%>


 
<table id="main-menu">
	<tr>
		<td><a href='<c:url value="/shop/index.do"/>'><b> <font
					color="black" size="2">&lt;&lt; Main Menu</font></b></a></td>
	</tr>
</table>


<div align="center">
  
      <h2>Shopping Cart</h2>
      
        <table class ="n23">
          <tr bgcolor="#cccccc">
            <td><b>ID</b></td>
            <td><b>분류</b></td>
            <td><b>품목명</b></td>
            <td><b>가격</b></td>
            <td><b>판매자 ID</b></td>
            <td colspan="2">&nbsp;</td>
          </tr>

          <c:if test="${map.cartMap==null}">
            <tr bgcolor="#FFFF88">
              <td colspan="8"><b>Your cart is empty.</b></td>
            </tr>
          </c:if>

          <c:forEach var="cartItem" items="${map.cartMap}">
            <tr bgcolor="#FFFF88">
              <td><b>
               	<a href='<c:url value="/shop/viewSalesDetail.do"> <c:param name="salesId" value="${cartItem.key}"/></c:url>'>
					<c:out value="${cartItem.value.saleId}" /></a></b>
			  </td>
              <td><c:out value="${cartItem.value.cateId}" /></td>
              <td><c:out value="${cartItem.value.itemName}" /></td>
              <td><c:out value="${cartItem.value.price}" /></td>
              <td><c:out value="${cartItem.value.userId}" /></td>
              <td><a href='<c:url value="/shop/removeItemFromCart.do">
                    <c:param name="workingItemId" value="${cartItem.value.saleId}"/></c:url>'>
                    	삭제</a>
              </td>
              <td><a href='<c:url value="/shop/orderForm.do">
                    <c:param name="saleId" value="${cartItem.value.saleId}"/></c:url>'>
                    	주문</a>
              </td>
            </tr>
          </c:forEach>
         
        </table>
 <br>
       
</div>