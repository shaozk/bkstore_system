
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>updateBook</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改信息</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/portal/book/updateBook" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${book.id}"/><br/>
        书籍名称：<input type="text" name="name" value="${book.name}"/><br/>
        书籍作者：<input type="text" name="author" value="${book.author}"/><br/>
        书籍价格：<input type="number" name="price" value="${book.price}"/><br/>
        书籍类别：<input type="text" name="type" value="${book.type }"/><br/>
        书籍ISBN：<input type="text" name="isbn" value="${book.isbn }"/><br/>
        书籍出版社<input type="text" name="publisher" value="${book.publisher }"/><br/>
        书籍简介：<input type="text" name="intro" value="${book.intro }"/><br/>
        书籍封面：<input type="file" name="diff_cover" value="${book.cover}"/><br/> <!--不和Book属性名一样-->
        <input type="submit" value="提交"/>
    </form>
    <a href="${pageContext.request.contextPath}/portal/book/showCover/${book.cover}"></a>

</div>