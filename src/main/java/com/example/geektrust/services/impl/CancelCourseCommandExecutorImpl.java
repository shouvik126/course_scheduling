package com.example.geektrust.services.impl;

import com.example.geektrust.constants.StatusConstant;
import com.example.geektrust.model.Command;
import com.example.geektrust.model.Course;
import com.example.geektrust.services.CommandExecutor;

import java.util.Map;
import java.util.TreeMap;

public class CancelCourseCommandExecutorImpl implements CommandExecutor {
    @Override
    public void executeCommand(TreeMap<String, Course> courses, Map<String, Course> registrationIdCourseMap, Command command) {
        String regId = command.getCommandParam().get(0);
        if (isValidRegistrationId(regId, registrationIdCourseMap)) {
            if (isCourseNotAlloted(regId, registrationIdCourseMap)) {
                System.out.println(regId+" "+ StatusConstant.CANCEL_REJECTED);
            } else {
                removeRegisteredEmployee(regId, registrationIdCourseMap);
                System.out.println(regId+" "+ StatusConstant.CANCEL_ACCEPTED);
            }
        } else {
            System.out.println(regId+" "+ StatusConstant.CANCEL_REJECTED);
        }
    }

    private void removeRegisteredEmployee(String regId, Map<String, Course> registrationIdCourseMap) {
        Course course = registrationIdCourseMap.get(regId);
        course.getRegisteredEmployeeCourseMap().remove(regId);
        registrationIdCourseMap.remove(regId);
    }

    private boolean isCourseNotAlloted(String regId, Map<String, Course> registrationIdCourseMap) {
        return registrationIdCourseMap.get(regId).isCourseIsAlloted();
    }

    private boolean isValidRegistrationId(String regId, Map<String, Course> registrationIdCourseMap) {
        if (registrationIdCourseMap.get(regId) != null) {
            return true;
        } else {
            return false;
        }
    }
}
