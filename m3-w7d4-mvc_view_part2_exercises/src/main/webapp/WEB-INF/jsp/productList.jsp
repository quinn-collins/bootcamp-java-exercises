<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
    <meta name="viewport" content="width=device-width" />
    <title>Product List View</title>
    <link rel="stylesheet" href="css/site.css" />
</head>
<body>
    <header>
        <h1>MVC Exercises - Views Part 2: Models</h1>        
    </header>
    <nav>
        <ul>
            <li><a href="#">Link 1</a></li>
            <li><a href="#">Link 2</a></li>
        </ul>
        
    </nav>
    <section id="main-content">
    
	<c:forEach var="product" items="${productList}">
	<div class="boximage">
	<img src="img/${product.imageName}"/>
	<div class="box">
		<ul>
			<li>
				<c:out value="${product.name}"></c:out>
			</li>
		</ul>
		<ul>
			<li>
				<c:out value="${product.manufacturer}"></c:out>
			</li>
		</ul>
		<ul>
			<li>
				<c:out value="${product.price}"></c:out>
			</li>
		</ul>
		<ul>
			<li>
				<c:out value="${product.weightInLbs}"></c:out>
			</li>
		</ul>
		<ul>
			<li>
				<c:out value="${product.averageRating}"></c:out>
			</li>
		</ul>
	</div>
	</div>
	</c:forEach>
	
	
	

    </section>
</body>
</html>