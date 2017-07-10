<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
	</head>
	<body>
		<h1>Favorite Things Exercise</h1>
		<h3>What is your favorite food?</h3>
		<c:url var="formAction" value="/Page3"></c:url>
	    <form method="POST" action="${formAction }">
	    	
	        <INPUT TYPE="radio" NAME="season" VALUE="Spring" CHECKED>
             Spring
             <INPUT TYPE="radio" NAME="season" VALUE="Summer" CHECKED>
             Summer
             <INPUT TYPE="radio" NAME="season" VALUE="Fall" CHECKED>
             Fall
             <INPUT TYPE="radio" NAME="season" VALUE="Winter" CHECKED>
             Winter
	        
	        <input type="submit" value="Next >>>">
	    </form>
	</body>
</html>