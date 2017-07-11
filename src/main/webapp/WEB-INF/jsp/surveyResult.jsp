<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<c:import url="common/header.jsp"/>
	<h1>Survey result</h1>
	<c:forEach var="park" items="${parkList}">
		<div class="park">
			<c:url value="/img/parks/${park.parkCode.toLowerCase()}.jpg" var="img"/>
			<img src="${img}"/>
			<c:out value="${park.parkName}"></c:out>
		</div>
	</c:forEach>

<c:import url="common/footer.jsp"/>