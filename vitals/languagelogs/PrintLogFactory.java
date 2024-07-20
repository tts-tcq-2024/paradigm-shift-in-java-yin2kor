package vitals.languagelogs;

import vitals.constants.Languages;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class PrintLogFactory {

    public static final HashMap<Languages, PrintLog> sLanguageLogMaps = new LinkedHashMap<Languages, PrintLog>() {{
       put(Languages.ENGLISH, new EnglishPrintLog());
       put(Languages.GERMAIN, new GermainPrintLog());
    }};

    public static PrintLog getLanguageSpecificLogger(Languages language) {
        return sLanguageLogMaps.get(language);
    }
}

