package View;

public class ConsoleView implements IView {

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void showErrorMessage(String message) {
        message += "\n1 - для повторного ввода\nЛюбой другой символ для выхода из программы\n";
        showMessage(message);
    }
}
