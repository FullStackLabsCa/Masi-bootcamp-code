package io.reactivestax.school;

import io.reactivestax.school.exceptions.ClassFullException;

public interface School {
    Student adminStudent(Student student)throws ClassFullException;
    Double chargeFees(Student student);
}
