<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<c:import url="common/header.jsp"/>
<c:forEach var="w" items="${weather }">
<c:out value="${w.fiveDayForecastValue }"></c:out>
<c:out value="${w.low }"></c:out>
<c:out value="${w.high }"></c:out>
<c:out value="${w.forecast }"></c:out>
<hr>
<br>
</c:forEach>
		<p>${park.parkName }</p>
		<p>${park.parkDescription }</p>
		<p>${park.parkName }</p>


	

<c:import url="common/footer.jsp"/>