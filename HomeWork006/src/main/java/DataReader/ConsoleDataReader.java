package DataReader;

import java.util.Scanner;

public class ConsoleDataReader implements IDataReader {
    public Scanner scanner;
    public ConsoleDataReader(){
        scanner = new Scanner(System.in, "Cp866");
    }
    @Override
    public String readString() {
        String answer = scanner.nextLine();
        return answer;
    }
}
