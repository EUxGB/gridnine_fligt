package com.gridnine.testing;

import com.gridnine.testing.filters.FiltersCreator;
import java.util.ArrayList;
import java.util.List;

import static com.gridnine.testing.FlightBuilder.createFlights;

public class Main {

    public static void main(String[] args) {

        List<Flight> flightsOut = new ArrayList<>();
        List<Flight> flights = createFlights();

        if (flights == null) {
            throw new NullPointerException(
                    "Входной лист перелетов пустой");
        }
        System.out.println("Входной лиcт перелотов:\n" + flights+"\n******************************\n");

        try {
            flights.stream().filter(FiltersCreator::setFilter)
                    .forEach(flightsOut::add);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n******************************\nОтфильтрованный лист перелетов:\n"+flightsOut);
    }



}
