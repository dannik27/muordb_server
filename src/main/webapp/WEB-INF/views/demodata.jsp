<%--
  Created by IntelliJ IDEA.
  User: danya
  Date: 18.09.2017
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<c:forEach var="entity" items="${data}">
    <h1>${entity.id}
            ${entity.name}
        <fmt:parseDate value="${entity.birthday}" pattern="yyyy-MM-dd" var="parsedDate" type="date"/>
        <fmt:formatDate type="date" dateStyle="short" value="${parsedDate}" /></h1>
</c:forEach>


</body>
</html>
