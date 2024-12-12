package de.tum.cit.ase;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.*;

public final class DataScience {

    private DataScience() {
    }

    // Task 1 - Implement the outputFlightInformation method
    public static String outputFlightInformation(Stream<Flight> flightStream, String flightNumber) {
        return flightStream
                .filter(flight -> flight.getFlightNumber().equals(flightNumber))
                .findFirst()
                .map(Flight::toString)
                .orElse("The flight with FlightNumber " + flightNumber + " does not exist");
    }

    // Task 2 - Implement the getFuelDemandOfFaction method
    public static int getFuelDemandOfFaction(Stream<Flight> flightStream, Faction faction) {
        return flightStream
                .filter(flight -> flight.getSpaceshipData().getFaction() == faction)
                .mapToInt(flight -> flight.getSpaceshipData().getFuel())
                .sum();
    }

    // Task 3 - Implement the getAverageDurationOfAllFlights method
    public static double getAverageDurationOfAllFlights(Stream<Flight> flightStream) {
        return flightStream
                .mapToInt(Flight::getDuration)
                .average()
                .orElse(0.0);
    }

    // Task 4 - Implement the getFlightCountPerFaction method
    public static Map<Faction, Long> getFlightCountPerFaction(List<Flight> flightList) {
        return Arrays.stream(Faction.values())
                .collect(Collectors.toMap(
                        faction -> faction,
                        faction -> flightList.stream()
                                .filter(flight -> flight.getSpaceshipData().getFaction() == faction)
                                .count()
                ));
    }

    // Task 5 - Implement the getFlightCountPerDestination method
    public static long getCountOfCoreWorldFlights(Stream<Flight> flightStream) {
        return flightStream
                .filter(Flight::isCoreWorld)
                .count();
    }

    // Task 6 - Implement the getAverageNumberOfPassengersPerNonCoreWorldFlight method
    public static double getAverageNumberOfPassengersPerNonCoreWorldFlight(Stream<Flight> flightStream) {
        return flightStream
                .filter(flight -> !flight.isCoreWorld())
                .mapToInt(flight -> flight.getSpaceshipData().getNumberOfPassenger())
                .average()
                .orElse(0.0);
    }

    // Task 7 - Implement the getAllDestinationsNotInCoreWorldAreaAsList method
    public static List<String> getAllDestinationsNotInCoreWorldAreaAsList(Stream<Flight> flightStream) {
        return flightStream
                .filter(flight -> !flight.isCoreWorld())
                .map(Flight::getDestination)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    // Task 8 - Implement the getCalculatedArrivalTime method
    public static Map<String, LocalDateTime> getCalculatedArrivalTime(Stream<Flight> flightStream) {
        return flightStream
                .collect(Collectors.toMap(
                        Flight::getFlightNumber,
                        flight -> flight.getDate().plusMinutes(flight.getDuration())
                ));
    }

    // Task 9 - Implement the getFlightCountPerSpaceshipType method
    public static Map<SpaceshipType, Long> getFlightCountPerSpaceshipType(List<Flight> flightList) {
        return Arrays.stream(SpaceshipType.values())
                .collect(Collectors.toMap(
                        spaceshipType -> spaceshipType,
                        spaceshipType -> flightList.stream()
                                .filter(flight -> flight.getSpaceshipData().getSpaceship() == spaceshipType)
                                .count()
                ));
    }

    // Task 10 - Implement the getDestinationsWithinBayRange method
    public static List<String> getDestinationsWithinBayRange(Stream<Flight> flightStream, String bayFrom,
            String bayTo) {
        char bayLetter = bayFrom.charAt(0);
        int bayStart = Integer.parseInt(bayFrom.substring(1));
        int bayEnd = Integer.parseInt(bayTo.substring(1));

        return flightStream
                .filter(flight -> flight.getHangarBay().charAt(0) == bayLetter)
                .filter(flight -> {
                    int bayNumber = Integer.parseInt(flight.getHangarBay().substring(1));
                    return bayNumber >= bayStart && bayNumber <= bayEnd;
                })
                .map(Flight::getDestination)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    // Task 11 - Implement the getAvgNumberOfPassengersPerDestination method
    public static Map<String, Integer> getAvgNumberOfPassengersPerDestination(List<Flight> flightList) {
        return flightList.stream()
                .collect(Collectors.groupingBy(
                        Flight::getDestination,
                        Collectors.collectingAndThen(
                                Collectors.averagingInt(flight -> flight.getSpaceshipData().getNumberOfPassenger()),
                                avg -> (int) Math.floor(avg)
                        )
                ));
    }

    // Task 12 - Implement the getAllFlightsFromBay method
    public static Map<String, Set<Flight>> getAllFlightsFromBay(List<Flight> flightList) {
        return flightList.stream()
                .collect(Collectors.groupingBy(
                        Flight::getHangarBay,
                        Collectors.toSet()
                ));
    }
}
