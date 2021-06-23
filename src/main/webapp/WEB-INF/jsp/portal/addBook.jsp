
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addBook</title>
    <script>
        function allIsNull() {
            const name = document.addForm.name.value;
            const author = document.addForm.author.value;
            const price = document.addForm.price.value;
            const type = document.addForm.type.value;
            const isbn = document.addForm.isbn.value;
            const publisher = document.addForm.publisher.value;
            const intro = document.addForm.intro.value;
            if( name === ""){
                alert("书名不能为空！");
                document.addForm.name.focus();
                return false;
            }
            if( author === ""){
                alert("作者不能为空！");
                document.addForm.author.focus();
                return false;
            }
            if( price === ""){
                alert("价格不能为空！");
                document.addForm.price.focus();
                return false;
            }
            if( type === ""){
                alert("书类型不能为空！");
                document.addForm.type.focus();
                return false;
            }
            if( isbn === ""){
                alert("isbn不能为空！");
                document.addForm.isbn.focus();
                return false;
            }
            if( publisher === ""){
                alert("出版社不能为空！");
                document.addForm.name.focus();
                return false;
            }
            if( intro === ""){
                alert("简介不能为空！");
                document.addForm.isbn.focus();
                return false;
            }
            document.addForm.submit();
            return true;
        }
    </script>
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增书籍</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/portal/book/addBook" method="post" enctype="multipart/form-data" name="addForm">
        书籍名称：<input type="text" name="name"><br><br>
        书籍作者：<input type="text" name="author"><br><br>
        书籍价格：<input type="text" name="price"><br><br>
        书籍类别：<input type="text" name="type"><br><br>
        书籍ISBN：<input type="text" name="isbn"><br><br>
        书籍出版社：<input type="text" name="publisher"><br><br>
        书籍简介：<input type="text" name="intro"><br><br>
        书籍封面：<input type="file" name="diff_cover"><br><br> <!--不和Book属性名一样-->
        <input type="button" value="添加" onclick="allIsNull()">
    </form>


</div>

</body>
</html>
