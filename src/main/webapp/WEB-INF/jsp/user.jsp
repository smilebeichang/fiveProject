<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/1
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>USER</title>
    <script src="/js/jquery-1.10.2.js"></script>
    <script src="/js/jqPaginator.js"></script>
    <script src="/js/bootstrap.js"></script>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/font-awesome/css/font-awesome.css">
    <link rel="shortcut icon" href="/favicon.png">
</head>
<body>
<div class="container">

    <table  class="table">
        <tr>
            <th>ID</th>
            <th>USERNAME</th>
            <th>STATUS</th>
            <th colspan="5">OPERATION</th>
        </tr>

        <c:forEach items="${pageInfo.list}" var="u">
            <tr>
                <td>${u.uid}</td>
                <td>${u.userName}</td>
                <td>
                    ${u.status eq 0?'<button class="btn btn-primary "  disabled="disabled">normal</button>':' <button class="btn btn-danger "  disabled="disabled">forbid</button>'}
                </td>
                <td>
                    <a class="btn btn-success fa fa-plus" href="/user/toUpdate?uid=${u.uid}">update</a>&nbsp
                    <a href="/user/delete?uid=${u.uid} " class="btn btn-danger fa fa-trash-o">delete</a>
                    <button class="btn btn-warning fa fa-file-o" data-toggle="modal" data-target="#myModal"  >update</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div id="div1"></div>
    <%--鉴权--%>
 <%--
    <shiro:hasPermission name="user:add">
       <a  class="sui-btn  btn-xlarge btn-danger" href="/user/toInsert">新增|</a>
    </shiro:hasPermission>
    <shiro:hasPermission name="user:update">
       <button class="btn btn-success">修改学生</button>
    </shiro:hasPermission>
    <shiro:hasPermission name="user:delete">
       <button class="btn btn-primary">删除学生</button>
    </shiro:hasPermission>
    <shiro:hasPermission name="users:select">
       <button class="btn btn-danger">查询学生</button>
    </shiro:hasPermission>
--%>


    <%--模态框--%>
    <div id="myModal" class="modal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header text-center">
                    <h4>角色修改</h4>
                </div>

                <div class="modal-body">
                   <label><a href="/user/toUpdate?uid=${u.uid}">跳转到修改页面</a></label>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-success"  οnclick="update()" >确认</button>
                    <button type="button" class="btn btn-warning" data-dismiss="modal">取消</button>
                </div>
            </div>
        </div>
    </div>



<div class="container">
    <div class="pagination-layout">
        <div class="pagination">
            <ul class="pagination" total-items="pageInfo.totalRows" max-size="10" boundary-links="true">
            </ul>
        </div>
    </div>

    <a class='btn btn-primary' href="/role/roleList">Role list management</a>
    <a class='btn btn-success' href="/power/powerList">Permission management page</a>
    <a class='btn btn-success' href="/power/getPowerInfo">Permission management page2</a>


    <script type="text/javascript">
        var if_firstime = true;

        window.onload = function () {
            $('.pagination').jqPaginator({
                totalPages: ${pageInfo.pages},
                visiblePages: 5,
                currentPage: ${pageInfo.pageNum},

                first: '<li class="first"><a href="javascript:void(0);">FIRST </a></li>',
                prev: '<li class="prev"><a href="javascript:void(0);">previous </a></li>',
                next: '<li class="next"><a href="javascript:void(0);">next </a></li>',
                last: '<li class="last"><a href="javascript:void(0);">LSTR </a></li>',
                page: '<li class="page"><a href="javascript:void(0);">{{page}}</a></li>',

                onPageChange: function (num) {
                    if (if_firstime) {
                        if_firstime = false;
                    } else if (!if_firstime) {
                        changePage(num);
                    }

                }
            });
        }

        function changePage(num) {

            location.href = "/user/findAllUserByPage?pageNum=" + num;

        }
    </script>


</div>

<script>

    $("button").click(function(){
        $.ajax({
            url:"/user/toUpdate?uid=1",
            success:function(result){
                //$("#div1").html(result);
                //$('#myModal').modal('show')
            }
        });
    });



</script>

</body>
</html>
