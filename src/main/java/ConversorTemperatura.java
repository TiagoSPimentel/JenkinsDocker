public class ConversorTemperatura {
    public static double fahrenheitParaCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public static double celsiusParaFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }
}