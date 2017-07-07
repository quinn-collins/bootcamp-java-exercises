<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<c:import url="common/header.jsp"/>
<c:out value="Day Low High Forecast"></c:out><br>
<c:forEach var="w" items="${weather }">
<c:out value="Day: ${w.fiveDayForecastValue }"></c:out>
<c:out value="${w.low }"></c:out>
<c:out value="${w.high }"></c:out>
<c:out value="${w.forecast }"></c:out>
<br>
</c:forEach>
		<img src="/m3-java-capstone/img/parks/${park.parkCode.toLowerCase()}.jpg"/>
		<p>${park.parkName }</p>
		<p>${park.parkDescription }</p>


	

<c:import url="common/footer.jsp"/>