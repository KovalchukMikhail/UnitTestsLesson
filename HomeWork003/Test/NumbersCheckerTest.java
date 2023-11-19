import infrastructure.NumbersChecker;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumbersCheckerTest {
    NumbersChecker numbersChecker;
    @BeforeEach
    void init(){
        numbersChecker = new NumbersChecker();
    }
    @AfterEach
    void cleanUp(){
        numbersChecker = null;
    }
    @Test
    @DisplayName("Проверка на четность. Результат true.")
    void numberIsEven(){
        assertTrue(numbersChecker.evenOddNumber(10000008));
    }
    @Test
    @DisplayName("Проверка на четность. Результат false.")
    void numberIsNotEven(){
        assertFalse(numbersChecker.evenOddNumber(10000009));
    }

    @Test
    @DisplayName("Проверка попадания числа в интервал. Число равно минимальному. Результат true.")
    void numberIsEqualMinValue(){
        assertTrue(numbersChecker.numberInInterval(25));
    }
    @Test
    @DisplayName("Проверка попадания числа в интервал. Число равно максимальному. Результат true.")
    void numberIsEqualMaxValue(){
        assertTrue(numbersChecker.numberInInterval(100));
    }
    @Test
    @DisplayName("Проверка попадания числа в интервал. Число внутри интервала. Результат true.")
    void numberIsIntoInterval(){
        assertTrue(numbersChecker.numberInInterval(30));
    }
    @Test
    @DisplayName("Проверка попадания числа в интервал. Число больше максимального. Результат false.")
    void numberMoreThanMaxValue(){
        assertFalse(numbersChecker.numberInInterval(101));
    }
    @Test
    @DisplayName("Проверка попадания числа в интервал. Число меньше максимального. Результат false.")
    void numberLessThanMinValue(){
        assertFalse(numbersChecker.numberInInterval(24));
    }
}
