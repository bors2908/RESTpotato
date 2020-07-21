package bors.restpotato.service;

import org.springframework.stereotype.Service;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 *  Simple class for service layer logic
 */
@Service
public class PotatoService {

    private static final String INCORRECT_DATA_ERROR = "INCORRECT INPUT DATA";

    /**
     * Method that sorts and processes input strings.
     *
     * @param strings List of input strings
     * @return List of output strings
     */
    public List<String> prepareStrings(List<String> strings) {
        sortStrings(strings);
        return strings.stream().map(s -> s = "(" + s.length() + "): " + s).collect(Collectors.toList());
    }

    /**
     * Method to get and parse russian month names by integer number
     *
     * @param num integer value of the month(1<=num<=12)
     * @return parsed name of the month
     */
    public String getMonthName(Integer num) {
        if ((num<1)||(num>12))
        {return INCORRECT_DATA_ERROR;}
        String month = Month.of(num)
                .getDisplayName(TextStyle.FULL_STANDALONE, Locale.forLanguageTag("ru"))
                .toUpperCase();
        return parseMonth(month);
    }

    private void sortStrings(List<String> strings) {
        strings.sort((s1, s2) -> {
            int res = Integer.compare(s1.length(), s2.length());
            if (res != 0) return res;
            else return s1.compareTo(s2);
        });
    }

    private String parseMonth(String month) {
        char[] symbols = month.toCharArray();
        StringBuilder builder = new StringBuilder(symbols.length * 2);
        for (int i = 0; i < symbols.length - 1; i++) {
            builder.append(symbols[i]).append("-");
        }
        builder.append(symbols[symbols.length - 1]);
        return builder.toString();
    }
}


