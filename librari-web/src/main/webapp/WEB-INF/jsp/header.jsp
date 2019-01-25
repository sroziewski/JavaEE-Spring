<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="lab.librari.service.api.BrowsingService" %>
<%@ page import="lab.librari.service.impl.BrowsingServiceImpl" %>
<%@ page import="lab.librari.model.Publisher" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Uczestnik
  Date: 21.01.2019
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

    <title>publishers</title>
    <C:url value="/css/style.css" var="cssUrl"/>
    <link href="${cssUrl}" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Orbitron" rel="stylesheet"/>
</head>
<body>
<header>
    <h1><a href="<c:url value="/publishers"/>">Librari</a></h1>
    <h2>${param.title}</h2>
    <h3>
        <security:authorize access="isAuthenticated()">
            <security:authentication property="principal.username" var="username"/>
            ${username}
            <br/>
            <a href="<c:url value="/logout"/>">Logout</a>
        </security:authorize>
        <security:authorize access="isAnonymous()">
            <a href="<c:url value="/login"/>">Login</a>
        </security:authorize>

    </h3>
</header>
<section>
