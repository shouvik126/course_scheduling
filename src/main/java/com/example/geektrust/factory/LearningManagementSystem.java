package com.example.geektrust.factory;

import com.example.geektrust.exceptions.CourseFullException;
import com.example.geektrust.exceptions.InvalidInputException;
import com.example.geektrust.model.Command;
import com.example.geektrust.model.Course;
import com.example.geektrust.services.CommandExecutor;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LearningManagementSystem {
    private final String orgName;
    private final TreeMap<String, Course> courses;
    private final Map<String, Course> registrationIdCourseMap;


    public LearningManagementSystem(String orgName) {
        this.orgName = orgName;
        courses = new TreeMap<>();
        registrationIdCourseMap = new HashMap<>();
    }

    public void fulfillCommand(Command inputCommand) throws InvalidInputException {
        CommandExecutor commandExecutor = CommandExecutionFactory.getExecutor(inputCommand);
        try {
            commandExecutor.executeCommand(courses, registrationIdCourseMap, inputCommand);
        } catch (CourseFullException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
