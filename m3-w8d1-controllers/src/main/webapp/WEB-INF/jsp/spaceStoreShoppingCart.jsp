<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section class="centeredPanel">
	<h2>Solar System Geek Gift Shop</h2>
	<c:forEach var="item" items="${shoppingCart}">
		<img src="img/${item.product.imageName}"/>
		<c:out value="${item.product.name}"></c:out>
		<c:out value="${item.product.price}"></c:out>
		<c:out value="${item.quantity}"></c:out>
		<c:out value="${item.totalPrice}"></c:out>
		
		
	</c:forEach>
	<c:out value="${grandTotalPrice}"></c:out>
	


</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />