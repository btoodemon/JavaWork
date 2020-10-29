package Test;

public class Computer {
    String cpu;
    String netCard;
    String gpu;
    String soundCard;
    String memory;

    public Computer(String cpu1, String netCard1, String gpu1, String soundCard1, String memory1){
        cpu = cpu1;
        netCard = netCard1;
        gpu = gpu1;
        soundCard = soundCard1;
        memory = memory1;
    }

    public void surfTheInternet(){
        System.out.println("正在使用电脑配置:");
        System.out.println("cpu:"+cpu+"\t网卡:"+netCard+"\t显卡:"+gpu+"\t声卡:"+soundCard+"\t内存:"+memory);
        System.out.println("上网冲浪");
    }
}
