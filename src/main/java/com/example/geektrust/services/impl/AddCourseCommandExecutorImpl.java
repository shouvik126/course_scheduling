package com.example.geektrust.services.impl;

import com.example.geektrust.constants.ExceptionConstant;
import com.example.geektrust.exceptions.InvalidInputException;
import com.example.geektrust.model.Command;
import com.example.geektrust.model.Course;
import com.example.geektrust.services.CommandExecutor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AddCourseCommandExecutorImpl implements CommandExecutor {
    @Override
    public void executeCommand(TreeMap<String, Course> courses, Map<String, Course> registrationIdCourseMap, Command command) throws InvalidInputException {
        List<String> params = command.getCommandParam();
        Course course = constructCourseObject(params);
        offerCourse(courses, course);
    }

    private Course constructCourseObject(List<String> params) throws InvalidInputException {
        Course course = null;
        try {

            String courseName = params.get(0);
            String courseInstructor = params.get(1);
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
            Date date = dateFormat.parse(params.get(2));
            int minCount = Integer.parseInt(params.get(3));
            int maxCount = Integer.parseInt(params.get(4));
            course = new Course("OFFERING-" + courseName + "-" + courseInstructor, courseName, courseInstructor, date, minCount, maxCount, false, false);
        } catch (Exception e) {
            throw new InvalidInputException(ExceptionConstant.INPUT_ERROR);
        }
        return course;
    }

    private void offerCourse(TreeMap<String, Course> courses, Course course) {
        courses.put(course.getCourseId(), course);
        System.out.println(course.getCourseId());
    }
}
