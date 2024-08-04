package vitals.paramter;

import vitals.constants.BatteryVital;
import vitals.constants.Limit;
import vitals.constants.VitalStatus;

import java.util.Map;

public class BatteryParameter {

    private final BatteryVital mBatteryVital;
    private final Map<VitalStatus, StatusLimit> mStatusLimitsMap;

    public BatteryParameter(BatteryVital batteryVital, Map<VitalStatus, StatusLimit> statusLimitMap) {
        checkIfListValid(statusLimitMap);
        mBatteryVital = batteryVital;
        mStatusLimitsMap = statusLimitMap;
        checkIfDangerPresent();
    }

    private void checkIfListValid(Map<VitalStatus, StatusLimit> statusLimits) {
        if (null == statusLimits || statusLimits.isEmpty()) {
            throw new IllegalArgumentException("VitalStatus limits must contain at least one entry");
        }
    }

    private void checkIfDangerPresent() {
        if (!mStatusLimitsMap.containsKey(VitalStatus.OUT_OF_RANGE)) {
            throw new IllegalArgumentException("VitalStatus limits must contain at DANGER entry");
        }
    }

    public BatteryVital getVital() {
        return mBatteryVital;
    }

    public Limit getCurrentLimit(final float value) {
        Limit currentLimit = Limit.IN_RANGE;
        for (VitalStatus vitalStatus : VitalStatus.getOrderedStatus()) {
            Limit currentStatusLimit = checkStatusLimitRange(vitalStatus, value);
            if (Limit.IN_RANGE != currentStatusLimit) {
                currentLimit = currentStatusLimit;
                break;
            }
        }
        return currentLimit;
    }

    private Limit checkStatusLimitRange(final VitalStatus vitalStatus, final float value) {
        Limit currentLimit = Limit.IN_RANGE;
        if (mStatusLimitsMap.containsKey(vitalStatus)) {
            currentLimit = getValueLimitForStatus(mStatusLimitsMap.get(vitalStatus), value);
        }
        return currentLimit;
    }

    private Limit getValueLimitForStatus(final StatusLimit statusLimit, final float value) {
        Limit currentLimit = Limit.IN_RANGE;
        if (value > statusLimit.getUpperLimit()) {
            currentLimit = Limit.UPPER_LIMIT;
        } else if (value < statusLimit.getLowerLimit()) {
            currentLimit = Limit.LOWER_LIMIT;
        }
        return currentLimit;
    }

    public VitalStatus getCurrentStatus(final float value) {
        VitalStatus currentVitalStatus = VitalStatus.NORMAL;
        for (VitalStatus vitalStatus : VitalStatus.getOrderedStatus()) {
            Limit currentStatusLimit = checkStatusLimitRange(vitalStatus, value);
            if (Limit.IN_RANGE != currentStatusLimit) {
                currentVitalStatus = vitalStatus;
                break;
            }
        }
        return currentVitalStatus;
    }
}
