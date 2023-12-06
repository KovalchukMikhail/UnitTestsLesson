package Infrastructure;

import java.util.ArrayList;

public class DataConverter implements IDataConverter {
    @Override
    public ArrayList<Double> stringToListOfDouble(String numbers) {
        String[] arrayNum = numbers.split(" ");
        ArrayList<Double> result = new ArrayList<Double>();
        try {
            for(int i = 0; i < arrayNum.length; i++){
                result.add(Double.parseDouble(arrayNum[i]));
            }
            if(result.size() == 0)
                return null;
        }
        catch (Exception ex){
            return null;
        }
        return result;
    }
}
