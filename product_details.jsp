<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
 <head> 
  <link rel="stylesheet" href="css/common.css" />
  <link rel="stylesheet" href="css/product_details.css" />

  <script src="js/common.js"> </script>
  <script src="js/product_details.js"> </script>
  <title>eShop :: Product Details</title>
 </head>
 <body>
  <div id="page">
	<%@ include file="header.jsp" %>
	
	<%@ include file="menubar.jsp" %>	

	<div id="main">	
		<input type="hidden" id="pro_id" value="${product.productId}" />
		<table border="1" width="100%">
			<caption id="cap">Product Result</caption>
			<tr>
				<td width="40%"><!-- Image Section -->
					<table border="1" width="100%">
						<tr>
							<td width="25%">
								<div class="arrow" id="up_arrow">
									<img src="images/arrow_up.jpg" />
								</div>
								<c:forEach var="pic_path" items="${product_pic_paths}" varStatus="cn">
									<div class="img_box" id="box_${cn.count}">
										<img src="product_pic.do?pic_path=${pic_path}" id="pic_${cn.count}" class="_pic" />	
									</div>
								</c:forEach>
								<div class="arrow" id="down_arrow">
									<img src="images/arrow_dw.jpg" />
								</div>
							</td>
							<td width="75%"><img src="product_pic.do?pic_path=${product_pic_paths[0]}" id="main_pic" /></td>
						</tr>
					</table>
				</td>
				<td width="60%" valign="top"><!-- Product Details Section -->
					<div id="pro_dtl"  style="border: 1px solid red">
						<span id="title">${product.product}</span>

						<span id="seller" class="rec"><span class="lbl">Seller: </span>${product.user.userName}</span>
						
						<span id="qt" class="rec"><span class="lbl">Quantity:</span> ${product.quantityLeft}/${product.quantity}</span>
						
						<span id="mrp" class="rec">
							<span class="lbl">MRP:</span> 
							<b>${product.mrp-(product.mrp*product.discount/100)}</b>(<s style="color:#999">${product.mrp}</s>)
						</span>

						<span id="gst" class="rec"><span class="lbl">GST:</span> ${product.gst}%</span>

						<span id="discount" class="rec"><span class="lbl">Discount:</span> ${product.discount}%</span>
					</div>
					<table width="100%">
						<tr align="center">
							<td width="25%"><img src="images/add_to_cart.gif" class="cntrl" title="Add To Cart" id="atc" /></td>
							<td width="25%"><img src="images/buy_now.gif" class="cntrl" title="Buy Now" id="bn" /></td>
							<td width="25%"><img src="images/add_to_wish_list.gif" class="cntrl" title="Add To Wish List" id="atwl" /></td>
							<td width="25%">
							<c:if test="${user.userId==product.user.userId}">
								<img src="images/remove.jpg" class="cntrl" title="Remove Listing" id="rm" />
							</c:if>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="2"><!-- Product Description -->
					${product.description}
				</td>
			</tr>
		</table>		
	</div>

	<%@ include file="footer.jsp" %>
  </div>
 </body>
</html>
