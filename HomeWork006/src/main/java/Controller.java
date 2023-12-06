import DataReader.IDataReader;
import Infrastructure.IDataConverter;
import Infrastructure.IMathematics;
import Infrastructure.Mathematics;
import View.IView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.DoubleStream;

public class Controller {
    IDataReader dataReader;
    IMathematics math;
    IView view;
    IDataConverter converter;
    public Controller(IDataReader dataReader, IMathematics math, IView view, IDataConverter converter){
        this.dataReader = dataReader;
        this.math = math;
        this.view = view;
        this.converter = converter;
    }

    public ArrayList<Double> getArrayListOfDouble(String message){
        while (true){
            view.showMessage(message);
            String answer = dataReader.readString();
            ArrayList<Double> result = converter.stringToListOfDouble(answer);
            if(result == null){
                view.showErrorMessage("Некорректные данные");
                answer = dataReader.readString();
                if(!answer.equals("1"))
                    return null;
            }
            else{
                return result;
            }
        }
    }
    public void chooseAnswer(Double num){
        if( num > 0){
            view.showMessage("Первый список имеет большее среднее значение");
        }else if (num < 0){
            view.showMessage("Второй список имеет большее среднее значение");
        }else{
            view.showMessage("Средние значения равны");
        }
    }
    public double compareTwoAverageOfList(ArrayList<Double> firstList, ArrayList<Double> secondList){
        Double firstAverage = math.getAverageValueOfList(firstList);
        Double secondAverage = math.getAverageValueOfList(secondList);
        return math.compareTwoNum(firstAverage, secondAverage);
    }
}
