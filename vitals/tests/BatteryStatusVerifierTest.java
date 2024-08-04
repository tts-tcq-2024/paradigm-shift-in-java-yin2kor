package vitals.tests;

import vitals.BatteryStatusVerifier;

public class BatteryStatusVerifierTest {

    public static void runAllTests() {
        assert (BatteryStatusVerifier.batteryIsOk(25, 70, 0.7f) == true);
        assert (BatteryStatusVerifier.batteryIsOk(1, 70, 0.7f) == true);
        assert (BatteryStatusVerifier.batteryIsOk(44, 70, 0.7f) == true);
        assert (BatteryStatusVerifier.batteryIsOk(25, 35, 0.7f) == true);
        assert (BatteryStatusVerifier.batteryIsOk(25, 21, 0.7f) == true);
        assert (BatteryStatusVerifier.batteryIsOk(25, 79, 0.7f) == true);
        assert (BatteryStatusVerifier.batteryIsOk(25, 70, 0.0f) == true);
        assert (BatteryStatusVerifier.batteryIsOk(25, 70, 0.5f) == true);
        assert (BatteryStatusVerifier.batteryIsOk(25, 70, 0.7f) == true);
        assert (BatteryStatusVerifier.batteryIsOk(-1, 70, 0.7f) == false);
        assert (BatteryStatusVerifier.batteryIsOk(46, 70, 0.7f) == false);
        assert (BatteryStatusVerifier.batteryIsOk(25, 19, 0.7f) == false);
        assert (BatteryStatusVerifier.batteryIsOk(25, 81, 0.7f) == false);
        assert (BatteryStatusVerifier.batteryIsOk(25, 70, -0.2f) == false);
        assert (BatteryStatusVerifier.batteryIsOk(25, 70, 0.9f) == false);
        assert (BatteryStatusVerifier.batteryIsOk(-1, 70, 0.9f) == false);
        assert (BatteryStatusVerifier.batteryIsOk(-1, 81, 0.7f) == false);
        assert (BatteryStatusVerifier.batteryIsOk(0, 19, 0.9f) == false);
        assert (BatteryStatusVerifier.batteryIsOk(-1, 19, 0.9f) == false);
    }
 }
