<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section class="centeredPanel">
	<h2>Solar System Geek Gift Shop</h2>
		<img src="img/${product.imageName }"/>
		<p>${product.name }</p>
		<p>${product.price }</p>
		<p>${product.description }</p>
		<form method="POST" action="${formAction }">
			<label for="quantityToBuy">Quantity to buy </label>
			<input type="hidden" name="productId" value="${product.id}">
			<input type="text" name="quantityToBuy">
			<input type="submit" value="Add to Cart">
		</form>
	


</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />