<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

</section>
<c:choose>
    <c:when  test="${not empty slogan}">
<footer>
    ${slogan}
</footer>
    </c:when>
    <c:otherwise>
        <footer>
                DEFINE SLOGAN!
        </footer>
    </c:otherwise>
</c:choose>
</body>
</html>
