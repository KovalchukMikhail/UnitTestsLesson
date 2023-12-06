package Infrastructure;

import java.util.ArrayList;

public class Mathematics implements IMathematics {

    @Override
    public Double getAverageValueOfList(ArrayList<Double> numbers) {
        Double result = 0d;
        int size = numbers.size();
        if(size == 0){
            return null;
        }
        for(int i = 0; i < size; i++){
            result += numbers.get(i);
        }
        return result / size;
    }

    @Override
    public Double compareTwoNum(Double numOne, Double numTwo) {
        return numOne - numTwo;
    }
}
