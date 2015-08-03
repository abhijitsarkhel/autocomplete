<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Add User</title>
<link rel="stylesheet" href="static/css/jquery-ui.min.css">
<link rel="stylesheet" href="static/css/style.css">
</head>
<body>
	<div class="header">
		<h3>Add User</h3>
	</div>
	<div style="float:right;">
		<a href="search.page">search users</a>
	</div>
	<div class="ui-widget">
		<form:form commandName="user">
			<table>
				<tr>
					<td>Enter name:</td>
					<td><form:input path="name"/></td>
				</tr>
				<tr>
					<td>Enter mobile no:</td>
					<td><form:input path="mobile"/></td>
				</tr>
				<tr>
					<td>Enter Address:</td>
					<td>
						<table>
							<tr>
								<td>Door no:</td>
								<td><form:input path="address.door"/></td>
							</tr>
							<tr>
								<td>House no:</td>
								<td><form:input path="address.house"/></td>
							</tr>
							<tr>
								<td>Street:</td>
								<td><form:input path="address.street"/></td>
							</tr>
							<tr>
								<td>Area:</td>
								<td><form:input path="address.area"/></td>
							</tr>
							<tr>
								<td>City:</td>
								<td><form:input path="address.city"/></td>
							</tr>
							<tr>
								<td>State:</td>
								<td><form:input path="address.state"/></td>
							</tr>
							<tr>
								<td>Country:</td>
								<td><form:input path="address.country"/></td>
							</tr>
							<tr>
								<td>PIN Code:</td>
								<td><form:input path="address.pin"/></td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Add User" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>