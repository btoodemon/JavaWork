package com.javasm.control;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取页面输入的账号和密码
        String username = req.getParameter("username");
        String pwd = req.getParameter("password");

            resp.setContentType("text/html;charset=utf-8");
            PrintWriter out = resp.getWriter();
            // 2.判断用户输入的账号（admin）密码（123456）是否正确
            if ("admin".equals(username) && "123456".equals(pwd)) {
                out.write(username + "登陆成功！");
            } else {
            out.write(username + "登陆不成功！");
        }
        out.flush();
        out.close();
    }

}
