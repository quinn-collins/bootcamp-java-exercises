<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<c:import url="common/header.jsp"/>
<c:forEach var="park" items="${parks }">
	<c:url var="detailsURL" value="/details">
		<c:param name="parkCode" value="${park.parkCode }" />
	</c:url>
	<a href="${detailsURL }"> 
	<c:url value="/img/parks/${park.parkCode.toLowerCase()}.jpg" var="img"/>
		<img src="${img }"/>
	</a>
		<p>${park.parkName }</p>
		<p>${park.parkDescription }</p>
		<hr>
</c:forEach>
	

<c:import url="common/footer.jsp"/>