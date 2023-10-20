package com.example.geektrust;

import com.example.geektrust.exceptions.InvalidInputException;
import com.example.geektrust.factory.LearningManagementSystem;
import com.example.geektrust.model.Command;
import com.example.geektrust.services.FileProcessorService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            if (args.length != 1) {
                throw new FileNotFoundException("Input file is not provided");
            } else {
                LearningManagementSystem lms = new LearningManagementSystem("Skill Dives");
                FileProcessorService fileProcessorService = new FileProcessorService(args[0]);
                try {
                    Command command = fileProcessorService.processLine();

                    while (command != null) {
                        lms.fulfillCommand(command);
                        command = fileProcessorService.processLine();
                    }
                } catch (InvalidInputException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }  catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
