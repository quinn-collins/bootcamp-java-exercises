<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section class="centeredPanel">
  <h2>Alien Travel Calculator</h2>
    
    <c:url var="formAction" value="/travelCalculatorResult"></c:url>
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
       <label for="chooseTravelMethod">Choose a Travel Method</label>
       <select name="chooseTravelMethod" id="chooseTravelMethod">
       	<option value="walking">Walking</option>
       	<option value="car">Car</option>
       	<option value="bulletTrain">Bullet Train</option>
       	<option value="boeing747">Boeing 747</option>
       	<option value="concorde">Concorde</option>
       </select>
       <br>
       <br>
       <label for="earthAge">Enter Your Earth Age</label>
        <input type="text" name="earthAge">
       <br>
       <br>
       <input type="submit" value="Calculate Travel Time">
    </form>
    
    
  
</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />