<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/2
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ROLE</title>
    <script src="/js/jquery-1.10.2.js"></script>
    <script src="/js/bootstrap.js"></script>
    <script src="/js/bootstrap-switch.js"></script>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/bootstrap-switch.css">
    <link rel="stylesheet" href="/css/font-awesome/css/font-awesome.css">
    <link rel="shortcut icon" href="/favicon.png">
</head>
<body>
<div class="container">

    <table  class="table">
        <tr>
            <th>RID</th>
            <th>ROLE</th>
            <th>STATUS</th>
            <th colspan="3">OPERATION</th>
        </tr>

        <c:forEach items="${roles}" var="r">
            <tr>
                <td>${r.rid}</td>
                <td>${r.roleName}</td>

                <td>
                    <input  name="status" value="${r.status}" class="form-control status" type="hidden">
                    <input  class="form-control statu" type="checkbox">
                </td>

                <td>
                    <a href="/role/toInsertRole" class="btn btn-primary fa fa-plus">INSERT</a>
                    <a href="/role/toUpdate?rid=${r.rid}" class="btn btn-success fa fa-music" >UPDATE</a>
                    <a href="/role/delete?rid=${r.rid} " class="btn btn-danger fa fa-trash-o">DELETE</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<script>



    //状态switch
    $('.statu').bootstrapSwitch({
        onColor : "success",
        offColor : "danger",
        onSwitchChange : function(event, state) {
            //正常
            if (state)
                $(".status").val(0);
            //停用
            else
                $(".status").val(1);
        }
    })
    if ($(".status").val() == 1)
        $('.statu').bootstrapSwitch('state', false);
    else
        $('.statu').bootstrapSwitch('state', true);




</script>

</body>
</html>
