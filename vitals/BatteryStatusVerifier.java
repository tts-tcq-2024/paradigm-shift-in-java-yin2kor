package vitals;

import vitals.components.BatteryParameter;
import vitals.components.StatusLimit;
import vitals.constants.Limit;
import vitals.constants.BatteryVital;
import vitals.constants.VitalStatus;
import vitals.languagelogs.Logger;
import vitals.localization.LocalizationManager;

import java.util.HashMap;
import java.util.List;

public class BatteryStatusVerifier {

    private static final vitals.languagelogs.Logger Logger = new Logger(new LocalizationManager());
    private static final HashMap<BatteryVital, BatteryParameter> mBatteryParameterMaps = new HashMap<BatteryVital, BatteryParameter>() {{
        put(BatteryVital.TEMPERATURE, new BatteryParameter(BatteryVital.TEMPERATURE, new HashMap<VitalStatus, StatusLimit>() {{
            put(VitalStatus.WARNING, new StatusLimit(10f, 35f));
            put(VitalStatus.BREACH, new StatusLimit(5f, 40f));
            put(VitalStatus.OUT_OF_RANGE, new StatusLimit(0f, 45f));
        }}));
        put(BatteryVital.SOC, new BatteryParameter(BatteryVital.SOC, new HashMap<VitalStatus, StatusLimit>() {{
            put(VitalStatus.WARNING, new StatusLimit(30f, 70f));
            put(VitalStatus.BREACH, new StatusLimit(25f, 75f));
            put(VitalStatus.OUT_OF_RANGE, new StatusLimit(20f, 80f));
        }}));
        put(BatteryVital.CHARGE_RATE, new BatteryParameter(BatteryVital.CHARGE_RATE, new HashMap<VitalStatus, StatusLimit>() {{
            put(VitalStatus.WARNING, new StatusLimit(0.1f, 0.3f));
            put(VitalStatus.OUT_OF_RANGE, new StatusLimit(-0.1f, 0.8f));
        }}));

    }};

    private static boolean isOk(BatteryParameter batteryParameter, float value) {
        final VitalStatus vitalStatus = batteryParameter.getCurrentStatus(value);
        final Limit limit = batteryParameter.getCurrentLimit(value);
        if (vitalStatus != VitalStatus.NORMAL || limit != Limit.IN_RANGE) {
            printEarlyWarnings(vitalStatus, limit, batteryParameter);
        }
        return !(vitalStatus == VitalStatus.OUT_OF_RANGE);
    }

    private static void printEarlyWarnings(VitalStatus vitalStatus, Limit limit, BatteryParameter batteryParameter) {
        final List<VitalStatus> vitalStatusList = VitalStatus.getOrderedStatus();
        final int vitalStatusIndex = vitalStatusList.indexOf(vitalStatus);
        for (int vitalIndex = vitalStatusList.size() - 2; vitalIndex >= 0; vitalIndex--) {
            if (vitalStatusIndex <= vitalIndex) {
                Logger.Print(":", vitalStatusList.get(vitalIndex).getKey(), batteryParameter.getVital().getKey(), limit.getKey());
            }
        }
    }


    public static boolean batteryIsOk(float temperature, float soc, float chargeRate) {
        return isOk(mBatteryParameterMaps.get(BatteryVital.TEMPERATURE), temperature) &&
                isOk(mBatteryParameterMaps.get(BatteryVital.SOC), soc) &&
                isOk(mBatteryParameterMaps.get(BatteryVital.CHARGE_RATE), chargeRate);
    }
}
