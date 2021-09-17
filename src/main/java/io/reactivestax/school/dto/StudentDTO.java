package io.reactivestax.school.dto;

public class StudentDTO {
    private String name;
    private String dateOfBirth;

    public StudentDTO() {
    }

    public StudentDTO(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }

}
