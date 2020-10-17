
public class Day02HomeWork04 {
    public static void main(String[] args) {

        /*
        	循环输出以下结果
        2*5=10
        4*10=40
        6*15=90
        .......
        ?*100=?
        */
        System.out.println("题10----------------------------");

        int numFor = 0, numBac = 0;
        int numPro;
        do {
            numFor += 2;
            numBac += 5;
            numPro = numFor * numBac;
            System.out.println(numFor + "*" + numBac + " = " + numPro);
        }while (numBac!=100);

        /*
        输出乘法口诀
        */
        System.out.println("题11----------------------------");

        for(int i = 1;i<10;i++){
            for(int j = 1;j<=i;j++){
                System.out.print(i+ " * " +j+ " = " + i*j + " | ");
                if(i==j){
                    System.out.println();
                }
            }
        }


    }
}
