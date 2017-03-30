package com.plucdrol.dailyprogrammer;

import com.plucdrol.dailyprogrammer.letitburn.entity.Coordinates;
import com.plucdrol.dailyprogrammer.letitburn.entity.Floor;
import com.plucdrol.dailyprogrammer.letitburn.input.CoordinatesTextInputReader;
import com.plucdrol.dailyprogrammer.letitburn.input.FloorTextInputReader;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        CoordinatesTextInputReader coordinatesReader = new CoordinatesTextInputReader();
        List<Coordinates> coordinates = coordinatesReader.read();

        FloorTextInputReader floorReader = new FloorTextInputReader();
        Floor floor = floorReader.read();
    }
}
