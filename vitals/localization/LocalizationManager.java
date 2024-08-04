package vitals.localization;

import vitals.constants.Languages;

import java.util.HashMap;
import java.util.Map;

public class LocalizationManager implements ILocalization{

    private static final String[][] mLocalizedLogs = new String[][] {
            {"Lower Limit", "Upper Limit", "In Range", "Normal", "Warning", "Breach", "Out of Range", "Temperature", "SOC", "Charge Rate"},
            {"Untergrenze", "Obergrenze", "Im Bereich", "Normal", "Warnung", "Verstoß", "Außerhalb des Bereichs", "Temperatur", "Ladezustand", "Laderate"}
    };


    public static boolean isValidIndex(Object[] array, int index) {
        return index >= 0 && index < array.length;
    }

    @Override
    public String getLog(Languages language, int logIndex) {
        String log = "";
        if (isValidIndex(mLocalizedLogs,language.getIndex()) && isValidIndex(mLocalizedLogs[language.getIndex()],logIndex)) {
            log = mLocalizedLogs[language.getIndex()][logIndex];
        }
        return log;
    }
}
