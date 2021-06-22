<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>listBook</title>
</head>
<body>

<c:forEach items="${bookList}" var="book">
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
