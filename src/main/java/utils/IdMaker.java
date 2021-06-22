package utils;

import java.util.Random;

/**
 * @author shaozk
 */
public class IdMaker {

    public long nextId() {
        return new Random().nextLong();
    }


}
