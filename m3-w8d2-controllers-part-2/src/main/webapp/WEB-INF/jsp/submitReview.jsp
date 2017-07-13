<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>
	<c:url var="formAction" value="/submitReview"></c:url>
    <form method="POST" action="${formAction }">
    	<label for="userName">Username:</label>
        <input type="text" name="userName">
        
        <br>
        <br>
        
        <select name="chooseRating" id="chooseRating">
        <option value="1">One Star</option>
        <option value="2">Two Stars</option>
        <option value="3">Three Stars</option>
        <option value="4">Four Stars</option>
        <option value="5">Five Stars</option>
       </select>
       
       <br>
        <br>
       
       <label for="reviewTitle">Review Title:</label>
        <input type="text" name="reviewTitle">
        
        <br>
        <br>
        
        <label for="reviewText">Review Text:</label>
        <input type="text" name="reviewText">
        
        <br>
        <br>
        
        <input type="submit" value="Submit Review!">
    </form>
</body>
</html>