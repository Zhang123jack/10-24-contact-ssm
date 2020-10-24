<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<% String path = request.getContextPath(); %>
<% String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";%>

<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>"/>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>修改用户</title>

    <link rel='stylesheet' href='css/bootstrap.min.css'/>
    <script src='js/jquery-3.3.1.min.js'></script>
    <script src='js/bootstrap.min.js'></script>
</head>

<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改联系人</h3>
    <form action="UpdateContact" method="post">
        <input type="hidden" name="id" value="${contact.id}">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" readonly="readonly" placeholder="请输入姓名" value="${contact.name}"/>
        </div>

        <div class="form-group">
            <label>性别：</label>
            <input type="radio" name="gender" value="m" ${contact.gender eq'm'?'checked':''}/>男
            <input type="radio" name="gender" value="f"  ${contact.gender eq'f'?'checked':''}/>女
        </div>

        <div class="form-group">
            <label for="formatBirthday">生日：</label>
            <input type="text" class="form-control" id="formatBirthday" name="formatBirthday" placeholder="请输入生日(yyyy-MM-dd)" value="${contact.formatBirthday}"/>
        </div>

        <div class="form-group">
            <%--@declare id="birthplace"--%><label for="birthplace">籍贯：</label>
            <select name="birthplace" class="form-control">
                <option value="广州" ${contact.birthplace eq'广州'?'selected':''}>广州</option>
				<option value="上海" ${contact.birthplace eq'上海'?'selected':''}>上海</option>
                <option value="北京" ${contact.birthplace eq'北京'?'selected':''}>北京</option>
            </select>
        </div>

        <div class="form-group">
            <%--@declare id="mobile"--%><label for="mobile">手机：</label>
            <input type="text" class="form-control" name="mobile" placeholder="请输入手机号码" value="${contact.mobile}"/>
        </div>

        <div class="form-group">
            <%--@declare id="email"--%><label for="email">Email：</label>
            <input type="text" class="form-control" name="email" placeholder="请输入邮箱地址" value="${contact.email}"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交"/>
            <input class="btn btn-default" type="reset" value="重置"/>
            <input class="btn btn-default" type="button" value="返回"/>
        </div>
    </form>
</div>
</body>
</html>
