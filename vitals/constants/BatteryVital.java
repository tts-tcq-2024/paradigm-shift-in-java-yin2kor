package vitals.constants;

public enum BatteryVital {

    TEMPERATURE("key_metric_temperature"),
    SOC("key_metric_soc"),
    CHARGE_RATE("key_metric_charge_rate");

    private final String mKey;
    BatteryVital(String key) {
        mKey = key;
    }

    public String getKey() {
        return mKey;
    }
}
