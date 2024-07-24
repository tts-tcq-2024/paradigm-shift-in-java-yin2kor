package vitals;

import vitals.components.BatteryComponent;
import vitals.components.StatusLimit;
import vitals.constants.Languages;
import vitals.constants.Limit;
import vitals.constants.Metrics;
import vitals.constants.Status;
import vitals.languagelogs.PrintLog;
import vitals.languagelogs.PrintLogFactory;

import java.util.Arrays;

public class BatteryStatusVerifier {

    private static final PrintLog Logger = PrintLogFactory.getLanguageSpecificLogger(Languages.ENGLISH);
    private static final BatteryComponent sTemperatureComponent = new BatteryComponent(Metrics.TEMPERATURE, Arrays.asList(
            new StatusLimit(Status.WARNING, 10f, 35f),
            new StatusLimit(Status.BREACH, 5f, 40f),
            new StatusLimit(Status.DANGER, 0f, 45f)
    ));
    private static final BatteryComponent sSocComponent = new BatteryComponent(Metrics.SOC, Arrays.asList(
            new StatusLimit(Status.WARNING, 30f, 70f),
            new StatusLimit(Status.BREACH, 25f, 75f),
            new StatusLimit(Status.DANGER, 20f, 80f)
    ));
    private static final BatteryComponent sChargeRateComponent = new BatteryComponent(Metrics.CHARGE_RATE, Arrays.asList(
            new StatusLimit(Status.WARNING, 1f, 0.6f),
            new StatusLimit(Status.BREACH, 0f, 0.7f),
            new StatusLimit(Status.DANGER, -0.1f, 0.8f)
    ));

    private static boolean IsOk(BatteryComponent batteryComponent , float value) {
        final Status status = batteryComponent.checkStatus(value);
        final Limit limit = batteryComponent.checkLimit(value);
        if (status != Status.NORMAL || limit != Limit.IN_RANGE) {
            Logger.Print(":", status.getKey(), batteryComponent.getMetrics().getKey(), limit.getKey(), Float.toString(value));
        }
        return !(status == Status.DANGER);
    }


    public static boolean batteryIsOk(float temperature, float soc, float chargeRate) {
        return IsOk(sTemperatureComponent, temperature) && IsOk(sSocComponent, soc) && IsOk(sChargeRateComponent, chargeRate);
    }
}
