package vitals.tests;

import vitals.constants.BatteryVital;
import vitals.constants.Languages;
import vitals.constants.VitalStatus;
import vitals.localization.LocalizationManager;

public class LocalizationManagerTest {

    // To test valid english language and log key
    private static void testGetLog1() {
        final String expectedLog = "Breach";
        final String key = VitalStatus.BREACH.getKey();
        final Languages language = Languages.ENGLISH;
        LocalizationManager localizationManager = new LocalizationManager();
        assert (expectedLog.equals(localizationManager.getLog(language, key)));
    }

    // To test valid germain language and missing log key
    private static void testGetLog2() {
        final String expectedLog = "Laderate";
        final String key = BatteryVital.CHARGE_RATE.getKey();
        final Languages language = Languages.ENGLISH;
        LocalizationManager localizationManager = new LocalizationManager();
        assert (expectedLog.equals(localizationManager.getLog(language, key)));
    }

    // To test valid language and missing log key
    private static void testGetLog3() {
        final String expectedLog = "";
        final String key = "testKey";
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
