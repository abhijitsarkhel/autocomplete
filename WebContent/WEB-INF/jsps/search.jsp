<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Users</title>
<script src="static/js/jquery-2.1.4.min.js"></script>
<script src="static/js/jquery-ui.min.js"></script>
<script src="static/js/autocompleter.js"></script>
<link rel="stylesheet" href="static/css/jquery-ui.min.css">
<link rel="stylesheet" href="static/css/style.css">
</head>
<body>
	<div class="header">
		<h3>Search Users</h3>
	</div>
	<div class="search-container">
		<div class="ui-widget">
			<form method="post" action="search.page">
				<b>Search User:</b> <input id="search" name="search" class="search" />
				<input type="submit" value="search" />
			</form>
		</div>
	</div>
	<div class="search-results">
		<c:if test="${not empty searchResult}">
			<h3>Search Results</h3>
			<c:forEach items="${searchResult}" var="user">
				<table>
					<tr>
						<td>Name</td>
						<td>${user.name}</td>
					</tr>
					<tr>
						<td>Mobile</td>
						<td>${user.mobile}</td>
					</tr>
					<tr>
						<td>Address</td>
						<td>${user.address.door}, ${user.address.house},
							${user.address.street}, ${user.address.area},
							${user.address.city}, ${user.address.state},
							${user.address.country} - ${user.address.pin}
					</tr>
				</table>
			</c:forEach>
		</c:if>
	</div>
</body>
</html>