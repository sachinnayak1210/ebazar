<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
 <head> 
  <link rel="stylesheet" href="css/common.css" />
  <link rel="stylesheet" href="css/dashboard.css" />

  <script src="js/common.js"> </script>
  <script src="js/dashboard.js"> </script>
  <title>eShop :: DashBoard</title>
 </head>
 <body>
  <div id="page">
	<%@ include file="header.jsp" %>
	
	<%@ include file="menubar.jsp" %>	

	<div id="main">	
		<div class="record_box">
			<c:forEach var="product" items="${products}">
				<div class="record_box_item">
					<img src="product_pic.do?pro_id=${product.productId}" class="pro_pic" />
					<a href="#" class="pro_ttl">${product.product}</a>
					<span class="pro_dtls">				
						<span class="pro_mrp">MRP: ${product.mrp}</span> |
						<span class="pro_qtt">Quantity: ${product.quantity}</span> |
						<span class="pro_gst">GST: ${product.gst}%</span> |
						<span class="pro_dsc">Discount: ${product.discount}%</span>
					</span>
				</div>
			</c:forEach>
		</div>
		
	</div>

	<%@ include file="footer.jsp" %>
  </div>
 </body>
</html>
