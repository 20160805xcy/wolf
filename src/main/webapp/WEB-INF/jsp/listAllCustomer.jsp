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
<div id="login_container" class="row" style="    top: -42px;">
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
                        <th>详情</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="clist" items="${customerChildList.list}">
                        <tr>
                            <td>${clist.customerName}</td>
                            <td>${clist.loginName}</td>
                            <td>${clist.crtByName}</td>
                            <td>
                                <fmt:formatDate value="${clist.crtDtm}" pattern="yyyy-MM-dd"/>
                            </td>
                            <td>${clist.activateBy}</td>
                            <td>
                                <fmt:formatDate value="${clist.activateDtm}" pattern="yyyy-MM-dd HH:mm:ss"/>
                            </td>
                            <td>
                                <a class="btn btn-info" href="/customer/${clist.id}/detail" target="_blank">点击</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="text-center">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li>
                            <a id="previousPage" href="/customer/aa?rows=4&page=+${pageNum-1}+" aria-label="Previous">
                                <span aria-hidden="true">上一页</span>
                            </a>
                        </li>
                        <li><a id="homePage" href="/customer/aa?rows=4">1</a></li>
                        <li class="active"><a >${pageNum}</a></li>
                        <li><a id="lastPage" href="/customer/aa?rows=4&page=+${pages}+">${pages}</a></li>
                        <li>
                            <a id="nextPage" href="/customer/aa?rows=4&page=+${pageNum+1}+"  aria-label="Next">
                                <span aria-hidden="true">下一页</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
        <div class="panel panel-default">
            <button type="button" onclick="window.location.href='/layUI/goLayUI'" class="btn btn-primary">跳转到LayUI界面</button>
            <button type="button" class="btn btn-success">（成功）Success</button>
            <button type="button" class="btn btn btn-info">（成功）Success</button>
        </div>
    </div>
</body>

<!-- jQuery文件.务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>
