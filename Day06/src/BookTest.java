/**
 * 创建BookTest类,表示本类是Book类的测试类
 *
 */
public class BookTest {
    public static void main(String[] args) {
        //数组的创建使用new关键字
        //        int[] arr = new int[2];

        //类的创建是 类名 变量名 = new 类名();
        Book b = new Book();
        //取值
        System.out.println(b.isbnNo);//通过变量名后加 . 来获取属性
        System.out.println(b.name);
        System.out.println(b.price);
        System.out.println(b.isBorrow);
        //赋值
        b.isbnNo = 10001;
        b.name = "Python 3天速成";
        b.price = 45.0;
        b.isBorrow = false;
        //调用方法
        b.borrow();//通过变量名后加 .  来调用方法

        //打印变量 会跟数组一样直接打印内存地址
        System.out.println(b);

        Book b1 = new Book();
        b1.isbnNo = 10002;
        b1.name = "C++入门到入土";
        b1.price = 128.5;

        b1.borrow();

        b.info();
        b1.info();

    }
}
