<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Track Your Vitals</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Health Management System</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link" href="user-dashboard.jsp">Dashboard</a>
				</li>
				<li class="nav-item active">
					<a class="nav-link" href="#">Vitals</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="profile.jsp">Profile</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="logout.jsp">Logout</a>
				</li>
			</ul>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-12">
				<h2>Track Your Vitals</h2>
				<form action="#" method="post">
					<div class="form-group">
						<label for="heart-rate">Heart Rate (BPM):</label>
						<input type="number" class="form-control" id="heart-rate" name="heart-rate" required>
					</div>
					<div class="form-group">
						<label for="blood-pressure">Blood Pressure (mmHg):</label>
						<input type="number" class="form-control" id="blood-pressure" name="blood-pressure" required>
					</div>
					<div class="form-group">
						<label for="temperature">Temperature (°F):</label>
						<input type="number" class="form-control" id="temperature" name="temperature" required>
					</div>
					<div class="form-group">
						<label for="oxygen-level">Oxygen Level (%):</label>
						<input type="number" class="form-control" id="oxygen-level" name="oxygen-level" required>
					</div>
					<button type="submit" class="btn btn-primary">Save</button>
				</form>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper-base.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
</body>
</html>
