<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
	</head>
	<body>
		<h1>Favorite Things Exercise</h1>
		<h3>What is your favorite color?</h3>
		<c:url var="formAction" value="/Page1"></c:url>
	    <form method="POST" action="${formAction }">
	    	
	        <input type="text" name="favoriteColor">
	        
	        <input type="submit" value="Next >>>">
	    </form>
	</body>
</html>