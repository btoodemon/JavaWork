package test03;

public interface MyInterface {//接口
    int NUM =100;
    String USER_NAME ="admin";
    String a(final int num);
    //public MyInterface(){}  //没有构造

    public default void b(){  //普通功能的方法
        System.out.println("b..............");
    }


    public static int c(){
        System.out.println("c..............");
        return NUM;
    }


}
