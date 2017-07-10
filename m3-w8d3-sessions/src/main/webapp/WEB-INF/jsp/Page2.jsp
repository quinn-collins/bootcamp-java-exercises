<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
	</head>
	<body>
		<h1>Favorite Things Exercise</h1>
		<h3>What is your favorite food?</h3>
		<c:url var="formAction" value="/Page2"></c:url>
	    <form method="POST" action="${formAction }">
	    	
	        <input type="text" name="favoriteFood">
	        
	        <input type="submit" value="Next >>>">
	    </form>
	</body>
</html>