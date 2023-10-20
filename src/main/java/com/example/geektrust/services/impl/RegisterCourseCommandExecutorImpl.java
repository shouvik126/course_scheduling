package com.example.geektrust.services.impl;

import com.example.geektrust.constants.ExceptionConstant;
import com.example.geektrust.constants.StatusConstant;
import com.example.geektrust.exceptions.CourseFullException;
import com.example.geektrust.exceptions.InvalidInputException;
import com.example.geektrust.model.Command;
import com.example.geektrust.model.Course;
import com.example.geektrust.model.Employee;
import com.example.geektrust.services.CommandExecutor;

import java.util.Map;
import java.util.TreeMap;

public class RegisterCourseCommandExecutorImpl implements CommandExecutor {
    @Override
    public void executeCommand(TreeMap<String, Course> courses, Map<String, Course> registrationIdCourseMap, Command command) throws InvalidInputException, CourseFullException {
        String courseId = command.getCommandParam().get(1);
        Employee employee = constructEmployeeObject(command);
        if (courses.containsKey(courseId)) {
            Course course = courses.get(courseId);
            if (!course.isCourseIsAlloted() ||  course.isCourseIsCancelled()) {
                if (course.getRegisteredEmployeeCourseMap().size() == course.getCourseMaxCapacity()) {
                    throw new CourseFullException(ExceptionConstant.COURSE_FULL_ERROR);
                } else {
                    registerEmployeeToCourse(employee, course, registrationIdCourseMap);
                }
            } else {
                System.out.println("REG-COURSE"+employee.getName()+"-"+courses.get(courseId).getCourseName()+" "+ StatusConstant.REJECTED);
            }
        } else {
            System.out.println(ExceptionConstant.INPUT_DATA_ERROR);
        }
    }

    private void registerEmployeeToCourse(Employee employee, Course course, Map<String, Course> registrationIdCourseMap) {
        String regId = course.addEmployeeToCourse(employee);
        registrationIdCourseMap.put(regId, course);
        System.out.println(regId+" "+StatusConstant.ACCEPTED);
    }

    private Employee constructEmployeeObject(Command command) throws InvalidInputException {
        return new Employee(command.getCommandParam().get(0));
    }
}
