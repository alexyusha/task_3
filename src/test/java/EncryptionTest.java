import org.junit.jupiter.api.BeforeEach;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class EncryptionTest {
    Encryption encryption = new Encryption();
    HashMap<Integer, Integer> hashMap = new HashMap<>();

    @BeforeEach
    void put(){
        hashMap.put(0,1);
        hashMap.put(1,1);
        hashMap.put(4,3);
        hashMap.put(7,3);
    }

    @org.junit.jupiter.api.Test
    void encryption() {
        assertEquals("00 0 0 0 00 000 0 000", encryption.encryption("G"));
    }

    @org.junit.jupiter.api.Test
    void stringToBinary() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Encryption.class.getDeclaredMethod("stringToBinary", String.class);
        method.setAccessible(true);
        assertEquals("01000111", method.invoke(encryption, "G").toString());
        assertEquals("0100011101001111", method.invoke(encryption, "GO").toString());
        assertEquals("010001110100111101001010", method.invoke(encryption, "GOJ").toString());
    }

    @org.junit.jupiter.api.Test
    void sequenceAmount() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method method = Encryption.class.getDeclaredMethod("sequenceAmount", String.class);
        method.setAccessible(true);
        assertEquals(hashMap, method.invoke(encryption, "01000111"));
    }

    @org.junit.jupiter.api.Test
    void getZero() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Encryption.class.getDeclaredMethod("getZero", int.class);
        method.setAccessible(true);
        assertEquals("00000", method.invoke(encryption, 5).toString());
    }

    @org.junit.jupiter.api.Test
    void buildString() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Encryption.class.getDeclaredMethod("buildString", HashMap.class, String.class);
        method.setAccessible(true);
        assertEquals("00 0 0 0 00 000 0 000", method.invoke(encryption, hashMap, "01000111").toString());
    }
}