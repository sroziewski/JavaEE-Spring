<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp">
    <jsp:param name="title" value="Error page"/>

</jsp:include>
<table>
    <tr>
        <td>
            ${errorMessage}
        </td>
    </tr>
</table>
<jsp:include page="footer.jsp"/>