<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="lab.librari.service.api.BrowsingService" %>
<%@ page import="lab.librari.service.impl.BrowsingServiceImpl" %>
<%@ page import="lab.librari.model.Publisher" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:message code="publishers.list.title" var="publishersListTitle"/>

    <%--BrowsingService bs = new BrowsingServiceImpl();--%>
    <%--List<Publisher> publishers = bs.getPublishers();--%>
<%--%>--%>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="${publishersListTitle}"/>
</jsp:include>
   <table>
       <tr>
           <th><spring:message code="publisher.name"/></th>
           <th><spring:message code="publisher.logo"/></th>
       </tr>
       <%--<%--%>
           <%--for(Publisher p : (List<Publisher>)request.getAttribute("publishers")){--%>
       <%--%>--%>
       <c:forEach items="${requestScope.publishers}" var="p">
       <tr>
           <td><a href="./books?publisherId=${p.id}">${p.name}</a></td>
           <td><img src="${p.logoImage}"/></td>
       </tr>
       </c:forEach>
   </table>
<jsp:include page="footer.jsp"/>