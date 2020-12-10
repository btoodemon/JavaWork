package com.javasm.control;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet4 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取ServletContext对象(application作用域对象)
        ServletContext application = getServletContext();
        // 将保存到application作用域对象中
        application.setAttribute("count", 0);

        /*******************************************************/
        // 获取HttpSession
        HttpSession session = req.getSession();
        // 设置有效期
        session.setMaxInactiveInterval(50);// 秒
        // 向session中保存数据
        session.setAttribute("username", "小白");


        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<a href='print'>取值</a>");
        out.flush();
        out.close();
    }
}
