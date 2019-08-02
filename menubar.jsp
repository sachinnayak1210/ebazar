<script src="js/menubar.js"></script>
<link rel="stylesheet" href="css/menubar.css" />

<div id="menu_bar">
	<img src="images/dashboard.png"  style="float:left;border:1px solid #ccc;margin-left:45px;cursor:pointer" id="ds" title="Dashboard" onclick="showDashboard()" />

	<a href="product_sell_form.do" id="sell_pro" style="float:right">Sell Products</a>

	<form action="search.do">
		<table align="center">
			<tr>
				<td>
					<select name="category" id="cat">
						<option>Categories</option>
						<option>Electronics</option>
						<option>Cloths</option>
						<option>Toys</option>
					</select>
				</td>
				<td>
					<div style="position:relative">
						<input type="text" onkeyup="searchHint()" name="search_text" id="search_text" />
						<div id="result"></div>	
					</div>
				</td>
				<td>
					<input type="submit" value="Find" id="find_btn" />
				</td>
			</tr>
		</table>		
	</form>

	
</div>