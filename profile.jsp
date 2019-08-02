<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
 <head> 
  <link rel="stylesheet" href="css/common.css" />
  <link rel="stylesheet" href="css/form.css" />
  <link rel="stylesheet" href="css/profile.css" />

  <script src="js/common.js"> </script>
  <script src="js/profile.js"> </script>
  <title>eShop :: Profile</title>
 </head>
 <body>
  <div id="page">
	<%@ include file="header.jsp" %>

	<%@ include file="menubar.jsp" %>

	<div id="main">	
		
		<table class="form_tbl">
			<tr>
				<!-- Profile #####################-->
                <td id="cell1" class="outer_cell">					
					<table class="main_form">
						<caption class="cap">Profile</caption>
						<tr>
							<td colspan="3">&nbsp;</td>
						</tr>
						<tr>
							<td class="lbl">User Name</td>
							<td class="mdl">:</td>
							<td class="fld_box">
								<span id="unm_sp">${user.userName}</span>
								<input type="text" class="fld hide" id="unm_txt"  />
								<span class="cntr_">
									<img src="images/edit.png" id="unm_edit" class="chng_ show" title="Edit" />
									<img src="images/save.png" id="unm_save" class="chng_ hide" title="Save" />
									<img src="images/cancel.png" id="unm_cancel" class="chng_ hide" title="Cancel" />
								</span>
							</td>
						</tr>
						<tr>
							<td colspan="3">&nbsp;</td>
						</tr>
						<tr>
							<td class="lbl">Email</td>
							<td class="mdl">:</td>
							<td class="fld_box">
								<span>${user.email}</span>
								<input type="text" class="hide" id="email"  />
							</td>
						</tr>
						<tr>
							<td colspan="3">&nbsp;</td>
						</tr>
						<tr>
							<td class="lbl" id="pass_td">Password</td>
							<td class="mdl" id="col_td">:</td>
							<td class="fld_box">
								<span id="pass_sp">*******</span>							
								<div id="pass_box" class="hide">
									<input type="password" class="mrg_btm" id="opass"  minlength="6" maxlength="10" placeholder="Old Password" />
									<input type="password" class="mrg_btm" id="npass"  minlength="6" maxlength="10" placeholder="New Password" />
									<input type="password" class="mrg_btm" id="repass"  minlength="6" maxlength="10" placeholder="Re Password" />
								</div>
								<span class="cntr_">
									<img src="images/edit.png" id="pass_edit" class="chng_ show" title="Edit" />
									<img src="images/save.png" id="pass_save" class="chng_ hide" title="Save" />
									<img src="images/cancel.png" id="pass_cancel" class="chng_ hide" title="Cancel" />
								</span>
							</td>
						</tr>
						<tr>
							<td colspan="3">&nbsp;</td>
						</tr>
						<tr>
							<td class="lbl">Contact</td>
							<td class="mdl">:</td>
							<td class="fld_box">
								<span>${user.contact}</span>
								<input type="text" class="hide" id="contact" />
							</td>
						</tr>
						<tr>
							<td colspan="3">&nbsp;</td>
						</tr>
						<tr>
							<td class="lbl">Address</td>
							<td class="mdl">:</td>
							<td class="fld_box">
								<span>${user.address}</span>
								<textarea class="hide" id="address"></textarea>
							</td>
						</tr>
						<tr>
							<td colspan="3">&nbsp;</td>
						</tr>
						<tr>
							<td class="lbl">City</td>
							<td class="mdl">:</td>
							<td class="fld_box">
								<span id="city_sp">${user.city.cityId}</span>
								<select id="state" class="hide">
								    <option>Select State</option>
									<c:forEach var="state" items="${states}">				
										<option value="${state.stateId}">${state.state}</option>
									</c:forEach>
								</select>
								<select id="city" class="hide">
									<option>Select City</option>
								</select>
								<span class="cntr_" id="cntr_ct">
									<img src="images/edit.png" id="city_edit" class="chng_ show" title="Edit" />
									<img src="images/save.png" id="city_save" class="chng_ hide" title="Save" />
									<img src="images/cancel.png" id="city_cancel" class="chng_ hide" title="Cancel" />
								</span>
							</td>
						</tr>
						<tr>
							<td colspan="3">&nbsp;</td>
						</tr>
						<tr>
							<td class="lbl">Aadhar</td>
							<td class="mdl">:</td>
							<td class="fld_box">
								<span>${user.aadharNumber}</span>
								<input type="text" class="hide" id="aadhar" />
							</td>
						</tr>
						<tr>
							<td colspan="3">&nbsp;</td>
						</tr>
					</table>					
				</td>
				<!-- Profile Pic Upload #####################-->
				<td id="cell2" class="outer_cell">	
					<% String proPic = user.getProfilePic();  %>
					<form action="picupload.do" method="post" enctype="multipart/form-data">
						<img src='<%= proPic!=null?"mypic.do":"images/pic.jpg" %>' width="300" />

						<br />
						<input type="file" name="mypic" />

						<br />

						<input type="submit" value="Upload" />
					</form>					
				</td>
			</tr>	
		</table>
	</div>

	<%@ include file="footer.jsp" %>
  </div>
 </body>
</html>
