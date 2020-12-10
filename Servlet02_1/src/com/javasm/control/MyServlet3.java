package com.javasm.control;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet3 implements Servlet {

    private ServletConfig servletConfig;

    public MyServlet3() {
        System.out.println("实例化Myservlet3。。。。。。。。。");
    }

    /**
     * 初始化数据
     *
     * @param servletConfig 当前servlet类在web.xml文件中配置信息，有tomcat容器进行实例化，并且获取到所有的配置信息
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
    }

    /**
     * 获取ServletConfig对象
     *
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }

    /**
     * 服务方法
     *
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        // ServletRequest、ServletResponse对转为HTTpServletRequest、HttpServletResponse
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        // 获取ServletConfig对象
        ServletConfig servletConfig = this.getServletConfig();// this.servletConfig
        String servletName = servletConfig.getServletName();
        System.out.println("servletName：" + servletName);

        // 获取提交方式
        String method = request.getMethod();
        if (method.equals("GET")) {
            this.doGet(request, response);
        } else if (method.equals("POST")) {
            this.doPost(request, response);
        }

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  完成登录的业务

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  完成登录的业务

    }


    /**
     * 获取servlet的配置信息
     *
     * @return
     */
    @Override
    public String getServletInfo() {
        return this.servletConfig.getServletName();
    }

    /**
     * 销毁方法
     */
    @Override
    public void destroy() {
        System.out.println("销毁myservlet3");
    }
}
