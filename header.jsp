<%@ page import="models.User" %>
<% User user = (User)session.getAttribute("user"); %>

<link rel="stylesheet" href="css/header.css" />
<script src="js/header.js"></script>

<div id="header">
	<img src="images/logo.png" id="logo_image" />
	<span id="logo_text">eShop</span>
	<span id="cntr">
		<% if(user!=null){ %>
			Hello! <a href="show_profile.do" title="<%= user.getUserName() %>~" id="anc"><%= user.getUserName() %></a>
			<a href="logout.do">Logout</a>
		<% }else{ %>
			<a href="member_access.do">Register</a>
			<a href="member_access.do">Login</a>
		<% } %>		
	</span>

	<span id="cart_box" title="Go To Cart">
		<img src="images/logo.png" width="20" />		
		<span id="cart_size">
			<c:choose>
				<c:when test="${cart==null||cart.size()==0}">
					0
				</c:when>
				<c:otherwise>
					${cart.size()}
				</c:otherwise>
			</c:choose>
		</span>
	</span>
</div>