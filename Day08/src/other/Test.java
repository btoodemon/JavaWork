package other;/*
	作业1
        	创建一个程序员类和项目经理类
        	封装两个类的所有属性，生成getter和setter方法；
        	为两个类分别编写两个构造函数，一个无参构造函数要求为所有属性设置默认值，另一个是带所有属性参数的构造函数。
        	编写测试类，分别创建两个程序员和两个项目经理，并调用show（）方法显示详细信息。

        	编写计算工资类：
        	添加两个计算程序员和计算项目经理工资的方法，实现方法的重载，分别输出应付多少工资；
        	编写测试类：
        	分别创建一个程序员和一个项目经理对象，再创建一个计算工资对象，调用计算程序员和项目经理工资的方法。
*/


public class Test {
    public static void main(String[] args) {
        SE se = new SE();
        se.show();


        PM pm = new PM();
        pm.show();

        SalaryCalc salaryCalc = new SalaryCalc();
        salaryCalc.pay(se);
        salaryCalc.pay(pm);


    }
}
