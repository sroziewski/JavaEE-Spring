<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="lab.librari.service.api.BrowsingService" %>
<%@ page import="lab.librari.service.impl.BrowsingServiceImpl" %>
<%@ page import="lab.librari.model.Publisher" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Uczestnik
  Date: 21.01.2019
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <%--BrowsingService bs = new BrowsingServiceImpl();--%>
    <%--List<Publisher> publishers = bs.getPublishers();--%>
<%--%>--%>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="List Of Publishers"/>
</jsp:include>
   <table>
       <tr>
           <th>Name</th>
           <th>Logo</th>
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