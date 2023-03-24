<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dashboard</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<header>
		<h1>Welcome, ${sessionScope.username}!</h1>
	</header>
	<main>
		<section class="dashboard">
			<h2>Your Health Data</h2>
			<ul>
				<li><a href="#">Weight Tracker</a></li>
				<li><a href="#">Blood Pressure Tracker</a></li>
				<li><a href="#">Exercise Tracker</a></li>
			</ul>
			<a href="logout" class="logout">Logout</a>
		</section>
	</main>
</body>
</html>
