package DataReaderTest;

import DataReader.ConsoleDataReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class ConsoleDataReaderTest {
    InputStream originalIn = System.in;
    ConsoleDataReader dataReader;
    @BeforeEach
    void SetUp(){
        dataReader = new ConsoleDataReader();
    }
    @AfterEach
    public void restoreInput(){
        dataReader.scanner = new Scanner(System.in);
        System.setIn(originalIn);
    }

    @Test
    void ReadStringTest(){
        String data = "Hello\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        dataReader.scanner = new Scanner(System.in);
        assertEquals("Hello", dataReader.readString().trim());
    }

}
