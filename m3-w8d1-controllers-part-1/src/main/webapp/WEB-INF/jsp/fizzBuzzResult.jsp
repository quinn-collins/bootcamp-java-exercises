<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<body>
	<h1>FizzBuzz Revisited</h1>
	<p>Divisible By: ${param.divisibleByFirst }</p>
	<p>Divisible By: ${param.divisibleBySecond }</p>
	<p>Divisible By Both: ${param.divisibleByFirst } and ${param.divisibleBySecond }</p>
	<p>Alternate Fizz: ${param.alternateFizz }</p>
	<p>Alternate Buzz: ${param.alternateBuzz }</p>
	<c:forEach var="number" items="${numbers}">
		<c:choose>
			<c:when test = "${number%param.divisibleByFirst==0} and ${number%param.divisibleBySecond==0}">
				<p>${param.alternateFizz } ${param.alternateBuzz }</p>
			</c:when>
			<c:when test = "${number%param.divisibleByFirst==0}">
				<p>${param.alternateFizz }</p>
			</c:when>
			<c:when test = "${number%param.divisibleBySecond==0}">
				<p>${param.alternateBuzz }</p>
			</c:when>
			<c:otherwise>
				<p>${number }</p>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</body>
</html>