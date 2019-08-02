<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
 <head> 
  <link rel="stylesheet" href="css/common.css" />
  <link rel="stylesheet" href="css/form.css" />
  <link rel="stylesheet" href="css/product_pic_upload.css" />
  <link rel="stylesheet" href="css/menubar.css" />

  <script src="js/common.js"> </script>
  <script src="js/product_pic_upload.js"> </script>
  <title>eShop :: Product Pic Upload</title>
 </head>
 <body>
  <div id="page">
	<%@ include file="header.jsp" %>

	<div id="menu_bar">
		<form action="search.do">
			<select name="category" id="cat">
				<option>Categories</option>
				<option>Electronics</option>
				<option>Cloths</option>
				<option>Toys</option>
			</select>
			<input type="text" name="search_text" id="search_text" />
			<input type="submit" value="Find" id="find_btn" />
		</form>

		<a href="product_sell_form.do" id="sell_pro">Sell Products</a>
	</div>

	<div id="main">	
		<!-- ################################################# -->
		<table class="form_tbl">
			<tr>
				<!-- Product Pic Upload ##################### -->
				<td id="cell2" class="outer_cell">
					
						<table class="main_form">
							<caption class="cap">
								Pic Upload 
								<a id="sv_pic" href="save_pics.do">Finish</a>
							</caption>
							<form action="product_pic_upload.do" enctype="multipart/form-data" method="post">
							<tr>
								<td>
									<% int c = 3; %>
									<table  width="100%" cellspacing="12">									
											<c:forEach varStatus="abc" var="proPic" items="${product_pics}">	
													<% if(c%3==0){ %>
													 <tr>
													<% } %>
														<td style="border:1px solid red;background-color:#ebebeb;position:relative;text-align:center">		
															<img id="img_${abc.index}" src="show_product_pic.do?picPath=${proPic}" height="200" />
															<img id="cancel_${abc.index}" style="position:absolute;left:0px;top:0px;z-index:1;" src="images/cancel.png" />		
														</td>
													<% if((c+1)%3==0){ %>
													 </tr>
													<% } c++; %>
											</c:forEach>
										
									</table>
																		
								</td>
							</tr>
							<tr>
								<td>
									<input type="file" name="product_pic" />
									<input type="submit" value="Upload" />
								</td>
							</tr>
							</form>
						</table>
					
				</td>-->
			</tr>	
		</table>
		<!-- ###################### -->
		
	</div>

	<%@ include file="footer.jsp" %>
  </div>
 </body>
</html>
