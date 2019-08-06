<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/5
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/js/jquery-1.10.2.js"></script>
    <script src="/js/jquery.ztree.all-3.5.js"></script>
    <link href="/css/zTreeStyle.css">
</head>
<body>

    <div class=" row form-group">
        <ul id="treeDemo" class="ztree"></ul>
    </div>




<script type="text/javascript">
    $(function () {
        $(".list-group-item").click(function(){
            if ( $(this).find("ul") ) {
                $(this).toggleClass("tree-closed");
                if ( $(this).hasClass("tree-closed") ) {
                    $("ul", this).hide("fast");
                } else {
                    $("ul", this).show("fast");
                }
            }
        });

        var setting = {
            check : {
                enable : true
            },
            view: {
                selectedMulti: false,
                addDiyDom: function(treeId, treeNode){
                    var icoObj = $("#" + treeNode.tId + "_ico"); // tId = permissionTree_1, $("#permissionTree_1_ico")
                    if ( treeNode.icon ) {
                        icoObj.removeClass("button ico_docu ico_open").addClass("fa fa-fw " + treeNode.icon).css("background","");
                    }
                },
            },
            async: {
                enable: true,
                url:"tree.txt",
                autoParam:["id", "name=n", "level=lv"]
            },
            callback: {
                onClick : function(event, treeId, json) {

                }
            }
        };
        var search = location.search;
        var string = search.split("=")[1];
        $.ajax({
            async: false,
            cache: false,
            traditional: true,
            type: "POST",
            url: "powerInfoDtos",
            contentType: "application/json;charset=utf-8",
            data: JSON.stringify({
                "rid":string
            }),
            success:function(text){

                $.fn.zTree.init($("#treeDemo"), setting, text);
            },
            error: function (text) {

            },

            dataType: "json"
        });
    });

</script>






</body>
</html>
