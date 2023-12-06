package InfrastructureTest;

import Infrastructure.Mathematics;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MathematicsTest {
    Mathematics math;
    @BeforeEach
    void setupParam(){
        math = new Mathematics();
    }
    @AfterEach
    void initParam(){
        math = null;
    }
    @Test
    void GetAverageValueOfListCorrectParamTest(){
        ArrayList<Double> data = new ArrayList<Double>();
        data.add(3d);
        data.add(2d);
        data.add(10d);
        data.add(7d);
        data.add(8d);
        Double result = math.getAverageValueOfList(data);
        assertEquals(6d, result, 0.0001);
    }
    @Test
    void GetAverageValueOfListNotCorrectParamTest(){
        ArrayList<Double> data = new ArrayList<Double>();

        Double result = math.getAverageValueOfList(data);
        assertEquals(null, result);
    }
    @Test
    void CompareTwoNumTest(){
        assertEquals(5d, math.compareTwoNum(10d, 5d), 0.001);
    }
}
