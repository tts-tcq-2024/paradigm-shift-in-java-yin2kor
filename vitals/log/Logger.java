package vitals.log;

import vitals.constants.Languages;
import vitals.localization.ILocalization;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Logger {

    ILocalization mLocalization;

    Languages mLanguage = Languages.ENGLISH;

    public Logger(ILocalization localization) {
        mLocalization = localization;
    }

    public void setLanguage(Languages language) {
        mLanguage = language;
    }

    public void Print(String delimiter, String... keys) {
        // to convert all the keys into the language specific logs,
        // map to transform
        List<String> logs = Arrays.stream(keys).
                map(key -> {
                    String log = mLocalization.getLog(mLanguage, key);
                    if (log.isEmpty()) {
                        log = key;
                    }
                    return log;
                }).collect(Collectors.toList());
        System.out.println(String.join(delimiter, logs));
    }
}
