package vitals.constants;

public enum Languages {
    ENGLISH("key_language_english"),
    GERMAIN("key_language_germain");

    private final String mKey;
    Languages(String key) {
        mKey = key;
    }

    public String getKey() {
        return mKey;
    }

}
