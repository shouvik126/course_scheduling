package com.example.geektrust.model;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class Course implements Comparable<Course>{
    private final String courseId;
    private final String courseName;
    private final String courseInstructor;
    private final Date courseDate;
    private final int courseMinCapacity;
    private final int courseMaxCapacity;
    private boolean courseIsAlloted;
    private boolean courseIsCancelled;
    private final Map<String, Employee> registeredEmployeeCourseMap;

    public Course(String courseId, String courseName, String courseInstructor, Date courseDate, int courseMinCapacity, int courseMaxCapacity, boolean courseIsAlloted, boolean courseIsCancelled) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseInstructor = courseInstructor;
        this.courseDate = courseDate;
        this.courseMinCapacity = courseMinCapacity;
        this.courseMaxCapacity = courseMaxCapacity;
        this.courseIsAlloted = courseIsAlloted;
        this.courseIsCancelled = courseIsCancelled;
        this.registeredEmployeeCourseMap = new TreeMap<>();
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseInstructor() {
        return courseInstructor;
    }

    public Date getCourseDate() {
        return courseDate;
    }

    public int getCourseMinCapacity() {
        return courseMinCapacity;
    }

    public int getCourseMaxCapacity() {
        return courseMaxCapacity;
    }

    public boolean isCourseIsAlloted() {
        return courseIsAlloted;
    }

    public boolean isCourseIsCancelled() {
        return courseIsCancelled;
    }

    public Map<String, Employee> getRegisteredEmployeeCourseMap() {
        return registeredEmployeeCourseMap;
    }

    public String addEmployeeToCourse(Employee e) {
        String registrationId = "REG-COURSE-" + e.getName() + "-" + this.courseName;
        this.registeredEmployeeCourseMap.put(registrationId, e);
        return registrationId;
    }

    public void setCourseIsAlloted(boolean courseIsAlloted) {
        this.courseIsAlloted = courseIsAlloted;
    }

    public void setCourseIsCancelled(boolean courseIsCancelled) {
        this.courseIsCancelled = courseIsCancelled;
    }

    @Override
    public int compareTo(Course o) {
        return this.courseName.compareTo(o.courseName);
    }
}
