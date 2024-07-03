package vitals;

public class Main {
    static boolean batteryIsOk(float temperature, float soc, float chargeRate) {
        return temperatureIsOk(temperature) && socIsOk(soc) && chargeRateIsOk(chargeRate);
    }

    static void DisplayOutOfRange(String parameter) {
        System.out.println(parameter + " is out of range!");
    }

    private static boolean isWithinRange(float value, float min, float max) {
        return (min < value) && (max > value);
    }

    static boolean temperatureIsOk(float temperature) {
        float min = 0;
        float max = 45;
        boolean tempIsOk = isWithinRange(temperature, min, max);
        if (!tempIsOk) {
            DisplayOutOfRange("temperature");
        }
        return tempIsOk;
    }

    static boolean socIsOk(float soc) {
        float min = 20;
        float max = 80;
        boolean socIsOk = isWithinRange(soc, min, max);
        if (!socIsOk) {
            DisplayOutOfRange("State of Charge");
        }
        return socIsOk;
    }

    static boolean chargeRateIsOk(float chargeRate) {
        float min = -0.1f;
        float max = 0.8f;
        boolean chargeRateOk = isWithinRange(chargeRate, min, max);
        if (!chargeRateOk) {
            DisplayOutOfRange("Charge Rate");
        }
        return chargeRateOk;
    }

    public static void main(String[] args) {
        assert (batteryIsOk(25, 70, 0.7f) == true);
        assert (batteryIsOk(1, 70, 0.7f) == true);
        assert (batteryIsOk(44, 70, 0.7f) == true);
        assert (batteryIsOk(25, 35, 0.7f) == true);
        assert (batteryIsOk(25, 21, 0.7f) == true);
        assert (batteryIsOk(25, 79, 0.7f) == true);
        assert (batteryIsOk(25, 70, 0.0f) == true);
        assert (batteryIsOk(25, 70, 0.5f) == true);
        assert (batteryIsOk(25, 70, 0.7f) == true);
        assert (batteryIsOk(0, 70, 0.7f) == false);
        assert (batteryIsOk(45, 70, 0.7f) == false);
        assert (batteryIsOk(25, 20, 0.7f) == false);
        assert (batteryIsOk(25, 80, 0.7f) == false);
        assert (batteryIsOk(25, 70, -0.1f) == false);
        assert (batteryIsOk(25, 70, 0.8f) == false);
        assert (batteryIsOk(0, 70, 0.8f) == false);
        assert (batteryIsOk(0, 80, 0.7f) == false);
        assert (batteryIsOk(1, 20, 0.8f) == false);
        assert (batteryIsOk(0, 20, 0.8f) == false);
    }
}
