package com.gridnine.testing.filters;

import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;

import java.time.temporal.ChronoUnit;
import java.util.List;

public class FilterMoreThanTwoHoursOnTheGround implements Filters {

    @Override
    public boolean setFilter(Flight flight) {

        boolean status = true;
        List<Segment> segments = flight.getSegments();

        if (segments.size() > 1) {
            long minutes, sumMinutes = 0;
            for (int i = 0; i < segments.size() - 1; i++) {
                minutes = ChronoUnit.MINUTES.between(segments.get(i).getArrivalDate(), flight.getSegments().get(i + 1).getDepartureDate());
                sumMinutes += minutes;
                if (sumMinutes > 120) {
                    System.out.println("Перебывание на земле более 2 часов. Удален перелет " + flight);
                    status = false;
                    break;
                }
            }
        }
        return status;
    }
}
