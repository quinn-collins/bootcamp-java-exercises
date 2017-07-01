<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section class="centeredPanel">
    <img src="img/${param.choosePlanet}.jpg"/>
    <p>Traveling by ${param.chooseTravelMethod } you will reach ${param.choosePlanet } in ${travelTime } years. You will be ${ageAfterTravel } years old.</p>
    
  
</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />