package vitals.languagelogs;

import java.util.HashMap;

public class GermainPrintLog extends PrintLog {

    private static final HashMap<String,String> sLogs = new HashMap<String, String>() {{
        put("key_lower_limit", "Untergrenze");
        put("key_upper_limit", "Obergrenze");
        put("key_in_range", "Im Bereich");
        put("key_status_normal", "normal");
        put("key_status_warning", "Warnung");
        put("key_status_breach", "Verstoß");
        put("key_status_out_of_range", "Außerhalb des Bereichs");
        put("key_metric_temperature", "Temperatur");
        put("key_metric_soc", "Ladezustand");
        put("key_metric_charge_rate", "Laderate");
    }};
    @Override
    protected HashMap<String, String> getLogMap() {
        return sLogs;
    }
}
