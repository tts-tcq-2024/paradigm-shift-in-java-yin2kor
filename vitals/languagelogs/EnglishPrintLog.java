package vitals.languagelogs;

import java.util.HashMap;


public class EnglishPrintLog extends PrintLog {

    private static final HashMap<String,String> sLogs = new HashMap<String, String>() {{
        put("key_low", "Lower limit");
        put("key_high", "Upper limit");
        put("key_normal", "In range");
        put("key_warning", "Warning");
        put("key_breach", "Breach");
        put("key_out_of_range", "Out of range");
        put("key_temperature", "Temperature");
        put("key_soc", "SOC");
        put("key_charge_rate", "Charge Rate");
    }};
    @Override
    protected HashMap<String, String> getLogMap() {
        return sLogs;
    }

}
