<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <%--<link rel="shortcut icon" href="#" />--%>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/js/plugins/layui/css/layui.css"  media="all">
</head>
<body>

<hr>
<div>
    <div class="layui-form-item">
        <label class="layui-form-label">用户名:</label>
        <div class="layui-input-inline">
            <input type="text" name="username" id="username" lay-verify="title" autocomplete="off" placeholder="请输入用户名" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密&emsp;码:</label>
        <div class="layui-input-inline">
            <input type="password" name="password" id="password" lay-verify="title" autocomplete="off" placeholder="请输入密码" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="loginSubmit" onclick="loginSubmit()">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</div>

<!--引入外部js-->
<script type="text/javascript">var ctx = "<%=request.getContextPath()%>";</script>
<script src="<%=request.getContextPath()%>/resources/js/plugins/jquery/jquery-1.7.2.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/plugins/layui/layui.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/apps/index.js"></script>
</body>
</html>
