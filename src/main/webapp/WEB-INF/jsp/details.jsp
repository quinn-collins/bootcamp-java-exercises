<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<c:import url="common/header.jsp"/>

<img src="/m3-java-capstone/img/parks/${park.parkCode.toLowerCase()}.jpg"/>
<p>${park.parkName }</p>
<p>${park.parkDescription }</p>


<div id="weather">
<c:forEach var="w" items="${weather }">
<div class="weatherbox">
	<c:choose>
		<c:when test = "${w.fiveDayForecastValue == 1}">
			<h3><c:out value="Today"></c:out></h3>
		</c:when>
		<c:when test = "${w.fiveDayForecastValue == 2}">
			<h4><c:out value="Tomorrow"></c:out></h4>
		</c:when>
		<c:when test = "${w.fiveDayForecastValue == 3}">
			<h4><c:out value="Day 3"></c:out></h4>
		</c:when>
		<c:when test = "${w.fiveDayForecastValue == 4}">
			<h4><c:out value="Day 4"></c:out></h4>
		</c:when>
		<c:when test = "${w.fiveDayForecastValue == 5}">
			<h4><c:out value="Day 5"></c:out></h4>
		</c:when>
	</c:choose>
<img src="/m3-java-capstone/img/weather/${w.forecast}.png"/>
<br>
	<c:out value="Low: ${w.low }"></c:out><br>
	<c:out value="High: ${w.high }"></c:out>
	<br>
	<br>
	<c:choose>
		<c:when test = "${w.forecast == 'snow'}">
			<c:out value="Pack snowshoes!"></c:out>
			<br>
		</c:when>
		<c:when test = "${w.forecast == 'rain'}">
			<c:out value="Pack rain gear and wear water proof shoes!"></c:out>
			<br>
		</c:when>
		<c:when test = "${w.forecast == 'thunderstorms'}">
			<c:out value="Seek shelter and avoid hiking on exposed ridges!"></c:out>
			<br>
		</c:when>
		<c:when test = "${w.forecast == 'sun'}">
			<c:out value="Pack sunblock!"></c:out>
			<br>
		</c:when>
	</c:choose>
	<c:choose>
		<c:when test = "${w.high > 75}">
			<c:out value="Bring an extra gallon of water!"></c:out>
			<br>
		</c:when>
		<c:when test = "${w.low < 20}">
			<c:out value="Danger of extended exposure in cold weather!"></c:out>
			<br>
		</c:when>
	</c:choose>
	<c:choose>
		<c:when test = "${w.high - w.low > 20}">
			<c:out value="Wear breathable layers!"></c:out>
			<br>
		</c:when>
	</c:choose>
	</div>
</c:forEach>
</div>

	

<c:import url="common/footer.jsp"/>