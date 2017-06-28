<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section class="centeredPanel">
    <img src="img/${param.choosePlanet}.jpg"/>
    <p>If you are ${param.earthAge} years old on planet Earth, you are ${alienAge } ${param.choosePlanet } years old.</p>
    
  
</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />