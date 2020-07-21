package bors.restpotato.service;

import java.util.List;

public interface PotatoService {

    /**
     * Method that sorts and processes input strings.
     *
     * @param strings List of input strings
     * @return List of output strings
     */
    List<String> prepareStrings(List<String> strings);

    /**
     * Method to get and parse russian month names by integer number
     *
     * @param num integer value of the month(1<=num<=12)
     * @return parsed name of the month
     */
    String getMonthName(Integer num);
}
