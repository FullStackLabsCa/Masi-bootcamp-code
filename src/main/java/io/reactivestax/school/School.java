package io.reactivestax.school;

public interface School {
    Student adminStudent(Student student)throws ClassFullException;
    Double chargeFees(Student student);
}
