package vitals.localization;

import vitals.constants.Languages;

import java.util.HashMap;
import java.util.Map;

public class LocalizationManager implements ILocalization{

    private static final String[][] mLocalizedLogs = new String[][] {
            {"Lower Limit", "Upper Limit", "In Range", "Normal", "Warning", "Breach", "Out of Range", "Temperature", "SOC", "Charge Rate"},
            {"Untergrenze", "Obergrenze", "Im Bereich", "Normal", "Warnung", "Verstoß", "Außerhalb des Bereichs", "Temperatur", "Ladezustand", "Laderate"}
    };
    private static final HashMap<String, HashMap<Languages, String>> mLogMap = new HashMap<String, HashMap<Languages, String>>() {{
        put("key_lower_limit", new HashMap<Languages, String>() {{
            put(Languages.ENGLISH, "Lower Limit");
            put(Languages.GERMAIN, "Untergrenze");
        }});
        put("key_upper_limit", new HashMap<Languages, String>() {{
            put(Languages.ENGLISH, "Upper Limit");
            put(Languages.GERMAIN, "Obergrenze");
        }});
        put("key_in_range", new HashMap<Languages, String>() {{
            put(Languages.ENGLISH, "In Range");
            put(Languages.GERMAIN, "Im Bereich");
        }});
        put("key_status_normal", new HashMap<Languages, String>() {{
            put(Languages.ENGLISH, "Normal");
            put(Languages.GERMAIN, "Normal");
        }});
        put("key_status_warning", new HashMap<Languages, String>() {{
            put(Languages.ENGLISH, "Warning");
            put(Languages.GERMAIN, "Warnung");
        }});
        put("key_status_breach", new HashMap<Languages, String>() {{
            put(Languages.ENGLISH, "Breach");
            put(Languages.GERMAIN, "Verstoß");
        }});
        put("key_status_out_of_range", new HashMap<Languages, String>() {{
            put(Languages.ENGLISH, "Out of Range");
            put(Languages.GERMAIN, "Außerhalb des Bereichs");
        }});
        put("key_vital_temperature", new HashMap<Languages, String>() {{
            put(Languages.ENGLISH, "Temperature");
            put(Languages.GERMAIN, "Temperatur");
        }});
        put("key_vital_soc", new HashMap<Languages, String>() {{
            put(Languages.ENGLISH, "SOC");
            put(Languages.GERMAIN, "Ladezustand");
        }});
        put("key_vital_charge_rate", new HashMap<Languages, String>() {{
            put(Languages.ENGLISH, "Charge Rate");
            put(Languages.GERMAIN, "Laderate");
        }});
    }};


    @Override
    public String getLog(Languages language, int logIndex) {
        String log = "";
        if (mLocalizedLogs.length > language.getIndex() && mLocalizedLogs[language.getIndex()].length > logIndex) {
            log = mLocalizedLogs[language.getIndex()][logIndex];
        }
        return log;
    }
}
