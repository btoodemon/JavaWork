package com.javasm.control;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Source;
import java.io.IOException;

public class MyServlet extends HttpServlet {

    // 属性（属于myservlet类的对象）,会有数据共享
    private int count = 0;

    public MyServlet() {
        System.out.println("myservlet被实例化了。。。。。");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("myservlet数据初始化...........");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入了service方法。。。。。。。。。。。。。。。");
        //  super.service(req, resp);
        // 获取用户的提交方式
        String method = req.getMethod();
        System.out.println(method);
        // 如果用户的提交方式是get，调用doGet方法
        if (method.equals("GET")) {
            this.doGet(req, resp);
        } else if (method.equals("POST")) { // 如果用户的提交方式是post，调用doPost方法
            this.doPost(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("调用了doPost方法..........");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int count = 0;
        System.out.println("调用了doget。。。。。。。。。。。。");
        try {
            Thread.sleep(5000);
            System.out.println(count++);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        System.out.println("销毁myservlet...........");
    }
}
