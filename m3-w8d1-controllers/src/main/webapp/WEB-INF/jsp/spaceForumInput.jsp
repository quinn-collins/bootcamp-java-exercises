<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section class="centeredPanel">
  <h2>New Geek Post</h2>
    <c:url var="formAction" value="/spaceForumInput"/>
      <form method="POST" action="${formAction }">
      <label for="username">Username</label>
        <input type="text" name="username"><br>
      <label for="subject">Subject</label>
        <input type="text" name="Subject"><br>
       <label for="message">Message</label>
        <input type="text" name="message"><br>
       <input type="submit" value="Submit">
    
    </form>
    
  
</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />