package ViewTest;

import View.ConsoleView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ConsoleViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    ConsoleView consoleView;

    @BeforeEach
    public void setUpStream(){
        System.setOut(new PrintStream(outContent));
        consoleView = new ConsoleView();
    }
    @AfterEach
    public void restoreStream(){
        System.setOut(originalOut);
    }
    @Test
    void showMessageTest(){
        consoleView.showMessage("Hello");
        assertEquals("Hello", outContent.toString().trim());
    }
    @Test
    void showErrorMessageTest(){
        consoleView.showErrorMessage("Hello");
        assertEquals("Hello\n1 - для повторного ввода\nЛюбой другой символ для выхода из программы", outContent.toString().trim());
    }

}
