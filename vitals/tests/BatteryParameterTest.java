package vitals.tests;

import vitals.paramter.BatteryParameter;
import vitals.paramter.StatusLimit;
import vitals.constants.BatteryVital;
import vitals.constants.Limit;
import vitals.constants.VitalStatus;

import java.util.HashMap;

public class BatteryParameterTest {
    private static final BatteryParameter batteryParameter = new BatteryParameter(BatteryVital.CHARGE_RATE, new HashMap<VitalStatus, StatusLimit>() {{
        put(VitalStatus.WARNING, new StatusLimit(0.1f, 0.3f));
        put(VitalStatus.OUT_OF_RANGE, new StatusLimit(-0.1f, 0.8f));
    }});

    private static void testGetVital() {
        BatteryVital expectedVital = BatteryVital.CHARGE_RATE;
        assert (batteryParameter.getVital() == expectedVital);
    }

    // To test in range limit
    private static void testGetCurrentLimit1() {
        final float value = 0.2f;
        final Limit expectedLimit = Limit.IN_RANGE;
        assert (batteryParameter.getCurrentLimit(value) == expectedLimit);
    }

    // To test in upper limit
    private static void testGetCurrentLimit2() {
        final float value = 0.4f;
        final Limit expectedLimit = Limit.UPPER_LIMIT;
        assert (batteryParameter.getCurrentLimit(value) == expectedLimit);
    }

    // To test in lower limit
    private static void testGetCurrentLimit3() {
        final float value = 0.0f;
        final Limit expectedLimit = Limit.LOWER_LIMIT;
        assert (batteryParameter.getCurrentLimit(value) == expectedLimit);
    }

    // To test normal status
    private static void testGetCurrentStatus1() {
        final float value = 0.3f;
        final VitalStatus expectedStatus = VitalStatus.NORMAL;
        assert (batteryParameter.getCurrentStatus(value) == expectedStatus);
    }

    // To test warning status
    private static void testGetCurrentStatus2() {
        final float value = 0.4f;
        final VitalStatus expectedStatus = VitalStatus.WARNING;
        assert (batteryParameter.getCurrentStatus(value) == expectedStatus);
    }

    // To test out of range status
    private static void testGetCurrentStatus3() {
        final float value = 0.9f;
        final VitalStatus expectedStatus = VitalStatus.OUT_OF_RANGE;
        assert (batteryParameter.getCurrentStatus(value) == expectedStatus);
    }

    public static void runAllTests() {
        testGetCurrentLimit1();
        testGetCurrentLimit2();
        testGetCurrentLimit3();
        testGetVital();
        testGetCurrentStatus1();
        testGetCurrentStatus2();
        testGetCurrentStatus3();

    }
}
