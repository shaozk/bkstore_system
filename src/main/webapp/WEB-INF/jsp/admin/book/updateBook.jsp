<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>updateBook</title>
</head>
<body>
<form:form action="adminGoods/addBook?updateAct=update" method="post" enctype="multipart/form-data">

    <input type="submit" value="提交"/>
    <input type="reset" value="重置"/>

</form:form>



</body>
</html>
