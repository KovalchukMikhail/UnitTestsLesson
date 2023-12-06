import DataReader.ConsoleDataReader;
import DataReader.IDataReader;
import Infrastructure.DataConverter;
import Infrastructure.IDataConverter;
import Infrastructure.IMathematics;
import Infrastructure.Mathematics;
import View.ConsoleView;
import View.IView;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        IDataReader dataReader = new ConsoleDataReader();
        IDataConverter converter = new DataConverter();
        IMathematics math = new Mathematics();
        IView view = new ConsoleView();

        Controller controller = new Controller(dataReader, math, view, converter);

        ArrayList<Double> firstList = controller.getArrayListOfDouble("Введите через пробел числа для первого списка");
        if(firstList == null)
            return;

        ArrayList<Double> secondList = controller.getArrayListOfDouble("Введите через пробел числа для второго списка");
        if(secondList == null)
            return;

        Double result = controller.compareTwoAverageOfList(firstList, secondList);

        controller.chooseAnswer(result);
    }
}