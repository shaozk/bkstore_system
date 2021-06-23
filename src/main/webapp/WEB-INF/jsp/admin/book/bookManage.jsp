
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>bookManage</title>
    <script type="text/javascript">
        // 用户管理
        function userManager() {

        }


        // 搜索时检查
        function searchIsNull(){
            const name = document.searchForm.keyword.value;
            if( name === ""){
                alert("搜索不能为空！");
                document.searchForm.keyword.focus();
                return false;
            }
            document.searchForm.submit();
            return true;
        }
    </script>
</head>
<body>
<br/>
<%--搜索--%>
<form action="${pageContext.request.contextPath}/admin/book/search" method="post"  name="searchForm">
    <input type="text" placeholder="搜索" name="keyword"/>
    <input type="button" value="搜索" onclick="allIsNull()"/>
</form>

<%--增加新书--%>
<form action="${pageContext.request.contextPath}/admin/book/addBook" method="post"  name="addForm">
    <input type="submit" value="增添新书"/>
</form>

<%--分类--%>
按类别查找：
<form action="${pageContext.request.contextPath}/admin/book/listByType" method="post"  name="addForm">
    作者：<input type="text" name="author"/>
    类别：<select>
    <c:forEach items="${bookType}" var="item">
        <option value="${item}" name="type">${item}</option>
    </c:forEach>
</select>
    <input type="submit" value="查找"/>

</form>

<%--批量删除--%>
<input type="submit" value="删除"/>
<input type="submit" value="修改"/>

<table border="1">
    <tr>
        <td><input type="checkbox" name="delete_all_id"></td>
        <td>书名</td>
        <td>作者</td>
        <td>价格</td>
        <td>类别</td>
        <td>isbn</td>
        <td>出版社</td>
        <td>简介</td>
    </tr>
    <c:forEach items="${bookList}" var="book">
        <tr>
            <td><input type="checkbox" name="delete_id" value="${book.id}"> </td>
            <td>${book.name}</td>
            <td>${book.author}</td>
            <td>${book.price}</td>
            <td>${book.type}</td>
            <td>${book.isbn}</td>
            <td>${book.publisher}</td>
            <td>${book.intro}</td>
        </tr>
    </c:forEach>
</table>

<%--<%@include file="addBook.jsp" %>--%>

</body>
</html>
