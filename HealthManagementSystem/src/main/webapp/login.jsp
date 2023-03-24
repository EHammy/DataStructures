<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login Page</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<header>
		<h1>Login to Your Account</h1>
	</header>
	<main>
		<section class="login">
			<h2>Enter your credentials</h2>
			<c:if test="${param.error == '1'}">
				<p class="error">Invalid username or password</p>
			</c:if>
			<form action="login" method="POST">
				<label for="username">Username:</label>
				<input type="text" id="username" name="username" required>
				<label for="password">Password:</label>
				<input type="password" id="password" name="password" required>
				<input type="submit" value="Login">
			</form>
			<p>Don't have an account? <a href="signup.jsp">Sign up here</a></p>
		</section>
	</main>
</body>
</html>
