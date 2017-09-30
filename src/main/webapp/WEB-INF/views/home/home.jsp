<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/js/plugins/layui/css/layui.css"  media="all">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/js/plugins/layui/css/modules/layer/default/layer.css">
    <!--引入外部js-->
    <script src="<%=request.getContextPath()%>/resources/js/plugins/jquery/jquery-1.7.2.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/plugins/layui/layui.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/plugins/layui/lay/modules/layer.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/apps/home/home.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">某某系统后台布局</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">控制台</a></li>
            <li class="layui-nav-item"><a href="">商品管理</a></li>
            <li class="layui-nav-item"><a href="">用户</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="">邮件管理</a></dd>
                    <dd><a href="">消息管理</a></dd>
                    <dd><a href="">授权管理</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    admin
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">退了</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">所有商品</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">发送邮件</a></dd>
                        <dd><a href="http://www.baidu.com">列表二</a></dd>
                        <dd><a href="javascript:;">列表三</a></dd>
                        <dd><a href="">超链接</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">解决方案</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">列表一</a></dd>
                        <dd><a href="javascript:;">列表二</a></dd>
                        <dd><a href="">超链接</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="">云市场</a></li>
                <li class="layui-nav-item"><a href="">发布商品</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <div>
                <button data-method="offset" data-type="auto" class="layui-btn layui-btn-normal">发送邮件功能</button>
                <br><br><br>
                <div class="layui-form-item">
                    <label class="layui-form-label">发送地址:</label>
                    <div class="layui-input-block">
                        <input type="text" name="address" id="address" lay-verify="title" autocomplete="off" placeholder="请输入邮件地址" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">发送人:</label>
                    <div class="layui-input-block">
                        <input type="text" name="sendPerson" id="sendPerson" lay-verify="title" autocomplete="off" placeholder="请输入发送人" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit="" lay-filter="loginSubmit" onclick="sendEmail()">简单发送</button>
                        <button class="layui-btn" lay-submit="" lay-filter="loginSubmit" onclick="sendEmailByFreemarker()">通过模板发送</button>
                        <button type="reset" class="layui-btn layui-btn-primary" onclick="resetSendEmail()">重置</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>

<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>

</body>
</html>
