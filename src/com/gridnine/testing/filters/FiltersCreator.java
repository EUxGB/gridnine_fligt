package com.gridnine.testing.filters;

import com.gridnine.testing.Flight;

import java.util.ArrayList;
import java.util.List;

public class FiltersCreator {

    public static boolean setFilter(Flight flight) {

        // реализовать метод получения списка фильтров из источника
        List<Filters> filters = new ArrayList<Filters>();
        filters.add(new FilterMoreThanTwoHoursOnTheGround());
        filters.add(new FilterDepartureBeforeTheCurrentTime());
        filters.add(new FilterTheArrivalDateBeforeTheDepartureDate());

        try {
            for (Filters filter : filters) {
                if (!filter.setFilter(flight))
                    return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
