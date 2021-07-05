package com.gridnine.testing.filters;

import com.gridnine.testing.Flight;

import java.time.temporal.ChronoUnit;

public class FilterTheArrivalDateBeforeTheDepartureDate implements Filters {

    @Override
    public boolean setFilter(Flight flight) {
        boolean status =true;
                for (int i = 0; i < flight.getSegments().size(); i++) {
                    long hours = ChronoUnit.HOURS.between(flight.getSegments().get(i).getArrivalDate(), flight.getSegments().get(i).getDepartureDate());
                    if (hours > 0) {
                        System.out.println("Время прибытия раньше времени отправления. Удален перелет "+ flight);
                        status = false;
                        break;
                    }
                }
        return status;
    }
}
