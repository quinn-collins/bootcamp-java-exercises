<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Exercise 3 - Echo</title>
		<style>
			li {
				list-style-type: none;
			}
			#word {
				font-size: 100px;
			}
		</style>
	</head>
	<body>
		<h1>Exercise 3 - Echo</h1>
		
		<ul>
		<%--
			Given two query string parameters, "word" and "count":
			
			Add a number of list items equal to "count".  Each list item should contain the value passed in "word".
			
			The font size of the first list item should be equal to "count".  The font size of each subsequent list
			item should be decreased by 1.
			 
			See exercise3-echo.png for example output
		 --%>
		 
		 
		 
			<!--  What if there are no params? -->
			
			<c:set var="word">word</c:set>
			<c:forEach begin="0" end="${param.count}" step="1" var="i">
				<li><span style="font-size: ${param.count - i}px"><c:out value="${param.word}"></c:out></span></li>
			</c:forEach>
		</ul>
		
		<%--
			Need to decrease font size by 1 each time.. 1 what? pixel?
			use css? declare string with java? use html? jsp?
			can I put ${word} and decrement count?
		 --%>
		
	</body>
</html>