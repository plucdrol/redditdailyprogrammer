import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    private final String INPUT_PATH = "inputs/smallhouse";
    private final String FILE_FLOOR = "floor";
    private final String FILE_COORDINATES = "coordinates";

    public Floor readFloor() {

        List<String> rawFloor = readFile(FILE_FLOOR);

        List<Tile> tiles = new ArrayList<>();

        for (int y = 0; y < rawFloor.size(); y++)
        {
            tiles.addAll(createTileRow(rawFloor.get(y), y));
        }

        return new Floor(tiles);
    }

    public List<Coordinates> readCoordinates() {
        List<String> rawCoordinates = readFile(FILE_COORDINATES);

        List<Coordinates> coordinates = new ArrayList<>();

        for (String rawCoords: rawCoordinates) {
            String[] split = rawCoords.split(" ");
            Coordinates coords = new Coordinates(Integer.parseInt(split[0]), Integer.parseInt(split[1]));

            coordinates.add(coords);
        }

        return coordinates;
    }

    private List<String> readFile(String fileName)
    {
        Path file = Paths.get(INPUT_PATH, fileName);

        List<String> lines;

        try
        {
            lines = Files.readAllLines(file);
        }
        catch (IOException ex)
        {
            throw new RuntimeException(ex.getMessage());
        }

        return lines;
    }

    private List<Tile> createTileRow(String rawLine, int y)
    {
        char[] rawTiles = rawLine.toCharArray();
        List<Tile> tiles = new ArrayList<>();

        for (int x = 0; x < rawTiles.length; x++)
        {
            tiles.add(new Tile(rawTiles[x], x, y));
        }

        return tiles;
    }

}
