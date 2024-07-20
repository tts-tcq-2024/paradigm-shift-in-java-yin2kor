package vitals.languagelogs;

import java.util.*;
import java.util.stream.Collectors;

public abstract class PrintLog {

    protected PrintLog() {
    }

    protected abstract HashMap<String, String> getLogMap();

    public void Print(String delimiter, String... keys) {
        // to convert all the keys into the language specific logs,
        // filter() used to remove non existing keys
        // map to transform
        List<String> logs = Arrays.stream(keys).
                filter(key -> getLogMap().containsKey(key)).
                map(key -> { return getLogMap().get(key);}).toList();
        System.out.println(String.join(delimiter, logs));
    }


}
