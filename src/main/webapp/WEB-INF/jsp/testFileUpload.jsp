
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>testFileUpload</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="post">
    <input type="file" name="file"/>
    <input type="submit" value="upload">
</form>

</body>
</html>
