package utils;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Test;

import static org.junit.Assert.*;

public class IdMakerTest {

    @Test
    public void nextId() {
        IdMaker idMaker = new IdMaker();
        System.out.println(idMaker.nextId());
        System.out.println("length:" + String.valueOf(idMaker.nextId()).length());
    }
}