package vitals.tests;

import vitals.paramter.StatusLimit;

public class StatusLimitTest {

    private static void testGetLowerLimit() {
        StatusLimit statusLimit = new StatusLimit(1,2);
        final float expectedValue = 1f;
        assert  (statusLimit.getLowerLimit() == expectedValue);
    }

    private static void testGetUpperLimit() {
        StatusLimit statusLimit = new StatusLimit(1,2);
        final float expectedValue = 2f;
        assert  (statusLimit.getUpperLimit() == expectedValue);
    }

    public static void runAllTests() {
        testGetUpperLimit();
        testGetLowerLimit();
    }
}
