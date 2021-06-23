<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>listBook</title>
        <!-- 引入 Bootstrap -->
        <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>


<div class="container">

        <div class="row clearfix">
                <div class="col-md-12 column">
                        <div class="page-header">
                                <h1>
                                        <small>书籍列表 —— 显示所有书籍</small>
                                </h1>
                        </div>
                </div>
        </div>

        <div class="row">
                <div class="col-md-4 column">
                        <a class="btn btn-primary" href="${pageContext.request.contextPath}/admin/book/addBook">新增</a>
                </div>
        </div>

        <div class="row clearfix">
                <div class="col-md-12 column">
                        <table class="table table-hover table-striped">
                                <thead>
                                <tr>
                                        <th>书籍名字</th>
                                        <th>书籍作者</th>
                                        <th>书籍价格</th>
                                        <th>书籍isbn</th>
                                        <th>书籍出版社</th>
                                        <th>书籍简介</th>
                                        <th>操作</th>
                                </tr>
                                </thead>

                                <tbody>
                                <c:forEach var="book" items="${bookList}">
                                        <tr>
                                                <td>${book.name}</td>
                                                <td>${book.author}</td>
                                                <td>${book.price}</td>
                                                <td>${book.isbn}</td>
                                                <td>${book.publisher}</td>
                                                <td>${book.intro}</td>
                                                <td>
                                                        <a href="${pageContext.request.contextPath}/admin/book/updateBook?id=${book.id}">更改</a> |
                                                        <a href="${pageContext.request.contextPath}/admin/book/deleteBook/${book.id}">删除</a>
                                                </td>
                                        </tr>
                                </c:forEach>
                                </tbody>
                        </table>
                </div>
        </div>
</div>
</body>
</html>
