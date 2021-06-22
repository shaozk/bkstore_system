<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/18
  Time: 7:32
  To change this template use File | Settings | File Templates.
--%>
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
****添加书籍****
<form action="${pageContext.request.contextPath }/admin/book/addBook" method="post" name="addForm">
    <table border="1">
        <tr>
            <td>书名</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>作者</td>
            <td><input type="text" name="author"/></td>

        </tr>
        <tr>
            <td>价格</td>
            <td><input type="number" name="price"/></td>

        </tr>
        <tr>
            <td>类别</td>
            <td><input type="text" name="type"></td>

        </tr>
        <tr>
            <td>isbn</td>
            <td><input type="number" name="isbn"/></td>

        </tr>
        <tr>
            <td>出版社</td>
            <td><input type="text" name="publisher"/></td>
        </tr>
        <tr>
            <td>简介</td>
            <td><input type="text" name="intro"/></td>
        </tr>
        <tr>
            <td>封面</td>
            <td><input type="file" name="cover"/></td>
        </tr>
    </table>
    <input type="button" value="确定" onclick="allIsNull()"/>
    <input type="reset" value="重置"/>
</form>

</body>
</html>
