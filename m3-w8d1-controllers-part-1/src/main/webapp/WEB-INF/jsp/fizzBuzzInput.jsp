<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<body>
	<h1>FizzBuzz Revisited</h1>
	<c:url var="formAction" value="/fizzBuzzResult"></c:url>
	<form method="get" action="${formAction}">
		<label for="divisibleByFirst">Divisible By:</label><br>
		<input type="text" name="divisibleByFirst"/><br>
		
		<label for="divisibleBySecond">Divisible By:</label><br>
		<input type="text" name="divisibleBySecond"/><br>
		
		<label for="alternateFizz">Alternate Fizz:</label><br>
		<input type="text" name="alternateFizz"/><br>
		
		<label for="alternateBuzz">Alternate Buzz:</label><br>
		<input type="text" name="alternateBuzz"/><br>
		
		<label for="numberOne">Number 1:</label><br>
		<input type="text" name="numberOne"/><br>
		
		<label for="numberTwo">Number 2:</label><br>
		<input type="text" name="numberTwo"/><br>
		
		<label for="numberThree">Number 3:</label><br>
		<input type="text" name="numberThree"/><br>
		
		<label for="numberFour">Number 4:</label><br>
		<input type="text" name="numberFour"/><br>
		
		<label for="numberFive">Number 5:</label><br>
		<input type="text" name="numberFive"/><br>
		
		<br>
		
		<input type="submit" value="Submit">
		
	</form>

</body>
</html>