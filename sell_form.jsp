<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
 <head>
  <link rel="stylesheet" href="css/sell_form.css" />
  <link rel="stylesheet" href="css/common.css" />
  <link rel="stylesheet" href="css/form.css" />

  <script src="js/common.js"> </script>
  <script src="js/sell_form.js"> </script>
  
  <title>eShop :: Sell Form</title>
 </head>
 <body>
  <div id="page">
	<%@ include file="header.jsp" %>

	<div id="main">
		<% 
			String message_err = (String)request.getAttribute("msg_err"); 
			String message_suc = (String)request.getAttribute("msg_suc"); 
		%>

		<% if(message_err!=null){ %>
			<div class="msg msg_err"><%= message_err %></div>
		<% } else if(message_suc!=null){ %>
			<div class="msg msg_suc"><%= message_suc %></div>
		<% } %>
		
		
		<table class="form_tbl">
			<tr>
				<!-- Registration Form #####################-->
                <td id="cell1" class="outer_cell">
					<form action="save_product.do">
						<table class="main_form">
							<caption class="cap">Product Registration</caption>
							<tr>
								<td colspan="3">&nbsp;</td>
							</tr>
							<tr>
								<td class="lbl">Product Title*</td>
								<td class="mdl">:</td>
								<td class="fld_box">
									<input type="text" class="fld" name="product_name" required="required" />
								</td>
							</tr>
							<tr>
								<td colspan="3">&nbsp;</td>
							</tr>
							<tr>
								<td class="lbl">Category*</td>
								<td class="mdl">:</td>
								<td class="fld_box">
									<select name="category_id">
										<option value="0">Category</option>	
										<c:forEach var="category" items="${categories}">
											<option value="${category.categoryId}">${category.category}</option>	
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<td colspan="3">&nbsp;</td>
							</tr>
							<tr>
								<td class="lbl">Quantity</td>
								<td class="mdl">:</td>
								<td class="fld_box">
									<input type="number" class="fld" name="quantity" /><br />
								</td>
							</tr>
							<tr>
								<td colspan="3">&nbsp;</td>
							</tr>
							<tr>
								<td class="lbl">MRP</td>
								<td class="mdl">:</td>
								<td class="fld_box">
									<input type="text" class="fld" name="mrp" /><br />
								</td>
							</tr>
							<tr>
								<td colspan="3">&nbsp;</td>
							</tr>
							<tr>
								<td class="lbl">GST</td>
								<td class="mdl">:</td>
								<td class="fld_box">
									<input type="text" class="fld" name="gst" /><br />
								</td>
							</tr>
							<tr>
								<td colspan="3">&nbsp;</td>
							</tr>
							<tr>
								<td class="lbl">Discount</td>
								<td class="mdl">:</td>
								<td class="fld_box">
									<input type="text" class="fld" name="discount" /><br />
								</td>
							</tr>
							<tr>
								<td colspan="3">&nbsp;</td>
							</tr>
							<tr>
								<td class="lbl">Description</td>
								<td class="mdl">:</td>
								<td class="fld_box">
									<textarea rows="20" cols="40" name="description"></textarea>
								</td>
							</tr>
							<tr>
								<td colspan="3">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="3" class="btn_box">
									<input type="submit" class="btn" value="Save Product" />
								</td>
							</tr>
							<tr>
								<td colspan="3">&nbsp;</td>
							</tr>
						</table>
					</form>
				</td>
				<!-- Product Pic Upload #####################
				<td id="cell2" class="outer_cell">
					<form action="product_pic_upload.do">
						<table class="main_form">
							<caption class="cap">Pic Upload</caption>
							<tr>
								<td colspan="3">&nbsp;</td>
							</tr>
							
							<tr>
								<td colspan="3">&nbsp;</td>
							</tr>
							
							<tr>
								<td colspan="3">&nbsp;</td>
							</tr>
						</table>
					</form>
				</td>-->
			</tr>	
		</table>
	</div>

	<%@ include file="footer.jsp" %>
  </div>
 </body>
</html>
