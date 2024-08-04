package vitals.constants;

public enum Languages {
    ENGLISH(0),
    GERMAIN(1);

    private final int mIndex;
    Languages(int index) {
        mIndex = index;
    }

    public int getIndex() {
        return mIndex;
    }

}
