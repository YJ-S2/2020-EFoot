<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="IncludeTop.jsp"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script>
function getSales(userId) {
	var reqUrl = "../rest/sales/" + userId;
	$.ajax({
		type: "get",
		url: reqUrl,
		dataType: 'json',
		async: false,
		processData: false,
		success: function(responseJson){	// object parsed from JSON text	
			$("#detail").html("<ul></ul>");
			for (var i = 0; i < responseJson.length; i++) {
				$("#detail > ul").append("<li> " + responseJson[i].itemName + "</li>"); 
			}
		},
		error: function(){
			alert("ERROR", arguments);
		}
	});
};
</script>

</head>
<table id="main-menu">
	<tr>
		<td><a href='<c:url value="/shop/index.do"/>'><b> <font
					color="black" size="2">&lt;&lt; Main Menu</font></b></a></td>
	</tr>
</table>
<div align="center">
<table>
<tr><td>
<div id="detail"></div>
</td></tr>
</table>
</div>

<div align="center"><br><br>
	<b><font size="4"><c:out value="${salesDetail.itemName}" /></font></b>
	<table class="n13" style="width: 700;">
		<tr bgcolor="#FFFF88">
			<td bgcolor="#FFFFFF"><img src="../upload/${salesDetail.image}" width="400" /> </td>
		</tr>
		<tr>
			<td>SALEID</td>
			<td><c:out value="${salesDetail.saleId}" /></td>
		</tr>
		<tr>
			<td>SELLER</td>
			<td onClick="getSales('${salesDetail.userId}');"><c:out value="${salesDetail.userId}" /></td>
		</tr>
		<tr>
			<td>CATEGORY</td>
			<td><c:out value="${salesDetail.cateId}" /></td>
		</tr>
		<tr>
			<td>PRICE</td>
			<td><fmt:formatNumber value="${salesDetail.item.price}" pattern="$#,##0" /></td>
		</tr>
		<tr>
			<td>CONTENT</td>
			<td><c:out value="${salesDetail.content}" /></td>
		</tr>
		<tr>

		</tr>

	</table><br><c:if test="${salesDetail.userId == userSession.account.userId}">
			<a
					href='<c:url value="/shop/updateSales.do">
          <c:param name="saleId" value="${salesDetail.saleId}"/></c:url>'>
						수정하기</a> <a
					href='<c:url value="/shop/deleteSales.do">
          <c:param name="saleId" value="${salesDetail.saleId}" />
          <c:param name="categoryId" value="${salesDetail.cateId}" /></c:url>'>
						삭제하기</a></c:if>
	<a
		href='<c:url value="/shop/addItemToCart.do">
          <c:param name="workingItemId" value="${salesDetail.saleId}"/></c:url>'>
		<img border="0" src="../images/button_add_to_cart.gif" alt="" />
	</a>

</div>
