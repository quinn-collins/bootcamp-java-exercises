<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section class="centeredPanel">
  <h2>Solar System Geek Forum</h2>
    <p><a href="/ssg-exercises-pair/spaceForumInput">Post a Message</a></p>
      <c:forEach var="forumPost" items="${forumPosts }">
        <p>${forumPost.subject }</p>
        <p>by ${forumPost.username} on ${forumPost.datePosted }</p>
        <p>${forumPost.message }</p>
      </c:forEach>
    
  
</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />