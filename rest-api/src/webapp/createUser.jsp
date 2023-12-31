<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New User</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
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
<h2 class="text-center mb-4">Add New User</h2>
<form class="border p-4 form"action="addUser"method="POST" >
<div class="form-group row">
			<label for="Username" class="col-sm-2 col-form-label">User
				Name:</label>
			<div class="col-sm-10">
				<input type="text" name="Username" placeholder="e.g. Doe">
			</div>
		</div>
<div class="form-group row">
			<label for="firstName" class="col-sm-2 col-form-label">First
				Name:</label>
			<div class="col-sm-10">
				<input type="text" name="firstName" placeholder="e.g. Mike">
			</div>
		</div>
		<div class="form-group row">
			<label for="lastName" class="col-sm-2 col-form-label">Last
				Name:</label>
			<div class="col-sm-10">
				<input type="text" name="lastName" placeholder="e.g. Shinoda">
			</div>
		</div>
		<div class="form-group row">
			<label for="email" class="col-sm-2 col-form-label">Email:</label>
			<div class="col-sm-10">
				<input type="text" name="email" placeholder="e.g. johndoe@gmail.com">
			</div>
		</div>
		<div class="form-group row">
			<label for="password" class="col-sm-2 col-form-label">Password:</label>
			<div class="col-sm-10">
				<input type="text" name="password" placeholder="****">
			</div>
		</div>

<input type="submit"name="submit">


</form>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>