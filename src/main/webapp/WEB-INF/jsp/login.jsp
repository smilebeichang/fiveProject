<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/1
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script type="application/javascript" src="/js/jquery-1.10.2.js"></script>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="shortcut icon" href="/favicon.png">


</head>
<body>
<div class="container">
    <form class="form-horizontal" action="" method="post">
        <div class="input-group">
            <span class="input-group-addon" id="basic-addon1">USERNAME：</span>
            <input type="text" class="form-control" placeholder="用户名" aria-describedby="basic-addon1" name="userName" value="xiaopang1">
        </div>
        <div class="input-group">
            <span class="input-group-addon" id="basic-addon2">PASSWORD：</span>
            <input type="password" class="form-control" placeholder="密码" aria-describedby="basic-addon2" name="password" value="123">
        </div>
        <!-- 这个input的name属性的值一定要是rememberMe -->
        <div>
            <input type="checkbox" name="rememberMe" />自动登陆
        </div>
        <div class="input-group">
            <input type="button" value="Login  In" class="btn btn-primary" onclick="changeAction(1)">

            <input type="button" value="Register" class="btn btn-warning" onclick="changeAction(0)">
        </div>
    </form>
</div>
<script type="application/javascript">
    function changeAction(flag) {
        if (flag){
            $(".form-horizontal").attr("action","/login/check").submit();
        }else {
            $(".form-horizontal").attr("action","/login/register").submit();
        }
    }
</script>
</body>
</html>



</body>
</html>
