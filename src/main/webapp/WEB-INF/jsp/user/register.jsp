
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
    <script type="text/javascript">
        // 注册时检查输入项
        function allIsNull(){
            const name = document.registerForm.name.value;
            const pwd = document.registerForm.password.value;
            const rePwd = document.registerForm.rePassword.value;
            if(name === ""){
                alert("请输入姓名！");
                document.registerForm.name.focus();
                return false;
            }
            if(pwd === ""){
                alert("请输入密码！");
                document.registerForm.password.focus();
                return false;
            }
            if(rePwd === "" || rePwd !== pwd){
                alert("密码不一致，请重新输入！");
                document.registerForm.rePassword.focus();
                return false;
            }
            document.registerForm.submit();
            return true;
        }
    </script>
</head>

<body>
****用户注册****
<form action="${pageContext.request.contextPath}/user/doRegister" method="post" name="registerForm">
    用户：<input type="text" name="name"><br/>
    密码：<input type="password" name="password">
    确认密码：<input type="password" name="rePassword"></br>
    邮箱：<input type="email" name="email"><br/>
    <input type="button" value="注册" onclick="allIsNull()"/>
    <input type="reset" value="重置"/>
</form>

</body>
</html>
