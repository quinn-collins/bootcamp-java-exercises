<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<h2>Colorized Name</h2>
	<p>First Name: ${param.firstName }</p>
	<p>Last Name: ${param.lastName }</p>
	<p style="color:red">${redName }</p>
	<p style="color:blue">${blueName }</p>
	<p style="color:green">${greenName }</p>
</body>
</html>