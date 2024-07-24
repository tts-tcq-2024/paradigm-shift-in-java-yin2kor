package vitals.components;

import vitals.constants.Limit;
import vitals.constants.Metrics;
import vitals.constants.Status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BatteryComponent {

    private final Metrics mMetrics;
    private final Map<Status, StatusLimit> mStatusLimitsMap;

    public BatteryComponent(Metrics metrics, List<StatusLimit> statusLimits) {
        checkIfListValid(statusLimits);
        mMetrics = metrics;
        mStatusLimitsMap = statusLimits.stream().collect(Collectors.toMap(StatusLimit::getStatus, statusLimit -> statusLimit));
        checkIfDangerPresent();
    }

    private void checkIfListValid(List<StatusLimit> statusLimits) {
        if (null == statusLimits || statusLimits.isEmpty()) {
            throw new IllegalArgumentException("Status limits must contain at least one entry");
        }
    }

    private void checkIfDangerPresent() {
        if (!mStatusLimitsMap.containsKey(Status.DANGER)) {
            throw new IllegalArgumentException("Status limits must contain at DANGER entry");
        }
    }

    public Metrics getMetrics() {
        return mMetrics;
    }

    public Limit checkLimit(final float value) {
        Limit currentLimit = Limit.IN_RANGE;
        for (Status status : Status.getOrderedStatus()) {
            Limit currentStatusLimit = checkStatusLimitRange(status, value);
            if (Limit.IN_RANGE != currentStatusLimit) {
                currentLimit = currentStatusLimit;
                break;
            }
        }
        return currentLimit;
    }

    private Limit checkStatusLimitRange(final Status status, final float value) {
        Limit currentLimit = Limit.IN_RANGE;
        if (mStatusLimitsMap.containsKey(status)) {
            currentLimit = checkLimits(mStatusLimitsMap.get(status), value);
        }
        return currentLimit;
    }

    private Limit checkLimits(final StatusLimit statusLimit, final float value) {
        Limit currentLimit = Limit.IN_RANGE;
        if (value > statusLimit.getUpperLimit()) {
            currentLimit = Limit.UPPER_LIMIT;
        } else if (value < statusLimit.getLowerLimit()) {
            currentLimit = Limit.LOWER_LIMIT;
        }
        return currentLimit;
    }

    public Status checkStatus(final float value) {
        Status currentStatus = Status.NORMAL;
        for (Status status : Status.getOrderedStatus()) {
            Limit currentStatusLimit = checkStatusLimitRange(status, value);
            if (Limit.IN_RANGE != currentStatusLimit) {
                currentStatus = status;
                break;
            }
        }
        return currentStatus;
    }
}
