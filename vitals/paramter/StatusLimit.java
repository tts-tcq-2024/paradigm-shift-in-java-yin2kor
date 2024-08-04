package vitals.paramter;

public class StatusLimit {
    private final float mUpperLimit;
    private final float mLowerLimit;


    public float getUpperLimit() {
        return mUpperLimit;
    }

    public float getLowerLimit() {
        return mLowerLimit;
    }

    public StatusLimit(float mLowerLimit, float mUpperLimit) {
        this.mLowerLimit = mLowerLimit;
        this.mUpperLimit = mUpperLimit;
    }
}
