package test02;

public class Test {
    public static void main(String[] args) {
        SE se = new SE(5001,"马化腾","男",3000.0,"非常");
        PM pm = new PM(9002,"马云","男",5000.0,7,2000.0);


        CalSalary.calSal(pm);
        CalSalary.calSal(se);

    }
}
