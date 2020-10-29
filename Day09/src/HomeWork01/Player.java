package HomeWork01;

public class Player {
    private Player(){

    }


    public static void play(Instrument instrument){

        if(instrument instanceof Piano){
            System.out.println(instrument.getName()+"正在弹一曲"+((Piano) instrument).getMusic());
        }else if(instrument instanceof Violin){
            System.out.println(instrument.getName()+"正在拉一曲"+((Violin) instrument).getMusic());
        }
    }
}
