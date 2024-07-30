package vitals.constants;

import java.util.Arrays;
import java.util.List;

public enum VitalStatus {
    OUT_OF_RANGE("key_status_out_of_range"),
    BREACH("key_status_breach"),
    WARNING("key_status_warning"),
    NORMAL("key_status_normal");

    private static final List<VitalStatus> S_ORDERED_VITAL_STATUS_LIST = Arrays.asList(
            OUT_OF_RANGE,
            BREACH,
            WARNING,
            NORMAL
    );
    private final String mKey;
    VitalStatus(String key) {
        mKey = key;
    }

    public String getKey() {
        return mKey;
    }

    public static List<VitalStatus> getOrderedStatus() {
        return S_ORDERED_VITAL_STATUS_LIST;
    }

    public static boolean isGreater(VitalStatus current, VitalStatus base) {
        return S_ORDERED_VITAL_STATUS_LIST.indexOf(current) > S_ORDERED_VITAL_STATUS_LIST.indexOf(base);
    }
}
