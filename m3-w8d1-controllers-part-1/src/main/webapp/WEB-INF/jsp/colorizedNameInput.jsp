<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>

	<h2>Colorized Name</h2>
	<c:url var="formAction" value="/colorizedNameResult"></c:url>
	<form method="get" action="${formAction }">
		<label for="firstName">First Name: </label><br>
		<input type="text" name="firstName"/><br>
		
		<label for="lastName">Last Name: </label><br>
		<input type="text" name="lastName"/><br>
		
		<br>
		
		<input type="radio" name="red" value="red">Red<br>
		<input type="radio" name="blue" value="blue">Blue<br>
		<input type="radio" name="green" value="green">Green<br>
		
		<br>
		
		<input type="submit" value="Send it!">
		
	</form>
</body>
</html>