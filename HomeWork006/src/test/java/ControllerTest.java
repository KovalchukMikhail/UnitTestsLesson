import DataReader.IDataReader;
import Infrastructure.IDataConverter;
import Infrastructure.IMathematics;
import View.IView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ControllerTest {
    Controller controller;
    IDataReader dataReaderMock;
    IMathematics mathMock;
    IView viewMock;
    IDataConverter converterMock;
    @BeforeEach
    void setupParam(){
        dataReaderMock = mock(IDataReader.class);
        mathMock = mock(IMathematics.class);
        viewMock = mock(IView.class);
        converterMock = mock(IDataConverter.class);
        controller = new Controller(dataReaderMock, mathMock, viewMock, converterMock);
    }
    @AfterEach
    void initParam(){
        dataReaderMock = null;
        mathMock = null;
        viewMock = null;
        converterMock = null;
        controller = null;
    }
    @Test
    void GetArrayListOfDoubleCorrectParamTest(){
        ArrayList<Double> list = new ArrayList<Double>();
        list.add(1d);
        list.add(2d);
        list.add(3d);
        Mockito.when(dataReaderMock.readString()).thenReturn("1 2 3");
        Mockito.when(converterMock.stringToListOfDouble("1 2 3")).thenReturn(list);

        assertEquals(list.toArray(), controller.getArrayListOfDouble("Hello").toArray());
    }
    @Test
    void GetArrayListOfDoubleNotCorrectParamTest(){
        Mockito.when(dataReaderMock.readString()).thenReturn("0");
        Mockito.when(converterMock.stringToListOfDouble("0")).thenReturn(null);

        assertEquals(null, controller.getArrayListOfDouble("Hello"));

    }
    @Test
    void chooseAnswerPositiveParam(){
        controller.chooseAnswer(5d);
        verify(viewMock).showMessage("Первый список имеет большее среднее значение");
    }
    @Test
    void chooseAnswerNegativeParam(){
        controller.chooseAnswer(-5d);
        verify(viewMock).showMessage("Второй список имеет большее среднее значение");
    }
    @Test
    void chooseAnswerZeroParam(){
        controller.chooseAnswer(0d);
        verify(viewMock).showMessage("Средние значения равны");
    }
    @Test
    void compareTwoAverageOfListTest(){
        ArrayList<Double> firstList = new ArrayList<Double>();
        firstList.add(1d);
        firstList.add(2d);
        firstList.add(3d);

        ArrayList<Double> secondList = new ArrayList<Double>();
        secondList.add(2d);
        secondList.add(2d);
        secondList.add(5d);

        Mockito.when(mathMock.getAverageValueOfList(firstList)).thenReturn(2d);
        Mockito.when(mathMock.getAverageValueOfList(secondList )).thenReturn(3d);
        Mockito.when(mathMock.compareTwoNum(2d, 3d)).thenReturn(-1d);

        assertEquals(-1d, controller.compareTwoAverageOfList(firstList, secondList), 0.001);
    }
}
