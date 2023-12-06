package InfrastructureTest;

import Infrastructure.DataConverter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class DataConverterTest {
    DataConverter converter;
    @BeforeEach
    void setupParam(){
        converter = new DataConverter();
    }
    @AfterEach
    void initParam(){
        converter = null;
    }
    @Test
    void stringToListOfDoubleCorrectDataTest(){
        String data = "1 2 3 4 5 0 -1 -2 -3 -4 -5";
        Double[] rightAnswer = {1d, 2d, 3d, 4d, 5d, 0d, -1d, -2d, -3d, -4d, -5d};

        assertEquals(rightAnswer, converter.stringToListOfDouble(data).toArray());
    }
    @Test
    void stringToListOfDoubleNotCorrectDataTest(){
        String data = "1 2 b 4 5 0 -1 -2 -3 -4 -5";
        Double[] rightAnswer = {1d, 2d, 3d, 4d, 5d, 0d, -1d, -2d, -3d, -4d, -5d};

        assertEquals(null, converter.stringToListOfDouble(data));
    }
}
