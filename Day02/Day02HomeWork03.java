import java.util.Scanner;

public class Day02HomeWork03 {
    public static void main(String[] args) {
        /*
        	求1到100之间所有能被3整除的整数的和
        */
        System.out.println("题7----------------------------");
        int numSumI = 0;
        for(int i = 1;i <=100;i++){
            if(i%3 != 0){
                continue;
            }
            numSumI += i;
        }
        System.out.println("1到100之间所有能被3整除的整数的和:" + numSumI);


        /*
        	要求用户输入一个0到2之间的整数
        如果用户输入0输出“你出的是石头”，
        如果用户输入1就输出“你出的是剪刀”，
        如果用户输入的是2就输出“你出的是布”，
        然后再问是否要继续出拳，
        如果回答“y”就重复以上过程，
        否则结束程序
        */
        System.out.println("题8----------------------------");
        Scanner scanner = new Scanner(System.in);
        String contJudge;
        do {
            System.out.println("请输入一个0到2之间的整数");
            int intNumber = scanner.nextInt();
            if(intNumber<0 || intNumber>2){
                System.out.println("输入错误");;
            }else if (intNumber == 0){
                System.out.println("你出的是石头");
            }else if (intNumber == 1){
                System.out.println("你出的是剪刀");
            }else {
                System.out.println("你出的是布");
            }
            System.out.println("是否要继续出拳?(y/n)");
            scanner.nextLine();//解决无法输入问题
            contJudge = scanner.nextLine();
        }while ("y".equals(contJudge));


        /*
         	让计算机随机产生10个0到2之间的数 Math.random()*3
         如果产生的是0就输出“生成了一只白猪，我好怕怕”
         如果产生的是1就输出“生成了一只黑猪，我喜欢”
         如果产生的是2就输出“生成了一只红猪，有下酒菜了
        */

        System.out.println("题9----------------------------");

        for (int i =0;i<10;i++){
            switch ((int)(Math.random()*3)){
                case 0:
                    System.out.println("生成了一只白猪，我好怕怕");
                    break;
                case 1:
                    System.out.println("生成了一只黑猪，我喜欢");
                    break;
                default:
                    System.out.println("生成了一只红猪，有下酒菜了");
                    break;

            }

        }



    }
}
