package com.plucdrol.dailyprogrammer.letitburn.input;

import com.plucdrol.dailyprogrammer.letitburn.entity.Floor;
import com.plucdrol.dailyprogrammer.letitburn.entity.Tile;

import java.util.ArrayList;
import java.util.List;

public class FloorTextInputReader extends FileReader
{
    private final String FILE_FLOOR = "floor";

    public Floor read()
    {
        List<String> rawFloor = readFile(FILE_FLOOR);

        List<Tile> tiles = new ArrayList<>();

        for (int y = 0; y < rawFloor.size(); y++)
        {
            tiles.addAll(createTileRow(rawFloor.get(y), y));
        }

        return new Floor(tiles);
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
