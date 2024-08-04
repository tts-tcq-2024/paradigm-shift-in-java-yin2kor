package vitals.constants;

public enum BatteryVital {

    TEMPERATURE(7),
    SOC(8),
    CHARGE_RATE(9);

    private final int mIndex;
    BatteryVital(int index) {
        mIndex = index;
    }

    public int getIndex() {
        return mIndex;
    }
}
