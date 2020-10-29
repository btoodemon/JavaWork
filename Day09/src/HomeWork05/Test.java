package HomeWork05;

public class Test {
    public static void main(String[] args) {
        Graphics[] graphics = new Graphics[3];
        graphics[0] = new Line(2,3,"red",9,12);
        graphics[1] = new Rectangle(-6,-6,"yellow",4,5);
        graphics[2] = new Circle(26,32,"green",8);

        for (int i = 0; i < graphics.length; i++) {
            graphics[i].draw();
        }

    }
}
