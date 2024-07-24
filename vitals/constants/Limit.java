package vitals.constants;

public enum Limit {
    LOWER_LIMIT("key_lower_limit"),
    UPPER_LIMIT("key_upper_limit"),
    IN_RANGE("key_in_range");
    private final String mKey;

    Limit(String key) {
        mKey = key;
    }

    public String getKey() {
        return mKey;
    }
}
