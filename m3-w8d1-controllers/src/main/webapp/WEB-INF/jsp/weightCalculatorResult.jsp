<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section class="centeredPanel">
    
    <p>If you are ${param.earthWeight } lbs on planet Earth, you would weigh ${alienWeight } lbs on ${param.choosePlanet }.</p>
    
  
</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />