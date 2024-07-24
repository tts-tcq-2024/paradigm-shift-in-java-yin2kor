package vitals;

public class Main {


    public static void main(String[] args) {
        assert (BatteryStatusVerifier.batteryIsOk(25, 70, 0.7f) == true);
        assert (BatteryStatusVerifier.batteryIsOk(1, 70, 0.7f) == true);
        assert (BatteryStatusVerifier.batteryIsOk(44, 70, 0.7f) == true);
        assert (BatteryStatusVerifier.batteryIsOk(25, 35, 0.7f) == true);
        assert (BatteryStatusVerifier.batteryIsOk(25, 21, 0.7f) == true);
        assert (BatteryStatusVerifier.batteryIsOk(25, 79, 0.7f) == true);
        assert (BatteryStatusVerifier.batteryIsOk(25, 70, 0.0f) == true);
        assert (BatteryStatusVerifier.batteryIsOk(25, 70, 0.5f) == true);
        assert (BatteryStatusVerifier.batteryIsOk(25, 70, 0.7f) == true);
        assert (BatteryStatusVerifier.batteryIsOk(0, 70, 0.7f) == true);
        assert (BatteryStatusVerifier.batteryIsOk(45, 70, 0.7f) == false);
        assert (BatteryStatusVerifier.batteryIsOk(25, 20, 0.7f) == false);
        assert (BatteryStatusVerifier.batteryIsOk(25, 80, 0.7f) == false);
        assert (BatteryStatusVerifier.batteryIsOk(25, 70, -0.1f) == false);
        assert (BatteryStatusVerifier.batteryIsOk(25, 70, 0.8f) == false);
        assert (BatteryStatusVerifier.batteryIsOk(0, 70, 0.8f) == false);
        assert (BatteryStatusVerifier.batteryIsOk(0, 80, 0.7f) == false);
        assert (BatteryStatusVerifier.batteryIsOk(1, 20, 0.8f) == false);
        assert (BatteryStatusVerifier.batteryIsOk(0, 20, 0.8f) == false);
    }
}
