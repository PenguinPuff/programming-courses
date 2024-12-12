package de.tum.cit.ase;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class CSVReading {

	private static volatile List<Flight> instance = null;

    private static final int FACTION = 0;
    private static final int SPACESHIP_TYPE = 2;
    private static final int PASSENGER = 5;
    private static final int FUEL = 8;
    private static final int YEAR = 9;
    private static final int MONTH = 10;
    private static final int DAY = 11;
    private static final int HOUR = 12;
    private static final int MINUTE = 13;
    private static final int FLIGHT_NUMBER = 1;
    private static final int DESTINATION = 3;
    private static final int HANGAR_BAY = 4;
    private static final int IS_COREWORLD = 6;
    private static final int DURATION = 7;

    private static final Function<String, Flight> MAP_TO_FLIGHT = (line) -> {
        String[] columns = line.split(";"); // this CSV uses semicolon as line separator

        SpaceshipData tempSpaceshipData = new SpaceshipData(columns[FACTION], columns[SPACESHIP_TYPE], Integer.parseInt(columns[PASSENGER]),
                Integer.parseInt(columns[FUEL]));

        LocalDateTime dateTime = LocalDateTime.of(Integer.parseInt(columns[YEAR]), Integer.parseInt(columns[MONTH]),
                Integer.parseInt(columns[DAY]), Integer.parseInt(columns[HOUR]), Integer.parseInt(columns[MINUTE]));

        return new Flight(tempSpaceshipData, columns[FLIGHT_NUMBER], columns[DESTINATION], columns[HANGAR_BAY],
                columns[IS_COREWORLD].equals("TRUE"), Integer.parseInt(columns[DURATION]), dateTime);
    };

    private CSVReading() {
    }

    //files.lines
    public static Stream<Flight> processInputFile(String filename) {
        if (instance == null) {

			instance = new ArrayList<>();
			try {
				Stream<String> lines = Files.lines(Paths.get("data", filename), StandardCharsets.UTF_8);
				instance = lines.skip(1).map(MAP_TO_FLIGHT).collect(Collectors.toList());
			} catch (IOException e) {
				System.out.println("File not found!");
				e.printStackTrace();
			}
		}
        return instance.stream();
    }
}
