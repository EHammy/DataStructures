<!DOCTYPE html>
<html>
<head>
	<title>Track Vitals</title>
	<link rel="stylesheet" type="text/css" href="style.css">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
		$( function() {
			$( "#datepicker" ).datepicker();
		} );
	</script>
</head>
<body>
	<h1>Track Vitals</h1>
	<form action="AddVitalsServlet" method="post">
		<label for="date">Date:</label>
		<input type="text" id="datepicker" name="date"><br>

		<label for="bloodPressure">Blood Pressure:</label>
		<input type="text" id="bloodPressure" name="bloodPressure"><br>

		<label for="heartRate">Heart Rate:</label>
		<input type="text" id="heartRate" name="heartRate"><br>

		<label for="weight">Weight:</label>
		<input type="text" id="weight" name="weight"><br>

		<button type="submit">Add Vitals</button>
	</form>
</body>
</html>
