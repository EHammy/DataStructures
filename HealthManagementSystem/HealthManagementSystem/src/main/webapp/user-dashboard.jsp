<%@ page import="model.User" %>
<%
    User user = (User) request.getSession().getAttribute("user");
    String username = "";
    if (user != null) {
        username = user.getUsername();
    }
%>

<!DOCTYPE html>
<html>
<head>
	<title>User Dashboard</title>
	<script src="dashboard.js"></script>
	<style>
		body {
			margin: 0;
			padding: 0;
			font-family: Arial, sans-serif;
		}
		.header {
			background-color: #CD5C5C;
			color: #fff;
			padding: 20px;
			text-align: center;
		}
		.sidenav {
			height: 100%;
			width: 220px;
			position: fixed;
			top: 0;
			left: 0;
			background-color: #333;
			overflow-x: hidden;
			padding-top: 20px;
		}
		.sidenav a {
			padding: 6px 6px 6px 24px;
			text-decoration: none;
			font-size: 16px;
			color: #fff;
			display: block;
			margin-bottom: 10px;
		}
		.sidenav a:hover {
			background-color: #444;
		}
		.sidenav i {
			margin-right: 10px;
		}
		.subnav {
			padding: 6px 6px 6px 24px;
			font-size: 16px;
			color: #fff;
			display: block;
			margin-bottom: 10px;
		}
		.subnav ul {
			list-style-type: none;
			margin: 0;
			padding: 0;
		}
		.subnav li {
			padding: 6px 6px 6px 24px;
			font-size: 16px;
			color: #fff;
			display: block;
			margin-bottom: 10px;
		}
		.subnav li:hover {
			background-color: #444;
		}
		.main {
			margin-left: 220px;
			padding: 20px;
			
		}
		.section {
			margin-bottom: 40px;
			padding: 20px;
			background-color: #eee;
			border-radius: 10px;
			box-shadow: 0px 0px 10px #ccc;
		}
		.section h2 {
			font-size: 24px;
			margin-top: 0;
			margin-bottom: 20px;
		}
		.section p {
			font-size: 18px;
			margin-top: 0;
			margin-bottom: 20px;
		}
		.icon {
		    border: 1px solid #ccc;
		    border-radius: 50%;
		    background-color: #f8f8f8;
		    padding: 10px;
		    box-sizing: border-box;
		    max-width: 100%;
		    height: auto;
  }
		.subnav-menu {
		  position: absolute;
		  top: 100%;
		  left: 0;
		  z-index: 1;
		  background-color: #333;
		  padding: 10px;
		  border-radius: 0 0 5px 5px;
		  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);
		  display: none;
		}
		
		.subnav-menu li {
		  margin: 0;
		}
		
		.subnav-menu a {
		  display: block;
		  padding: 8px 16px;
		  color: #fff;
		  font-size: 16px;
		  text-decoration: none;
		  transition: background-color 0.3s;
		}
		
		.subnav-menu a:hover {
		  background-color: #444;
		}
		
		.subnav-menu.show {
		  display: block;
}
	</style>
</head>

<body>
<header class="header">
<h1>Welcome, <%= username %>!</h1>
</header>
	<div class="sidenav">
		<a href="profile.jsp"><img src="imgs/profile.png" alt="Profile" width="24" height="24" /> Profile</a>
		<a href="#"><i class="fas fa-shopping-cart"></i> Orders</a>
		<a href="#"><i class="fas fa-credit-card"></i> Payments</a>
		<a href="vitals.jsp" class="subnav" id="vitals-link"><i class="fas fa-heartbeat"></i> Vitals</a>
			<ul class="subnav-menu" id="vitals-menu">
			  <li><a href="viewVitals.jsp">View Vitals</a></li>
			  <li><a href="addVitals.jsp">Add New Vitals</a></li>
			</ul>
		<a href="#"><i class="fas fa-cog"></i> Settings</a>
		<a href="#"><i class="fas fa-question-circle"></i> Help</a>
		<a href="logout.jsp"><i class="fas fa-cog"></i> Logout</a>
	</div>
	<div class="main">
		<div class="section-container">
			<section class="section">
				<h2>Health Summary</h2>
				<p>View your health summary, including vitals and other health information.</p>
				<a href="#">View Health Summary</a>
			</section>
			<section class="section">
				<h2>Recent Orders</h2>
				<p>View your recent orders and order status.</p>
				<a href="#">View Orders</a>
			</section>
			<section class="section">
				<h2>Upcoming Appointments</h2>
				<p>View your upcoming appointments and schedule new ones.</p>
				<a href="#">View Appointments</a>
			</section>
		</div>
	</div>
	<!-- Font Awesome CDN for icons -->
	<script src="https://kit.fontawesome.com/yourkitid.js"></script>
</body>
</html>






				