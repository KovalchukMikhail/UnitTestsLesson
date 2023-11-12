import Calculator.Calculator;
import org.junit.Assert;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }
    @AfterEach
    void tearDown(){
        calculator = null;
    }

    @Test
    @DisplayName("Сумма покупки с учетом скидки. Валидные параметры")
    void testCalculatingDiscountWithRightParam(){
        double purchaseAmount = 200;
        int discountAmount = 50;
        double expectedResult = 100;
        assertEquals(expectedResult, calculator.calculatingDiscount(purchaseAmount, discountAmount));
    }

    @Test
    @DisplayName("Сумма покупки с учетом скидки. Отрицательная сумма покупки")
    void testCalculatingDiscountWithNegativePurchase(){
        double purchaseAmount = -200;
        int discountAmount = 50;
        assertThrows(IllegalArgumentException.class, () -> calculator.calculatingDiscount(purchaseAmount, discountAmount));
    }

    @Test
    @DisplayName("Сумма покупки с учетом скидки. Отрицательная скидка")
    void testCalculatingDiscountWithNegativeDiscount(){
        double purchaseAmount = 200;
        int discountAmount = -50;
        assertThrows(IllegalArgumentException.class, () -> calculator.calculatingDiscount(purchaseAmount, discountAmount));
    }

    @Test
    @DisplayName("Сумма покупки с учетом скидки. Скидка больше 100%")
    void testCalculatingDiscountWithTooBigDiscount(){
        double purchaseAmount = 200;
        int discountAmount = 101;
        assertThrows(IllegalArgumentException.class, () -> calculator.calculatingDiscount(purchaseAmount, discountAmount));
    }

}
