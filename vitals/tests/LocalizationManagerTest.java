package vitals.tests;

import vitals.constants.BatteryVital;
import vitals.constants.Languages;
import vitals.constants.VitalStatus;
import vitals.localization.LocalizationManager;

public class LocalizationManagerTest {

    // To test valid english language and log key
    private static void testGetLog1() {
        final String expectedLog = "Breach";
        final int key = VitalStatus.BREACH.getIndex();
        final Languages language = Languages.ENGLISH;
        LocalizationManager localizationManager = new LocalizationManager();
        assert (expectedLog.equals(localizationManager.getLog(language, key)));
    }

    // To test valid germain language and log key
    private static void testGetLog2() {
        final String expectedLog = "Laderate";
        final int key = BatteryVital.CHARGE_RATE.getIndex();
        final Languages language = Languages.GERMAIN;
        LocalizationManager localizationManager = new LocalizationManager();
        assert (expectedLog.equals(localizationManager.getLog(language, key)));
    }

    // To test valid language and missing log key
    private static void testGetLog3() {
        final String expectedLog = "";
        final int key = -1;
        final Languages language = Languages.ENGLISH;
        LocalizationManager localizationManager = new LocalizationManager();
        assert (expectedLog.equals(localizationManager.getLog(language, key)));
    }

    public static void runAllTests() {
        testGetLog1();
        testGetLog2();
        testGetLog3();
    }
}
