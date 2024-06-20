package vitals;

public class Main {
    static boolean batteryIsOk(float temperature, float soc, float chargeRate) {
        return temperatureIsOk(temperature) && socIsOk(soc) && chargeRateIsOk(chargeRate);
    }

    static boolean temperatureIsOk(float temperature) {
        boolean isOk = true;
        if (temperature < 0) {
            isOk = false;
        }
        if (temperature > 45) {
            isOk = false;
        }
        return isOk;
    }

    static boolean socIsOk(float soc) {
        boolean isOk = true;
        if (soc < 20) {
            isOk = false;
        }
        if (soc > 80) {
            isOk = false;
        }
        return isOk;
    }

    static boolean chargeRateIsOk(float chargeRate) {
        boolean isOk = true;
        if (chargeRate > 0.8) {
            isOk = false;
        }
        return isOk;
    }

    public static void main(String[] args) {
        assert(batteryIsOk(25, 70, 0.7f) == true);
        assert(batteryIsOk(50, 85, 0.0f) == false);
        System.out.println("Some more tests needed");
    }
}
