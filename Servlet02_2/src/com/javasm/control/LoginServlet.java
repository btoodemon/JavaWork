package com.javasm.control;

import com.javasm.dao.UserinfoDao;
import com.javasm.dao.impl.UserinfoDaoImpl;
import com.javasm.entity.Userinfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    private UserinfoDao userinfoDao = new UserinfoDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取用户输入的账号和密码
        String userName = req.getParameter("userName");
        String pwd = req.getParameter("pwd");
        // 2.通过账号和密码到数据库中查询所有这个用户
        Userinfo userinfo = userinfoDao.login(userName, pwd);

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        // 3.将处理的结果响应到浏览器
        if (userinfo != null) {
            out.write("<h1 style='color:red'>登录成功</h1>");
        } else {
            out.write("<h1 style='color:blue'>登录失败</h1>");
        }
    }
}
