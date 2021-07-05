package com.gridnine.testing.filters;

import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;

import java.time.LocalDateTime;
import java.util.List;

public class FilterDepartureBeforeTheCurrentTime implements Filters {

    @Override
    public boolean setFilter(Flight flight) {
        List<Segment> segments = flight.getSegments();
        if (segments.get(0).getDepartureDate().isBefore(LocalDateTime.now())) {
            System.out.println("Отправление раньше текущего времени. Удален перелет " +flight);
            return false;
        }
        return true;
    }
}
