<!doctype html>
<html lang="en">
 <head>
  <link rel="stylesheet" href="css/register_login.css" />
  <link rel="stylesheet" href="css/common.css" />
  <link rel="stylesheet" href="css/form.css" />
  <script src="js/register_login.js"> </script>
  <title>eShop :: Member Access</title>
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
					<form action="register.do">
						<table class="main_form">
							<caption class="cap">Registration Form</caption>
							<tr>
								<td colspan="3">&nbsp;</td>
							</tr>
							<tr>
								<td class="lbl">User Name*</td>
								<td class="mdl">:</td>
								<td class="fld_box">
									<input type="text" class="fld" name="user_name" required="required" />
								</td>
							</tr>
							<tr>
								<td colspan="3">&nbsp;</td>
							</tr>
							<tr>
								<td class="lbl">Email</td>
								<td class="mdl">:</td>
								<td class="fld_box">
									<input type="text" class="fld" name="email" id="email"  /><br />
									<span id="eml_msg"></span>
								</td>
							</tr>
							<tr>
								<td colspan="3">&nbsp;</td>
							</tr>
							<tr>
								<td class="lbl">Password</td>
								<td class="mdl">:</td>
								<td class="fld_box">
									<input type="password" class="fld" name="password"  minlength="6" maxlength="10" />
									<!-- <input type="password" class="fld" name="password"  minlength="6" maxlength="10" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,10}" title="Minimum eight and maximum 10 characters, at least one uppercase letter, one lowercase letter, one number and one special character" /> -->
								</td>
							</tr>
							<tr>
								<td colspan="3">&nbsp;</td>
							</tr>
							<tr>
								<td class="lbl">Re-Password</td>
								<td class="mdl">:</td>
								<td class="fld_box">
									<input type="password" class="fld" name="repassword" />
								</td>
							</tr>
							<tr>
								<td colspan="3">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="3" class="btn_box">
									<input type="submit" class="btn" value="Register" />
								</td>
							</tr>
							<tr>
								<td colspan="3">&nbsp;</td>
							</tr>
						</table>
					</form>
				</td>
				<!-- Login Form #####################-->
				<td id="cell2" class="outer_cell">
					<form action="login.do">
						<table class="main_form">
							<caption class="cap">Login Form</caption>
							<tr>
								<td colspan="3">&nbsp;</td>
							</tr>
							<tr>
								<td class="lbl">Email</td>
								<td class="mdl">:</td>
								<td class="fld_box">
									<input type="text" class="fld" name="email" />
								</td>
							</tr>
							<tr>
								<td colspan="3">&nbsp;</td>
							</tr>
							<tr>
								<td class="lbl">Password</td>
								<td class="mdl">:</td>
								<td class="fld_box">
									<input type="password" class="fld" name="password" />
								</td>
							</tr>
							<tr>
								<td colspan="3">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="3" class="btn_box">
									<input type="submit" class="btn" value="Login" />
								</td>
							</tr>
							<tr>
								<td colspan="3">&nbsp;</td>
							</tr>
						</table>
					</form>
				</td>
			</tr>	
		</table>
	</div>

	<%@ include file="footer.jsp" %>
  </div>
 </body>
</html>
