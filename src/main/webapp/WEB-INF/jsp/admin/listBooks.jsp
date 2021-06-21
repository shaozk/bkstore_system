<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/20
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>listBook</title>
</head>
<body>

<c:forEach items="${responseResult.data}" var="book">
        ${book.id}<br/>
        ${book.name}<br/>
        ${book.price}<br/>
        ${book.author}<br/>
        ${book.isbn}<br/>
        ${book.publisher}<br/>
        ${book.intro}<br/>

</c:forEach>
</body>
</html>
