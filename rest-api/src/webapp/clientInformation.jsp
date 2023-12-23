<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="Models.Client" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="org.json.JSONObject" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Client Information</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<%
Client client = (Client) session.getAttribute("client");
%>
<body>
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
    <div class="container mt-5">
        <h1 class="mb-4">Client Information</h1>

        <div class="row">
            <!-- First Section: Client ID, ID, and Name -->
            <div class="col-md-4">
                <div class="card mb-4">
                    <div class="card-body">
                        <h5 class="card-title">Client ID, ID, and Name</h5>
                        <ul class="list-group">
                            <li class="list-group-item"><strong>Client ID:</strong> <%= client.getClientId() %></li>
                            <li class="list-group-item"><strong>ID:</strong> <%= client.getId() %></li>
                            <li class="list-group-item"><strong>Name:</strong> <%= client.getName() %></li>
                        </ul>
                    </div>
                </div>
            </div>

            <!-- Second Section: Root URL and Base URL -->
            <div class="col-md-4">
                <div class="card mb-4">
                    <div class="card-body">
                        <h5 class="card-title">Root URL and Base URL</h5>
                        <ul class="list-group">
                            <li class="list-group-item"><strong>Root URL:</strong> <%= client.getRootUrl() %></li>
                            <li class="list-group-item"><strong>Base URL:</strong> <%= client.getBaseUrl() %></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <!-- Third Section: Standard Flow Enabled, Implicit Flow Enabled, Direct Access Grants Enabled -->
            <div class="col-md-4">
                <div class="card mb-4">
                    <div class="card-body">
                        <h5 class="card-title">Flow and Grants</h5>
                        <ul class="list-group">
                            <li class="list-group-item"><strong>Standard Flow Enabled:</strong> <%= client.isStandardFlowEnabled() %></li>
                            <li class="list-group-item"><strong>Implicit Flow Enabled:</strong> <%= client.isImplicitFlowEnabled() %></li>
                            <li class="list-group-item"><strong>Direct Access Grants Enabled:</strong> <%= client.isDirectAccessGrantsEnabled() %></li>
                        </ul>
                    </div>
                </div>
            </div>

            <!-- Fourth Section: Service Accounts Enabled -->
            <div class="col-md-4">
                <div class="card mb-4">
                    <div class="card-body">
                        <h5 class="card-title">Service Accounts</h5>
                        <ul class="list-group">
                            <li class="list-group-item"><strong>Service Accounts Enabled:</strong> <%= client.isServiceAccountsEnabled() %></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <!-- Fifth Section: Remaining Client Details -->
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Remaining Client Details</h5>
                <ul class="list-group">
                    <li class="list-group-item"><strong>Client Authenticator Type:</strong> <%= client.getClientAuthenticatorType() %></li>
                    <li class="list-group-item"><strong>Not Before:</strong> <%= client.getNotBefore() %></li>
                    <li class="list-group-item"><strong>Bearer Only:</strong> <%= client.isBearerOnly() %></li>
                    <li class="list-group-item"><strong>Consent Required:</strong> <%= client.isConsentRequired() %></li>
                    <li class="list-group-item"><strong>Public Client:</strong> <%= client.isPublicClient() %></li>
                    <li class="list-group-item"><strong>Frontchannel Logout:</strong> <%= client.isFrontchannelLogout() %></li>
                    <li class="list-group-item"><strong>Protocol:</strong> <%= client.getProtocol() %></li>

                    <!-- Uncomment the lines below if you have attributes, authenticationFlowBindingOverrides, defaultClientScopes, optionalClientScopes, and access properties in your Client class -->
                    <%-- <li class="list-group-item"><strong>Attributes:</strong> <%= client.getAttributes() %></li> --%>
                    <%-- <li class="list-group-item"><strong>Authentication Flow Binding Overrides:</strong> <%= client.getAuthenticationFlowBindingOverrides() %></li> --%>
                    <%-- <li class="list-group-item"><strong>Default Client Scopes:</strong> <%= client.getDefaultClientScopes() %></li> --%>
                    <%-- <li class="list-group-item"><strong>Optional --%>
                    
</ul>
</div>
</div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>