package com.javasm.control;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        // 获取数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 操作数据，将数据保存到数据中


        PrintWriter out = resp.getWriter();
        out.write(username + "注册成功");
        out.flush();
        out.close();

    }
}
