<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/1
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UPDATE</title>
    <script src="/js/jquery-1.10.2.js"></script>
    <script src="/js/bootstrap.js"></script>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="shortcut icon" href="/favicon.png">

</head>
<body>
<div>
    <form action="update" method="post" class="form-horizontal" >
        <div class="container">
            <div class="row" style="padding: 20px 0">
                <h3>  UPDATE     PAGE </h3>
            </div>
            <div class=" row form-group">
                <input   type="hidden" name="uid" value="${user.uid}"><br>
            </div>
            <div class=" row form-group">
                <label>userName:</label><input   type="text" name="userName" value="${user.userName}"><br>
            </div>
            <div class=" row form-group">
                <label>password:</label><input  type="text" name="password" value="${user.password}"><br>
            </div>
            <div class="row form-group">
                <label>role </label>
                <input name="rid" type="checkbox" value="1" ${rids.indexOf('1')>=0 ?"checked":""} >admin
                <input name="rid" type="checkbox" value="2" ${rids.indexOf('2')>=0 ?"checked":""}>staff<br>
            </div>
            <div class="row form-group">
                <input type="submit" value="submit" class="btn btn-success">
            </div>

        </div>
    </form>
</div>

</body>
</html>
