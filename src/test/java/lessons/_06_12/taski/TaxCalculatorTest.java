package lessons._06_12.taski;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static lessons._06_12.taski.TaxCalculator.calculateTax;

class TaxCalculatorTest {
    @DisplayName("Проверка, что метод возвращает положительное значение для\n" +
            "различных уровней дохода и фиксированного статуса налогоплательщика.")
    @ParameterizedTest
    @ValueSource(doubles = {30000, 60000, 100000})
    void calculateTaxPositiveValueTest(double income) {
        double tax = calculateTax(income, "single");

        Assertions.assertTrue(tax > 0);
    }

//    ************************************************
    //Проверка с использованием @CsvSource
    //
    //Проверка, что метод возвращает правильное значение для
    //различных комбинаций дохода и статуса налогоплательщика.
    //Набор данных:
    //income: 30000, status: "single", ожидаемое значение: 6000
    //income: 60000, status: "single", ожидаемое значение: 15000
    //income: 90000, status: "married", ожидаемое значение: 18000
//   ************************************************

    @DisplayName("Проверка, что метод возвращает правильное значение для\n" +
            " различных комбинаций дохода и статуса налогоплательщика.")
    @ParameterizedTest
    @CsvSource({
            "30000, single, 6000",
            "60000, single, 15000",
            "90000, married, 18000",
    })
    void calculateTaxCSVSrcTest( double income, String status, double expected) {
        double tax = calculateTax(income, status);

        Assertions.assertEquals(expected, tax);
    }

//    ************************************************
// Проверка с использованием @MethodSource
//
// Проверка, что метод возвращает правильное значение для
// различных комбинаций дохода и статуса налогоплательщика.
// Набор данных (метод должен возвращать Stream<Arguments>):
// income: 30000, status: "single", ожидаемое значение: 6000
// income: 60000, status: "single", ожидаемое значение: 15000
// income: 90000, status: "married", ожидаемое значение: 18000
//    ************************************************

    @DisplayName("Проверка, что метод возвращает правильное значение для\n" +
            " различных комбинаций дохода и статуса налогоплательщика.")
    @ParameterizedTest
    @MethodSource("taxProvider")
    void calculateTaxWithDiffStatus(double income, String status, double expected) {
        double tax = calculateTax(income, status);

        Assertions.assertEquals(expected, tax);
    }

    static Stream<Arguments> taxProvider() {
        return Stream.of(
                Arguments.of(30000, "single", 6000),
                Arguments.of(60000, "single", 15000),
                Arguments.of(90000, "married", 18000)
        );
    }

    @DisplayName("Проверка, что метод возвращает правильное значение для\n" +
            " различных комбинаций дохода и статуса налогоплательщика.")
    @ParameterizedTest
    @CsvFileSource(resources = "/taxes.csv", numLinesToSkip = 1)
    void calculateTaxWithDiffStatusEnum(double income, String status, double expected) {
        double tax = calculateTax(income, status);

        Assertions.assertEquals(expected, tax);
    }
}
