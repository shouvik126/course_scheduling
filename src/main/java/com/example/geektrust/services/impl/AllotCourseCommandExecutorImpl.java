package com.example.geektrust.services.impl;

import com.example.geektrust.constants.ExceptionConstant;
import com.example.geektrust.exceptions.InvalidInputException;
import com.example.geektrust.model.Command;
import com.example.geektrust.model.Course;
import com.example.geektrust.model.Employee;
import com.example.geektrust.services.CommandExecutor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.TreeMap;

public class AllotCourseCommandExecutorImpl implements CommandExecutor {
    @Override
    public void executeCommand(TreeMap<String, Course> courses, Map<String, Course> registrationIdCourseMap, Command command) throws InvalidInputException {
        String courseId = command.getCommandParam().get(0);
        Course course = courses.get(courseId);
        if (course != null) {
            if (course.getRegisteredEmployeeCourseMap().size() < course.getCourseMinCapacity()) {
                course.setCourseIsCancelled(true);
                printCourseData(course);
            } else {
                course.setCourseIsAlloted(true);
                printCourseData(course);
            }
        } else {
            throw new InvalidInputException(ExceptionConstant.INPUT_DATA_ERROR);
        }
    }

    private void printCourseData(Course course) {
        String status = course.isCourseIsCancelled() ? "COURSE_CANCELED" : "CONFIRMED";
        for(Map.Entry<String, Employee> e : course.getRegisteredEmployeeCourseMap().entrySet()) {
            String pattern = "ddMMyyyy";
            DateFormat dateFormat = new SimpleDateFormat(pattern);
            System.out.println(e.getKey()+" "+e.getValue().getEmailAddress()+" "+course.getCourseId()+" "+course.getCourseName()+" "+course.getCourseInstructor()+" "+dateFormat.format(course.getCourseDate())+" "+status);
        }
    }
}
