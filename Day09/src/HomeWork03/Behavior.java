package HomeWork03;

public class Behavior {
    private Behavior(){

    }


    public static void move(Animal animal){
        if(animal instanceof Snake){
            ((Snake) animal).crawl();
        }else if (animal instanceof Fish){
            ((Fish) animal).swim();
        }
    }


}
