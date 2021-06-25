package utils;


import org.junit.Test;

public class IdMakerTest {

    @Test
    public void nextId() {
        IdMaker idMaker = new IdMaker();
        System.out.println(idMaker.nextId());
        System.out.println("length:" + String.valueOf(idMaker.nextId()).length());
    }
}