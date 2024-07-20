package vitals.constants;

public enum Languages {
    ENGLISH("key_english"),
    GERMAIN("key_germain");

    String mKey;
    Languages(String key) {
        mKey = key;
    }

    public String getKey() {
        return mKey;
    }

}
