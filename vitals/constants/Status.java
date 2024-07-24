package vitals.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Status {
    DANGER("key_status_out_of_range"),
    BREACH("key_status_breach"),
    WARNING("key_status_warning"),
    NORMAL("key_status_normal");

    private static final List<Status> sOrderedStatusList = Arrays.asList(
            DANGER,
            BREACH,
            WARNING,
            NORMAL
    );
    private final String mKey;
    Status(String key) {
        mKey = key;
    }

    public String getKey() {
        return mKey;
    }

    public static List<Status> getOrderedStatus() {
        return sOrderedStatusList;
    }
}
