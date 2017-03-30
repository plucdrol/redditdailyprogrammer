package com.plucdrol.dailyprogrammer.letitburn.input;

import com.plucdrol.dailyprogrammer.letitburn.entity.Coordinates;

import java.util.ArrayList;
import java.util.List;

public class CoordinatesTextInputReader extends FileReader
{
    private final String FILE_COORDINATES = "coordinates";

    public List<Coordinates> read()
    {
        List<String> rawCoordinates = readFile(FILE_COORDINATES);

        List<Coordinates> coordinates = new ArrayList<>();

        for (String rawCoords: rawCoordinates) {
            String[] split = rawCoords.split(" ");
            Coordinates coords = new Coordinates(Integer.parseInt(split[0]), Integer.parseInt(split[1]));

            coordinates.add(coords);
        }

        return coordinates;
    }
}
