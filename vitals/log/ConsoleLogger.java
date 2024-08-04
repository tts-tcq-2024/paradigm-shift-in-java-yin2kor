package vitals.log;

import vitals.constants.Languages;
import vitals.localization.ILocalization;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConsoleLogger implements ILogger {

    ILocalization mLocalization;

    Languages mLanguage = Languages.ENGLISH;

    public ConsoleLogger(ILocalization localization) {
        mLocalization = localization;
    }

    public void setLanguage(Languages language) {
        mLanguage = language;
    }

    @Override
    public void print(String delimiter, int... logIndexes) {
        // to convert all the keys into the language specific logs,
        // map to transform

        List<String> logs = Arrays.stream(logIndexes).
                filter(index -> !mLocalization.getLog(mLanguage, index).isEmpty()).
                mapToObj(index -> {
                    String log = mLocalization.getLog(mLanguage, index);
                    if (log.isEmpty()) {
                        log = "";
                    }
                    return log;
                }).collect(Collectors.toList());
        System.out.println(String.join(delimiter, logs));
    }
}
