<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/2
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ROLEUPDATE</title>
    <script src="/js/jquery-1.10.2.js"></script>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/zTreeStyle.css">
    <script src="/js/jquery.ztree.all-3.5.js"></script>
    <link rel="shortcut icon" href="/favicon.png">
</head>
<body>

    <form action="roleUpdate" method="post" class="form-horizontal">
        <div class="container">
            <div class="row" style="padding: 20px 0">
                <h3>  UPDATEROLE     PAGE </h3>
            </div>
            <div class=" row form-group">
                <input  type="hidden" name="rid" value="${role.rid}" ><br>
            </div>
            <div class=" row form-group">
                RNAME:<input type="text" name="roleName" value="${role.roleName}"><br>
            </div><br>
            <div class=" row form-group">
                STSTUS:<input type="text" name="status" value="${role.status}"><br>
            </div><br>

            <label class=" control-label">权限菜单：</label>

            <div class=" row form-group">
                <ul id="treeDemo" class="ztree"></ul>
            </div>
            <div class=" row form-group">
                <input class="btn btn-success" type="button" value="SUBMIT">
            </div>
        </div>
    </form>
    <%--ztree--%>
    <script>
        //编写配置
        var setting = {
            view: {
                dblClickExpand: false,
                showLine: true,
                selectedMulti: false
            },
            check:{
                enable:true,
                chkboxType:{ "Y" : "ps", "N" : "ps" }
            },
            data: {
                simpleData: {
                    enable: true,//是否使用简单数据类型
                    idKey: "pid",//设置主键
                    pIdKey: "parentId",//设置父键
                    rootPId: "0"
                },
                key:{
                    name:"pname"
                }
            },
            callback:{//表示tree的一些事件处理函数
                onClick:function(event, treeId, data) {
                    alert(data.pname);
                },
                beforeCheck:true,
                onCheck:onCheck
            }
        };
        var ids="";
        function onCheck(event, treeId, data){
            var treeObj=$.fn.zTree.getZTreeObj("treeDemo"),
                nodes=treeObj.getCheckedNodes(true);
            //ids="";
            for(var i=0;i<nodes.length;i++){
                ids+=nodes[i].pid + ",";
                // console.log("节点id:"+nodes[i].pid+"节点名称"+v); //获取选中节点的值
                console.log("节点id:"+ids); //获取选中节点的id
            }
        }

        //获取数据
        var data = ${array3};

        //核心api使用
        var  zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, data);

        //通过ztree对象的方法，展开所有节点
        zTreeObj.expandAll(true);
    </script>


    <script>
        $(function () {
            /**
             * 点击按钮，执行绑定事件，在回调函数中获取数据，通过ajax完成提交数据到服务器中
             * 提交的数据格式：username=admin&password=123&phone=13913007563
             */

            $("input[type='button']").click(function () {

                var rid = $("input[name='rid']").val();
                var roleName = $("input[name='roleName']").val();
                var status = $("input[name='status']").val();


                /*post请求的参数是以json形式传到服务器中,url和href的区别*/
                $.ajax({
                    //模拟提交给/role/roleUpdate页面
                    url:"/role/roleUpdate",
                    type:"post",
                    data:{
                        rid:rid,
                        roleName:roleName,
                        status:status,
                        ids:ids
                    },
                    success:function(){
                        //如果整个ajax过程成功了，执行success回调函数
                        location.href="/role/roleList";
                    },
                    error:function(){
                        //如果整个ajax过程失败了，执行error回调函数
                        alert("error");
                    }
                });
            });
        });
    </script>






</body>
</html>
