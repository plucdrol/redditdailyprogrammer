import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        FileReader reader = new FileReader();

        Floor floor = reader.readFloor();
        System.out.print(floor);

        List<Coordinates> coordinatesList = reader.readCoordinates();
        floor.letItBurn(coordinatesList);
        System.out.print(floor);
    }
}
