package com.example.geektrust.services;

import com.example.geektrust.exceptions.CourseFullException;
import com.example.geektrust.exceptions.InvalidInputException;
import com.example.geektrust.model.Command;
import com.example.geektrust.model.Course;

import java.util.Map;
import java.util.TreeMap;

public interface CommandExecutor {
    void executeCommand(TreeMap<String, Course> courses, Map<String, Course> registrationIdCourseMap, Command command) throws InvalidInputException, CourseFullException;
}
