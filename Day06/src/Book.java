public class Book {
    /**
     * 属性
     */
    int isbnNo;     //编号
    String name;    //书名
    double price;   //价格
    boolean isBorrow;//是否被借阅

    /**
     * 方法
     */
    public void borrow() {
        isBorrow = true;   //局部变量
        System.out.println("借阅书籍");
    }

    public void info() {
        System.out.println("编号: " + isbnNo + "\t书名: " + name + "\t\t价格: " + price + "\t是否被借阅: " + isBorrow);
    }
}
