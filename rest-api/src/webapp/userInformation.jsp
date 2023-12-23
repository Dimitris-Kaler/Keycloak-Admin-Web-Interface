<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="Models.Users"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Information</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
 <link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<%
Users user = (Users) session.getAttribute("user");
%>
<body>
	   <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Administrator</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <form class="form-inline my-2 my-lg-0" action="userRepository" method="GET">
                        <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Users List</button>
                    </form>
                </li>
                <li class="nav-item">
                    <form class="form-inline my-2 my-lg-0 mx-3" action="createUser" method="GET">
                        <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Create a new user</button>
                    </form>
                </li>
                  <li class="nav-item">
                    <form class="form-inline my-2 my-lg-0 mx-3" action="clientRepository" method="GET">
                        <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Clients List</button>
                    </form>
                </li>
            </ul>
        </div>
    </nav>
<div class="container mt-5">
 <h2 class="text-center mb-4">Update User</h2>
	<form class="border p-4 form"action="updateUser/<%=user.getId()%>" method="POST">
		<input type="hidden" name="id" value="<%=user.getId()%>" readonly>
		<div class="form-group row">
			<label for="Username" class="col-sm-2 col-form-label">User
				Name</label>
			<div class="col-sm-10">
				<input type="text" name="Username" value="<%=user.getUsername()%>">
			</div>
		</div>
		<div class="form-group row">
			<label for="firstName" class="col-sm-2 col-form-label">First
				Name</label>
			<div class="col-sm-10">
				<input type="text" name="firstName" value="<%=user.getFirstName()%>">
			</div>
		</div>
		<div class="form-group row">
			<label for="lastName" class="col-sm-2 col-form-label">Last
				Name</label>
			<div class="col-sm-10">
				<input type="text" name="lastName" value="<%=user.getLastName()%>">
			</div>
		</div>
		<div class="form-group row">
			<label for="email" class="col-sm-2 col-form-label">Email</label>
			<div class="col-sm-10">
				<input type="text" name="email" value="<%=user.getEmail()%>">
			</div>
		</div>



		<input type="submit" class="btn btn-primary" value="Update User">





	</form>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>