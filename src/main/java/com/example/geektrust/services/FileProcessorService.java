package com.example.geektrust.services;

import com.example.geektrust.exceptions.InvalidInputException;
import com.example.geektrust.model.Command;
import com.sun.tools.javac.util.StringUtils;

import java.io.*;

public class FileProcessorService {
    private final File file;
    private final BufferedReader reader;


    public FileProcessorService(String filePath) throws FileNotFoundException {
        this.file = new File(filePath);
        this.reader = new BufferedReader(new FileReader(file));
    }

    public Command processLine() throws IOException {
        String inputString = this.reader.readLine();
        if (inputString == null || inputString.length() == 0 || inputString.trim().isEmpty()) {
            return null;
        }
        try {
            return CommandService.getInstance().getCommandFromString(inputString);
        } catch (InvalidInputException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
