<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
 <head> 
  <link rel="stylesheet" href="css/common.css" />
  <link rel="stylesheet" href="css/show_cart.css" />

  <script src="js/common.js"> </script>
  <script src="js/show_cart.js"> </script>
  <title>eShop :: DashBoard</title>
 </head>
 <body>
  <div id="page">
	<%@ include file="header.jsp" %>
	
	<%@ include file="menubar.jsp" %>	

	<div id="main">	
		<table class="record_box" width="100%" border="1">
			<tr>
				<th>Pic</th>
				<th>Title</th>
				<th>Unit Price</th>
				<th>Quantity</th>
				<th>Total</th>
			</tr>
			<c:forEach var="product" items="${cart_records}" varStatus="x">
				<tr class="record_box_item" align="center">
					<input type="hidden" id="proId_${x.count}" value="${product.productId}" />
					<td><img src="product_pic.do?pro_id=${product.productId}" width="80" class="pro_pic" /></td>
					<td><a href="product_detail.do?pro_id=${product.productId}" class="pro_ttl">${product.product}</a></td>
					<td>
						<span class="pro_mrp">
							<span id="mrp_${x.count}">${product.mrp-(product.mrp*product.discount/100)}</span>
						</span>
					</td>
					<td><input type="number" min="1" value="1" style="width:50px" id="apply_changes_${x.count}" /></td>
					<td id="amt_${x.count}">${product.mrp-(product.mrp*product.discount/100)}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="4" align="right"><b>Grand Total(Rs.): </b></td>
				<td id="gt" align="center"></td>
			</tr>
			<tr>
				<td colspan="5" align="right"><span id="chk" style="border:1px solid red;padding:3px 8px;font-weight:bold;font-size:22px;cursor:pointer;color:#888">Checkout&gt;&gt;</span></td>
			</tr>
		</div>
		
	</div>

	<%@ include file="footer.jsp" %>
  </div>
 </body>
</html>
