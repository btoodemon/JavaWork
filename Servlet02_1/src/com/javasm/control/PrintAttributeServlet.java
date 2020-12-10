package com.javasm.control;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintAttributeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取servletcontext对象
        ServletContext application = getServletContext();
        // 获取存储在servletcontext对象中的数据
        Integer count = (Integer) application.getAttribute("count");

        //获取session中的数据
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        // sessionID
        String id = session.getId();
        long creationTime = session.getCreationTime();
        int maxInactiveInterval = session.getMaxInactiveInterval();
        long lastAccessedTime = session.getLastAccessedTime();

        System.out.println(count);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.write("servletcontext对象中获取的数据（count）:" + count + "<br />");
        out.write("session对象中获取的数据（username）:" + username + "<br />");
        out.write("sessionID：" + id + "<br />");
        out.write("creationTime：" + creationTime + "<br />");
        out.write("lastAccessedTime：" + lastAccessedTime + "<br />");
        out.write("maxInactiveInterval：" + maxInactiveInterval + "<br />");
        out.flush();
        out.close();
    }
}
