import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ConversorTemperaturaTest {
    @Test
    public void testFahrenheitParaCelsius() {
        assertEquals(0.0, ConversorTemperatura.fahrenheitParaCelsius(32), 0.01);
    }

    @Test
    public void testCelsiusParaFahrenheit() {
        assertEquals(212.0, ConversorTemperatura.celsiusParaFahrenheit(100), 0.01);
    }
}
