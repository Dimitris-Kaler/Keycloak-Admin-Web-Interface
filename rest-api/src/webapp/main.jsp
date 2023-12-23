<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="Models.Users"%>
<%@page import="Models.Client"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Repository</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.slim.min.js"
	integrity="sha256-u7e5khyithlIdTpu22PHhENmPcRdFiHRjhAuHcs05RI="
	crossorigin="anonymous"></script>
<link href="/DataTables/datatables.css">

<script src="/DataTables/datatables.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.css">
<link rel="stylesheet" href="style.css">
</head>
<%
List<Users> userList = (List<Users>) session.getAttribute("usersList");
%>
<%
List<Client> clientList = (List<Client>) session.getAttribute("clientList");
boolean clientBtn = (session.getAttribute("clientBtn") != null) ? (boolean) session.getAttribute("clientBtn") : false;
%>
<body>

</body>
<div id="main">
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Administrator</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active">
					<form class="form-inline my-2 my-lg-0" action="userRepository"
						method="GET">
						<button class="btn btn-outline-primary my-2 my-sm-0" type="submit"
							onclick="showUsersTable()">Users List</button>
					</form>
				</li>
				<li class="nav-item">
					<form class="form-inline my-2 my-lg-0 mx-3" action="createUser"
						method="GET">
						<button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Create
							a new user</button>
					</form>
				</li>
				<li class="nav-item">
					<form class="form-inline my-2 my-lg-0 mx-3"
						action="clientRepository" method="GET">
						<button class="btn btn-outline-primary my-2 my-sm-0" type="submit"
							onclick="showClientsTable()">Clients List</button>
					</form>
				</li>
			</ul>
		</div>
	</nav>
	<div class="container justify-content-center border mt-5">
		<%
		if (userList != null && !userList.isEmpty()&&clientBtn!=true) {
		%>
		<div id="usersTable">
			<h4 class="text-center">Users Repository</h4>
			<div id="table-area row">
				<table id="table-stats" class="display table">
					<h4 class="table-heading">General Stats</h4>
					<thead>
						<tr>
							<th>Id</th>
							<th>Username</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>Delete</th>
							<th>Update</th>
						</tr>
					</thead>
					<tbbody> <%
 for (Users user : userList) {
 %>
					<tr>
						<th><%=user.getId()%></th>
						<th><%=user.getUsername()%></th>
						<th><%=user.getFirstName()%></th>
						<th><%=user.getLastName()%></th>
						<th><%=user.getEmail()%></th>
						<th><a href="/rest-api/delete/<%=user.getId()%>">X</a></th>
						<th><a href="/rest-api/updateUser/<%=user.getId()%>">update</a>
					</tr>
					<%
					}
					%>

					</tbody>
				</table>
			</div>
		</div>
		<%
		} else if (clientList != null && !clientList.isEmpty()) {
		%>
		<div id="clientsTable">
			<h4 class="text-center">Clients Repository</h4>
			<div id="table-area row">
				<table id="table-stats" class="display table">
					<h4 class="table-heading">General Stats</h4>
					<thead>
						<tr>
							<th>ID</th>
							<th>Client ID</th>
							<th>Name</th>
							<th>Root URL</th>
							<th>Base URL</th>
							<th>SurrogateAuthRequired</th>
							<th>Enabled</th>
							<th>AlwaysDisplayInConsole</th>
							<!-- Add more columns as needed -->
						</tr>
					</thead>
					<tbody>
						<%
						for (Client client : clientList) {
						%>
						<tr>
							<td><%=client.getId()%></td>
							<td><%=client.getClientId()%></td>
							<td><%=client.getName()%></td>
							<td><%=client.getRootUrl()%></td>
							<td><%=client.getBaseUrl()%></td>
							<td><%=client.isSurrogateAuthRequired() %>
							<td><%=client.isEnabled() %>
							<td><%=client.isAlwaysDisplayInConsole() %>
							<!-- Populate other client fields similarly -->
						</tr>
						<%
						}
						%>

					</tbody>

				</table>
			</div>
		</div>
		<%
		}
		%>
	</div>




	<script type="text/javascript" src='table.js'></script>

</html>