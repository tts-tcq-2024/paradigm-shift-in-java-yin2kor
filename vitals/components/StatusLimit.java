package vitals.components;

import vitals.constants.Status;

public class StatusLimit {
    private final Status mStatus;
    private final float mUpperLimit;
    private final float mLowerLimit;

    public Status getStatus() {
        return mStatus;
    }

    public float getUpperLimit() {
        return mUpperLimit;
    }

    public float getLowerLimit() {
        return mLowerLimit;
    }

    public StatusLimit(Status mStatus, float mLowerLimit, float mUpperLimit) {
        this.mStatus = mStatus;
        this.mLowerLimit = mLowerLimit;
        this.mUpperLimit = mUpperLimit;
    }
}
