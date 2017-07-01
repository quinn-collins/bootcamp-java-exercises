<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section class="centeredPanel">
  <h2>Alien Weight Calculator</h2>
    
    <c:url var="formAction" value="/weightCalculatorResult"></c:url>
    <form method="GET" action="${formAction }">
      <label for="choosePlanet">Choose A Planet</label>
      <select name="choosePlanet" id="choosePlanet">
        <option value="mercury">Mercury</option>
        <option value="venus">Venus</option>
        <option value="earth">Earth</option>
        <option value="mars">Mars</option>
        <option value="jupiter">Jupiter</option>
        <option value="saturn">Saturn</option>
        <option value="uranus">Uranus</option>
        <option value="neptune">Neptune</option>
       </select>
       <br>
       <br>
       <label for="earthWeight">Enter your Earth weight</label>
        <input type="text" name="earthWeight">
       <br>
       <br>
       <input type="submit" value="Calculate Weight">
       
    </form>
  
</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />