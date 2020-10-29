package HomeWork04;

/*
	作业4：
        	描述一个计算器类 , 计算机有 操作数1 ， 操作数2 ， 运算符 三个属性，还具备运算的功能。
        	要求：不能直接给 操作数1 操作数2，运算符直接赋值
*/


public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.operation(23,'+',34);
        computer.operation(46,'-',2);
        computer.operation(5,'*',14);
        computer.operation(3,'/',6);
        computer.operation(58,'%',13);
        computer.operation(41,'!',7);
    }
}
