<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <style type="text/css">
        .input {
            width: 150px;
            height: 20px;
            border: 1px skyblue solid;
            margin-bottom: 5px;
        }

        select {
            width: 50px;
            height: 20px;
            border: 1px skyblue solid;
            margin-bottom: 5px;
        }

        .focus {
            border: 1px red solid;
        }

        span {
            color: red;
        }
    </style>
    <script src="js/jquery-3.2.1.min.js" type="text/javascript" charset="utf-8"></script>

</head>
<body>
<form action="login" method="post" id="myFrm">
    <table width="500px" align="center">
        <tr>
            <td align="right" width="100px">
                <label for="username">账号：</label>
            </td>
            <td>
                <input type="text" name="userName" id="username" placeholder="请输入账号" class="input" value="小白"/>
                <span></span>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label for="password">密码：</label>
            </td>
            <td>
                <input type="password" name="pwd" id="password" placeholder="请输入密码" class="input"/>
                <span></span>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="登录"/>
                <a href="register.html">注册</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
