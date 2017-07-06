<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<c:import url="common/header.jsp"/>
<c:forEach var="park" items="${parks }">
	<c:url var="details" value="/details">
		<c:param name="parkCode" value="${park.parkCode }" />
	</c:url>
		<img src=/m3-java-capstone/img/${park.parkCode}.png/>
		<p>${park.parkName }</p>
		<p>${park.parkDescription }</p>
		<p>${park.parkName }</p>
</c:forEach>
	

<c:import url="common/footer.jsp"/>