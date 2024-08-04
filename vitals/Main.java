package vitals;

import vitals.tests.BatteryParameterTest;
import vitals.tests.BatteryStatusVerifierTest;
import vitals.tests.LocalizationManagerTest;
import vitals.tests.StatusLimitTest;

public class Main {


    public static void main(String[] args) {
        BatteryStatusVerifierTest.runAllTests();
        LocalizationManagerTest.runAllTests();
        BatteryParameterTest.runAllTests();
        StatusLimitTest.runAllTests();
    }
}
