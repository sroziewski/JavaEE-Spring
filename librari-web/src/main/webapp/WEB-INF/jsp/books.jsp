<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:message code="books.publisher.title" var="booksPublisherTitle"/>

<jsp:include page="header.jsp">
    <jsp:param name="title" value="${booksPublisherTitle} ${publisher.name}"/>
</jsp:include>

   <table>
       <tr>
           <th><spring:message code="book.title"/></th>
           <th><spring:message code="book.author"/></th>
           <th><spring:message code="book.cover"/></th>
           <th><spring:message code="book.price"/></th>
           <th><spring:message code="book.view"/></th>
           <th><spring:message code="book.publisher"/></th>
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