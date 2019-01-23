<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Books For Publisher ${publisher.name}"/>
</jsp:include>
   <table>
       <tr>
           <th>Title</th>
           <th>Author</th>
           <th>Cover</th>
           <th>Price</th>
           <th>View</th>
           <th>Publisher</th>
       </tr>
       <%--<%--%>
           <%--for(Publisher p : (List<Publisher>)request.getAttribute("publishers")){--%>
       <%--%>--%>

       <c:if test="${not empty requestScope.books}">
       <c:forEach items="${requestScope.books}" var="p">
       <tr>
           <td>${p.title}</td>
           <td>${p.author}</td>
           <td><img src="${p.cover}"/></td>
           <td>${p.price}</td>
           <td>
               <c:if test="${not empty p.view}">
               <a href="${p.view}" target="_blank">Details</a>
               </c:if>
           </td>
           <td>${publisher.name}</td>
       </tr>
       </c:forEach>
       </c:if>
       <c:if test="${empty requestScope.books}">
           <tr><td colspan="6">Not Found</td></tr>
       </c:if>
   </table>
<jsp:include page="footer.jsp"/>