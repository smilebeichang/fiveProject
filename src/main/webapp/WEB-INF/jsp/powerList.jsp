<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/5
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>jQuery三级下拉列表导航菜单</title>

    <script type="text/javascript" src="/js/jquery-1.10.2.js"></script>

    <style type="text/css">
        *{margin: 0; padding: 0;}
        body{ font-size: 12px; }
        li{ list-style: none;}
        ul.nav li{ width: 200px; text-align:center;}
        ul.nav > li{ float: left; margin-right:10px;}
        ul.nav li h3{height: 40px; line-height: 40px;}
        ul.nav > li > h3{ background: #72a7ff;}
        ul.nav > li > ul > li h3{ background: #ffd9d9;}
        ul.nav > li h3:hover,.choice{ background: #ffc0c0!important;}
        ul > li > ul{ display: none;}
        ul > li.on > ul{ display: block;}
        ul.nav li{ position: relative;}
        ul.nav > li > ul > li ul{ position: absolute; top: 0; right: -200px;}
        ul.nav span.sub{ position: absolute; display: block; right:10px; top: 0; width: 10px; height: 40px; background: url(images/arrows.png) no-repeat center center;}
    </style>

    <script type="text/javascript">
        $(document).ready(function() {
            $("ul.nav li").hover(function(){
                    $(this).addClass("on");

                },
                function(){
                    $(this).removeClass("on");

                })
        });

        $(document).ready(function() {
            $("ul.nav li").hover(function(){
                    $(this).parent("ul").siblings("h3").addClass("choice");

                },
                function(){
                    $(this).parent("ul").siblings("h3").removeClass("choice");
                })
        });

        $(document).ready(function() {
            if ($("ul.nav li").find("ul") .html()!="") {
                $("ul.nav li").parent("ul").siblings("h3").append("<span class='sub'></span>");
            }
        });
    </script>


</head>
<body>
<ul class="nav">
    <li><h3>我的网站</h3>
        <ul>
            <li><h3>2级分类</h3>
                <ul>
                    <li><h3>3级分类</h3>
                        <ul>
                            <li><h3>4级分类</h3>
                                <ul>
                                    <li><h3>5级分类</h3></li>
                                    <li><h3>5级分类</h3></li>
                                    <li><h3>5级分类</h3></li>
                                    <li><h3>5级分类</h3></li>
                                </ul>
                            </li>
                            <li><h3>4级分类</h3></li>
                            <li><h3>4级分类</h3></li>
                            <li><h3>4级分类</h3></li>
                        </ul>
                    </li>
                    <li><h3>3级分类</h3></li>
                    <li><h3>3级分类</h3></li>
                    <li><h3>3级分类</h3></li>
                </ul>
            </li>
            <li><h3>2级分类</h3>
                <ul>
                    <li><h3>3级分类</h3></li>
                    <li><h3>3级分类</h3></li>
                    <li><h3>3级分类</h3></li>
                    <li><h3>3级分类</h3></li>
                </ul>
            </li>
            <li><h3>2级分类</h3>
                <ul>
                    <li><h3>3级分类</h3></li>
                    <li><h3>3级分类</h3></li>
                    <li><h3>3级分类</h3></li>
                    <li><h3>3级分类</h3></li>
                </ul>
            </li>
            <li><h3>2级分类</h3>
                <ul>
                    <li><h3>3级分类</h3></li>
                    <li><h3>3级分类</h3></li>
                    <li><h3>3级分类</h3></li>
                    <li><h3>3级分类</h3></li>
                </ul>
            </li>
        </ul>
    </li>



</ul>

</body>
</html>

