<html>

<head>
    <title>Welcome!</title>
</head>
<style>
    table{
        border-collapse: collapse;
    }
    td{
        border:solid#000 1px;
    }
    th{
        border:solid#000 1px;
    }
</style>
<body>
<p>
    各位评审人及项目组成员：<br>
    &emsp;${requisitionName}已完成第${distributeCount}轮已打回，各专业模块评审意见见下表。<br>
    &emsp;请申请人及时按照评审意见组织落实，再次提交评审时请在“反馈意见”中说明落实情况。
</p>
<table>
    <tr>
        <th style="width: 50px">轮次</th>
        <th style="width: 100px">专业方向</th>
        <th style="width: 80px">评审人</th>
        <th style="width: 100px">评审结果</th>
        <th>评审意见</th>
        <th style="width: 100px">反馈意见</th>
    </tr>

    <#list records?sort_by("count")?reverse as record>
    <#--<#list userList as user>-->
        <tr>
            <td>${record.count}</td>
            <td>
                <#if record.type == 'jjfa'>
                    解决方案
                <#elseif record.type == 'jffa'>
                    交付方案
                <#elseif record.type == 'cjfa'>
                    财经方案
                <#elseif record.type == 'sffa'>
                    商法方案
                <#elseif record.type == 'xsclysw'>
                    销售策略与商务
                </#if>
            </td>
            <td>${record.username}</td>
            <td>${record.reviewResult}</td>
            <td>${record.reviewOpintion}</td>
            <td>${record.feedback}</td>
        </tr>
    </#list>
</table>
</body>

</html>



