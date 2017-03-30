import java.util.ArrayList;
import java.util.List;

public class Floor {

    private final List<Tile> tiles;

    public Floor(List<Tile> tiles)
    {
        this.tiles = tiles;
    }

    public void letItBurn(List<Coordinates> coordinatesList) {

        for (Coordinates coordinates: coordinatesList) {
            letItBurn(coordinates);
        }
    }

    private void letItBurn(Coordinates coordinates) {
        Tile tile = getTile(coordinates);

        if (tile != null) {
            switch (tile.status) {
                case 'S':
                    spreadFire(tile);
                    break;
                case ' ':
                    smokeAndSpreadFire(tile);
                    break;
                default:
                    break;
            }
        }
    }

    private void spreadFire(Tile tile) {
        tile.status = 'F';
        spreadFire(getAdjacentTiles(tile, 'S'));

    }

    private void spreadFire(List<Tile> tileQueue) {
        for (Tile tile: tileQueue) {
            tile.status = 'F';
            spreadFire(getAdjacentTiles(tile, 'S'));
        }
    }

    private void smokeAndSpreadFire(Tile tile) {
        tile.status = 'S';
        List<Tile> adjacentTiles = getAdjacentTiles(tile, 'F');

        if (!adjacentTiles.isEmpty())
        {
            tile.status = 'F';
            spreadFire(tile);
        }
    }

    public String toString() {
        int xMax = 0;
        int yMax = 0;

        for (Tile t : tiles) {
            if (t.x() > xMax) xMax = t.x();
            if (t.y() > yMax) yMax = t.y();
        }

        String value = "";
        for (int y = 0; y <= yMax; y++) {

            for (int x = 0; x <= xMax; x++) {
                Tile tile = getTile(x, y);
                value += tile.status;
            }

            value += "\n";
        }

        return value;
    }

    private Tile getTile(int x, int y) {
        Tile tile = null;

        for (Tile t: tiles) {
            if (t.x() == x && t.y() == y)
                tile = t;
        }

        return tile;
    }

    private Tile getTile(Coordinates coordinates) {
        return getTile(coordinates.x, coordinates.y);
    }

    private List<Tile> getAdjacentTiles(Tile tile, char status) {
        List<Tile> adjacentTiles = new ArrayList<>();

        Tile leftTile = getTile(tile.x() - 1, tile.y());
        if (isFileWithStatus(leftTile, status)) adjacentTiles.add(leftTile);

        Tile rightTile = getTile(tile.x() + 1, tile.y());
        if (isFileWithStatus(rightTile, status)) adjacentTiles.add(rightTile);

        Tile upTile = getTile(tile.x(), tile.y() + 1);
        if (isFileWithStatus(upTile, status)) adjacentTiles.add(upTile);

        Tile downTile = getTile(tile.x(), tile.y() - 1);
        if (isFileWithStatus(downTile, status)) adjacentTiles.add(downTile);

        return adjacentTiles;
    }

    private Boolean isFileWithStatus(Tile tile, char status) {
        return tile != null && tile.status == status;
    }
}
