package com.plucdrol.dailyprogrammer.letitburn.input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class FileReader
{
    private final String INPUT_PATH = "./letItBurn308/src/main/resources";

    protected List<String> readFile(String fileName)
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
}
