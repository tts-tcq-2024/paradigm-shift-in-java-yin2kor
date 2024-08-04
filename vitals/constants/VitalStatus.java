package vitals.constants;

import java.util.Arrays;
import java.util.List;

public enum VitalStatus {
    OUT_OF_RANGE(6),
    BREACH(5),
    WARNING(4),
    NORMAL(3);

    private static final List<VitalStatus> S_ORDERED_VITAL_STATUS_LIST = Arrays.asList(
            OUT_OF_RANGE,
            BREACH,
            WARNING,
            NORMAL
    );
    private final int mIndex;
    VitalStatus(int index) {
        mIndex = index;
    }

    public int getIndex() {
        return mIndex;
    }

    public static List<VitalStatus> getOrderedStatus() {
        return S_ORDERED_VITAL_STATUS_LIST;
    }
}
