<%--
  Created by IntelliJ IDEA.
  User: Uczestnik
  Date: 21.01.2019
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>counter</title>
</head>
<body>
<%--<%--%>
    <%--int count = 0;--%>
    <%--if(session.getAttribute("count")!=null){--%>
        <%--count = (int) session.getAttribute("count");--%>
    <%--}--%>
    <%--session.setAttribute("count", ++count);--%>
<%--%>--%>
    This A site has been visited <%=session.getAttribute("count")%> times.
</body>
</html>
