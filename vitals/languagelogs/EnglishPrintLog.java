package vitals.languagelogs;

import java.util.HashMap;


public class EnglishPrintLog extends PrintLog {

    private static final HashMap<String,String> sLogs = new HashMap<String, String>() {{
        put("key_lower_limit", "Lower limit");
        put("key_upper_limit", "Upper limit");
        put("key_in_range", "In range");
        put("key_status_warning", "Warning");
        put("key_status_normal", "Normal");
        put("key_status_breach", "Breach");
        put("key_status_out_of_range", "Out of range");
        put("key_metric_temperature", "Temperature");
        put("key_metric_soc", "SOC");
        put("key_metric_charge_rate", "Charge Rate");
    }};
    @Override
    protected HashMap<String, String> getLogMap() {
        return sLogs;
    }

}
