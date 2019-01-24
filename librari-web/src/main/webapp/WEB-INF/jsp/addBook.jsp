<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:message code="books.publisher.title" var="booksPublisherTitle"/>

<jsp:include page="header.jsp">
    <jsp:param name="title" value="${booksPublisherTitle} ${publisher.name}"/>
</jsp:include>

<form:form method="post" action="add" modelAttribute="bookForm">
   <table>
       <tr>
           <td> Title: <form:input path="title"/> <br/><form:errors path="title"/> </td>
           <td> Author: <form:input path="author"/> </td>
           <td> Price: <form:input path="price"/><br/><form:errors path="price"/> </td>
           <td> Cover: <form:input path="cover"/></td>
       </tr>
       <tr><td colspan="4"><input type="submit" value="Send"/></td></tr>
   </table>
</form:form>

<jsp:include page="footer.jsp"/>