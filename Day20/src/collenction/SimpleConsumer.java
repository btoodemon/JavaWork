package collenction;

import java.util.function.Consumer;

public class SimpleConsumer implements Consumer {
    @Override
    public void accept(Object o) {
        System.out.println(o);
    }
}
