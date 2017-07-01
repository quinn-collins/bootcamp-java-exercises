<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section class="centeredPanel">
	<h2>Solar System Geek Gift Shop</h2>
	<c:forEach var="product" items="${products}">
		<c:url var="productDetailURL" value="/spaceStoreDetailView">
			<c:param name="productId" value="${product.id }" />
		</c:url>
		<a href="${productDetailURL }"> <c:url
				value="img/${product.imageName }" var="productURL" /> <img
			src="${productURL}" />
		</a>
		<p>${product.name }</p>
		<p>${product.price }</p>
	</c:forEach>


</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />