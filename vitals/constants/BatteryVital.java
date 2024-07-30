package vitals.constants;

public enum BatteryVital {

    TEMPERATURE("key_vital_temperature"),
    SOC("key_vital_soc"),
    CHARGE_RATE("key_vital_charge_rate");

    private final String mKey;
    BatteryVital(String key) {
        mKey = key;
    }

    public String getKey() {
        return mKey;
    }
}
