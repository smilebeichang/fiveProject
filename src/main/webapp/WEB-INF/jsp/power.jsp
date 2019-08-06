<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/2
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>POWER</title>
    <script src="/js/jquery-1.10.2.js"></script>
    <script src="/js/bootstrap.js"></script>
    <link rel="stylesheet" href="/css/bootstrap.css">
</head>
<body>

<table class="table">
    <tr>

        <th>POWER</th>
        <th colspan="3">OPERATION</th>
    </tr>

    <c:forEach items="${powers}" var="p">
        <tr>
            <td>${p.pname}</td>
            <td><a class="btn btn-success" href="/role/toUpdate?rid=${r.rid}">UPDATE</a></td>
        </tr>
    </c:forEach>
</table>




</body>
</html>
