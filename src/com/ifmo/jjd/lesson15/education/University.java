package com.ifmo.jjd.lesson15.education;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class University {
    private List<Course> courses = new ArrayList<>();

    public boolean addCourse(Course course) {
        return courses.add(Objects.requireNonNull(course));
    }
    public boolean addCourses(List<Course> courses) {
        return this.courses.addAll(Objects.requireNonNull(courses));
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Course> getFilteredCourses(Predicate<Course> condition) {
        ArrayList<Course> newList = new ArrayList<>();
        for (Course course : courses) {
            if (condition.test(course)) newList.add(course);
        }
        return newList;
    }
}