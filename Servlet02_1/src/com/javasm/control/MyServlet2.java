package com.javasm.control;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class MyServlet2 extends GenericServlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        // 1.将ServletRequest、ServletResponse装为httpServletrequest、httpServletresponse
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 2.获取页面数据
        String name = request.getParameter("name");
        System.out.println(name);
        // 3.获取servlet在web.xml文件中配置的<Servlet-name>
        String servletName = super.getServletName();
        System.out.println(servletName);
        //  4.获取在web.xml文件中配置的初始数据
        String initParameter = super.getInitParameter("username");// getInitParameter(username) 中的参数需要对应到<param-name>name</param-name>
        System.out.println(initParameter);
        //  5.获取在web.xml文件中配置所有的初始数据的name
        Enumeration<String> initParameterNames = super.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String paramName = initParameterNames.nextElement();
            String paramValue = super.getInitParameter(paramName);
            System.out.println(paramName + "：" + paramValue);
        }
    }
}
