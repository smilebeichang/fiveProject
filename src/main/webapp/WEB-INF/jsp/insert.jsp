<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/1
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>INSERT</title>
    <link rel="shortcut icon" href="/favicon.png">
</head>
<body>
    <form action="insert" method="post">
        <label>id:</label><input type="hidden" name="uid" ><br>
        <label>userName:</label><input type="text" name="userName" ><br>
        <label>roles:</label> <select name="rid">
                                    <option value="1">admin</option>
                                    <option value="2">staff</option>
                                </select><br>
        <input type="submit" value="submit">
    </form>
</body>
</html>
