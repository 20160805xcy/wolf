<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: xcy
  Date: 2018-11-15
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入jstl--%>
<%@include file="common/tag.jsp"%>
<html lang="en">
<head>
    <%@include file="common/head.jsp"%>
    <title>客户列表页</title>
</head>
<body>

<div class="container">
    <div id="content-all" class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>客户列表页</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>客户名称</th>
                    <th>登录名</th>
                    <th>创建人</th>
                    <th width="100px">创建时间</th>
                    <th width="100px">激活人</th>
                    <th width="100px">激活时间</th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${customerChild.customerName}</td>
                        <td>${customerChild.loginName}</td>
                        <td>${customerChild.crtByName}</td>
                        <td>
                            <fmt:formatDate value="${customerChild.crtDtm}" pattern="yyyy-MM-dd"/>
                        </td>
                        <td>${customerChild.activateBy}</td>
                        <td>
                            <fmt:formatDate value="${customerChild.activateDtm}" pattern="yyyy-MM-dd HH:mm:ss"/>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>


    </div>
</div>

<textarea cols="20" rows="10" id="biao1">用户定义的代码区域</textarea>
<input type="button" onClick="copyUrl2()" value="点击复制代码"/>

</body>
<!-- jQuery文件.务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<script type="text/javascript">
    function copyUrl2() {
        var Url2 = document.getElementById("biao1");
        Url2.select(); // 选择对象
        document.execCommand("Copy"); // 执行浏览器复制命令
        alert("已复制好，可贴粘。");
    }
</script>



</body>
</html>
