package vitals.constants;

public enum Limit {
    LOWER_LIMIT(0),
    UPPER_LIMIT(1),
    IN_RANGE(2);
    private final int mIndex;

    Limit(int index) {
        mIndex = index;
    }

    public int getIndex() {
        return mIndex;
    }
}
