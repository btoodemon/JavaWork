package HomeWork04;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Computer {
    private double num1;
    private double num2;
    private char operator;

    public void operation(double num1,char operator,double num2){
        switch (operator){
            case '+':
                System.out.println(num1+" + "+num2+" = "+(num1+num2));
                break;
            case '-':
                System.out.println(num1+" - "+num2+" = "+(num1-num2));
                break;
            case '*':
                System.out.println(num1+" * "+num2+" = "+(num1*num2));
                break;
            case '/':
                System.out.println(num1+" / "+num2+" = "+(num1/num2));
                break;
            case '%':
                System.out.println(num1+" % "+num2+" = "+(num1%num2));
                break;
            default:
                System.out.println("看不懂你输了个啥");
        }
    }




}
