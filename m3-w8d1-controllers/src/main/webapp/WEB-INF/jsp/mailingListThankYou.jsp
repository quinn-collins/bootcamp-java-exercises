<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<section id="main-content"  class="centeredPanel">
<h2>Thank You for signing up, <c:out value="${signup.name}" /></h2>
</section>

<%@include file="common/footer.jsp" %>