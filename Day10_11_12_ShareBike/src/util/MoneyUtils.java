package util;

public interface MoneyUtils {
    /**
     * 计算借出分钟数应付的金额
     * @param time
     * @return
     */
    static double countMoney(int time){
        double billing = 0.2;
        return time*billing;
    }
}
