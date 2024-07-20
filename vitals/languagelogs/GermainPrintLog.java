package vitals.languagelogs;

import java.util.HashMap;

public class GermainPrintLog extends PrintLog {

    private static final HashMap<String,String> sLogs = new HashMap<String, String>() {{
        put("key_low", "Untergrenze");
        put("key_high", "Obergrenze");
        put("key_normal", "Im Bereich");
        put("key_warning", "Warnung");
        put("key_breach", "Verstoß");
        put("key_out_of_range", "Außerhalb des Bereichs");
        put("key_temperature", "Temperatur");
        put("key_soc", "Ladezustand");
        put("key_charge_rate", "Laderate");
    }};
    @Override
    protected HashMap<String, String> getLogMap() {
        return sLogs;
    }
}
